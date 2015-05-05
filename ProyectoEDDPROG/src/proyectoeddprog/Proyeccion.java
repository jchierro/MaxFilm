/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import java.io.Serializable;
import java.util.Date;

/**
 * CLASE PROYECCION
 * @author jchierro
 */
public class Proyeccion implements Serializable {
    protected String Id_sala;
    protected String Id_entrada;
    protected String Id_pelicula;
    protected Date Fecha_proyeccion;

    /**
     * CONSTRUCTOR DE LA CLASE PROYECCION
     * @param Id_sala
     * @param Id_entrada
     * @param Id_pelicula
     * @param Fecha_proyeccion 
     */
    public Proyeccion(String Id_sala, String Id_entrada, String Id_pelicula, Date Fecha_proyeccion) {
        this.Id_sala = Id_sala;
        this.Id_entrada = Id_entrada;
        this.Id_pelicula = Id_pelicula;
        this.Fecha_proyeccion = Fecha_proyeccion;
    }

    /**
     * GET ID_SALA
     * @return DEVUELVE EL VALOR ID_SALA
     */
    public String getId_sala() {
        return Id_sala;
    }

    /**
     * SET ID_SALA
     * @param Id_sala 
     */
    public void setId_sala(String Id_sala) {
        this.Id_sala = Id_sala;
    }

    /**
     * GET ID_ENTRADA
     * @return DEVUELVE EL VALOR ID_ENTRADA
     */
    public String getId_entrada() {
        return Id_entrada;
    }

    /**
     * SET ID_ENTRADA
     * @param Id_entrada 
     */
    public void setId_entrada(String Id_entrada) {
        this.Id_entrada = Id_entrada;
    }

    /**
     * GET ID_PELICULA
     * @return DEVUELVE EL VALOR ID_PELICULA
     */
    public String getId_pelicula() {
        return Id_pelicula;
    }

    /**
     * SET ID_PELICULA
     * @param Id_pelicula 
     */
    public void setId_pelicula(String Id_pelicula) {
        this.Id_pelicula = Id_pelicula;
    }

    /**
     * GET FECHA_PROYECCION
     * @return DEVUELVE EL VALOR FECHA_PROYECCION
     */
    public Date getFecha_proyeccion() {
        return Fecha_proyeccion;
    }

    /**
     * SET FECHA_PROYECCION
     * @param Fecha_proyeccion 
     */
    public void setFecha_proyeccion(Date Fecha_proyeccion) {
        this.Fecha_proyeccion = Fecha_proyeccion;
    }

    /**
     * TOSTRING DE LA CLASE PROYECCION
     * @return DEVUELVE LA PROYECCION
     */
    @Override
    public String toString() {
        return "Proyeccion{" + "Id_sala=" + Id_sala + ", Id_entrada=" + Id_entrada + ", Id_pelicula=" + Id_pelicula + ", Fecha_proyeccion=" + Fecha_proyeccion + '}';
    }
    
}
