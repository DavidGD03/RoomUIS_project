/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.vo.EstudianteVo;
import java.util.ArrayList;
import model.conexion.Conexion;

/**
 * Clase que contiene los metodos de acceso a la db.
 *
 * @author David Rojas, Julián Rodríguez
 */
public class EstudianteDao {
    static int idE2= 14;
    Conexion c;
    Connection con;

    private ArrayList<EstudianteVo> listaEstudiante;

    /**
     * Constructor clase AdminDao
     */
    public EstudianteDao() {
        this.listaEstudiante = new ArrayList<EstudianteVo>();
        c = new Conexion();
        con = c.getConexion();
    }

    public ResultSet obtenerEstudiante() {
        String sql = "SELECT * FROM estudiante";
        return queryWithResultSet(sql);
    }

    /**
     * Metodo que agrega nuevos usuarios a la lista de registrados. Retorna un
     * boolean dependiendo de si se realizo la operación o no.
     *
     * @param nombre nombre del nuevo Estudiante
     * @return true si se agrego correctamente, false si no
     */
//  
    public boolean añadirEstudiante(String codigo, String nombre, String carrera, String telefono) {
        String sql = "INSERT INTO estudiante (codigo, nombre, carrera, telefono) "
                + "VALUES (?,?,?,?)";

        EstudianteVo user = new EstudianteVo(idE2,codigo, nombre, carrera, telefono);
        Boolean check = queryInsert(sql, user);
        idE2++;
        return check;
    }

    /**
     * Metodo que busca un estudiante en la db por el nombre
     *
     * @param nombre Nombre del estudiante que se desea buscar
     * @return Regresa la lista de usuarios que contengan el string( nombre) de
     * busqueda.
     */
    public ResultSet buscarEstudiante(String nombre) {
        String sql = "SELECT *FROM estudiante WHERE nombre LIKE '" + nombre + "%'";
        return queryWithResultSet(sql);

    }

    public ArrayList<EstudianteVo> getListaEstudiantes() {
        return listaEstudiante;
    }

    private ResultSet queryWithResultSet(String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error traer datos estudiante: " + e);
        }
        return rs;
    }

    private Boolean queryInsert(String sql, EstudianteVo user) {
        PreparedStatement ps = null;
        try {
            if (user != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, user.getCodigo());
                ps.setString(2, user.getNombre());
                ps.setString(3, user.getCarrera());
                ps.setString(4, user.getTelefono());

                ps.execute();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en la petición de la db: " + e);
        }
        return false;
    }

    private Boolean queryUpdate(String sql, EstudianteVo user) {
        PreparedStatement ps = null;
        try {
            if (user != null) {
                ps = con.prepareStatement(sql);

                ps.setString(1, user.getCodigo());
                ps.setString(2, user.getNombre());
                ps.setString(3, user.getCarrera());
                ps.setString(4, user.getTelefono());

                ps.setInt(5, user.getIdE());
                ps.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en actualizar estudiante de la db: " + e);
        }
        return false;
    }
}
