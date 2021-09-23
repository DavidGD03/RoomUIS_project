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
import model.vo.DenunciaVo;

/**
 *
 * @author David Rojas, Julián Rodríguez
 */
public class DenunciaDao {

    Conexion c;
    Connection con;

    int i = 1;
    private ArrayList<DenunciaVo> listaDenuncias;
    Scanner teclado = new Scanner(System.in);

    public DenunciaDao() {
        this.listaDenuncias = new ArrayList<DenunciaVo>();

        c = new Conexion();
        con = c.getConexion();
    }

    public ResultSet obtenerDenuncias() {
        String sql = "SELECT * FROM denuncia";
        return queryWithResultSet(sql, 0);
    }
    

    public boolean guardarDenuncia(int idE, int idL, String titulo, String descripcion) {
        String sql = "INSERT INTO denuncia (idE, idL, titulo,descripcion) "
                + "VALUES (?,?,?,?)";

        DenunciaVo denuncia = new DenunciaVo(
                idE,
                idL,
                titulo,
                descripcion
        );

        Boolean check = queryWithBoolean(sql, denuncia, "execute");

        return check;
    }



    public ResultSet buscarDenuncia(String titulo) {
        String sql = "SELECT *FROM denuncia WHERE titulo LIKE '" + titulo + "%'";
        return queryWithResultSet(sql, 0);
    }
    
    public ResultSet buscarDenunciaId(int idD) {
        String sql = "SELECT *FROM denuncia WHERE idD = ?";
        return queryWithResultSet(sql, idD);
    }

    public boolean modificarDenuncia(DenunciaVo dataProducto) {
        boolean check = false;

        String sql = "UPDATE denuncia SET idE = ?, idL = ?, titulo = ?, descripcion = ?";
        check = queryWithBoolean(sql, dataProducto, "executeUpdate");

        return check;
    }

    public boolean eliminarDenuncia(int idD) {
        String sql = "DELETE FROM denuncia WHERE idD = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idD);
            ps.execute();
            
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar denuncia: " + e);
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
            System.out.println("Error traer datos denuncia: " + e);
        }

        return rs;
    }

    private Boolean queryWithBoolean(String sql, DenunciaVo denuncia, String type) {
        PreparedStatement ps = null;

        try {
            if (denuncia != null) {
                ps = con.prepareStatement(sql);
                ps.setInt(1, denuncia.getDenunciante());
                ps.setInt(2, denuncia.getLocacion());
                ps.setString(3, denuncia.getTitulo());
                ps.setString(4, denuncia.getDescripcion());

                switch (type) {
                    case "execute":
                        ps.execute();
                        break;

                    case "executeUpdate":
                        ps.setInt(6, denuncia.getId());
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
