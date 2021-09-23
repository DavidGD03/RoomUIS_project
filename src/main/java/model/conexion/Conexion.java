/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que realiza la conexión a la base MySQL
 *
 * @author David y Julian
 */
public class Conexion {

    private static Connection con;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String db = "roomuis";
    private static final String host = "localhost";

    public Conexion() {
        con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + db + "?" + "user=" + user + "&password=" + pass + "&serverTimezone=UTC");

            if (con != null) {
                System.out.println("Conexión establecida...");
            } else {
                System.out.println("Conexión nula");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar: " + e);
        }
    }

    /**
     * Devuelve la conexión con la db
     *
     * @return
     */
    public Connection getConexion() {
        return con;
    }

    /**
     * Cierra la conexión con la db
     */
    public void cerrarConexion() {
        con = null;

        if (con == null) {
            System.out.println("Conexion cerrada...");
        }
    }
}
