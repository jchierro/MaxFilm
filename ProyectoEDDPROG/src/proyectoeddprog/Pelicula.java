/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import java.io.Serializable;

/**
 * CLASE PELICULA
 * @author jchierro
 */
public class Pelicula implements Serializable, Comparable<Pelicula> {
    protected String Id_pelicula;
    protected String Nombre;
    protected String Director;
    protected String Año;
    protected String Edad;
    protected String Pais;
    protected String Genero;
    protected String Duracion;
    protected String Cod_productora;

    /**
     * CONSTRUCTOR DE LA CASE PELICULA
     * @param Id_pelicula
     * @param Nombre
     * @param Director
     * @param Año
     * @param Edad
     * @param Pais
     * @param Genero
     * @param Duracion
     * @param Cod_productora 
     */
    public Pelicula(String Id_pelicula, String Nombre, String Director, String Año, String Edad, String Pais, String Genero, String Duracion, String Cod_productora) {
        this.Id_pelicula = Id_pelicula;
        this.Nombre = Nombre;
        this.Director = Director;
        this.Año = Año;
        this.Edad = Edad;
        this.Pais = Pais;
        this.Genero = Genero;
        this.Duracion = Duracion;
        this.Cod_productora = Cod_productora;
    }
    
    /**
     * COMPARETO DE CLASE PELICULA
     * @param otro
     * @return DEVUELVE UN VALOR INT
     */
    @Override
    public int compareTo(Pelicula otro) {
        return Id_pelicula.compareTo(otro.Id_pelicula);
    }
    
    /**
     * EQUALS DE LA CLASE PELICULA
     * @param otro
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    @Override
    public boolean equals(Object otro) {
        return Id_pelicula.equals(((Pelicula)otro).Id_pelicula);
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
     * GET NOMBRE
     * @return DEVUELVE EL VALOR NOMBRE
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * SET NOMBRE
     * @param Nombre 
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * GET DIRECTOR
     * @return DEVUELVE EL VALOR DIRECTOR
     */
    public String getDirector() {
        return Director;
    }

    /**
     * SET DIRECTOR
     * @param Director 
     */
    public void setDirector(String Director) {
        this.Director = Director;
    }

    /**
     * GET AÑO
     * @return DEVUELVE EL VALOR AÑO
     */
    public String getAño() {
        return Año;
    }

    /**
     * SET AÑO
     * @param Año 
     */
    public void setAño(String Año) {
        this.Año = Año;
    }

    /**
     * GET EDAD
     * @return DEVUELVE EL VALOR EDAD
     */
    public String getEdad() {
        return Edad;
    }

    /**
     * SET EDAD
     * @param Edad 
     */
    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    /**
     * GET PAIS
     * @return DEVUELVE EL VALOR PAIS
     */
    public String getPais() {
        return Pais;
    }
    
    /**
     * SET PAIS
     * @param Pais 
     */
    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    /**
     * GET GENERO
     * @return DEVUELVE EL VALOR GENERO
     */
    public String getGenero() {
        return Genero;
    }

    /**
     * SET GENERO
     * @param Genero 
     */
    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    /**
     * GET DURACION
     * @return DEVUELVE EL VALOR DURACION
     */
    public String getDuracion() {
        return Duracion;
    }

    /**
     * SET DURACION
     * @param Duracion 
     */
    public void setDuracion(String Duracion) {
        this.Duracion = Duracion;
    }

    /**
     * GET COD_PRODUCTORA
     * @return DEVUELVE EL VALOR COD_PRODUCTORA
     */
    public String getCod_productora() {
        return Cod_productora;
    }

    /**
     * SET COD_PRODUCTORA
     * @param Cod_productora 
     */
    public void setCod_productora(String Cod_productora) {
        this.Cod_productora = Cod_productora;
    }

    /**
     * TOSTRING DE LA CLASE PELICULA
     * @return DEVUELVE LA PELICULA
     */
    @Override
    public String toString() {
        return "Pelicula{" + "Id_pelicula=" + Id_pelicula + ", Nombre=" + Nombre + ", Director=" + Director + ", A\u00f1o=" + Año + ", Edad=" + Edad + ", Pais=" + Pais + ", Genero=" + Genero + ", Duracion=" + Duracion + ", Cod_productora=" + Cod_productora + '}';
    }
    
}
