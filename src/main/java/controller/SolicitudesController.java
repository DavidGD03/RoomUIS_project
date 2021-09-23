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

import model.dao.SolicitudDao;
import model.vo.SolicitudVo;

public class SolicitudesController {

    private SolicitudDao solicitudDao;
    private JTable table;
    private DefaultTableModel model;

    public SolicitudesController() {
        solicitudDao = new SolicitudDao();
    }

    /**
     * Este metodo carga la lista de solicitudes
     * 
     *
     * @return
     */
    public Boolean obtenerListaSolicitudes() {
        ResultSet rs = solicitudDao.obtenerSolicitudes();

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] solicitud = new String[5];

                while (rs.next()) {
                    solicitud[0] = rs.getString("idS");
                    solicitud[1] = rs.getString("idE");
                    solicitud[2] = rs.getString("idAS");
                    solicitud[3] = rs.getString("mensaje");
                    model.addRow(solicitud);
                }
                return true;
                
            } catch (Exception e) {
                System.out.println("Error al recorrer solicitudes: " + e);;
            }
        } else {
            System.out.println("No se recibio datos solicitudes, null");
        }
        return false;
    }
    
     public Boolean obtenerListaSolicitudesA(int idAS) {
        ResultSet rs = solicitudDao.obtenerSolicitudesA(idAS);

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] solicitud = new String[5];

                while (rs.next()) {
                    solicitud[0] = rs.getString("idS");
                    solicitud[1] = rs.getString("idE");
                    solicitud[2] = rs.getString("idAS");
                    solicitud[3] = rs.getString("mensaje");
                    model.addRow(solicitud);
                }
                return true;
                
            } catch (Exception e) {
                System.out.println("Error al recorrer solicitudes: " + e);;
            }
        } else {
            System.out.println("No se recibio datos solicitudes, null");
        }
        return false;
    }

    public Boolean obtenerSolicitudes() {
        ResultSet rs = solicitudDao.obtenerSolicitudes();

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] solicitud = new String[6];

                while (rs.next()) {
                    solicitud[0] = rs.getString("idS");
                    solicitud[1] = rs.getString("idE");
                    solicitud[2] = rs.getString("idAS");
                    solicitud[3] = rs.getString("mensaje");

                    model.addRow(solicitud);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer solicitudes: " + e);;
            }
        } else {
            System.out.println("No se recibio datos solicitudes, null");
        }
        return false;
    }

    
    public Boolean buscarLocacion(String mensaje, String vista) {
        ResultSet rs = solicitudDao.buscarSolicitud(mensaje);

        if (rs != null) {
            try {
                model.setNumRows(0);
                String[] solicitud = new String[4];

                while (rs.next()) {
                    switch (vista) {
                        case "solicitud":
                           solicitud[0] = rs.getString("idS");
                            solicitud[1] = rs.getString("idE");
                            solicitud[2] = rs.getString("idAS");
                            solicitud[3] = rs.getString("mensaje");
                            break;
                    }
                    
                    model.addRow(solicitud);
                }
                return true;
            } catch (Exception e) {
                System.out.println("Error al recorrer solicitudes buscadas: " + e);;
            }
        } else {
            System.out.println("No se recibio datos solicitudes buscadas, null");
        }
        return false;
    }

    public SolicitudVo buscarSolicitudId(int idS) {
        ResultSet rs = solicitudDao.buscarSolicitudId(idS);

        if (rs != null) {
            try {
                while (rs.next()) {
                    SolicitudVo solicitud = new SolicitudVo(
                            rs.getInt("idS"),
                            rs.getInt("idE"),
                            rs.getInt("idAS"),
                            rs.getString("mensaje")
                    );
                    return solicitud;
                }
            } catch (Exception e) {
                System.out.println("Error al buscar solicitud por id " + e);
            }
        }
        return null;
    }

    /**
     * Metodo que pide añadir una solicitud
     *
     * @return 
     */
    public boolean añadirSolicitud(int idE, int idL, String mensaje) {
        boolean check = solicitudDao.guardarSolicitud(idE, idL, mensaje);

        if (check) {
            System.out.println("\nSolicitud registrada correctamente!!");
        } else {
            System.out.println("\nError al registrar solicitud");
        }

        return check;
    }


    /**
     * Metodo que pide al modelo que elimine una solicitud de la db
     *
     * @param idS Id de la solicitud que se desea eliminar
     * @return 
     */
    public boolean eliminarSolicitud(int idS) {
        boolean check = this.solicitudDao.eliminarSolicitud(idS);
        if (check) {
            System.out.println("\nSolicitud con id " + idS + " eliminada correctamente!!");
        } else {
            System.out.println("\nNo se encontró solicitud con id " + idS);
        }

        return check;
    }

    public void setTable(JTable table) {
        this.table = table;
        model = (DefaultTableModel) table.getModel();
    }
}
