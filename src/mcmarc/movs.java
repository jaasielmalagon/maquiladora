package mcmarc;

import datos.model;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jxl.*;
import jxl.write.*;

public class movs {

    model modelo = new model("mc&marc");

    public movs() {

    }

    public String[] usuario(String u, String p) throws SQLException {
        String[] datos = new String[7];
        ResultSet rs = modelo.consultar("*", "administradores", "n_usuario='" + u + "' AND pw='" + p + "' LIMIT 1");
        while (rs.next()) {
            datos[0] = rs.getString("n_usuario");
            datos[1] = rs.getString("pw");
            datos[2] = rs.getString("tipo");
            datos[3] = rs.getString("nombre");
            datos[4] = rs.getString("foto");
            datos[5] = rs.getString("ultimo_inicio");
            datos[6] = rs.getString("activo");
        }
        return datos;
    }

    public boolean nuevoCorte(String brand, String nCorte, int cant, int plant, int line, String recibo, String entrega, int price, String desc, String img) throws SQLException {
        boolean bandera;
        if (nCorte != null) {
            modelo.insertar("cortes", "marca,id_corte,cantidad,planta,linea,fecha_recibo,fecha_entrega,precio,descripcion,imagen,parcialuno,parcialdos,parcialtres,parcialcuatro,parcialcinco,enviouno,enviodos,enviotres,enviocuatro,enviocinco",
                    "'" + brand + "','" + nCorte + "'," + cant + "," + plant + "," + line + ",'" + recibo + "','" + entrega + "'," + price + ",'" + desc + "','" + img + "',0,0,0,0,0,0,0,0,0,0");
            bandera = true;
        } else {
            bandera = false;
        }
        return bandera;
    }

