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
 * CLASE PRODUCTORA
 * @author jchierro
 */
public class Productora implements Serializable, Comparable<Productora> {
    protected String Id_productora;
    protected String Nombre;
    protected String Telefono;
    protected String Fax;
    protected String E_mail;
    protected String Representante;
    protected List<Pelicula> Peliculas;

    /**
     * CONSTRUCTOR DE LA CLASE PRODUCTORA
     * @param Id_productora
     * @param Nombre
     * @param Telefono
     * @param Fax
     * @param E_mail
     * @param Representante 
     */
    public Productora(String Id_productora, String Nombre, String Telefono, String Fax, String E_mail, String Representante) {
        this.Id_productora = Id_productora;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Fax = Fax;
        this.E_mail = E_mail;
        this.Representante = Representante;
        this.Peliculas = new ArrayList<>();
    }
    
    /**
     * COMPARETO DE LA CLASE PRODUCTORA
     * @param otro
     * @return DEVUELVE UN VALOR INT
     */
    @Override
    public int compareTo(Productora otro) {
        return Id_productora.compareTo(otro.Id_productora);
    }
    
    /**
     * EQUALS DE LA CLASE PRODUCTORA
     * @param otro
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    @Override
    public boolean equals(Object otro) {
        return Id_productora.equals(((Productora)otro).Id_productora);
    }

    /**
     * GET ID_PRODUCTORA
     * @return DEVUELVE EL VALOR ID_PRODUCTORA
     */
    public String getId_productora() {
        return Id_productora;
    }

    /**
     * SET ID_PRODUCTORA
     * @param Id_productora 
     */
    public void setId_productora(String Id_productora) {
        this.Id_productora = Id_productora;
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
     * GET REPRESENTANTE
     * @return DEVUELVE EL VALOR REPRESENTANTE
     */
    public String getRepresentante() {
        return Representante;
    }

    /**
     * SET REPRESENTANTE
     * @param Representante 
     */
    public void setRepresentante(String Representante) {
        this.Representante = Representante;
    }

    /**
     * GET PELICULAS
     * @return DEVUELVE LIST PELICULAS
     */
    public List<Pelicula> getPeliculas() {
        return Peliculas;
    }

    /**
     * SET PELICULAS
     * @param Peliculas 
     */
    public void setPeliculas(List<Pelicula> Peliculas) {
        this.Peliculas = Peliculas;
    }

    /**
     * TOSTRING DE LA CLASE PRODUCTORA
     * @return DEVUELVE LA PRODUCTORA
     */
    @Override
    public String toString() {
        return "Productora{" + "Id_productora=" + Id_productora + ", Nombre=" + Nombre + ", Telefono=" + Telefono + ", Fax=" + Fax + ", E_mail=" + E_mail + ", Representante=" + Representante + ", Peliculas=" + Peliculas + '}';
    }

}
