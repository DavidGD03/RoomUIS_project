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
import model.vo.LocacionVo;

/**
 *
 * @author David Rojas, Julián Rodríguez
 */
public class LocacionDao {

    Conexion c;
    Connection con;
    static int idL2 = 48;
    private ArrayList<LocacionVo> listaLocaciones;
    Scanner teclado = new Scanner(System.in);

    public LocacionDao() {
        this.listaLocaciones = new ArrayList<LocacionVo>();

        c = new Conexion();
        con = c.getConexion();
    }

    public ResultSet obtenerLocaciones() {
        String sql = "SELECT * FROM locacion";
        return queryWithResultSet(sql, 0);
    }
    
    public ResultSet obtenerLocacionesA(int idA) {
        String sql = "SELECT * FROM locacion WHERE idAL="+"?";
        return queryWithResultSet(sql, 0);
    }

    public boolean guardarLocacion(int idA, String direccion, String extradir, double precio, String detalles, String imagen) {
        String sql = "INSERT INTO locacion (idAL, direccion, extradir, precio, detalles,imagen) "
                + "VALUES (?,?,?,?,?,?)";

        LocacionVo pro = new LocacionVo(
                idL2,
                idA,
                direccion,
                extradir,
                precio,
                detalles,
                imagen
        );
        idL2 = idL2++;
        Boolean check = queryWithBoolean(sql, pro, "execute");

        return check;
    }


    public ResultSet buscarLocacion(String direccion) {
        String sql = "SELECT *FROM locacion WHERE direccion LIKE '" + direccion + "%'";
        return queryWithResultSet(sql, 0);
    }
    
    public ResultSet buscarLocacionPrMe(double precio) {
        String sql = "SELECT *FROM locacion WHERE precio < '" + precio + "%'";
        return queryWithResultSet(sql, 0);
    }
 
    public boolean modificarLocacion(LocacionVo dataProducto) {
        boolean check = false;

        String sql = "UPDATE locacion SET idAL = ?, direccion = ?, extradir = ?, precio = ?, detalles = ?,imagen=?";
        check = queryWithBoolean(sql, dataProducto, "executeUpdate");

        return check;
    }

    public boolean eliminarLocacion(int id) {
        String sql = "DELETE FROM locacion WHERE idL = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar locación: " + e);
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
            System.out.println("Error traer datos locación: " + e);
        }

        return rs;
    }

    private Boolean queryWithBoolean(String sql, LocacionVo pro, String type) {
        PreparedStatement ps = null;

        try {
            if (pro != null) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, pro.getArrendador());
                ps.setString(2, pro.getDireccion());
                ps.setString(3, pro.getExtraDir());
                ps.setDouble(4, pro.getPrecio());
                ps.setString(5, pro.getDetalles());
                ps.setString(6, pro.getImagen());    
                switch (type) {
                    case "execute":
                        ps.execute();
                        break;

                    case "executeUpdate":
                        ps.setInt(6, pro.getId());
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
