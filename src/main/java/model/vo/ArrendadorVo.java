/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 * Clase que representa las entidades de la tabla Arrendador en la db. Es la
 * abstracción de un arrendador.
 *
 * @author David Rojas, Julián Rodríguez
 * @version 0.1
 */
public class ArrendadorVo {

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     *
     *
     */
    private int idA;
    private String cedula, nombre, correo, telefono;

    public ArrendadorVo() {

        this.nombre = null;
        this.correo = null;
        this.telefono = null;

        System.out.println(cedula);
    }

    /**
     * Constructor de la clase ArrendadorVo
     *
     * @param idA Id del arrendador
     * @param nombre Nombre del Usuario
     * @param correo Correo electronico del Usuario
     * @param telefono Teléfono del arrendador
     * @param cedula Número de identificación
     */
    public ArrendadorVo(int idA, String nombre, String correo, String telefono, String cedula) {
        this.idA = idA;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    public ArrendadorVo(String nombre, String correo, String telefono, String cedula) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        String str = "IdA: " + idA
                + ", Nombre: " + nombre
                + ", Correo: " + correo
                + ", Teléfono: " + telefono
                + ", Cedula: " + getCedula();

        return str;
    }


    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
