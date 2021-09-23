/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.vo.AdminVo;
import java.util.ArrayList;
import model.conexion.Conexion;

/**
 * Clase que contiene los metodos de acceso a la db.
 *
 * @author David Rojas, Julián Rodríguez
 */
public class AdminDao {

    Conexion c;
    Connection con;

    private ArrayList<AdminVo> listaAdmin;

    /**
     * Constructor clase AdminDao
     */
    public AdminDao() {
        this.listaAdmin = new ArrayList<AdminVo>();
        c = new Conexion();
        con = c.getConexion();
    }

    public ResultSet obtenerAdmin() {
        String sql = "SELECT * FROM admin";
        return queryWithResultSet(sql);
    }

    /**
     * Metodo que agrega nuevos usuarios a la lista de registrados. Retorna un
     * boolean dependiendo de si se realizo la operación o no.
     *
     * @param nombre nombre del nuevo admin
     * @param correo correo electronico del nuevo admin
     * @param cedula Número de identificación
     * @return true si se agrego correctamente, false si no
     */
//  
    public boolean añadirAdmin(String nombre, String correo, String telefono, String cedula) {
        String sql = "INSERT INTO admin (nombre, correo, telefono,cedula) "
                + "VALUES (?,?,?,?)";

        AdminVo user = new AdminVo(nombre, correo, telefono, cedula);
        Boolean check = queryInsert(sql, user);
        return check;
    }

    /**
     * Metodo que busca en la lista de Usuarios registrado usando el Id y luego
     * lo elimina
     *
     * @param id Id del arrendador que se desea eliminar
     * @return True si se pudo eliminar, False si no.
     */
    public boolean eliminarAdmin(int id) {
        String sql = "DELETE FROM admin WHERE id = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar admin: " + e);
            return false;
        }
    }

    /**
     * Metodo que busca un admin en la db por el nombre
     *
     * @param nombre Nombre del admin que se desea buscar
     * @return Regresa la lista de usuarios que contengan el string( nombre) de
     * busqueda.
     */
    public ResultSet buscarAdmin(String nombre) {
        String sql = "SELECT *FROM admin WHERE nombre LIKE '" + nombre + "%'";
        return queryWithResultSet(sql);

    }

    public ArrayList<AdminVo> getListaUsuarios() {
        return listaAdmin;
    }

    private ResultSet queryWithResultSet(String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error traer datos productos: " + e);
        }
        return rs;
    }

    private Boolean queryInsert(String sql, AdminVo user) {
        PreparedStatement ps = null;
        try {
            if (user != null) {
                ps = con.prepareStatement(sql);

                ps.setString(1, user.getNombre());
                ps.setString(2, user.getCorreo());
                ps.setString(3, user.getTelefono());
                ps.setString(4, user.getCedula());

                ps.execute();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en la petición de la db: " + e);
        }
        return false;
    }

    private Boolean queryUpdate(String sql, AdminVo user) {
        PreparedStatement ps = null;
        try {
            if (user != null) {
                ps = con.prepareStatement(sql);

                ps.setString(1, user.getNombre());
                ps.setString(2, user.getCorreo());
                ps.setString(3, user.getTelefono());
                ps.setString(4, user.getCedula());

                ps.setInt(5, user.getIdAd());
                ps.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en actualizar arrendador de la db: " + e);
        }
        return false;
    }
}
