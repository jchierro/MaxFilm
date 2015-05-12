/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * CLASE SALA
 * @author jchierro
 */
public class Sala implements Serializable, Comparable<Sala> {
    protected String Id_Sala;
    protected String Nombre;
    protected String Tipo;
    protected String Num_butacas;
    protected String Cod_cine;
    protected List<Mobiliario> Mobiliarios;

    /**
     * CONSTRUCTOR DE LA CLASE SALA
     * @param Id_Sala
     * @param Nombre
     * @param Tipo
     * @param Num_butacas
     * @param Cod_cine 
     */
    public Sala(String Id_Sala, String Nombre, String Tipo, String Num_butacas, String Cod_cine) {
        this.Id_Sala = Id_Sala;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Num_butacas = Num_butacas;
        this.Cod_cine = Cod_cine;
        this.Mobiliarios = new ArrayList<>();
    }
    
    /**
     * COMPARETO DE LA CLASE SALA
     * @param otro
     * @return DEVUELVE UN VALOR INT
     */
    @Override
    public int compareTo(Sala otro) {
        return Id_Sala.compareTo(otro.Id_Sala);
    }
    
    /**
     * EQUALS DE LA CLASE SALA
     * @param otro
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    @Override
    public boolean equals(Object otro) {
        return Id_Sala.equals(((Sala)otro).Id_Sala);
    }

    /**
     * GET ID_SALA
     * @return DEVUELVE EL VALOR ID_SALA
     */
    public String getId_Sala() {
        return Id_Sala;
    }

    /**
     * SET ID_SALA
     * @param Id_Sala 
     */
    public void setId_Sala(String Id_Sala) {
        this.Id_Sala = Id_Sala;
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
     * GET TIPO
     * @return DEVUELVE EL VALOR TIPO
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * SET TIPO
     * @param Tipo 
     */
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    /**
     * GET NUM_BUTACAS
     * @return DEVUELVE EL VALOR NUM_BUTACAS
     */
    public String getNum_butacas() {
        return Num_butacas;
    }

    /**
     * SET NUM_BUTACAS
     * @param Num_butacas 
     */
    public void setNum_butacas(String Num_butacas) {
        this.Num_butacas = Num_butacas;
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
     * GET MOBILIARIOS
     * @return DEVUELVE LIST MOBILIARIOS
     */
    public List<Mobiliario> getMobiliarios() {
        return Mobiliarios;
    }

    /**
     * SET MOBILIARIOS
     * @param Mobiliarios 
     */
    public void setMobiliarios(List<Mobiliario> Mobiliarios) {
        this.Mobiliarios = Mobiliarios;
    }

    /**
     * TOSTRING DE LA CLASE SALA
     * @return DEVUELVE LA SALA
     */
    @Override
    public String toString() {
        return "Sala{" + "Id_Sala=" + Id_Sala + ", Nombre=" + Nombre + ", Tipo=" + Tipo + ", Num_butacas=" + Num_butacas + ", Cod_cine=" + Cod_cine + ", Mobiliarios=" + Mobiliarios + '}';
    }
    
}
