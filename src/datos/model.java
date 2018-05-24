package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class model {

    Statement estado;

    public model(String db) {
        try {
            estado = conectar(db).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
        }
    }

    private Connection conectar(String bd) {
        Connection cnx;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/" + bd + "?"
                    + "zeroDateTimeBehavior=convertToNull", "root", "");
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean insertar(String tabla, String campos, String valores) throws SQLException {
        if (tabla.isEmpty() || campos.isEmpty() || valores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay datos para guardar.");
            return false;
        } else {
            estado.execute("INSERT INTO " + tabla + "(" + campos + ") VALUES (" + valores + ")");
            return true;
        }
    }

    public ResultSet consultar(String campos, String tabla, String condicion) throws SQLException {
        ResultSet rs = estado.executeQuery("SELECT " + campos + " FROM " + tabla + " WHERE " + condicion);
        return rs;
    }

    public boolean actualizar(String tabla, String valores, String condicion) throws SQLException {
        if (tabla.isEmpty() || condicion.isEmpty() || valores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay datos para actualizar.");
            return false;
        } else {
            estado.execute("UPDATE " + tabla + " SET " + valores + " WHERE " + condicion);
            return true;
        }
    }

    public boolean eliminar(String tabla, String condicion) throws SQLException {
        if (tabla.isEmpty() || condicion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay datos para eliminar.");
            return false;
        } else {
            estado.execute("DELETE FROM"+ tabla + " WHERE " + condicion);
            return true;
        }
    }

    public ResultSet contarfilas(String campo, String alias, String tabla) throws SQLException {
        ResultSet rs = estado.executeQuery("select count(" + campo + ") as '" + alias + "' from " + tabla + " where estado= 1");
        return rs;
    }

    public ResultSet obtenerAreas() throws SQLException {
        ResultSet consultarAreas = estado.executeQuery("SELECT nombre_area FROM area");
        return consultarAreas;
    }

    public ResultSet obtenerOperaciones(String area) throws SQLException {
        ResultSet consOperaciones = estado.executeQuery("SELECT * FROM op_" + area + " ORDER BY nombre_op ASC");
        return consOperaciones;
    }

    private String[] consultarUser(String user, String pass) throws SQLException {
        ResultSet rs = null;
        String[] datos = new String[3];
        rs = estado.executeQuery("SELECT n_usuario,pw,tipo from administradores WHERE n_usuario='" + user + "' limit 1");
        while (rs.next()) {
            datos[0] = rs.getString("n_usuario");
            datos[1] = rs.getString("pw");
            datos[2] = rs.getString("tipo");
        }

        return datos;
    }

    public String[] consultarUsuario(String user, String pass) throws SQLException {
        String[] data;
        data = consultarUser(user, pass);
        return data;
    }

}
