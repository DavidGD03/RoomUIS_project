/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import model.conexion.Conexion;
import model.vo.SolicitudVo;

/**
 *
 * @author David Rojas, Julián Rodríguez
 */
public class SolicitudDao {

    Conexion c;
    Connection con;

    int i = 1;
    private ArrayList<SolicitudVo> listaSolicitudes;
    Scanner teclado = new Scanner(System.in);

    public SolicitudDao() {
        this.listaSolicitudes = new ArrayList<SolicitudVo>();

        c = new Conexion();
        con = c.getConexion();
    }

    public ResultSet obtenerSolicitudes() {
        String sql = "SELECT * FROM solicitud";
        return queryWithResultSet(sql, 0);
    }
    
    public ResultSet obtenerSolicitudesA(int idAS) {
        String sql = "SELECT * FROM solicitudCompra WHERE idAS="+"?";
        return queryWithResultSet(sql, 0);
    }

    public boolean guardarSolicitud(int idE, int idAS, String mensaje) {
        String sql = "INSERT INTO solicitudCompra (idE, idAS, mensaje) "
                + "VALUES (?,?,?)";

        SolicitudVo solicitud = new SolicitudVo(
                idE,
                idAS,
                mensaje
        );

        Boolean check = queryWithBoolean(sql, solicitud, "execute");

        return check;
    }



    public ResultSet buscarSolicitud(String mensaje) {
        String sql = "SELECT *FROM solicitudCompra WHERE mensaje LIKE '" + mensaje + "%'";
        return queryWithResultSet(sql, 0);
    }
    
    public ResultSet buscarSolicitudId(int idS) {
        String sql = "SELECT *FROM solicitudCompra WHERE idS = ?";
        return queryWithResultSet(sql, idS);
    }

    public boolean modificarSolicitud(SolicitudVo dataProducto) {
        boolean check = false;

        String sql = "UPDATE solicitud SET idE = ?, idAS = ?, mensaje = ?";
        check = queryWithBoolean(sql, dataProducto, "executeUpdate");

        return check;
    }

    public boolean eliminarSolicitud(int idS) {
        String sql = "DELETE FROM solicitudCompra WHERE id = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idS);
            ps.execute();
            
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar solicitud: " + e);
            return false;
        }
    }

    private ResultSet queryWithResultSet(String sql, int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            
            // Al ser mayor de cero se entiende que se quiere buscar por id
            if (id > 0) {
                ps.setInt(1, id);
            }
            
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error traer datos solicitud: " + e);
        }

        return rs;
    }

    private Boolean queryWithBoolean(String sql, SolicitudVo solicitud, String type) {
        PreparedStatement ps = null;

        try {
            if (solicitud != null) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, solicitud.getEstudiante());
                ps.setInt(2, solicitud.getArrendador());
                ps.setString(3, solicitud.getMensaje());

                switch (type) {
                    case "execute":
                        ps.execute();
                        break;

                    case "executeUpdate":
                        ps.setInt(6, solicitud.getId());
                        ps.executeUpdate();
                        break;

                    default:
                        break;
                }
            }
            return true;

        } catch (Exception e) {
            System.out.println("Error en la petición de la db: " + e);
        }

        return false;
    }
}
