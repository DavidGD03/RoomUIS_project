/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 * Esta clase crea y contiene la informacion de los productos al ser traidos de
 * la db
 *
 * @author David Rojas, Julián Rodríguez
 * @version 0.1
 *
 */
public class DenunciaVo {

    private String titulo, descripcion;
    private int idD, idE, idL;

    /**
     */
    public DenunciaVo(int idD, int idE, int idL, String titulo, String descripcion) {
        this.idD = idL;
        this.idE = idE;
        this.idL = idL;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public DenunciaVo(int idE, int idL, String titulo, String descripcion) {
        this.idE = idE;
        this.idL = idL;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    // recibir objeto
    public void modificar(int idD, int idE, int idL, String titulo, String descripcion) {
        this.idD = idL;
        this.idE = idE;
        this.idL = idL;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String toString() {
        String str = "id Denuncia: " + idD + ". id Denunciante: " + idE + ". id Locacion: " + idL + ". Titulo: " + titulo + ". Descripción: " + descripcion;

        return str;
    }

    public int getDenunciante() {
        return idE;
    }

    public void setDenunciante(int idE) {
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

    public int getLocacion() {
        return idL;
    }

    public void setLocacion(int idL) {
        this.idL = idL;
    }
    
    public int getId() {
        return idD;
    }

    public void setId(int idD) {
        this.idD = idD;
    }


}
