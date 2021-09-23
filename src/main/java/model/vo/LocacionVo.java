/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.io.File;

/**
 * Esta clase crea y contiene la informacion de las locaciones al ser traidos de
 * la db
 *
 * @author David Rojas, Julián Rodríguez
 * @version 0.1
 *
 */
public class LocacionVo {

    private String direccion, extradir, detalles,imagen;
    private double precio;
    private int idL, idA;
    /**
     */
    public LocacionVo(int idL, int idA, String direccion, String extradir, double precio, String detalles, String imagen) {
        this.idL = idL;
        this.idA = idA;
        this.direccion = direccion;
        this.extradir = extradir;
        this.precio = precio;
        this.detalles = detalles;
        this.imagen = imagen;
    }

    public LocacionVo(int idA, String direccion, String extradir, double precio, String detalles, String imagen) {
        this.idA = idA;
        this.direccion = direccion;
        this.extradir = extradir;
        this.precio = precio;
        this.detalles = detalles;
        this.imagen = imagen;
    }


    public void modificar(int idL, int idA, String direccion, String extradir, double precio, String detalles, String imagen) {
        this.idL = idL;
        this.idA = idA;
        this.direccion = direccion;
        this.extradir = extradir;
        this.precio = precio;
        this.detalles = detalles;
        this.imagen = imagen;
    }

    public String toString() {
        String str = "idL: " + idL + ". id Arrendador: " + idA + ". Dirección: " + direccion + ". Extra Dir: " + extradir + ". Precio: $" + precio + ". Detalles: "
                + detalles;

        return str;
    }

    public int getArrendador() {
        return idA;
    }

    public void setArrendador(int idA) {
        this.idA = idA;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
     public String getExtraDir() {
        return extradir;
    }

    public void setExtraDir(String extradir) {
        this.extradir = extradir;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

     public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    
    public int getId() {
        return idL;
    }

    public void setId(int idL) {
        this.idL = idL;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
