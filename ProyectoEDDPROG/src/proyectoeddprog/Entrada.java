/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import java.io.Serializable;

/**
 * CLASE ENTRADA
 * @author jchierro
 */
public class Entrada implements Serializable, Comparable<Entrada> {
    protected String Id_entrada;
    protected Double Precio;
    protected String Titulo_pelicula;
    protected String Cod_sala;
    protected String Cod_cine;

    /**
     * CONSTRUCTOR DE LA CLASE ENTRADA
     * @param Id_entrada
     * @param Precio
     * @param Titulo_pelicula
     * @param Cod_sala
     * @param Cod_cine 
     */
    public Entrada(String Id_entrada, Double Precio, String Titulo_pelicula, String Cod_sala, String Cod_cine) {
        this.Id_entrada = Id_entrada;
        this.Precio = Precio;
        this.Titulo_pelicula = Titulo_pelicula;
        this.Cod_sala = Cod_sala;
        this.Cod_cine = Cod_cine;
    }
    
    @Override
    public int compareTo(Entrada otro) {
        return Id_entrada.compareTo(otro.Id_entrada);
    }
    
    @Override
    public boolean equals(Object otro) {
        return Id_entrada.equals(((Entrada)otro).Id_entrada);
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
     * GET PRECIO
     * @return DEVUELVE EL VALOR PRECIO
     */
    public Double getPrecio() {
        return Precio;
    }

    /**
     * SET PRECIO
     * @param Precio 
     */
    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    /**
     * GET TITULO_PELICULA
     * @return DEVUELVE EL VALOR TITULO_PELICULA
     */
    public String getTitulo_pelicula() {
        return Titulo_pelicula;
    }

    /**
     * SET TITULO_PELICULA
     * @param Titulo_pelicula 
     */
    public void setTitulo_pelicula(String Titulo_pelicula) {
        this.Titulo_pelicula = Titulo_pelicula;
    }

    /**
     * GET COD_SALA
     * @return DEVUELVE EL VALOR COD_SALA
     */
    public String getCod_sala() {
        return Cod_sala;
    }

    /**
     * SET COD_SALA
     * @param Cod_sala 
     */
    public void setCod_sala(String Cod_sala) {
        this.Cod_sala = Cod_sala;
    }

    /**
     * GET COD_CINE
     * @return DEVUELVE EL VALOR COD_CINE
     */
    public String getCod_cine() {
        return Cod_cine;
    }

    /**
     * SET COD_CINE
     * @param Cod_cine 
     */
    public void setCod_cine(String Cod_cine) {
        this.Cod_cine = Cod_cine;
    }

    /**
     * TOSTRING DE LA CLASE ENTRADA
     * @return DEVUELVE LA ENTRADA
     */
    @Override
    public String toString() {
        return "Entrada{" + "Id_entrada=" + Id_entrada + ", Precio=" + Precio + ", Titulo_pelicula=" + Titulo_pelicula + ", Cod_sala=" + Cod_sala + ", Cod_cine=" + Cod_cine + '}';
    }
    
}