    public void exportarExcel(JTable tabla, File archivo) {
        try {
            WritableWorkbook libro = Workbook.createWorkbook(archivo);
            WritableSheet hoja = libro.createSheet("Hoja1", 0);
            TableModel modeloTabla = tabla.getModel();
            for (int i = 0; i < modeloTabla.getColumnCount(); i++) {
                Label columna = new Label(i, 0, modeloTabla.getColumnName(i));
                hoja.addCell(columna);
            }

            int j = 0;
            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                for (j = 0; j < modeloTabla.getColumnCount(); j++) {
                    Label fila = new Label(j, i + 1, modeloTabla.getValueAt(i, j).toString());
                    hoja.addCell(fila);
                }
            }
            libro.write();
            libro.close();

        } catch (Exception e) {
            System.err.println("Error al crear el documento Excel.");
            e.printStackTrace();
        }
    }

    public boolean tareas(String dia, int n, int prod) throws SQLException {
        int produccionDia = 0;
        int num = 0;
        boolean bandera = false;
        try {
            ResultSet t = modelo.consultar(dia + ",n_nomina", "empleados", "n_nomina=" + n + " LIMIT 1");
            while (t.next()) {
                num = t.getInt("n_nomina");
                produccionDia = t.getInt(dia);
            }
            if (num == 0 || produccionDia > 0) {
                bandera = false;
            } else {
                boolean produccion = modelo.actualizar("empleados", dia + "=" + prod, "n_nomina=" + n);
                bandera = true;
            }
        } catch (Exception e) {
        }

        return bandera;
    }

    public boolean nuevoEmpleado(String valores) throws SQLException {
        boolean a = false;
        if (valores.isEmpty()) {
            System.err.println("Faltan valores");
            a = false;
        } else {
            String coincidencia = null;
            modelo.insertar("empleados", "n_nomina,nombre_empleado,area,operacion,estado,fecha_contrato,sueldo_base,tarea,lunes,martes,miercoles,jueves,viernes,sabado", valores);
            a = true;
        }
        return a;
    }

    public ResultSet busqueda(String campos, String tabla, String condicion) throws SQLException {
        ResultSet rs = modelo.consultar(campos, tabla, condicion);
        return rs;
    }

    public ResultSet busquedaPreEliminacion(int n) throws SQLException {
        ResultSet rs = modelo.consultar("*", "empleados", "n_nomina=" + n);
        return rs;
    }

    public void modificarEmpleado(String valores, String condicion) throws SQLException {
        if (condicion != "") {
            try {
                modelo.actualizar("empleados", valores, condicion);
            } catch (Exception e) {
                System.err.println("Error 1 " + e);
            }
        } else {
            System.err.println("Error 2");
        }
    }

    public boolean eliminarEmpleado(int n) throws SQLException {
        boolean flag = false;
        if (n != 0) {
            boolean b = modelo.eliminar("empleados", "n_nomina=" + n);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public DefaultTableModel tablaNomina(String condicion) throws SQLException {
        String titulos[] = {"Número", "Nombre", "Area", "Operación", "Sueldo base ($)", "Tarea diaria (pzas)", "Tarea Semanal (pzas)",
            "Factor x pieza($)", "Miercoles", "Jueves", "Viernes", "Sábado", "Lunes", "Martes", "Total Producido(pzas)", "Rendimiento general(%)", "Sueldo al dia"};
        ResultSet rs = modelo.consultar("n_nomina,nombre_empleado,area,operacion,sueldo_base,tarea,miercoles,jueves,viernes,sabado,lunes,martes,SUM(lunes+martes+miercoles+jueves+viernes+sabado) as suma", "empleados", condicion + " GROUP BY n_nomina");
        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String[] valores = new String[17];
        double tareaReq = 0;
        double sueldoNeto = 0;
        double porcentajeSem = 0;
        double porcentajeDia = 0;
        double factorPza = 0;
        double totalNomina = 0;
        double porcentajeTotal = 0;
        int totalProducido = 0;
        int tEmpleados = 0;
        double porMier, porJue, porVie, porSab, porLun, porMar;
        while (rs.next()) {
            valores[0] = rs.getString("n_nomina");
            valores[1] = rs.getString("nombre_empleado");
            valores[2] = rs.getString("area");
            valores[3] = rs.getString("operacion");
            valores[4] = rs.getString("sueldo_base");
            valores[5] = rs.getString("tarea");
            totalProducido = Integer.parseInt(rs.getString("suma"));
            if (rs.getString("n_nomina") == null) {
                tareaReq = 0;
                sueldoNeto = 0;
                porcentajeSem = 0;
                porcentajeDia = 0;
                factorPza = 0;
                totalNomina = 0;
                porcentajeTotal = 0;
                totalProducido = 0;
            } else {
                tareaReq = Integer.parseInt(rs.getString("tarea")) * 5.5;
                factorPza = (Integer.parseInt(valores[4]) / tareaReq);
                sueldoNeto = totalProducido * factorPza;
                porcentajeSem = (totalProducido * 100) / tareaReq;

                valores[6] = String.valueOf(String.format("%.0f", tareaReq)) + " pzas";
                valores[7] = "$" + String.valueOf(String.format("%.2f", factorPza));
                valores[8] = rs.getString("miercoles") + " = " + String.valueOf(String.format("%.0f", ((Double.parseDouble(rs.getString("miercoles")) * 100) / Integer.parseInt(valores[5])))) + "%";
                valores[9] = rs.getString("jueves") + " = " + String.valueOf(String.format("%.0f", ((Double.parseDouble(rs.getString("jueves")) * 100) / Integer.parseInt(valores[5])))) + "%";
                valores[10] = rs.getString("viernes") + " = " + String.valueOf(String.format("%.0f", ((Double.parseDouble(rs.getString("viernes")) * 100) / Integer.parseInt(valores[5])))) + "%";
                valores[11] = rs.getString("sabado") + " = " + String.valueOf(String.format("%.0f", ((Double.parseDouble(rs.getString("sabado")) * 100) / (Integer.parseInt(valores[5]) / 2)))) + "%";
                valores[12] = rs.getString("lunes") + " = " + String.valueOf(String.format("%.0f", ((Double.parseDouble(rs.getString("lunes")) * 100) / Integer.parseInt(valores[5])))) + "%";
                valores[13] = rs.getString("martes") + " = " + String.valueOf(String.format("%.0f", ((Double.parseDouble(rs.getString("martes")) * 100) / Integer.parseInt(valores[5])))) + "%";
                valores[14] = String.valueOf(totalProducido) + " pzas.";
                valores[15] = String.valueOf(String.format("%.2f", porcentajeSem)) + "%";
                valores[16] = "$" + String.valueOf(String.format("%.2f", sueldoNeto));
                totalNomina = sueldoNeto + totalNomina;
                tEmpleados = tEmpleados + 1;
                porcentajeTotal = (porcentajeSem + porcentajeTotal);
            }
            if (valores[0] != null) {
                tabla.addRow(valores);

            } else {
                System.err.println("No se han encontrado resultados.");
                tabla.addRow(valores);
            }
        }
        double pt = porcentajeTotal / tEmpleados;
        String t = String.valueOf(String.format("%.2f", totalNomina));
        String p = String.valueOf(String.format("%.2f", pt));
        String[] total = {"", "", "", "", "", "", "", "", "", "", "", "", "", "Porcentaje total:", p + " %", "Total sueldos: ", "$" + t};
        tabla.addRow(total);
        return tabla;
    }

    public String[] llenarCampos(int n) throws SQLException {
        ResultSet rs = busqueda("*", "empleados", "n_nomina=" + n + " limit 1");
        String[] campos = new String[6];
        while (rs.next()) {
            campos[0] = rs.getString("nombre_empleado");
            campos[2] = rs.getString("area");
            campos[3] = rs.getString("operacion");
            campos[4] = rs.getString("sueldo_base");
            campos[5] = rs.getString("tarea");
        }
        return campos;
    }

    public DefaultTableModel LlenarTablaEmpleados(int numero) throws SQLException {
        ResultSet rs = modelo.consultar("*", "empleados", "n_nomina= " + numero);
        String columnas[] = {"Número", "Nombre", "Area", "Operación", "Sueldo", "Tarea diaria"};
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        String[] valores = new String[6];
        while (rs.next()) {
            valores[0] = rs.getString("n_nomina");
            valores[1] = rs.getString("nombre_empleado");
//            valores[2] = rs.getString("curp");
//            valores[3] = rs.getString("direccion_empleado");
            valores[2] = rs.getString("area");
            valores[3] = rs.getString("operacion");
            valores[4] = rs.getString("sueldo_base");
            valores[5] = rs.getString("tarea");
            //tabla.addRow(valores);
        }
        if (valores[0] != null) {
            tabla.addRow(valores);
        } else {
            System.err.println("No se han encontrado resultados.");
            tabla.addRow(valores);
        }
        return tabla;
    }

    public DefaultComboBoxModel areas() throws SQLException {
        ResultSet rs = modelo.obtenerAreas();
        String valor;
        DefaultComboBoxModel A = new DefaultComboBoxModel();
        A.addElement("--Seleccione--");
        while (rs.next()) {
            valor = rs.getString("nombre_area");
            A.addElement(valor);
        }
        return A;
    }

    public DefaultComboBoxModel operaciones(String area) throws SQLException {
        ResultSet rs = modelo.obtenerOperaciones(area);
        String op;
        DefaultComboBoxModel O = new DefaultComboBoxModel();
        O.addElement("--Seleccione--");
        while (rs.next()) {
            op = rs.getString("nombre_op");
            O.addElement(op);
        }
        return O;
    }

    public String[] datosOperacion(String campos, String tabla, String condicion) throws SQLException {
        ResultSet rs = modelo.consultar(campos, tabla, condicion);
        String[] datosObtenidos = new String[2];
        while (rs.next()) {
            datosObtenidos[0] = rs.getString("tarea");
            datosObtenidos[1] = rs.getString("sueldo_base");
        }
        return datosObtenidos;
    }

    void reiniciarCampos(String condicion) throws SQLException {
        modelo.actualizar("empleados", "lunes=0, martes=0, miercoles=0,jueves=0,viernes=0,sabado=0", condicion);
    }

    public String[] fecha() {

        Calendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int anio = fecha.get(Calendar.YEAR);
        int ds = fecha.get(Calendar.DAY_OF_WEEK);
        int hora = fecha.get(Calendar.HOUR);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        int meridiano = fecha.get(Calendar.AM_PM);
        String diaSem = "";
        String[] date = new String[8];
        switch (ds) {
            case 2:
                diaSem = "Lunes";
                break;
            case 3:
                diaSem = "Martes";
                break;
            case 4:
                diaSem = "Miercoles";
                break;
            case 5:
                diaSem = "Jueves";
                break;
            case 6:
                diaSem = "Viernes";
                break;
            case 7:
                diaSem = "Sabado";
                break;
            default:
                diaSem = "Domingo";
                break;
        }
        date[0] = diaSem;
        if (dia <= 9) {
            date[1] = "0" + String.valueOf(dia);
        } else {
            date[1] = String.valueOf(dia);
        }
        if (mes <= 9) {
            date[2] = "0" + String.valueOf(mes);
        } else {
            date[2] = String.valueOf(mes);
        }
        date[3] = String.valueOf(anio);
        if (hora <= 9) {
            date[4] = "0" + String.valueOf(hora);
        } else {
            date[4] = String.valueOf(hora);
        }
        if (minuto <= 9) {
            date[5] = "0" + String.valueOf(minuto);
        } else {
            date[5] = String.valueOf(minuto);
        }
        if (segundo <= 9) {
            date[7] = "0" + String.valueOf(segundo);
        } else {
            date[7] = String.valueOf(segundo);
        }
        if (meridiano > 0) {
            date[6] = "p.m.";
        } else {
            date[6] = "a.m.";
        }
        return date;
    }
    
    public boolean registroSesion(String usuario) throws SQLException{
        boolean bandera = false;
        if (usuario.isEmpty()) {
           return bandera;
        }else{
            boolean regSes = modelo.actualizar("administradores", "ultimo_inicio='"+this.fecha()[3]+"-"+this.fecha()[2]+"-"+this.fecha()[1]+"-"+this.fecha()[4]+"-"+this.fecha()[5]+"-"+this.fecha()[7]+"',activo=1", "n_usuario='"+usuario+"'");
            if (regSes==true) {
                bandera = true;
            }
        }
        return bandera;
    }
    public boolean cerrarSesion(String usuario) throws SQLException{
        boolean bandera = false;
        if (usuario.isEmpty()) {
           return bandera;
        }else{
            boolean closeSes = modelo.actualizar("administradores", "ultimo_cierre='"+this.fecha()[3]+"-"+this.fecha()[2]+"-"+this.fecha()[1]+"-"+this.fecha()[4]+"-"+this.fecha()[5]+"-"+this.fecha()[7]+"',activo=0", "n_usuario='"+usuario+"'");
            if (closeSes==true) {
                bandera = true;
            }
        }
        return bandera;
    }

}
