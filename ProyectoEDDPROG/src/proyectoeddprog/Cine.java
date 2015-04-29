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
 * CLASE CINE
 * @author jchierro
 */
public class Cine implements Serializable, Comparable<Cine> {
    protected String Id_cine;
    protected String Nombre;
    protected String Direccion;
    protected String Telefono;
    protected String Fax;
    protected String E_mail;
    protected List<Sala> Salas;
    protected List<VIP> VIP;
    protected List<Empleado> Empleados;
    
    /**
     * CONSTRUCTOR DE LA CLASE CINE
     * @param Id_cine
     * @param Nombre
     * @param Direccion
     * @param Telefono
     * @param Fax
     * @param E_mail 
     */
    public Cine(String Id_cine, String Nombre, String Direccion, String Telefono, String Fax, String E_mail) {
        this.Id_cine = Id_cine;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Fax = Fax;
        this.E_mail = E_mail;
        this.Salas = new ArrayList<>();
        this.VIP = new ArrayList<>();
        this.Empleados = new ArrayList<>();
    }
    
    /**
     * COMPARETO DE LA CLASE CINE
     * @param otro
     * @return 
     */
    @Override
    public int compareTo(Cine otro) {
        return Id_cine.compareTo(otro.Id_cine);
    }
    
    /**
     * EQUALS DE LA CLASE CINE
     * @param otro
     * @return 
     */
    @Override
    public boolean equals(Object otro) {
        return Id_cine.equals(((Cine)otro).Id_cine);
    }
    
    /**
     * GET ID_CINE
     * @return DEVUELVE EL VALOR ID_CINE
     */
    public String getId_cine() {
        return Id_cine;
    }

    /**
     * SET ID_CINE
     * @param Id_cine 
     */
    public void setId_cine(String Id_cine) {
        this.Id_cine = Id_cine;
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
     * GET DIRECCION
     * @return DEVUELVE EL VALOR DIRECCION
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * SET DIRECCION
     * @param Direccion 
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * GET TELEFONO
     * @return DEVUELVE EL VALOR TELEFONO
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * SET TELEFONO
     * @param Telefono 
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * GET FAX
     * @return DEVUELVE EL VALOR FAX
     */
    public String getFax() {
        return Fax;
    }

    /**
     * SET FAX
     * @param Fax 
     */
    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    /**
     * GET E_MAIL
     * @return DEVUELVE EL VALOR E_MAIL
     */
    public String getE_mail() {
        return E_mail;
    }

    /**
     * SET E_MAIL
     * @param E_mail 
     */
    public void setE_mail(String E_mail) {
        this.E_mail = E_mail;
    }

    /**
     * GET SALAS
     * @return DEVUELVE LIST SALAS
     */
    public List<Sala> getSalas() {
        return Salas;
    }

    /**
     * SET SALAS
     * @param Salas 
     */
    public void setSalas(List<Sala> Salas) {
        this.Salas = Salas;
    }

    /**
     * GET VIP
     * @return DEVUELVE LIST SALAS
     */
    public List<VIP> getVIP() {
        return VIP;
    }

    /**
     * SET VIP
     * @param VIP 
     */
    public void setVIP(List<VIP> VIP) {
        this.VIP = VIP;
    }

    /**
     * GET EMPLEADOS
     * @return DEVUELVE LIST EMPLEADOS
     */
    public List<Empleado> getEmpleados() {
        return Empleados;
    }

    /**
     * SET EMPLEADOS
     * @param Empleados 
     */
    public void setEmpleados(List<Empleado> Empleados) {
        this.Empleados = Empleados;
    }

    /**
     * TOSTRING DE LA CLASE CINE
     * @return DEVUELVE EL CINE
     */
    @Override
    public String toString() {
        return "Cine{" + "Id_cine=" + Id_cine + ", Nombre=" + Nombre + ", Direccion=" + Direccion + ", Telefono=" + Telefono + ", Fax=" + Fax + ", E_mail=" + E_mail + ", Salas=" + Salas + ", VIP=" + VIP + ", Empleados=" + Empleados + '}';
    }
    
}
