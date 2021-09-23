/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.dao.AdminDao;
import model.vo.AdminVo;

/**
 * Clase que conecta la Vista con el Modelo
 *
 * @author David Rojas, Julián Rodríguez
 */
public class AdminController {

    private AdminDao adminDao;
    private JTable table;
    private DefaultTableModel model;

    public AdminController() {
        adminDao = new AdminDao();
        table = null;
        model = null;
    }

    /**
     * Metodo que pide al modelo que se añada un admin a la base de datos
     *
     * 
     */
    public boolean añadirAdmin(String nombre, String correo, String telefono, String cedula) {
        boolean check = adminDao.añadirAdmin(nombre,correo,telefono,cedula);
        if (check) {
            System.out.println("\nAdmin " + nombre + " registrado correctamente!!");
        } else {
            System.out.println("\nError al registrar nuevo admin!!");
        }

        return check;
    }

    /**
     * Asigna una vista al controlador para que este pueda cargar los datos
     * recibidos
     *
     * @param table Tabla de la vista que se desea actualizar
     */
    public void setTable(JTable table) {
        this.table = table;
        model = (DefaultTableModel) table.getModel();
    }
}
