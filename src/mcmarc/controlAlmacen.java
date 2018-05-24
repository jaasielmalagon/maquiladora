package mcmarc;

import datos.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jaasiel Malagon
 */
public class controlAlmacen {

    model modelo = new model("mc_marc");

    public controlAlmacen() {
    }

    public String[] nombreAlmacen(String u) throws SQLException {
        ResultSet rs = modelo.consultar("*", "nombres_almacen", "nombre_almacen='" + u + "'");
        String[] almacen = new String[2];
        while (rs.next()) {
            almacen[0] = rs.getString("nombre_almacen");
            almacen[1] = rs.getString("id_almacen");
        }
        return almacen;
    }

    public boolean guardarAvios(String valores) throws SQLException {
        boolean bandera = false;
        if (valores != null) {
            modelo.insertar("almacen_stock", "almacen,corte, cierre, deslizador, et_marca, et_monach,"
                    + " et_talla, cinta_fus, hilo, resorte, et_piel, et_tabtam, et_tabtalla, comentarios, fecha_registro, hora_registro", valores);
            bandera = true;
        } else {
            bandera = false;
        }
        return bandera;
    }

    public DefaultTableModel tablaAvios(String condicion) throws SQLException {
        ResultSet rs = modelo.consultar("nombre_almacen,fecha_registro,corte,cierre,deslizador,et_marca,et_monach,et_talla,cinta_fus,hilo,resorte,et_piel,et_tabtam,"
                + "et_tabtalla,comentarios", "almacen_stock inner join nombres_almacen on id_almacen=almacen", condicion + " ORDER BY corte ASC");
        String[] titulos = {"Almacen", "Corte", "Recibido", "Cierre", "Deslizador", "Etq. Marca", "Etq. Monach", "Etq. Talla", "Cinta FUS", "Hilo", "Resorte",
            "Etq. Piel", "Etq. Tabtam", "Etq. Tabtalla", "Comentarios"};
        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String[] valores = new String[15];
        while (rs.next()) {
            valores[0] = rs.getString("nombre_almacen");
            valores[1] = rs.getString("corte");
            valores[2] = rs.getString("fecha_registro");
            valores[3] = rs.getString("cierre");
            valores[4] = rs.getString("deslizador");
            valores[5] = rs.getString("et_marca");
            valores[6] = rs.getString("et_monach");
            valores[7] = rs.getString("et_talla");
            valores[8] = rs.getString("cinta_fus");
            valores[9] = rs.getString("hilo");
            valores[10] = rs.getString("resorte");
            valores[11] = rs.getString("et_piel");
            valores[12] = rs.getString("et_tabtam");
            valores[13] = rs.getString("et_tabtalla");
            valores[14] = rs.getString("comentarios");
            tabla.addRow(valores);
        }
        return tabla;
    }

    public DefaultComboBoxModel destinosComboBox() throws SQLException {
        ResultSet rs = modelo.consultar("*", "nombres_almacen", "tipo=2 and nombre_almacen!='Administrador' and nombre_almacen!='Superusuario' "
                + "or tipo=7 and nombre_almacen!='Administrador' and nombre_almacen!='Superusuario'");
        String valor;
        DefaultComboBoxModel destino = new DefaultComboBoxModel();
        destino.addElement("--Seleccione--");
        while (rs.next()) {
            valor = rs.getString("nombre_almacen");
            destino.addElement(valor);
        }
        return destino;
    }

    public int id_destino(String destino) throws SQLException {
        int destiny = 0;
        ResultSet dest = modelo.consultar("id_almacen", "nombres_almacen", "nombre_almacen='" + destino + "' limit 1");
        while (dest.next()) {
            destiny = dest.getInt("id_almacen");
        }
        return destiny;
    }

    public boolean enviarAvios(String corte, int origen, int destino, int cierre, int deslizador, int marca, int monach, int talla, int fus, int hilo, int resorte, int piel, int tabtam, int tabtalla, String comentarios) throws SQLException {
        boolean bandera = false;
        int[] valores = new int[11];
        String c = null;
        int o = 0;
        if (corte != null && origen != 0) {
            ResultSet rs = modelo.consultar("*", "almacen_stock", "corte='" + corte + "' and almacen=" + origen);
            while (rs.next()) {
                c = rs.getString("corte");
                o = rs.getInt("almacen");
                valores[0] = rs.getInt("cierre");
                valores[1] = rs.getInt("deslizador");
                valores[2] = rs.getInt("et_marca");
                valores[3] = rs.getInt("et_monach");
                valores[4] = rs.getInt("et_talla");
                valores[5] = rs.getInt("cinta_fus");
                valores[6] = rs.getInt("hilo");
                valores[7] = rs.getInt("resorte");
                valores[8] = rs.getInt("et_piel");
                valores[9] = rs.getInt("et_tabtam");
                valores[10] = rs.getInt("et_tabtalla");
            }            
            if ((valores[0] >= cierre && valores[1] >= deslizador && valores[2] >= marca && valores[3] >= monach && valores[4] >= talla && valores[5] >= fus && valores[6] >= hilo
                    && valores[7] >= resorte && valores[8] >= piel && valores[9] >= tabtam && valores[10] >= tabtalla) && (corte.equals(c) && origen == o)) {
                modelo.insertar("almacen_reportes", " ", "'" + corte + "'," + origen + "," + destino + "," + cierre + "," + deslizador + "," + marca + "," + monach + "," + talla + "," + fus
                        + "," + hilo + "," + resorte + "," + piel + "," + tabtam + "," + tabtalla + ",now(),now(),'" + comentarios + "'");
                    valores[0] = valores[0] - cierre;
                    valores[1] = valores[1] - deslizador;
                    valores[2] = valores[2] - marca;
                    valores[3] = valores[3] - monach;
                    valores[4] = valores[4] - talla;
                    valores[5] = valores[5] - fus;
                    valores[6] = valores[6] - hilo;
                    valores[7] = valores[7] - resorte;
                    valores[8] = valores[8] - piel;
                    valores[9] = valores[9] - tabtam;
                    valores[10] = valores[10] - tabtalla;
                    modelo.insertar("almacen_stock", " ", destino + ",now(),now(),'" + corte + "'," + cierre + "," + deslizador + ","
                            + marca + "," + monach + "," + talla + "," + fus + "," + hilo + "," + resorte + "," + piel + ","
                            + tabtam + "," + tabtalla + ",'" + comentarios + "'");
                    
                    modelo.actualizar("almacen_stock", "cierre=" + valores[0] + ", deslizador=" + valores[1] + ", et_marca=" + valores[2] + ", et_monach=" + valores[3] + ", et_talla=" + valores[4] + ", "
                            + "cinta_fus=" + valores[5] + ", hilo=" + valores[6] + ", resorte=" + valores[7] + ", et_piel=" + valores[8] + ", et_tabtam=" + valores[9] + ", et_tabtalla=" + valores[10] + ",comentarios='" + comentarios + "'", "corte='" + corte + "' and almacen=" + origen);
                    bandera = true;
            }
        } else {
            bandera = false;
        }
        return bandera;
    }
}
