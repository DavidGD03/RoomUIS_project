/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 * Clase que representa las entidades de la tabla Estudiante en la db. Es la
 * abstracción de un estudiante.
 *
 * @author David Rojas, Julián Rodríguez
 * @version 0.1
 */
public class EstudianteVo {

    /**

     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo Código del estudiante
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     *
     */
    private int idE;
    private String codigo, nombre, carrera, telefono;

    public EstudianteVo() {

        this.nombre = null;
        this.carrera = null;
        this.telefono = null;

        System.out.println(codigo);
    }

    /**
     * Constructor de la clase EstudianteVo
     *
     * @param idE Id del estudiante
     * @param codigo
     * @param nombre Nombre del estudiante
     * @param carrera
     * @param telefono Teléfono del estudiante
     */
    public EstudianteVo(int idE, String codigo, String nombre, String carrera, String telefono) {
        this.idE = idE;
        this.codigo = codigo;
        this.nombre = nombre;
        this.carrera = carrera;
        this.telefono = telefono;
    }

    public EstudianteVo(String codigo, String nombre, String carrera, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.carrera = carrera;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        String str = "idE: " + idE
                + ", Nombre: " + nombre
                + ", Carrera: " + carrera
                + ", Teléfono: " + telefono
                + ", Codigo: " + getCodigo();

        return str;
    }


    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
