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
public class Mobiliario implements Serializable {
    protected Integer Id_mobiliario;
    protected String nombre;
    protected Integer Cantidad;
    protected String Fecha;
    protected Boolean Estado;
    protected Integer Cod_sala;

    /**
     * CONSTRUCTOR DE LA CLASE MOBILIARIO
     * @param Id_mobiliario
     * @param nombre
     * @param Cantidad
     * @param Fecha
     * @param Estado
     * @param Cod_sala 
     */
    public Mobiliario(Integer Id_mobiliario, String nombre, Integer Cantidad, String Fecha, Boolean Estado, Integer Cod_sala) {
        this.Id_mobiliario = Id_mobiliario;
        this.nombre = nombre;
        this.Cantidad = Cantidad;
        this.Fecha = Fecha;
        this.Estado = Estado;
        this.Cod_sala = Cod_sala;
    }

    /**
     * GET ID_MOBILIARIO
     * @return 
     */
    public Integer getId_mobiliario() {
        return Id_mobiliario;
    }

    /**
     * SET ID_MOBILIARIO
     * @param Id_mobiliario 
     */
    public void setId_mobiliario(Integer Id_mobiliario) {
        this.Id_mobiliario = Id_mobiliario;
    }

    /**
     * GET NOMBRE
     * @return 
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
     * @return 
     */
    public Integer getCantidad() {
        return Cantidad;
    }

    /**
     * SET CANTIDAD
     * @param Cantidad 
     */
    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     * GET FECHA
     * @return 
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
     * @return 
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
     * @return 
     */
    public Integer getCod_sala() {
        return Cod_sala;
    }

    /**
     * SET COD_SALA
     * @param Cod_sala 
     */
    public void setCod_sala(Integer Cod_sala) {
        this.Cod_sala = Cod_sala;
    }

    /**
     * TOSTRING DE LA CLASE MOBILIARIO
     * @return 
     */
    @Override
    public String toString() {
        return "Mobiliario{" + "Id_mobiliario=" + Id_mobiliario + ", nombre=" + nombre + ", Cantidad=" + Cantidad + ", Fecha=" + Fecha + ", Estado=" + Estado + ", Cod_sala=" + Cod_sala + '}';
    }
    
}
