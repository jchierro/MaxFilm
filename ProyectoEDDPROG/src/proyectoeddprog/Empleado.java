/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import java.io.Serializable;

/**
 * CLASE EMPLEADO, LA CLASE EMPLEADO HEREDA DE LA CLASE PERSONA
 * @author jchierro
 */
public class Empleado extends Persona implements Serializable {
    protected String Puesto;
    protected Double Sueldo;

    /**
     * CONSTRUCTOR DE LA CLASE EMPLEADO
     * @param Dni
     * @param Nombre
     * @param Apellidos
     * @param Edad
     * @param Puesto
     * @param Sueldo
     * @param Cod_cine 
     */
    public Empleado(String Dni, String Nombre, String Apellidos, String Edad, String Puesto, Double Sueldo, String Cod_cine) {
        super(Dni, Nombre, Apellidos, Edad, Cod_cine);
        this.Puesto = Puesto;
        this.Sueldo = Sueldo;
    }

    /**
     * GET PUESTO
     * @return 
     */
    public String getPuesto() {
        return Puesto;
    }

    /**
     * SET PUESTO
     * @param Puesto 
     */
    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    /**
     * GET PUESTO
     * @return 
     */
    public Double getSueldo() {
        return Sueldo;
    }

    /**
     * SET SUELDO
     * @param Sueldo 
     */
    public void setSueldo(Double Sueldo) {
        this.Sueldo = Sueldo;
    }

    /**
     * TOSTRING DE LA CLASE EMPLEADO
     * @return 
     */
    @Override
    public String toString() {
        return "Empleado{" + super.toString() + "Puesto=" + Puesto + ", Sueldo=" + Sueldo + '}';
    }
    
}
