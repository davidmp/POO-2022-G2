/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.dao.conx;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnS {

    private static volatile ConnS instance;
    private static volatile Connection connection;

    private ConnS() {
        try {
            Class.forName("org.sqlite.JDBC");
            //Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnS.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create ");
        }
        if (connection != null) {
            throw new RuntimeException(
                    "Use getConnection() method to create ");
        }
    }

    public static ConnS getInstance() {
        if (instance == null) {
            synchronized (ConnS.class) {
                if (instance == null) {
                    instance = new ConnS();
                    System.out.println("Se instancio ConnS");
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            synchronized (ConnS.class) {
                if (connection == null) {
                    try {
                        //String dbUrl= "jdbc:sqlite:data/db_ventas.db?foreign_keys=on;";
                        String dbUrl= "jdbc:sqlite:"+getFile("db_ventas.db").getAbsolutePath()+"?foreign_keys=on;";
                        connection = DriverManager.getConnection(dbUrl);
                        /*connection=DriverManager.getConnection(
  "jdbc:mysql://us-east.connect.psdb.cloud/sys_ventas?sslMode=VERIFY_IDENTITY",
  "qlsryy9mmz18aeap56v8",
  "pscale_pw_X4ZI0iO0hLB1YmSLrDjoKp90OHrIk55dKMJYL6im4xy");
                        System.out.println("conexion Exitosa!!");*/
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
    public File getFile(String filex) {
        File newFolder = new File("data");
        String ruta = newFolder.getAbsolutePath();
        Path CAMINO = Paths.get(ruta + "/" + filex);        
        return CAMINO.toFile();
    }
}
