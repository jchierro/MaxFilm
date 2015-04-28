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
public class Productora implements Serializable {
    protected Integer Id_productora;
    protected String Nombre;
    protected Integer Telefono;
    protected Integer Fax;
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
    public Productora(Integer Id_productora, String Nombre, Integer Telefono, Integer Fax, String E_mail, String Representante) {
        this.Id_productora = Id_productora;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Fax = Fax;
        this.E_mail = E_mail;
        this.Representante = Representante;
        this.Peliculas = new ArrayList<>();
    }

    /**
     * GET ID_PRODUCTORA
     * @return 
     */
    public Integer getId_productora() {
        return Id_productora;
    }

    /**
     * SET ID_PRODUCTORA
     * @param Id_productora 
     */
    public void setId_productora(Integer Id_productora) {
        this.Id_productora = Id_productora;
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
     * GET TELEFONO
     * @return 
     */
    public Integer getTelefono() {
        return Telefono;
    }

    /**
     * SET TELEFONO
     * @param Telefono 
     */
    public void setTelefono(Integer Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * GET FAX
     * @return 
     */
    public Integer getFax() {
        return Fax;
    }

    /**
     * SET FAX
     * @param Fax 
     */
    public void setFax(Integer Fax) {
        this.Fax = Fax;
    }

    /**
     * GET E_MAIL
     * @return 
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
     * @return 
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
     * @return 
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
     * @return 
     */
    @Override
    public String toString() {
        return "Productora{" + "Id_productora=" + Id_productora + ", Nombre=" + Nombre + ", Telefono=" + Telefono + ", Fax=" + Fax + ", E_mail=" + E_mail + ", Representante=" + Representante + ", Peliculas=" + Peliculas + '}';
    }

}