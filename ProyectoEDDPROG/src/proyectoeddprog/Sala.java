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
 *
 * @author jchierro
 */
public class Sala implements Serializable, Comparable<Sala> {
    protected String Id_Sala;
    protected String Nombre;
    protected String Tipo;
    protected String Num_butacas;
    protected String Cod_cine;
    protected List<Mobiliario> Mobiliarios;

    public Sala(String Id_Sala, String Nombre, String Tipo, String Num_butacas, String Cod_cine) {
        this.Id_Sala = Id_Sala;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Num_butacas = Num_butacas;
        this.Cod_cine = Cod_cine;
        this.Mobiliarios = new ArrayList<>();
    }
    
    @Override
    public int compareTo(Sala otro) {
        return Id_Sala.compareTo(otro.Id_Sala);
    }
    
    @Override
    public boolean equals(Object otro) {
        return Id_Sala.equals(((Sala)otro).Id_Sala);
    }

    public String getId_Sala() {
        return Id_Sala;
    }

    public void setId_Sala(String Id_Sala) {
        this.Id_Sala = Id_Sala;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getNum_butacas() {
        return Num_butacas;
    }

    public void setNum_butacas(String Num_butacas) {
        this.Num_butacas = Num_butacas;
    }

    public String getCod_cine() {
        return Cod_cine;
    }

    public void setCod_cine(String Cod_cine) {
        this.Cod_cine = Cod_cine;
    }

    public List<Mobiliario> getMobiliarios() {
        return Mobiliarios;
    }

    public void setMobiliarios(List<Mobiliario> Mobiliarios) {
        this.Mobiliarios = Mobiliarios;
    }

    @Override
    public String toString() {
        return "Sala{" + "Id_Sala=" + Id_Sala + ", Nombre=" + Nombre + ", Tipo=" + Tipo + ", Num_butacas=" + Num_butacas + ", Cod_cine=" + Cod_cine + ", Mobiliarios=" + Mobiliarios + '}';
    }
    
}
