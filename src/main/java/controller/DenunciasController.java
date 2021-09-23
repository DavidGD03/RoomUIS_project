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

import model.dao.DenunciaDao;
import model.vo.DenunciaVo;

public class DenunciasController {

    private DenunciaDao denunciaDao;
    private JTable table;
    private DefaultTableModel model;

    public DenunciasController() {
        denunciaDao = new DenunciaDao();
    }

    /**
     * Este metodo carga las listas de denuncias 
     * 
     *
     * @return
     */
    public Boolean obtenerListaDenuncias() {
        ResultSet rs = denunciaDao.obtenerDenuncias();

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] denuncia = new String[5];

                while (rs.next()) {
                    denuncia[0] = rs.getString("idD");
                    denuncia[1] = rs.getString("idE");
                    denuncia[2] = rs.getString("idL");
                    denuncia[3] = rs.getString("titulo");
                    denuncia[4] = rs.getString("descripcion");
                    model.addRow(denuncia);
                }
                return true;
                
            } catch (Exception e) {
                System.out.println("Error al recorrer denuncias: " + e);;
            }
        } else {
            System.out.println("No se recibio datos denuncias, null");
        }
        return false;
    }

    public Boolean obtenerDenuncias() {
        ResultSet rs = denunciaDao.obtenerDenuncias();

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] denuncia = new String[6];

                while (rs.next()) {
                    denuncia[0] = rs.getString("idD");
                    denuncia[1] = rs.getString("idE");
                    denuncia[2] = rs.getString("idL");
                    denuncia[3] = rs.getString("titulo");
                    denuncia[4] = rs.getString("descripcion");

                    model.addRow(denuncia);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer denuncias: " + e);;
            }
        } else {
            System.out.println("No se recibio datos denuncias, null");
        }
        return false;
    }

    
    public Boolean buscarDenuncia(String nombre, String vista) {
        ResultSet rs = denunciaDao.buscarDenuncia(nombre);

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] denuncia = new String[6];

                while (rs.next()) {
                    switch (vista) {
                        case "locacion":
                            denuncia[0] = rs.getString("idD");
                            denuncia[1] = rs.getString("idE");
                            denuncia[2] = rs.getString("idL");
                            denuncia[3] = rs.getString("titulo");
                            denuncia[4] = rs.getString("descripcion");
                            break;
                    }
                    
                    model.addRow(denuncia);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer denuncias buscadas: " + e);;
            }
        } else {
            System.out.println("No se recibio datos denuncias buscadas, null");
        }
        return false;
    }

    public DenunciaVo buscarDenunciaId(int idD) {
        ResultSet rs = denunciaDao.buscarDenunciaId(idD);

        if (rs != null) {
            try {
                while (rs.next()) {
                    DenunciaVo denuncia = new DenunciaVo(
                            rs.getInt("idL"),
                            rs.getInt("idE"),
                            rs.getInt("idL"),
                            rs.getString("titulo"),
                            rs.getString("descripcion")
                    );
                    return denuncia;
                }
            } catch (Exception e) {
                System.out.println("Error al buscar denuncia por id " + e);
            }
        }
        return null;
    }

    /**
     * Metodo que pide al modelo que se añada una denuncia a la base de datos
     *
     * @return 
     */
    public boolean añadirDenuncia(int idE, int idL, String titulo, String descripcion) {
        boolean check = denunciaDao.guardarDenuncia(idE, idL, titulo, descripcion);

        if (check) {
            System.out.println("\nDenuncia registrada correctamente!!");
        } else {
            System.out.println("\nError al registrar denuncia");
        }

        return check;
    }


    /**
     * Metodo para eliminar una denuncia
     *
     * @param idD Id de la denuncia que se quiere eliminar
     * @return 
     */
    public boolean eliminarDenuncia(int idD) {
        boolean check = this.denunciaDao.eliminarDenuncia(idD);
        if (check) {
            System.out.println("\nDenuncia con id " + idD + " eliminada correctamente!!");
            obtenerListaDenuncias();
        } else {
            System.out.println("\nNo se encontró denuncia con id " + idD);
        }

        return check;
    }



    public void setTable(JTable table) {
        this.table = table;
        model = (DefaultTableModel) table.getModel();
    }
}
