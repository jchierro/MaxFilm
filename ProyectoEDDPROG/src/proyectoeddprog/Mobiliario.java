/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import java.io.Serializable;

/**
 * CLASE MOBILIARIO
 * @author jchierro
 */
public class Mobiliario implements Serializable, Comparable<Mobiliario> {
    protected String Id_mobiliario;
    protected String nombre;
    protected String Cantidad;
    protected String Fecha;
    protected Boolean Estado;
    protected String Cod_sala;

    /**
     * CONSTRUCTOR DE LA CLASE MOBILIARIO
     * @param Id_mobiliario
     * @param nombre
     * @param Cantidad
     * @param Fecha
     * @param Estado
     * @param Cod_sala 
     */
    public Mobiliario(String Id_mobiliario, String nombre, String Cantidad, String Fecha, Boolean Estado, String Cod_sala) {
        this.Id_mobiliario = Id_mobiliario;
        this.nombre = nombre;
        this.Cantidad = Cantidad;
        this.Fecha = Fecha;
        this.Estado = Estado;
        this.Cod_sala = Cod_sala;
    }
    
    /**
     * COMPARETO DE LA CLASE MOBILIARIO
     * @param otro
     * @return DEVUELVE UN VALOR INT
     */
    @Override
    public int compareTo(Mobiliario otro) {
        return Id_mobiliario.compareTo(otro.Id_mobiliario);
    }
    
    /**
     * EQUALS DE LA CLASE MOBILIARIO
     * @param otro
     * @return DEVUELVE EL VALOR BOOLEAN
     */
    @Override
    public boolean equals(Object otro) {
        return Id_mobiliario.equals(((Mobiliario)otro).Id_mobiliario);
    }

    /**
     * GET ID_MOBILIARIO
     * @return DEVUELVE EL VALOR ID_MOBILIARIO
     */
    public String getId_mobiliario() {
        return Id_mobiliario;
    }

    /**
     * SET ID_MOBILIARIO
     * @param Id_mobiliario 
     */
    public void setId_mobiliario(String Id_mobiliario) {
        this.Id_mobiliario = Id_mobiliario;
    }

    /**
     * GET NOMBRE
     * @return DEVUELVE EL VALOR NOMBRE
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * SET NOMBRE
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * GET CANTIDAD
     * @return DEVUELVE EL VALOR CANTIDAD
     */
    public String getCantidad() {
        return Cantidad;
    }

    /**
     * SET CANTIDAD
     * @param Cantidad 
     */
    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     * GET FECHA
     * @return DEVUELVE EL VALOR FECHA
     */
    public String getFecha() {
        return Fecha;
    }

    /**
     * SET FECHA
     * @param Fecha 
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * GET ESTADO
     * @return DEVUELVE EL VALOR ESTADO
     */
    public Boolean getEstado() {
        return Estado;
    }

    /**
     * SET ESTADO
     * @param Estado 
     */
    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
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
     * TOSTRING DE LA CLASE MOBILIARIO
     * @return DEVUELVE EL MOBILIARIO
     */
    @Override
    public String toString() {
        return "Mobiliario{" + "Id_mobiliario=" + Id_mobiliario + ", nombre=" + nombre + ", Cantidad=" + Cantidad + ", Fecha=" + Fecha + ", Estado=" + Estado + ", Cod_sala=" + Cod_sala + '}';
    }
    
}
