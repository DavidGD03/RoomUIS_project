/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author David Rojas, Julián Rodríguez
 */
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.dao.ValoracionDao;
import model.vo.ValoracionVo;

public class ValoracionController {

    private ValoracionDao valoracionDao;
    private JTable table;
    private DefaultTableModel model;

    public ValoracionController() {
        valoracionDao = new ValoracionDao();
    }

    /**
     * Este metodo carga la lista de Valoraciones
     * 
     *
     * @return
     */
    public Boolean obtenerListaValoracion() {
        ResultSet rs = valoracionDao.obtenerValoraciones();

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] valoracion = new String[5];

                while (rs.next()) {
                    valoracion[0] = rs.getString("idV");
                    valoracion[1] = rs.getString("titulo");
                    valoracion[2] = rs.getString("descripcion");
                    valoracion[3] = rs.getString("estrellas");
                    model.addRow(valoracion);
                }
                return true;
                
            } catch (Exception e) {
                System.out.println("Error al recorrer valoraciones: " + e);;
            }
        } else {
            System.out.println("No se recibio datos de valoraciones, null");
        }
        return false;
    }

    public Boolean obtenerValoraciones() {
        ResultSet rs = valoracionDao.obtenerValoraciones();

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] valoracion = new String[6];

                while (rs.next()) {
                    valoracion[0] = rs.getString("idV");
                    valoracion[1] = rs.getString("titulo");
                    valoracion[2] = rs.getString("descripcion");
                    valoracion[3] = rs.getString("estrellas");
                    model.addRow(valoracion);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer valoraciones: " + e);;
            }
        } else {
            System.out.println("No se recibio datos de valoraciones, null");
        }
        return false;
    }

    
    public Boolean buscarValoracion(String titulo, String vista) {
        ResultSet rs = valoracionDao.buscarValoracion(titulo);

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] valoracion = new String[4];

                while (rs.next()) {
                    switch (vista) {
                        case "valoracion":
                           valoracion[0] = rs.getString("idV");
                            valoracion[1] = rs.getString("titulo");
                            valoracion[2] = rs.getString("descripcion");
                            valoracion[3] = rs.getString("estrellas");
                            break;
                    }
                    
                    model.addRow(valoracion);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer valoraciones buscadas: " + e);;
            }
        } else {
            System.out.println("No se recibio datos de valoraciones buscadas, null");
        }
        return false;
    }

    public ValoracionVo buscarValoracionId(int idS) {
        ResultSet rs = valoracionDao.buscarValoracionId(idS);

        if (rs != null) {
            try {
                while (rs.next()) {
                    ValoracionVo valoracion = new ValoracionVo(
                            rs.getInt("idV"),
                            rs.getInt("idE"),
                            rs.getInt("idL"),
                            rs.getString("titulo"),
                            rs.getString("descripcion"),
                            rs.getInt("estrellas")
                    );
                    return valoracion;
                }
            } catch (Exception e) {
                System.out.println("Error al buscar valoracion por id " + e);
            }
        }
        return null;
    }

    /**
     * Metodo que pide que se añada la valoración
     *
     * @return 
     */
    public boolean añadirValoracion(int idE, int idL, String titulo, String descripcion, int estrellas) {
        boolean check = valoracionDao.guardarValoracion(idE, idL, titulo, descripcion,estrellas);

        if (check) {
            System.out.println("\nValoracion registrada correctamente!!");
        } else {
            System.out.println("\nError al registrar Valoracion");
        }

        return check;
    }






    public void setTable(JTable table) {
        this.table = table;
        model = (DefaultTableModel) table.getModel();
    }
}
