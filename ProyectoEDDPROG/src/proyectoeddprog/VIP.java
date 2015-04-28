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
public class VIP extends Persona implements Serializable, Comparable<VIP> {
    protected String Telefono;
    protected String Codigo_Postal;

    public VIP(String Dni, String Nombre, String Apellidos, String Telefono, String Codido_Postal, String Edad, String Cod_cine) {
        super(Dni, Nombre, Apellidos, Edad, Cod_cine);
        this.Telefono = Telefono;
        this.Codigo_Postal = Codigo_Postal;
    }
    
    @Override
    public int compareTo(VIP otro) {
        return Dni.compareTo(otro.Dni);
    }
    
    @Override
    public boolean equals(Object otro) {
        return Dni.equals(((VIP)otro).Dni);
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCodigo_Postal() {
        return Codigo_Postal;
    }

    public void setCodigo_Postal(String Codigo_Postal) {
        this.Codigo_Postal = Codigo_Postal;
    }

    @Override
    public String toString() {
        return "VIP{" + super.toString() + "Telefono=" + Telefono + ", Codigo_Postal=" + Codigo_Postal + '}';
    }
    
    
    
}
