/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author jchierro
 */
public class Funcionalidades implements Serializable {

    protected List<Cine> Cines;
    protected List<Sala> Salas;
    protected List<Mobiliario> Mobiliarios;
    protected List<Empleado> Empleados;
    protected List<VIP> VIP;
    protected List<Proyeccion> Proyecciones;
    protected List<Entrada> Entradas;
    protected List<Pelicula> Peliculas;
    protected List<Productora> Productoras;

    protected int idCine;
    protected int idSala;
    protected int idVIP;

    public Funcionalidades() {
        this.Cines = new ArrayList<>();
        this.Salas = new ArrayList<>();
        this.Mobiliarios = new ArrayList<>();
        this.Empleados = new ArrayList<>();
        this.VIP = new ArrayList<>();
        this.Proyecciones = new ArrayList<>();
        this.Entradas = new ArrayList<>();
        this.Peliculas = new ArrayList<>();
        this.Productoras = new ArrayList<>();

        this.idCine = 1;
        this.idSala = 1;
        this.idVIP = 1;
    }

    //
    // COMIENZO FLUJOS DE DATOS
    //
    public void cargarDatos() throws IOException {
        ObjectInputStream entrada = null;

        try {
            entrada = new ObjectInputStream(new FileInputStream("datos.dat"));
            try {
                Cines = (List<Cine>) entrada.readObject();
                Salas = (List<Sala>) entrada.readObject();
                Mobiliarios = (List<Mobiliario>) entrada.readObject();
                Empleados = (List<Empleado>) entrada.readObject();
                VIP = (List<VIP>) entrada.readObject();
                Proyecciones = (List<Proyeccion>) entrada.readObject();
                Entradas = (List<Entrada>) entrada.readObject();
                Peliculas = (List<Pelicula>) entrada.readObject();
                Productoras = (List<Productora>) entrada.readObject();
                idCine = entrada.readInt();
                idSala = entrada.readInt();
                idVIP = entrada.readInt();
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public void guardarDatos() throws IOException {
        ObjectOutputStream salida = null;

        try {
            salida = new ObjectOutputStream(new FileOutputStream("datos.dat"));
            salida.writeObject(Cines);
            salida.writeObject(Salas);
            salida.writeObject(Mobiliarios);
            salida.writeObject(Empleados);
            salida.writeObject(VIP);
            salida.writeObject(Proyecciones);
            salida.writeObject(Entradas);
            salida.writeObject(Peliculas);
            salida.writeObject(Productoras);
            salida.writeInt(idCine);
            salida.writeInt(idSala);
            salida.writeInt(idVIP);
        } catch (FileNotFoundException ex) {
            System.out.println("Error de apertura del archivo de salida!");
            System.out.println(ex.getMessage());
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    //
    // FIN FLUJOS DE DATOS
    //
    //
    // COMIENZO LIMPIAR MODELOS
    //
    public void limpiarModelos(JTable j) {
        while (j.getRowCount() != 0) {
            ((DefaultTableModel) j.getModel()).removeRow(0);
        }
    }

    //
    // FIN LIMPIAR MODELOS
    //
    //
    // COMIENZO OPERACIONES CON CINES
    //
    public void nexoCineId(JTextField ca) {
        String id = "MFC-";
        String result = id.concat(Integer.toString(this.idCine));
        ca.setText(result);
        this.idCine++;
    }

    public void nexoCineCodCine(JComboBox co) {
        co.removeAllItems();
        for (int i = 0; i < Cines.size(); i++) {
            co.addItem(Cines.get(i).getId_cine());
        }
    }

    public boolean insertarCine(Cine c, DefaultTableModel d, JTable j) {
        if (!this.Cines.contains(c)) {
            this.Cines.add(c);
            cargarModeloCines(d, j);
            return true;
        } else {
            return false;
        }
    }

    public void borrarCine(int i, DefaultTableModel d, JTable j) {
        this.Cines.remove(i);
        cargarModeloCines(d, j);
    }

    public void modificarCine(int i, DefaultTableModel d, JTable j,
            String nombre, String direccion, String telefono, String fax, String e_mail) {
        Cine aux = this.Cines.get(i);
        //aux.setId_cine(id_cine);
        aux.setNombre(nombre);
        aux.setDireccion(direccion);
        aux.setTelefono(telefono);
        aux.setFax(fax);
        aux.setE_mail(e_mail);
        cargarModeloCines(d, j);
    }

    public Cine buscarCine(Cine c) {
        Cine result = null;
        int indice = Collections.binarySearch(this.Cines, c);
        if (indice >= 0) {
            result = this.Cines.get(indice);
        }
        return result;
    }

    public void cargarModeloCines(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel();

        limpiarModelos(j);

        d.addColumn("Id_cine");
        d.addColumn("Nombre");
        d.addColumn("Dirección");
        d.addColumn("Teléfono");
        d.addColumn("Fax");
        d.addColumn("E_mail");
        j.setModel(d);

        Object[] filaCines = new Object[d.getColumnCount()];
        for (int i = 0; i < Cines.size(); i++) {
            filaCines[0] = Cines.get(i).getId_cine();
            filaCines[1] = Cines.get(i).getNombre();
            filaCines[2] = Cines.get(i).getDireccion();
            filaCines[3] = Cines.get(i).getTelefono();
            filaCines[4] = Cines.get(i).getFax();
            filaCines[5] = Cines.get(i).getE_mail();
            d.addRow(filaCines);

            for (int k = 0; k < 6; k++) {
                DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
                modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
                j.getColumnModel().getColumn(k).setCellRenderer(modelocentrar);
            }
        }
    }

    //
    // FIN OPERACIONES CON CINES
    //
    //
    // COMIENZO OPERACIONES CON SALAS
    //
    public void nexoSalaId(JTextField ca) {
        String id = "MFS-";
        String result = id.concat(Integer.toString(this.idSala));
        ca.setText(result);
        this.idSala++;
    }

    public boolean insertarSala(Sala s, DefaultTableModel d, JTable j) {
        boolean result = false;
        Cine aux = new Cine(s.getCod_cine(), null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            if (!aux.Salas.contains(s)) {
                aux.Salas.add(s);
                cargarModeloSalas(d, j);
                result = true;
            }
        } else {
            result = false;
        }
        return result;
    }

    public void borrarSala(String x, String y, DefaultTableModel d, JTable j) {
        Cine aux = new Cine(y, null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            for (Sala i : aux.Salas) {
                if (i.Id_Sala.equals(x)) {
                    Sala aux2 = new Sala(i.getId_Sala(), i.getNombre(),
                            i.getTipo(), i.getNum_butacas(), i.getCod_cine());
                    aux.Salas.remove(aux2);
                    break;
                }
            }
            cargarModeloSalas(d, j);
        }
    }

    public void modificarSala(String x, String y, DefaultTableModel d, JTable j,
            String nombre, String tipo, String num_butacas, String cod_cine) {
        Cine aux = new Cine(y, null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            try {
                for (Sala i : aux.Salas) {
                    if (i.Id_Sala.equals(x) && i.getCod_cine().equals(cod_cine)) {
                        i.setNombre(nombre);
                        i.setTipo(tipo);
                        i.setNum_butacas(num_butacas);
                        i.setCod_cine(cod_cine);
                    }
                    if (i.Id_Sala.equals(x) && !i.getCod_cine().equals(cod_cine)) {
                        Sala aux2 = new Sala(x, i.getNombre(), i.getTipo(), i.getNum_butacas(),
                                i.getCod_cine());
                        aux.Salas.remove(aux2);
                        aux2 = new Sala(x, nombre, tipo, num_butacas,
                                cod_cine);
                        nexoModificarSala(aux2, d, j);
                    }
                    cargarModeloSalas(d, j);
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public void nexoModificarSala(Sala s, DefaultTableModel d, JTable j) {
        Cine aux = new Cine(s.getCod_cine(), null, null, null, null, null);
        //System.out.println(s.getCod_cine());
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            if (!aux.Salas.contains(s)) {
                aux.Salas.add(s);
                cargarModeloSalas(d, j);
                //System.out.println(aux);
            }
        }
    }

    public void cargarModeloSalas(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel();

        limpiarModelos(j);

        d.addColumn("Id_sala");
        d.addColumn("Nombre");
        d.addColumn("Tipo");
        d.addColumn("Num_butaca");
        d.addColumn("Cod_cine");
        j.setModel(d);

        Salas.clear();

        for (int i = 0; i < Cines.size(); i++) {
            Salas.addAll(Cines.get(i).getSalas());
        }

        Object[] filaSalas = new Object[d.getColumnCount()];
        for (int i = 0; i < Salas.size(); i++) {
            filaSalas[0] = Salas.get(i).getId_Sala();
            filaSalas[1] = Salas.get(i).getNombre();
            filaSalas[2] = Salas.get(i).getTipo();
            filaSalas[3] = Salas.get(i).getNum_butacas();
            filaSalas[4] = Salas.get(i).getCod_cine();
            d.addRow(filaSalas);

            for (int k = 0; k < 5; k++) {
                DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
                modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
                j.getColumnModel().getColumn(k).setCellRenderer(modelocentrar);
            }
        }
    }

    //
    // FIN OPERACIONES CON SALAS
    //
    
    //
    // COMIENZO OPERACIONES VIPS
    //
    
    public void nexoVIPId(JTextField ca) {
        String id = "MFV-";
        String result = id.concat(Integer.toString(this.idVIP));
        ca.setText(result);
        this.idVIP++;
    }
    
    public boolean insertarVIP(VIP v, DefaultTableModel d, JTable j) {
        boolean result = false;
        Cine aux = new Cine(v.getCod_cine(), null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            if (!aux.VIP.contains(v)) {
                aux.VIP.add(v);
                cargarModeloVIP(d, j);
                result = true;
            }
        } else {
            result = false;
        }
        return result;
    }
    
    public void borrarVIP(String x, String y, DefaultTableModel d, JTable j) {
        Cine aux = new Cine(y, null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            for (VIP i : aux.VIP) {
                if (i.Dni.equals(x)) {
                    VIP aux2 = new VIP(i.getDni(), i.getNombre(),
                            i.getApellidos(), i.getEdad(), i.getTelefono(),
                    i.getCodigo_Postal(),i.getCod_cine());
                    aux.VIP.remove(aux2);
                    break;
                }
            }
            cargarModeloVIP(d, j);
        }
    }
    
    public void modificarVIP(String x, String y, DefaultTableModel d, JTable j,
            String nombre, String apellidos, String edad, String telefono,
            String cod_postal, String cod_cine) {
        Cine aux = new Cine(y, null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            try {
                for (VIP i : aux.VIP) {
                    if (i.Dni.equals(x) && i.getCod_cine().equals(cod_cine)) {
                        i.setNombre(nombre);
                        i.setApellidos(apellidos);
                        i.setEdad(edad);
                        i.setTelefono(telefono);
                        i.setCodigo_Postal(cod_postal);
                        i.setCod_cine(cod_cine);
                    }
                    if (i.Dni.equals(x) && !i.getCod_cine().equals(cod_cine)) {
                        VIP aux2 = new VIP(x, i.getNombre(), i.getApellidos(), i.getEdad(),
                                i.getTelefono(),i.getCodigo_Postal(),i.getCod_cine());
                        aux.VIP.remove(aux2);
                        aux2 = new VIP(x, nombre, apellidos, edad, telefono,
                                cod_postal, cod_cine);
                        nexoModificarVIP(aux2, d, j);
                    }
                    cargarModeloVIP(d, j);
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    
    public void nexoModificarVIP(VIP v, DefaultTableModel d, JTable j) {
        Cine aux = new Cine(v.getCod_cine(), null, null, null, null, null);
        //System.out.println(s.getCod_cine());
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            if (!aux.VIP.contains(v)) {
                aux.VIP.add(v);
                cargarModeloVIP(d, j);
                //System.out.println(aux);
            }
        }
    }
    
    public void cargarModeloVIP(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel();

        limpiarModelos(j);

        d.addColumn("Dni");
        d.addColumn("Nombre");
        d.addColumn("Apellidos");
        d.addColumn("Edad");
        d.addColumn("Teléfono");
        d.addColumn("Código_postal");
        d.addColumn("Cod_cine");
        j.setModel(d);

        VIP.clear();

        for (int i = 0; i < Cines.size(); i++) {
            VIP.addAll(Cines.get(i).getVIP());
        }

        Object[] filaVIP = new Object[d.getColumnCount()];
        for (int i = 0; i < VIP.size(); i++) {
            filaVIP[0] = VIP.get(i).getDni();
            filaVIP[1] = VIP.get(i).getNombre();
            filaVIP[2] = VIP.get(i).getApellidos();
            filaVIP[3] = VIP.get(i).getEdad();
            filaVIP[4] = VIP.get(i).getTelefono();
            filaVIP[5] = VIP.get(i).getCodigo_Postal();
            filaVIP[6] = VIP.get(i).getCod_cine();
            d.addRow(filaVIP);

            for (int k = 0; k < 7; k++) {
                DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
                modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
                j.getColumnModel().getColumn(k).setCellRenderer(modelocentrar);
            }
        }
    }
    
    //
    // FIN OPERACIONES VIPS
    //
}
