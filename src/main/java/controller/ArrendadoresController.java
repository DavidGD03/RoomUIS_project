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
import model.dao.ArrendadorDao;
import model.vo.ArrendadorVo;

/**
 * Clase que conecta la Vista con el Modelo
 *
 * @author David Rojas, Julián Rodríguez
 */
public class ArrendadoresController {
    static int idA= 47;
    private ArrendadorDao arrendadorDao;
    private JTable table;
    private DefaultTableModel model;
     
   
    public ArrendadoresController() {
        arrendadorDao = new ArrendadorDao();
        table = null;
        model = null;
    }

    /**
     * Metodo que pide al modelo que se añada un arrendador a la base de datos
     * @return true si se realizo la operación, false si no
     */
    public boolean añadirArrendador(String nombre, String correo, String telefono, String cedula) {
        idA++;
        boolean check = arrendadorDao.añadirArrendador(nombre,correo,telefono,cedula);
        if (check) {
            System.out.println("\nArrendador " + nombre + " registrado correctamente!!");
        } else {
            System.out.println("\nError al registrar nuevo arrendador!!");
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
    
    public int getIdArr() {
        return idA;
    }
}
