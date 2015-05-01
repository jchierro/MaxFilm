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
    protected int idMobiliario;

    protected TreeSet<String> VIPDni;
    protected TreeSet<String> EmpleadoDni;

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
        this.idMobiliario = 1;

        this.VIPDni = new TreeSet<>();
        this.EmpleadoDni = new TreeSet<>();
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
                idMobiliario = entrada.readInt();
                VIPDni = (TreeSet<String>) entrada.readObject();
                EmpleadoDni = (TreeSet<String>) entrada.readObject();
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
            salida.writeInt(idMobiliario);
            salida.writeObject(VIPDni);
            salida.writeObject(EmpleadoDni);
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
        aux.setNombre(nombre);
        aux.setDireccion(direccion);
        aux.setTelefono(telefono);
        aux.setFax(fax);
        aux.setE_mail(e_mail);
        cargarModeloCines(d, j);
    }

    /*public Cine buscarCine(Cine c) {
     Cine result = null;
     int indice = Collections.binarySearch(this.Cines, c);
     if (indice >= 0) {
     result = this.Cines.get(indice);
     }
     return result;
     }*/
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

    public void nexoSalaCodSala(JComboBox co) {
        co.removeAllItems();
        for (int i = 0; i < Cines.size(); i++) {
            for (int j = 0; j < Cines.get(i).Salas.size(); j++) {
                co.addItem(Cines.get(i).Salas.get(j).getId_Sala());
            }
        }
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
            for (Iterator<Sala> it = aux.Salas.iterator(); it.hasNext();) {
                Sala aux2 = it.next();
                if (aux2.getId_Sala().equals(x)) {
                    it.remove();
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
            for (Iterator<Sala> it = aux.Salas.iterator(); it.hasNext();) {
                Sala aux2 = it.next();
                if (aux2.getId_Sala().equals(x) && aux2.getCod_cine().equals(cod_cine)) {
                    aux2.setNombre(nombre);
                    aux2.setTipo(tipo);
                    aux2.setNum_butacas(num_butacas);
                    aux2.setCod_cine(cod_cine);
                }
                if (aux2.getId_Sala().equals(x) && !aux2.getCod_cine().equals(cod_cine)) {
                    it.remove();
                    aux2 = new Sala(x, nombre, tipo, num_butacas, cod_cine);
                    nexoModificarSala(aux2, d, j);
                }
                cargarModeloSalas(d, j);
            }
        }
    }

    public void nexoModificarSala(Sala s, DefaultTableModel d, JTable j) {
        Cine aux = new Cine(s.getCod_cine(), null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            if (!aux.Salas.contains(s)) {
                aux.Salas.add(s);
                cargarModeloSalas(d, j);
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
    // COMIENZO OPERACIONES CON MOBILIARIOS
    //
    public void nexoMobiliarioId(JTextField ca) {
        String id = "MFM-";
        String result = id.concat(Integer.toString(this.idMobiliario));
        ca.setText(result);
        this.idMobiliario++;
    }

    public boolean insertarMobiliario(Mobiliario m, DefaultTableModel d, JTable j) {
        boolean result = false;
        for (int i = 0; i < Cines.size(); i++) {
            for (Iterator<Sala> it = Cines.get(i).Salas.iterator(); it.hasNext();) {
                Sala aux = it.next();
                if (aux.getId_Sala().equals(m.getCod_sala())) {
                    if (!aux.Mobiliarios.contains(m)) {
                        aux.Mobiliarios.add(m);
                        cargarModeloMobiliarios(d, j);
                        result = true;
                    } else {
                        result = false;
                    }
                }
            }

        }
        return result;
    }

    public void borrarMobiliario(String x, String y, DefaultTableModel d, JTable j) {
        for (int i = 0; i < Cines.size(); i++) {
            for (int k = 0; k < Cines.get(i).Salas.size(); k++) {
                for (Iterator<Mobiliario> it = Cines.get(i).Salas.get(k).Mobiliarios.iterator(); it.hasNext();) {
                    Mobiliario aux = it.next();
                    if (aux.getId_mobiliario().equals(x)) {
                        it.remove();
                    }
                }
            }
        }
        cargarModeloMobiliarios(d, j);
    }

    public void cargarModeloMobiliarios(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel();

        limpiarModelos(j);

        d.addColumn("Id_mobiliario");
        d.addColumn("Nombre");
        d.addColumn("Cantidad");
        d.addColumn("Fecha");
        d.addColumn("Estado");
        d.addColumn("Cod_sala");
        j.setModel(d);

        Mobiliarios.clear();

        for (int i = 0; i < Cines.size(); i++) {
            for (int k = 0; k < Cines.get(i).Salas.size(); k++) {
                Mobiliarios.addAll(Cines.get(i).Salas.get(k).getMobiliarios());
            }
        }

        Object[] filaMobiliarios = new Object[d.getColumnCount()];
        for (int i = 0; i < Mobiliarios.size(); i++) {
            filaMobiliarios[0] = Mobiliarios.get(i).getId_mobiliario();
            filaMobiliarios[1] = Mobiliarios.get(i).getNombre();
            filaMobiliarios[2] = Mobiliarios.get(i).getCantidad();
            filaMobiliarios[3] = Mobiliarios.get(i).getFecha();
            filaMobiliarios[4] = Mobiliarios.get(i).getEstado();
            filaMobiliarios[5] = Mobiliarios.get(i).getCod_sala();
            d.addRow(filaMobiliarios);

            for (int k = 0; k < 6; k++) {
                DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
                modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
                j.getColumnModel().getColumn(k).setCellRenderer(modelocentrar);
            }
        }
    }

    //
    // FIN OPERACIONES CON MOBILIARIOS
    //
    //
    // COMIENZO OPERACIONES CON VIPS
    //
    public boolean nexoVIPCompruebaDni(String Dni) {
        return this.VIPDni.add(Dni);
    }

    public boolean insertarVIP(VIP v, DefaultTableModel d, JTable j) {
        boolean result = false;
        boolean dni = nexoVIPCompruebaDni(v.getDni());
        if (dni == true) {
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
        }
        return result;
    }

    public void borrarVIP(String x, String y, DefaultTableModel d, JTable j) {
        Cine aux = new Cine(y, null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            for (Iterator<VIP> it = aux.VIP.iterator(); it.hasNext();) {
                VIP aux2 = it.next();
                if (aux2.getDni().equals(x)) {
                    this.VIPDni.remove(aux2.getDni());
                    it.remove();
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
            for (Iterator<VIP> it = aux.VIP.iterator(); it.hasNext();) {
                VIP aux2 = it.next();
                if (aux2.getDni().equals(x) && aux2.getCod_cine().equals(cod_cine)) {
                    aux2.setNombre(nombre);
                    aux2.setApellidos(apellidos);
                    aux2.setEdad(edad);
                    aux2.setTelefono(telefono);
                    aux2.setCodigo_Postal(cod_postal);
                    aux2.setCod_cine(cod_cine);
                }
                if (aux2.getDni().equals(x) && !aux2.getCod_cine().equals(cod_cine)) {
                    it.remove();
                    aux2 = new VIP(x, nombre, apellidos, edad, telefono,
                            cod_postal, cod_cine);
                    nexoModificarVIP(aux2, d, j);
                }
                cargarModeloVIP(d, j);
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
    // FIN OPERACIONES CON VIPS
    //
    //
    // COMIENZO OPERACIONES CON EMPLEADOS
    //
    public boolean nexoEmpleadoCompruebaDni(String Dni) {
        return this.EmpleadoDni.add(Dni);
    }

    public boolean insertarEmpleado(Empleado e, DefaultTableModel d, JTable j) {
        boolean result = false;
        boolean dni = nexoEmpleadoCompruebaDni(e.getDni());
        //System.out.println(dni);
        if (dni == true) {
            Cine aux = new Cine(e.getCod_cine(), null, null, null, null, null);
            int indice = Collections.binarySearch(this.Cines, aux);
            if (indice >= 0) {
                aux = this.Cines.get(indice);
                if (!aux.Empleados.contains(e)) {
                    aux.Empleados.add(e);
                    cargarModeloEmpleados(d, j);
                    result = true;
                }
            } else {
                result = false;
            }
        }
        return result;
    }

    public void borrarEmpleado(String x, String y, DefaultTableModel d, JTable j) {
        Cine aux = new Cine(y, null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            for (Iterator<Empleado> it = aux.Empleados.iterator(); it.hasNext();) {
                Empleado aux2 = it.next();
                if (aux2.getDni().equals(x)) {
                    this.EmpleadoDni.remove(aux2.getDni());
                    it.remove();
                }
            }
            cargarModeloEmpleados(d, j);
        }
    }

    public void modificarEmpleado(String x, String y, DefaultTableModel d, JTable j,
            String nombre, String apellidos, String edad, String puesto,
            Double sueldo, String cod_cine) {
        Cine aux = new Cine(y, null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            for (Iterator<Empleado> it = aux.Empleados.iterator(); it.hasNext();) {
                Empleado aux2 = it.next();
                if (aux2.getDni().equals(x) && aux2.getCod_cine().equals(cod_cine)) {
                    aux2.setNombre(nombre);
                    aux2.setApellidos(apellidos);
                    aux2.setEdad(edad);
                    aux2.setPuesto(puesto);
                    aux2.setSueldo(sueldo);
                    aux2.setCod_cine(cod_cine);
                }
                if (aux2.getDni().equals(x) && !aux2.getCod_cine().equals(cod_cine)) {
                    it.remove();
                    aux2 = new Empleado(x, nombre, apellidos, edad, puesto,
                            sueldo, cod_cine);
                    nexoModificarEmpleado(aux2, d, j);
                }
                cargarModeloEmpleados(d, j);
            }
        }
    }

    public void nexoModificarEmpleado(Empleado e, DefaultTableModel d, JTable j) {
        Cine aux = new Cine(e.getCod_cine(), null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            if (!aux.Empleados.contains(e)) {
                aux.Empleados.add(e);
                cargarModeloEmpleados(d, j);
            }
        }
    }

    public void cargarModeloEmpleados(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel();

        limpiarModelos(j);

        d.addColumn("Dni");
        d.addColumn("Nombre");
        d.addColumn("Apellidos");
        d.addColumn("Edad");
        d.addColumn("Puesto");
        d.addColumn("Sueldo");
        d.addColumn("Cod_cine");
        j.setModel(d);

        Empleados.clear();

        for (int i = 0; i < Cines.size(); i++) {
            Empleados.addAll(Cines.get(i).getEmpleados());
        }

        Object[] filaEmpleados = new Object[d.getColumnCount()];
        for (int i = 0; i < Empleados.size(); i++) {
            filaEmpleados[0] = Empleados.get(i).getDni();
            filaEmpleados[1] = Empleados.get(i).getNombre();
            filaEmpleados[2] = Empleados.get(i).getApellidos();
            filaEmpleados[3] = Empleados.get(i).getEdad();
            filaEmpleados[4] = Empleados.get(i).getPuesto();
            filaEmpleados[5] = Empleados.get(i).getSueldo();
            filaEmpleados[6] = Empleados.get(i).getCod_cine();
            d.addRow(filaEmpleados);

            for (int k = 0; k < 7; k++) {
                DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
                modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
                j.getColumnModel().getColumn(k).setCellRenderer(modelocentrar);
            }
        }
    }

    //
    // FIN OPERACIONES CON EMPLEADOS
    //   
}
