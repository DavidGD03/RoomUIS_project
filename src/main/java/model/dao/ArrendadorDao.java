/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.vo.ArrendadorVo;
import java.util.ArrayList;
import model.conexion.Conexion;

/**
 * Clase que contiene los metodos de acceso a la db.
 *
 * @author David Rojas, Julián Rodríguez
 */
public class ArrendadorDao {

    Conexion c;
    Connection con;
    static int idA2= 48;

    private ArrayList<ArrendadorVo> listaArrendadores;

    /**
     * Constructor clase UsuarioDao
     */
    public ArrendadorDao() {
        this.listaArrendadores = new ArrayList<ArrendadorVo>();
        c = new Conexion();
        con = c.getConexion();
    }

    public ResultSet obtenerArrendadores() {
        String sql = "SELECT * FROM arrendador";
        return queryWithResultSet(sql);
    }

    /**
     * Metodo que agrega nuevos usuarios a la lista de registrados. Retorna un
     * boolean dependiendo de si se realizo la operación o no.
     *
     * @param nombre nombre del nuevo usuario
     * @param correo correo electronico del nuevo usuario
     * @param cedula Número de identificación
     * @return true si se agrego correctamente, false si no
     */
//  
    public boolean añadirArrendador(String nombre, String correo, String telefono, String cedula) {
        String sql = "INSERT INTO arrendador (nombre, correo, telefono,cedula) "
                + "VALUES (?,?,?,?)";
        ArrendadorVo user = new ArrendadorVo(idA2,nombre, correo, telefono, cedula);
        Boolean check = queryInsert(sql, user);
        idA2++;
        return check;
    }
    
    

    /**
     * Metodo que busca un arrendador en la db por el nombre
     *
     * @param nombre Nombre del usuario que se desea buscar
     * @return Regresa la lista de usuarios que contengan el string( nombre) de
     * busqueda.
     */
    public ResultSet buscarArrendador(String nombre) {
        String sql = "SELECT *FROM arrendador WHERE nombre LIKE '" + nombre + "%'";
        return queryWithResultSet(sql);

    }

    public ArrayList<ArrendadorVo> getListaUsuarios() {
        return listaArrendadores;
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

    private Boolean queryInsert(String sql, ArrendadorVo user) {
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

    private Boolean queryUpdate(String sql, ArrendadorVo user) {
        PreparedStatement ps = null;
        try {
            if (user != null) {
                ps = con.prepareStatement(sql);

                ps.setString(1, user.getNombre());
                ps.setString(2, user.getCorreo());
                ps.setString(3, user.getTelefono());
                ps.setString(4, user.getCedula());

                ps.setInt(5, user.getIdA());
                ps.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en actualizar arrendador de la db: " + e);
        }
        return false;
    }
}
