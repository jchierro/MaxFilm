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
public class Pelicula implements Serializable {
    protected Integer Id_pelicula;
    protected String Nombre;
    protected String Director;
    protected Integer Año;
    protected Integer Edad;
    protected String Pais;
    protected String Genero;
    protected Integer Duracion;
    protected Integer Cod_productora;

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
    public Pelicula(Integer Id_pelicula, String Nombre, String Director, Integer Año, Integer Edad, String Pais, String Genero, Integer Duracion, Integer Cod_productora) {
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
     * GET ID_PELICULA
     * @return 
     */
    public Integer getId_pelicula() {
        return Id_pelicula;
    }

    /**
     * SET ID_PELICULA
     * @param Id_pelicula 
     */
    public void setId_pelicula(Integer Id_pelicula) {
        this.Id_pelicula = Id_pelicula;
    }

    /**
     * GET NOMBRE
     * @return 
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
     * @return 
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
     * @return 
     */
    public Integer getAño() {
        return Año;
    }

    /**
     * SET AÑO
     * @param Año 
     */
    public void setAño(Integer Año) {
        this.Año = Año;
    }

    /**
     * GET EDAD
     * @return 
     */
    public Integer getEdad() {
        return Edad;
    }

    /**
     * SET EDAD
     * @param Edad 
     */
    public void setEdad(Integer Edad) {
        this.Edad = Edad;
    }

    /**
     * GET PAIS
     * @return 
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
     * @return 
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
     * @return 
     */
    public Integer getDuracion() {
        return Duracion;
    }

    /**
     * SET DURACION
     * @param Duracion 
     */
    public void setDuracion(Integer Duracion) {
        this.Duracion = Duracion;
    }

    /**
     * GET COD_PRODUCTORA
     * @return 
     */
    public Integer getCod_productora() {
        return Cod_productora;
    }

    /**
     * SET COD_PRODUCTORA
     * @param Cod_productora 
     */
    public void setCod_productora(Integer Cod_productora) {
        this.Cod_productora = Cod_productora;
    }

    /**
     * TOSTRING DE LA CLASE PELICULA
     * @return 
     */
    @Override
    public String toString() {
        return "Pelicula{" + "Id_pelicula=" + Id_pelicula + ", Nombre=" + Nombre + ", Director=" + Director + ", A\u00f1o=" + Año + ", Edad=" + Edad + ", Pais=" + Pais + ", Genero=" + Genero + ", Duracion=" + Duracion + ", Cod_productora=" + Cod_productora + '}';
    }
    
}
