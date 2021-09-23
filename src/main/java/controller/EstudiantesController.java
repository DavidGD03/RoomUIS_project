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
import model.dao.EstudianteDao;
import model.vo.EstudianteVo;

/**
 * Clase que conecta la Vista con el Modelo
 *
 * @author David Rojas, Julián Rodríguez
 */
public class EstudiantesController {
    static int idE= 14;
    private EstudianteDao estudianteDao;
    private JTable table;
    private DefaultTableModel model;

    public EstudiantesController() {
        estudianteDao = new EstudianteDao();
        table = null;
        model = null;
    }

    /**
     * Metodo que añade un estudiante a la base de datos
     *
     * @return
     */
    public boolean añadirEstudiante(String codigo, String nombre, String carrera, String telefono) {
        idE++;
        boolean check = estudianteDao.añadirEstudiante(codigo, nombre, carrera, telefono);
        if (check) {
            System.out.println("\nEstudiante " + nombre + " registrado correctamente!!");
        } else {
            System.out.println("\nError al registrar nuevo arrendador!!");
        }

        return check;
    }

   
    public void setTable(JTable table) {
        this.table = table;
        model = (DefaultTableModel) table.getModel();
    }
    
    public int getIdE() {
        return idE;
    }
}
