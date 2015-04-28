/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import java.io.Serializable;

/**
 *
 * @author jchierro
 */
public class Proyeccion implements Serializable {
    protected Sala Id_sala;
    protected Entrada Id_entrada;
    protected Pelicula Id_pelicula;
    protected String Fecha_proyeccion;

    public Proyeccion(Sala Id_sala, Entrada Id_entrada, Pelicula Id_pelicula, String Fecha_proyeccion) {
        this.Id_sala = Id_sala;
        this.Id_entrada = Id_entrada;
        this.Id_pelicula = Id_pelicula;
        this.Fecha_proyeccion = Fecha_proyeccion;
    }

    public Sala getId_sala() {
        return Id_sala;
    }

    public void setId_sala(Sala Id_sala) {
        this.Id_sala = Id_sala;
    }

    public Entrada getId_entrada() {
        return Id_entrada;
    }

    public void setId_entrada(Entrada Id_entrada) {
        this.Id_entrada = Id_entrada;
    }

    public Pelicula getId_pelicula() {
        return Id_pelicula;
    }

    public void setId_pelicula(Pelicula Id_pelicula) {
        this.Id_pelicula = Id_pelicula;
    }

    public String getFecha_proyeccion() {
        return Fecha_proyeccion;
    }

    public void setFecha_proyeccion(String Fecha_proyeccion) {
        this.Fecha_proyeccion = Fecha_proyeccion;
    }

    @Override
    public String toString() {
        return "Proyeccion{" + "Id_sala=" + Id_sala + ", Id_entrada=" + Id_entrada + ", Id_pelicula=" + Id_pelicula + ", Fecha_proyeccion=" + Fecha_proyeccion + '}';
    }
    
}
