
package pe.edu.upeu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import pe.edu.upeu.dao.conn.Conn;
import pe.edu.upeu.modelo.ClienteTO;
import pe.edu.upeu.util.ErrorLogger;


public class ClienteDAO {

    Statement stmt = null;       
    Vector columnNames;
    Vector visitdata ;

    
    Connection connection = Conn.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ClienteDAO.class.getName());
    ResultSet rs = null;

    public int create(ClienteTO d) {
        int rsId = 0;
        String[] returns = {"dniruc"};
        String sql = "INSERT INTO cliente(dniruc, nombrers, tipo) "
                + "VALUES(?,?,?)";
        int i = 0;
        try {
            ps = connection.prepareStatement(sql, returns);
            ps.setString(++i, d.getDniruc());
            ps.setString(++i, d.getNombresrs());
            ps.setString(++i, d.getTipo());
            rsId = ps.executeUpdate();// 0 no o 1 si commit
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId = rs.getInt(1);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            //System.err.println("create:" + ex.toString());
            log.log(Level.SEVERE, "create", ex);
        }
        return rsId;
    }

    public int update(ClienteTO d) {
        System.out.println("actualizar d.getDniruc: " + d.getDniruc());
        int comit = 0;
        String sql = "UPDATE cliente SET "
                + "nombrers=?, "
                + "tipo=? "
                + "WHERE dniruc=?";
        int i = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(++i, d.getNombresrs());
            ps.setString(++i, d.getTipo());            
            ps.setString(++i, d.getDniruc());
            comit = ps.executeUpdate();
            
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }

    public int delete(String id) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM cliente WHERE dniruc = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Detalle:" + ex.getMessage());
        }
        return comit;
    }

    public List<ClienteTO> listCmb(String filter) {
        List<ClienteTO> ls = new ArrayList();
        ls.add(new ClienteTO());
        ls.addAll(listarClientes());
        return ls;
    }    
    
    
    public ClienteDAO() {
        columnNames = new Vector();
        visitdata = new Vector();        
    }

    public List listarClientes(){
       List<ClienteTO> listarclientes = new ArrayList();
       String sql = "SELECT * FROM cliente";
       try {
           connection = new Conn().connectSQLite();
           ps = connection.prepareStatement(sql); 
           rs = ps.executeQuery();
           while (rs.next()) {               
               ClienteTO cli = new ClienteTO();
               cli.setDniruc(rs.getString("dniruc"));
               cli.setNombresrs(rs.getString("nombrers"));
               cli.setTipo(rs.getString("tipo"));
               listarclientes.add(cli);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return listarclientes;
   } 
    public ClienteTO buscarClientes(String dni){
       ClienteTO cliente = new ClienteTO();
       String sql = "SELECT * FROM cliente WHERE dniruc = ?";
       try {
           connection = new Conn().connectSQLite();
           ps = connection.prepareStatement(sql); 
           ps.setString(1, dni);
           rs = ps.executeQuery();
           if (rs.next()) {                             
               cliente.setDniruc(rs.getString("dniruc"));
               cliente.setNombresrs(rs.getString("nombrers"));
               cliente.setTipo(rs.getString("tipo"));               
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return cliente;
   } 
    
    
    public void reportarCliente(){
    String query = "SELECT * FROM cliente ";
        try {
            connection = new Conn().connectSQLite();
            //  Read data from a table
            stmt = connection.createStatement();     
            rs = stmt.executeQuery(query);
            ResultSetMetaData md = rs.getMetaData();
            //Get number of columns
            int columns = md.getColumnCount();      
            
            //  Get column names
            for (int i = 1; i <= columns; i++){
                columnNames.addElement( md.getColumnName(i) );
                System.out.println("ver: "+md.getColumnName(i));
            }
 
            //  Get row data
            while ((rs!= null)&&(rs.next())){
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++){
                    row.addElement( rs.getObject(i) );
                }
                visitdata.addElement( row );
            }
            
            
            //Close the resultset, statement and the connection
            rs.close();
            connection.close();
            stmt.close();            
        } catch (Exception e) {
            System.out.println( e );
        }
    
    }
}
