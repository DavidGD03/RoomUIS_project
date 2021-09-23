/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 * Esta clase crea y contiene la informacion de las solicitudes al ser traidos de
 * la db
 *
 * @author David Rojas, Julián Rodríguez
 * @version 0.1
 *
 */
public class SolicitudVo {

    private String mensaje;
    private int idS, idE, idAS;

    /**
     */
    public SolicitudVo(int idS, int idE, int idAS, String mensaje) {
        this.idS = idS;
        this.idE = idE;
        this.idAS = idAS;
        this.mensaje = mensaje;
    }

    public SolicitudVo(int idE, int idL, String mensaje) {
        this.idE = idE;
        this.idAS = idAS;
        this.mensaje = mensaje;
    }

    // recibir objeto
    public void modificar(int idS, int idE, int idL, String mensaje) {
        this.idS = idL;
        this.idE = idE;
        this.idAS = idAS;
        this.mensaje = mensaje;
    }

    public String toString() {
        String str = "id Solicitud: " + idS + ". id Estudiante: " + idE + ". id Arrendador: " + idAS + ". Mensaje: " + mensaje;

        return str;
    }

    public int getEstudiante() {
        return idE;
    }

    public void setEstudiante(int idE) {
        this.idE = idE;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public int getArrendador() {
        return idAS;
    }

    public void setArrendador(int idAS) {
        this.idAS = idAS;
    }
    
    public int getId() {
        return idS;
    }

    public void setId(int idS) {
        this.idS = idS;
    }


}
