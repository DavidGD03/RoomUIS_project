/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 * Clase que representa las entidades de la tabla Admin en la db. Es la
 * abstracción de un admin.
 *
 * @author David Rojas, Julián Rodríguez
 * @version 0.1
 */
public class AdminVo {

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
    private int idAd;
    private String cedula, nombre, correo, telefono;

    public AdminVo() {

        this.nombre = null;
        this.correo = null;
        this.telefono = null;

        System.out.println(cedula);
    }

    /**
     * Constructor de la clase AdminVo
     *
     * @param idAd Id del admin
     * @param nombre Nombre del Admin
     * @param correo Correo electronico del Admin
     * @param telefono Teléfono del admin
     * @param cedula Número de identificación
     */
    public AdminVo(int idAd, String nombre, String correo, String telefono, String cedula) {
        this.idAd = idAd;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    public AdminVo(String nombre, String correo, String telefono, String cedula) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        String str = "IdAd: " + idAd
                + ", Nombre: " + nombre
                + ", Correo: " + correo
                + ", Teléfono: " + telefono
                + ", Cedula: " + getCedula();

        return str;
    }


    public int getIdAd() {
        return idAd;
    }

    public void setIdAd(int idAd) {
        this.idAd = idAd;
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
