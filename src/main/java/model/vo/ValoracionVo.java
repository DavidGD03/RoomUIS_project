/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 * Clase que representa las entidades de la tabla Valoracion en la db. 
 * 
 *
 * @author David Rojas, Julián Rodríguez
 * @version 0.1
 */
public class ValoracionVo {

    /**
     *
     *
     */
    private int idV, idE, idL,estrellas;
    private String titulo, descripcion;

    public ValoracionVo() {

        this.titulo = null;
        this.descripcion = null;  

        
    }

    /**
     * Constructor de la clase ValoracionVo
     *
     * @param idV
     * @param idE
     * @param idL
     * @param estrellas
     * @param titulo
     * @param descripcion
     */
    public ValoracionVo(int idV, int idE, int idL, String titulo, String descripcion, int estrellas) {
        this.idV = idV;
        this.idV = idE;
        this.idV = idL;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estrellas = estrellas;
    }

    public ValoracionVo(int idE, int idL, String titulo, String descripcion, int estrellas) {
        this.idE = idE;
        this.idL = idL;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estrellas = estrellas;
    }

    @Override
    public String toString() {
        String str = "idV: " + idV
                + ", idE: " + idE
                + ", idL: " + idL
                + ", Titulo: " + titulo
                + ", Descripcion: " + descripcion
                + ", Estrellas: " + estrellas;

        return str;
    }


    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }
    
    public int getIdL() {
        return idL;
    }

    public void setIdL(int idL) {
        this.idL = idL;
    }
    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

  

}
