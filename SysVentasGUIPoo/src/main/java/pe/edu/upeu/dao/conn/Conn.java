package pe.edu.upeu.dao.conn;

/**
 *
 * @author Asullom
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conn {

  
        
     public static final String DEFAULT_DATE_STRING_FORMAT_PE = "dd/MM/yyyy";
     public static final String DEFAULT_DATE_STRING_FORMAT = "yyyy-MM-dd HH:mm:ss";
    static Connection conn = null;
    
    public static Connection connectSQLite() {

        
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:data/ventasdb.db?foreign_keys=on;";
            
            if(conn==null) conn = DriverManager.getConnection(dbURL);
            
            System.out.println("Conexion Exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return conn;
    }

    public static void closeSQLite(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        connectSQLite();
    }

}
