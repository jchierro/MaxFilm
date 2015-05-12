/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import java.io.Serializable;

/**
 * CLASE VIP, LA CLASE VIP HEREDA DE LA CLASE PERSONA
 * @author jchierro
 */
public class VIP extends Persona implements Serializable, Comparable<VIP> {
    protected String Telefono;
    protected String Codigo_Postal;

    /**
     * CONSTRUCTOR DE LA CLASE VIP
     * @param Dni
     * @param Nombre
     * @param Apellidos
     * @param Edad
     * @param Telefono
     * @param Codigo_Postal
     * @param Cod_cine 
     */
    public VIP(String Dni, String Nombre, String Apellidos, String Edad, String Telefono, String Codigo_Postal, String Cod_cine) {
        super(Dni, Nombre, Apellidos, Edad, Cod_cine);
        this.Telefono = Telefono;
        this.Codigo_Postal = Codigo_Postal;
    }
    
    /**
     * COMPARETO DE LA CLASE VIP
     * @param otro
     * @return DEVUELVE UN VALOR INT
     */
    @Override
    public int compareTo(VIP otro) {
        return Dni.compareTo(otro.Dni);
    }
    
    /**
     * EQUALS DE LA CLASE VIP
     * @param otro
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    @Override
    public boolean equals(Object otro) {
        return Dni.equals(((VIP)otro).Dni);
    }

    /**
     * GET TELEFONO DE LA CLASE VIP
     * @return DEVUELVE EL VALOR TELEFONO
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * SET TELEFONO DE LA CLASE VIP
     * @param Telefono 
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * GET CODIGO_POSTAL
     * @return DEVUELVE EL VALOR CODIGO_POSTAL
     */
    public String getCodigo_Postal() {
        return Codigo_Postal;
    }

    /**
     * SET CODIGO_POSTAL
     * @param Codigo_Postal 
     */
    public void setCodigo_Postal(String Codigo_Postal) {
        this.Codigo_Postal = Codigo_Postal;
    }

    /**
     * TOSTRING DE LA CLASE VIP
     * @return DEVUELVE EL VIP
     */
    @Override
    public String toString() {
        return "VIP{" + super.toString() + "Telefono=" + Telefono + ", Codigo_Postal=" + Codigo_Postal + '}';
    }
    
    
    
}
