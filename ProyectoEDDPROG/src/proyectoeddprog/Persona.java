/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import java.io.Serializable;

/**
 * CLASE PERSONA, LA CLASE PERSONA TIENE DOS SUBCLASES: EMPLEADO Y VIP
 * @author jchierro
 */
public class Persona implements Serializable {
    protected String Dni;
    protected String Nombre;
    protected String Apellidos;
    protected String Edad;
    protected String Cod_cine;

    /**
     * CONSTRUCTOR DE LA CLASE PERSONA
     * @param Dni
     * @param Nombre
     * @param Apellidos
     * @param Edad
     * @param Cod_cine 
     */
    public Persona(String Dni, String Nombre, String Apellidos, String Edad, String Cod_cine) {
        this.Dni = Dni;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Edad = Edad;
        this.Cod_cine = Cod_cine;
    }

    /**
     * GET DNI
     * @return 
     */
    public String getDni() {
        return Dni;
    }

    /**
     * SET DNI
     * @param Dni 
     */
    public void setDni(String Dni) {
        this.Dni = Dni;
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
     * GET APELLIDOS
     * @return 
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * SET APELLIDOS
     * @param Apellidos 
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    /**
     * GET EDAD
     * @return 
     */
    public String getEdad() {
        return Edad;
    }

    /**
     * SET EDAD
     * @param Edad 
     */
    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    /**
     * GET COD_CINE
     * @return 
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
     * TOSTRING DE LA CLASE PERSONA
     * @return 
     */
    @Override
    public String toString() {
        return "Persona{" + "Dni=" + Dni + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Edad=" + Edad + ", Cod_cine=" + Cod_cine + '}';
    }
    
}
