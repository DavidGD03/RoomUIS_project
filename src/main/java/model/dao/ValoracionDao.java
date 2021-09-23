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
import model.vo.ValoracionVo;

/**
 *
 * @author David Rojas, Julián Rodríguez
 */
public class ValoracionDao {

    Conexion c;
    Connection con;

    int i = 1;
    private ArrayList<ValoracionVo> listaValoraciones;
    Scanner teclado = new Scanner(System.in);

    public ValoracionDao() {
        this.listaValoraciones = new ArrayList<ValoracionVo>();

        c = new Conexion();
        con = c.getConexion();
    }

    public ResultSet obtenerValoraciones() {
        String sql = "SELECT * FROM valoracion";
        return queryWithResultSet(sql, 0);
    }
    
    public ResultSet obtenerLocacionesA(String idV) {
        String sql = "SELECT * FROM valoracion WHERE idV="+"?";
        return queryWithResultSet(sql, 0);
    }

    public boolean guardarValoracion(int idE, int idL, String titulo, String descripcion, int estrellas) {
        String sql = "INSERT INTO valoracion (idE, idL, titulo, descripcion, estrellas) "
                + "VALUES (?,?,?,?,4)";

        ValoracionVo valoracion = new ValoracionVo(
                idE,
                idL,
                titulo,
                descripcion,
                estrellas
        );

        Boolean check = queryWithBoolean(sql, valoracion, "execute");

        return check;
    }

    public ResultSet buscarValoracion(String titulo) {
        String sql = "SELECT *FROM valoracion WHERE titulo LIKE '" + titulo + "%'";
        return queryWithResultSet(sql, 0);
    }
    
    public ResultSet buscarValoracionId(int idV) {
        String sql = "SELECT *FROM valoracion WHERE idV = ?";
        return queryWithResultSet(sql, idV);
    }

    public boolean modificarValoracion(ValoracionVo dataProducto) {
        boolean check = false;

        String sql = "UPDATE valoracion SET idE = ?, idL = ?, titulo = ?, descripcion = ?, estrellas = ?";
        check = queryWithBoolean(sql, dataProducto, "executeUpdate");

        return check;
    }


    private ResultSet queryWithResultSet(String sql, int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            
           
            if (id > 0) {
                ps.setInt(1, id);
            }
            
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error traer datos valoración: " + e);
        }

        return rs;
    }

    private Boolean queryWithBoolean(String sql, ValoracionVo valoracion, String type) {
        PreparedStatement ps = null;

        try {
            if (valoracion != null) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, valoracion.getIdE());
                ps.setInt(2, valoracion.getIdL());
                ps.setString(3, valoracion.getTitulo());
                ps.setString(4, valoracion.getDescripcion());

                switch (type) {
                    case "execute":
                        ps.execute();
                        break;

                    case "executeUpdate":
                        ps.setInt(6, valoracion.getIdV());
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
