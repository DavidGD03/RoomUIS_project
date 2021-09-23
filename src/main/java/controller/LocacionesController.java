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
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.dao.LocacionDao;
import model.vo.LocacionVo;

public class LocacionesController {
    static int idL= 47;
    private LocacionDao locacionDao;
    private JTable table;
    private DefaultTableModel model;

    public LocacionesController() {
        locacionDao = new LocacionDao();
    }

    /**
     * Este metodo carga las locaciones
     * 
     *
     * @return
     */
    public Boolean obtenerListaLocaciones() {
        ResultSet rs = locacionDao.obtenerLocaciones();

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] locacion = new String[6];

                while (rs.next()) {
                    locacion[0] = rs.getString("direccion");
                    locacion[1] = rs.getString("extradir");
                    locacion[2] = rs.getString("idAL");
                    locacion[3] = rs.getString("precio");
                    locacion[4] = rs.getString("detalles");
                    locacion[5] = rs.getString("imagen");
                    model.addRow(locacion);
                }
                return true;
                
            } catch (Exception e) {
                System.out.println("Error al recorrer locaciones: " + e);;
            }
        } else {
            System.out.println("No se recibio datos de locaciones, null");
        }
        return false;
    }
    
   

    public Boolean obtenerLocaciones() {
        ResultSet rs = locacionDao.obtenerLocaciones();

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] locacion = new String[6];

                while (rs.next()) {
                    locacion[0] = rs.getString("direccion");
                    locacion[1] = rs.getString("extradir");
                    locacion[2] = rs.getString("idAL");
                    locacion[3] = rs.getString("precio");
                    locacion[4] = rs.getString("detalles");
                    locacion[5] = rs.getString("imagen");

                    model.addRow(locacion);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer locaciones: " + e);;
            }
        } else {
            System.out.println("No se recibio datos locaciones, null");
        }
        return false;
    }

    
    public Boolean buscarLocacion(String nombre, String vista) {
        ResultSet rs = locacionDao.buscarLocacion(nombre);

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] locacion = new String[6];

                while (rs.next()) {
                    switch (vista) {
                        case "locacion":
                            locacion[0] = rs.getString("direccion");
                    locacion[1] = rs.getString("extradir");
                    locacion[2] = rs.getString("idAL");
                    locacion[3] = rs.getString("precio");
                    locacion[4] = rs.getString("detalles");
                    locacion[5] = rs.getString("imagen");
                            break;
                    }
                    
                    model.addRow(locacion);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer locaciones buscadas: " + e);;
            }
        } else {
            System.out.println("No se recibieron datos de locaciones buscadas, null");
        }
        return false;
    }
    
    public Boolean buscarLocacionPrMe(double precio, String vista) {
        ResultSet rs = locacionDao.buscarLocacionPrMe(precio);

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] locacion = new String[6];

                while (rs.next()) {
                    switch (vista) {
                        case "locacion":
                            locacion[0] = rs.getString("direccion");
                            locacion[1] = rs.getString("extradir");
                            locacion[2] = rs.getString("idAL");
                            locacion[3] = rs.getString("precio");
                            locacion[4] = rs.getString("detalles");
                            locacion[5] = rs.getString("imagen");
                            break;
                    }
                    
                    model.addRow(locacion);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer locaciones buscadas: " + e);;
            }
        } else {
            System.out.println("No se recibieron datos de locaciones buscadas, null");
        }
        return false;
    }


    /**
     * Metodo que pide al modelo que se añada un usuario a la db
     *
     * @return true si se realizo la operación, false si no
     */
    public boolean añadirLocacion(int idA, String direccion, String extradir, double precio, String detalles, String imagen) {
        idL++;
        boolean check = locacionDao.guardarLocacion(idA, direccion, extradir, precio, detalles, imagen);

        if (check) {
            System.out.println("\nLocación " + idL + " registrada correctamente!!");
        } else {
            System.out.println("\nError al registrar locación!!");
        }

        return check;
    }

    /**
     * Metodo que pide al modelo modificar una locación en la base de datos
     *
     * @param .
     * @return
     */
    public boolean modificarLocacion(LocacionVo locacion) {
        boolean check = locacionDao.modificarLocacion(locacion);
        if (check) {
            System.out.println("\nLocación modificada correctamente!!");
            obtenerLocaciones();
        } else {
            System.out.println("\nNo se encontró la locación!!");
        }

        return check;
    }

    /**
     * Metodo que elimina una locación
     *
     * @param id Id de la locación que se desea eliminar
     * @return
     */
    public boolean eliminarLocacion(int id) {
        boolean check = this.locacionDao.eliminarLocacion(id);
        if (check) {
            System.out.println("\nLocacion con id " + id + " eliminada correctamente!!");
        } else {
            System.out.println("\nNo se encontró locación con id " + id);
        }

        return check;
    }


    public void setTable(JTable table) {
        this.table = table;
        model = (DefaultTableModel) table.getModel();
    }
    
    public int getIdL2() {
        return idL;
    }
}
