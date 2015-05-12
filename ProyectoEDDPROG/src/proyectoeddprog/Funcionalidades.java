/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * CLASE FUNCIONALIDADES
 *
 * @author jchierro
 */
public class Funcionalidades implements Serializable {

    // LIST QUE CONTIENE LOS CINES SUS SALAS Y SUS MOBILIARIOS
    protected List<Cine> Cines;
    // LIST DE APOYO PARA MOSTRAR LAS SALAS EN UN JTABLE
    protected List<Sala> Salas;
    // LIST DE APOYO PARA MOSTRAR LOS MOBILIARIOS EN UN JTABLE
    protected List<Mobiliario> Mobiliarios;
    // LIST DE APOYO PARA MOSTRAR LOS EMPLEADOS EN UN JTABLE
    protected List<Empleado> Empleados;
    // LIST DE APOYO PARA MOSTRAR LOS VIP'S EN UN JTABLE
    protected List<VIP> VIP;
    // LIST QUE CONTIENE LAS PROYECCIONES
    protected List<Proyeccion> Proyecciones;
    // LIST QUE CONTIENE LAS ENTRADAS
    protected List<Entrada> Entradas;
    // LIST DE APOYO PARA MOSTRAR LAS PELÍCULAS EN UN JTABLE
    protected List<Pelicula> Peliculas;
    // LIST QUE CONTIENE LAS PRODUCTORAS Y SUS PELÍCULAS
    protected List<Productora> Productoras;

    // CONTADORES PARA GENERAR ID'S
    protected int idCine;
    protected int idSala;
    protected int idVIP;
    protected int idMobiliario;
    protected int idPr;
    protected int idPe;
    protected int idEn;

    // TREESET PARA COMROBAR QUE NO SE REPITEN EMPLEADOS O VIP'S (DNI)
    protected TreeSet<String> VIPDni;
    protected TreeSet<String> EmpleadoDni;

    /**
     * CONSTRUCTOR DE LA CLASE FUNCIONALIDADES
     */
    public Funcionalidades() {
        // INICIALIZO LAS LIST'S
        this.Cines = new ArrayList<>();
        this.Salas = new ArrayList<>();
        this.Mobiliarios = new ArrayList<>();
        this.Empleados = new ArrayList<>();
        this.VIP = new ArrayList<>();
        this.Proyecciones = new ArrayList<>();
        this.Entradas = new ArrayList<>();
        this.Peliculas = new ArrayList<>();
        this.Productoras = new ArrayList<>();

        // INICIALIZO LOS CONTADORES A 1
        this.idCine = 1;
        this.idSala = 1;
        this.idVIP = 1;
        this.idMobiliario = 1;
        this.idPr = 1;
        this.idPe = 1;
        this.idEn = 1;

        // INICIALIZO LOS TREESET'S
        this.VIPDni = new TreeSet<>();
        this.EmpleadoDni = new TreeSet<>();
    }

    //
    // COMIENZO FLUJOS DE DATOS
    //
    /**
     * MÉTODO PARA CARGAR TODOS LOS DATOS DEL PROYECTO
     *
     * @throws IOException
     */
    public void cargarDatos() throws IOException {
        // CREO EL OBJETO
        ObjectInputStream entrada = null;

        // ABRO EL FICHERO Y CARGO TODOS LOS DATOS
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
                idPr = entrada.readInt();
                idPe = entrada.readInt();
                idEn = entrada.readInt();
                VIPDni = (TreeSet<String>) entrada.readObject();
                EmpleadoDni = (TreeSet<String>) entrada.readObject();
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            // CIERRO EL FLUJO DE DATOS
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

    /**
     * MÉTODO PARA GUARDAR TODOS LOS DATOS DEL PROYECTO
     *
     * @throws IOException
     */
    public void guardarDatos() throws IOException {
        // CREO EL OBJETO
        ObjectOutputStream salida = null;

        // ABRO EL FICHERO Y GUARDO TODOS DATOS
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
            salida.writeInt(idPr);
            salida.writeInt(idPe);
            salida.writeInt(idEn);
            salida.writeObject(VIPDni);
            salida.writeObject(EmpleadoDni);
        } catch (FileNotFoundException ex) {
            System.out.println("Error de apertura del archivo de salida!");
            System.out.println(ex.getMessage());
            // CIERRO EL FLUJO DE DATOS
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
    // COMIENZO OPERACIONES CON CINES
    //
    /**
     * MÉTODO PARA GENERAR EL ID CINE
     *
     * @param ca
     */
    public void nexoCineId(JTextField ca) {
        // CONCATENO Y AUMENTO EL ID CINE
        String id = "MFC-";
        String result = id.concat(Integer.toString(this.idCine));
        ca.setText(result);
        this.idCine++;
    }

    /**
     * MÉTODO PARA CARGAR UN JCOMBOBOX CON LOS ID'S CINES
     *
     * @param co
     */
    public void nexoCineCodCine(JComboBox co) {
        // ELIMINO TODOS LOS ELEMENTOS Y VOY INSERTANDO
        co.removeAllItems();
        for (int i = 0; i < Cines.size(); i++) {
            co.addItem(Cines.get(i).getId_cine());
        }
    }

    /**
     * MÉTODO PARA INSERTAR UN CINE
     *
     * @param c
     * @param d
     * @param j
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    public boolean insertarCine(Cine c, DefaultTableModel d, JTable j) {
        // COMPRUEBO QUE NO ESTE CONTENIDO EL CINE PASADO COMO PARÁMETRO
        // INSERTO EL CINE Y RECARGO EL MODELOCINES
        if (!this.Cines.contains(c)) {
            this.Cines.add(c);
            cargarModeloCines(d, j);
            return true;
        } else {
            return false;
        }
    }

    /**
     * MÉTODO PARA BORRAR UN CINE
     *
     * @param i
     * @param d
     * @param j
     */
    public void borrarCine(int i, DefaultTableModel d, JTable j) {
        // BORRA EL CINE POR SU ÍNDICE Y RECARGA EL MODELOCINES
        this.Cines.remove(i);
        cargarModeloCines(d, j);
    }

    /**
     * MÉTODO PARA MODIFICAR UN CINE
     *
     * @param i
     * @param d
     * @param j
     * @param nombre
     * @param direccion
     * @param telefono
     * @param fax
     * @param e_mail
     */
    public void modificarCine(int i, DefaultTableModel d, JTable j,
            String nombre, String direccion, String telefono, String fax, String e_mail) {
        // MODIFICA UN CINE POR SU ÍNDICE Y RECARGA EL MODELOCINES
        Cine aux = this.Cines.get(i);
        aux.setNombre(nombre);
        aux.setDireccion(direccion);
        aux.setTelefono(telefono);
        aux.setFax(fax);
        aux.setE_mail(e_mail);
        cargarModeloCines(d, j);
    }

    /**
     * MÉTODO PARA CARGAR EL MODELO CINES
     *
     * @param d
     * @param j
     */
    public void cargarModeloCines(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // LIMPIO EL MODELO
        limpiarModelos(j);

        // AGREGO LAS COLUMNAS A LA TABLA
        d.addColumn("Id_cine");
        d.addColumn("Nombre");
        d.addColumn("Dirección");
        d.addColumn("Teléfono");
        d.addColumn("Fax");
        d.addColumn("E_mail");
        j.setModel(d);

        // CREO UN MODELO RENDERER PARA CENTRAR LOS DATOS Y PINTAR LAS FILAS
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                this.setHorizontalAlignment(SwingConstants.CENTER);

                if (row % 2 == 0) {
                    this.setOpaque(true);
                    this.setBackground(new Color(255, 255, 255));
                    this.setForeground(new Color(0, 0, 0));
                } else {
                    this.setOpaque(true);
                    this.setBackground(new Color(191, 191, 191));
                    this.setForeground(new Color(0, 0, 0));
                }

                if (isSelected) {
                    this.setOpaque(true);
                    this.setBackground(new Color(59, 115, 175));
                    this.setForeground(new Color(255, 255, 255));
                }

                return this;
            }
        };

        j.setDefaultRenderer(Object.class, modelocentrar);
        j.setGridColor(new Color(0, 0, 0));

        // VOY INSERTANDO FILAS AL MODELO
        Object[] filaCines = new Object[d.getColumnCount()];
        for (int i = 0; i < Cines.size(); i++) {
            filaCines[0] = Cines.get(i).getId_cine();
            filaCines[1] = Cines.get(i).getNombre();
            filaCines[2] = Cines.get(i).getDireccion();
            filaCines[3] = Cines.get(i).getTelefono();
            filaCines[4] = Cines.get(i).getFax();
            filaCines[5] = Cines.get(i).getE_mail();
            d.addRow(filaCines);
        }
    }

    //
    // FIN OPERACIONES CON CINES
    //
    //
    // COMIENZO OPERACIONES CON SALAS
    //
    /**
     * MÉTODO PARA GENERAR EL ID SALA
     *
     * @param ca
     */
    public void nexoSalaId(JTextField ca) {
        // CONCATENO Y AUMENTO EL ID SALA
        String id = "MFS-";
        String result = id.concat(Integer.toString(this.idSala));
        ca.setText(result);
        this.idSala++;
    }

    /**
     * MÉTODO PARA CARGAR EN UN JCOMBOBOX LOS COD'S SALAS
     *
     * @param co
     */
    public void nexoSalaCodSala(JComboBox co) {
        // BORRO TODOS LOS ELEMENTOS Y VOY INSERTANDO
        co.removeAllItems();
        for (int i = 0; i < Cines.size(); i++) {
            for (int j = 0; j < Cines.get(i).Salas.size(); j++) {
                co.addItem(Cines.get(i).Salas.get(j).getId_Sala());
            }
        }
    }

    /**
     * MÉTODO PARA INSERTAR UNA SALA
     *
     * @param s
     * @param d
     * @param j
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    public boolean insertarSala(Sala s, DefaultTableModel d, JTable j) {
        // BUSCO EL CINE AL QUE PERTENECE LA SALSA PASADA COMO PARÁMETRO
        // COMRPUEBO QUE NO ESTE CONTENIDA, LA INSERTO Y RECARGO EL MODELOSALAS
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

    /**
     * MÉTODO PARA BORRAR UNA SALA
     *
     * @param x
     * @param y
     * @param d
     * @param j
     */
    public void borrarSala(String x, String y, DefaultTableModel d, JTable j) {
        // BUSCO EL CINE AL QUE PERTENECE DICHA SALA
        // BORRO LA SALA CON EL ITERADOR Y RECARGO EL MODELOSALAS
        Cine aux = new Cine(y, null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            for (Iterator<Sala> it = aux.Salas.iterator(); it.hasNext();) {
                Sala aux2 = it.next();
                if (aux2.getId_Sala().equals(x)) {
                    nexoBorrarProyeccion(aux2.getId_Sala());
                    it.remove();
                }
            }
            cargarModeloSalas(d, j);
        }
    }

    /**
     * MÉTODO PARA MODIFICAR SALA
     *
     * @param x
     * @param y
     * @param d
     * @param j
     * @param nombre
     * @param tipo
     * @param num_butacas
     * @param cod_cine
     */
    public void modificarSala(String x, String y, DefaultTableModel d, JTable j,
            String nombre, String tipo, String num_butacas, String cod_cine) {
        // BUSCO EL CINE AL QUE PERTENECE DICHA SALA
        // HAGO LOS CAMBIOS PERTINENTES CON EL ITERADOR Y RECARGO EL MODELOSALAS
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
            }
            cargarModeloSalas(d, j);
        }
    }

    /**
     * NEXO NECESARIO PARA MODIFICAR UN SALA CUANDO SE CAMBIA DE CINE
     *
     * @param s
     * @param d
     * @param j
     */
    public void nexoModificarSala(Sala s, DefaultTableModel d, JTable j) {
        // CAMBIO LA SALA DE CINE Y RECARGO EL MODELOSALAS
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

    /**
     * MÉTODO PARA CARGAR EL MODELO SALAS
     *
     * @param d
     * @param j
     */
    public void cargarModeloSalas(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // BORRO EL MODLEO ENTERO
        limpiarModelos(j);

        // AGREGO LAS COLUMNAS A LA TABLA
        d.addColumn("Id_sala");
        d.addColumn("Nombre");
        d.addColumn("Tipo");
        d.addColumn("Num_butaca");
        d.addColumn("Cod_cine");
        j.setModel(d);

        // LIMPIO LA LIST SALAS "APOYO"
        Salas.clear();

        // DE CADA CINE OBTENGO SUS SALAS
        for (int i = 0; i < Cines.size(); i++) {
            Salas.addAll(Cines.get(i).getSalas());
        }

        // CREO UN MODELO RENDERER PARA CENTRAR LOS DATOS Y PINTAR LAS FILAS
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                this.setHorizontalAlignment(SwingConstants.CENTER);

                if (row % 2 == 0) {
                    this.setOpaque(true);
                    this.setBackground(new Color(255, 255, 255));
                    this.setForeground(new Color(0, 0, 0));
                } else {
                    this.setOpaque(true);
                    this.setBackground(new Color(191, 191, 191));
                    this.setForeground(new Color(0, 0, 0));
                }

                if (isSelected) {
                    this.setOpaque(true);
                    this.setBackground(new Color(59, 115, 175));
                    this.setForeground(new Color(255, 255, 255));
                }

                return this;
            }
        };

        j.setDefaultRenderer(Object.class, modelocentrar);
        j.setGridColor(new Color(0, 0, 0));

        // VOY INSERTANDO LAS FILAS A LA TABLA
        Object[] filaSalas = new Object[d.getColumnCount()];
        for (int i = 0; i < Salas.size(); i++) {
            filaSalas[0] = Salas.get(i).getId_Sala();
            filaSalas[1] = Salas.get(i).getNombre();
            filaSalas[2] = Salas.get(i).getTipo();
            filaSalas[3] = Salas.get(i).getNum_butacas();
            filaSalas[4] = Salas.get(i).getCod_cine();
            d.addRow(filaSalas);
        }
    }

    //
    // FIN OPERACIONES CON SALAS
    //
    //
    // COMIENZO OPERACIONES CON MOBILIARIOS
    //
    /**
     * MÉTODO PARA GENERAR EL ID MOBILIARIO
     *
     * @param ca
     */
    public void nexoMobiliarioId(JTextField ca) {
        // CONCATENO Y AUMENTO EL ID MOBILIARIO
        String id = "MFM-";
        String result = id.concat(Integer.toString(this.idMobiliario));
        ca.setText(result);
        this.idMobiliario++;
    }

    /**
     * MÉTODO PARA INSERTAR UN MOBILIARIO
     *
     * @param m
     * @param d
     * @param j
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    public boolean insertarMobiliario(Mobiliario m, DefaultTableModel d, JTable j) {
        // BUSCO LA SALA A LA QUE PERTENECE DICHO MOBILIARIO
        // COMPRUEBO QUE NO ESTE CONTENIDO, LO INSERTO Y RECARGO EL MODELOMOBILIARIOS
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

    /**
     * MÉTODO PARA BORRAR UN MOBILIARIO
     *
     * @param x
     * @param y
     * @param d
     * @param j
     */
    public void borrarMobiliario(String x, String y, DefaultTableModel d, JTable j) {
        // VOY BUSCANDO CON EL ITERADOR, BORRO EL MOBILIARIO Y RECARGO EL MODELOMOBILIARIOS
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

    /**
     * MÉTODO PARA MODIFICAR UN MOBILIARIO
     *
     * @param x
     * @param d
     * @param j
     * @param nombre
     * @param cantidad
     * @param fecha
     * @param estado
     * @param cod_sala
     */
    public void modificarMobiliario(String x, DefaultTableModel d, JTable j,
            String nombre, String cantidad, String fecha, Boolean estado, String cod_sala) {
        // VOY BUSCANDO, REALIZO LOS CAMBIOS PERTINENTES EN EL MOBILIARIO Y RECARGO EL MODELOMOBILIARIOS
        for (int i = 0; i < Cines.size(); i++) {
            for (int k = 0; k < Cines.get(i).Salas.size(); k++) {
                for (Iterator<Mobiliario> it = Cines.get(i).Salas.get(k).Mobiliarios.iterator(); it.hasNext();) {
                    Mobiliario aux = it.next();
                    if (aux.getId_mobiliario().equals(x) && aux.getCod_sala().equals(cod_sala)) {
                        aux.setNombre(nombre);
                        aux.setCantidad(cantidad);
                        aux.setFecha(fecha);
                        aux.setEstado(estado);
                        aux.setCod_sala(cod_sala);
                    }
                    if (aux.getId_mobiliario().equals(x) && !aux.getCod_sala().equals(cod_sala)) {
                        it.remove();
                        aux = new Mobiliario(x, nombre, cantidad, fecha, estado, cod_sala);
                        nexoModificarMobiliario(aux, d, j);
                    }
                }
            }
        }
        cargarModeloMobiliarios(d, j);
    }

    /**
     * MÉTODO NECESARIO PARA CUANDO CAMBIO UN MOBILIARIO DE SALA
     *
     * @param m
     * @param d
     * @param j
     */
    public void nexoModificarMobiliario(Mobiliario m, DefaultTableModel d, JTable j) {
        // VOY BUSCANDO, REALIZO EL CAMBIO Y RECARGO EL MODELOMOBILIARIOS
        for (int i = 0; i < Cines.size(); i++) {
            for (Iterator<Sala> it = Cines.get(i).Salas.iterator(); it.hasNext();) {
                Sala aux = it.next();
                if (aux.getId_Sala().equals(m.getCod_sala())) {
                    if (!aux.Mobiliarios.contains(m)) {
                        aux.Mobiliarios.add(m);
                        cargarModeloMobiliarios(d, j);
                    }
                }
            }

        }
    }

    /**
     * MÉTODO PARA CARGAR EL MODELO MOBILIARIOS
     *
     * @param d
     * @param j
     */
    public void cargarModeloMobiliarios(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // LIMPIO EL MODELO ENTERO
        limpiarModelos(j);

        // AGREGO LAS COLUMNAS A LA TABLA
        d.addColumn("Id_mobiliario");
        d.addColumn("Nombre");
        d.addColumn("Cantidad");
        d.addColumn("Fecha");
        d.addColumn("Estado");
        d.addColumn("Cod_sala");
        j.setModel(d);

        // LIMPIO LA LIST MOBILIARIOS "APOYO"
        Mobiliarios.clear();

        // VOY OBTENIEDO LOS MOBILIARIOS
        for (int i = 0; i < Cines.size(); i++) {
            for (int k = 0; k < Cines.get(i).Salas.size(); k++) {
                Mobiliarios.addAll(Cines.get(i).Salas.get(k).getMobiliarios());
            }
        }

        // CREO UN MODELO RENDERER PARA CENTRAR LOS DATOS Y PINTAR LAS FILAS
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                this.setHorizontalAlignment(SwingConstants.CENTER);

                if (row % 2 == 0) {
                    this.setOpaque(true);
                    this.setBackground(new Color(255, 255, 255));
                    this.setForeground(new Color(0, 0, 0));
                } else {
                    this.setOpaque(true);
                    this.setBackground(new Color(191, 191, 191));
                    this.setForeground(new Color(0, 0, 0));
                }

                if (isSelected) {
                    this.setOpaque(true);
                    this.setBackground(new Color(59, 115, 175));
                    this.setForeground(new Color(255, 255, 255));
                }

                return this;
            }
        };

        j.setDefaultRenderer(Object.class, modelocentrar);
        j.setGridColor(new Color(0, 0, 0));

        // VOY INSERTANDO LAS FILAS A LA TABLA
        Object[] filaMobiliarios = new Object[d.getColumnCount()];
        for (int i = 0; i < Mobiliarios.size(); i++) {
            filaMobiliarios[0] = Mobiliarios.get(i).getId_mobiliario();
            filaMobiliarios[1] = Mobiliarios.get(i).getNombre();
            filaMobiliarios[2] = Mobiliarios.get(i).getCantidad();
            filaMobiliarios[3] = Mobiliarios.get(i).getFecha();
            filaMobiliarios[4] = Mobiliarios.get(i).getEstado();
            filaMobiliarios[5] = Mobiliarios.get(i).getCod_sala();
            d.addRow(filaMobiliarios);
        }
    }

    //
    // FIN OPERACIONES CON MOBILIARIOS
    //
    //
    // COMIENZO OPERACIONES CON VIPS
    //
    
    /**
     * METODO NECESARIO PARA COMPROBAR QUE NO EXISTAN VIP DUPLICADOS
     * @param Dni
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    public boolean nexoVIPCompruebaDni(String Dni) {
        return this.VIPDni.add(Dni);
    }

    /**
     * METODO PARA CREAR UN VIP
     * @param v
     * @param d
     * @param j
     * @return DEVUELVE UN VALOR BOOLEAN 
     */
    public boolean insertarVIP(VIP v, DefaultTableModel d, JTable j) {
        boolean result = false;
        boolean dni = nexoVIPCompruebaDni(v.getDni());
        if (dni == true) {
            // REALIZO UNA BUSQUEDA BINARIA PARA ENCONTRAR SU RESPECTIVO CINE
            Cine aux = new Cine(v.getCod_cine(), null, null, null, null, null);
            int indice = Collections.binarySearch(this.Cines, aux);
            if (indice >= 0) {
                // COMPRUEBO QUE NO ESTE CONTENIDO, LO INSERTO Y RECARGO EL MODELOVIPS
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

    /**
     * METODO PARA BORRA UN VIP
     * @param x
     * @param y
     * @param d
     * @param j 
     */
    public void borrarVIP(String x, String y, DefaultTableModel d, JTable j) {
        // BUSCO EL CINE AL QUE PERTENECE DICHO VIP
        Cine aux = new Cine(y, null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            // BORRO EL VIP CON EL ITERADOR Y RECARGO EL MODELO
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

    /**
     * METODO PARA MODIFICAR UN VIP
     * @param x
     * @param y
     * @param d
     * @param j
     * @param nombre
     * @param apellidos
     * @param edad
     * @param telefono
     * @param cod_postal
     * @param cod_cine 
     */
    public void modificarVIP(String x, String y, DefaultTableModel d, JTable j,
            String nombre, String apellidos, String edad, String telefono,
            String cod_postal, String cod_cine) {
        // BUSCO EL CINE AL QUE PERTENECE DICHO VIP
        Cine aux = new Cine(y, null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            // REALIZO LOS CAMBIOS PERTINENTES Y RECARGO EL MODELO VIPS
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
            }
            cargarModeloVIP(d, j);
        }
    }

    /**
     * METODO NECESARIO PARA CUANDO UN VIP CAMBIA DE CINE
     * @param v
     * @param d
     * @param j 
     */
    public void nexoModificarVIP(VIP v, DefaultTableModel d, JTable j) {
        // BUSCO EL CINE CORRESPONDIENTE
        Cine aux = new Cine(v.getCod_cine(), null, null, null, null, null);
        //System.out.println(s.getCod_cine());
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            // COMPRUEBO QUE NO ESTE CONTENIDO EL VIP, LO INSERTO Y RECARGO EL MODELO VIPS
            aux = this.Cines.get(indice);
            if (!aux.VIP.contains(v)) {
                aux.VIP.add(v);
                cargarModeloVIP(d, j);
                //System.out.println(aux);
            }
        }
    }

    /**
     * METODO PARA CARGAR EL MODELO VIP
     * @param d
     * @param j 
     */
    public void cargarModeloVIP(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // LIMPIO EL MODELO
        limpiarModelos(j);

        // AGREGO LAS COLUMNAS A LA TABLA
        d.addColumn("Dni");
        d.addColumn("Nombre");
        d.addColumn("Apellidos");
        d.addColumn("Edad");
        d.addColumn("Teléfono");
        d.addColumn("Código_postal");
        d.addColumn("Cod_cine");
        j.setModel(d);

        // BORRO LA LIST DE "APOYO" VIP
        VIP.clear();

        for (int i = 0; i < Cines.size(); i++) {
            VIP.addAll(Cines.get(i).getVIP());
        }

        // CREO UN MODELO RENDERER PARA CENTRAR LOS DATOS Y PINTAR LAS FILAS
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                this.setHorizontalAlignment(SwingConstants.CENTER);

                if (row % 2 == 0) {
                    this.setOpaque(true);
                    this.setBackground(new Color(255, 255, 255));
                    this.setForeground(new Color(0, 0, 0));
                } else {
                    this.setOpaque(true);
                    this.setBackground(new Color(191, 191, 191));
                    this.setForeground(new Color(0, 0, 0));
                }

                if (isSelected) {
                    this.setOpaque(true);
                    this.setBackground(new Color(59, 115, 175));
                    this.setForeground(new Color(255, 255, 255));
                }

                return this;
            }
        };

        j.setDefaultRenderer(Object.class, modelocentrar);
        j.setGridColor(new Color(0, 0, 0));

        // VOY INSERTANDO FILAS AL MODELO
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
        }
    }

    //
    // FIN OPERACIONES CON VIPS
    //
    //
    // COMIENZO OPERACIONES CON EMPLEADOS
    //
    
    /**
     * METODO NECESARIO PARA COMPROBAR QUE NO EXISTAN EMPLEADOS DUPLICADOS
     * @param Dni
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    public boolean nexoEmpleadoCompruebaDni(String Dni) {
        return this.EmpleadoDni.add(Dni);
    }

    /**
     * METODO PARA CREAR UN EMPLEADO
     * @param e
     * @param d
     * @param j
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    public boolean insertarEmpleado(Empleado e, DefaultTableModel d, JTable j) {
        boolean result = false;
        boolean dni = nexoEmpleadoCompruebaDni(e.getDni());
        //System.out.println(dni);
        if (dni == true) {
            // REALIZO UNA BUSQUEDA BINARIA PARA ENCONTRAR EL CINE CORRESPONDIENTE
            Cine aux = new Cine(e.getCod_cine(), null, null, null, null, null);
            int indice = Collections.binarySearch(this.Cines, aux);
            if (indice >= 0) {
                // COMPRUEBO QUE EL EMPLEADO NO ESTE CONTENIDO, LO INSERTO Y RECARGO EL MODELO EMPLEADOS
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

    /**
     * METODO PARA BORRAR UN EMPLEADO
     * @param x
     * @param y
     * @param d
     * @param j 
     */
    public void borrarEmpleado(String x, String y, DefaultTableModel d, JTable j) {
        Cine aux = new Cine(y, null, null, null, null, null);
        // BUSCO EL CINE AL QUE PERTENECE DICHO EMPLEADO
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            aux = this.Cines.get(indice);
            // BORRO EL EMPLEADO CON EL ITERADOOR Y RECARGO EL MODELO EMPLEADOS
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

    /**
     * METODO PARA MODIFICAR UN EMPLEADO
     * @param x
     * @param y
     * @param d
     * @param j
     * @param nombre
     * @param apellidos
     * @param edad
     * @param puesto
     * @param sueldo
     * @param cod_cine 
     */
    public void modificarEmpleado(String x, String y, DefaultTableModel d, JTable j,
            String nombre, String apellidos, String edad, String puesto,
            Double sueldo, String cod_cine) {
        // BUSCO EL CINE AL QUE PERTENECE DICHO EMPLEADO
        Cine aux = new Cine(y, null, null, null, null, null);
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            // REALIZO LOS CAMBIOS NECESARIOSY RECARGO EL MODELO EMPLEADOS
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
            }
            cargarModeloEmpleados(d, j);
        }
    }

    /**
     * METODO NECESARIO PARA CUANDO UN EMPLEADO CAMBIE DE CINE
     * @param e
     * @param d
     * @param j 
     */
    public void nexoModificarEmpleado(Empleado e, DefaultTableModel d, JTable j) {
        Cine aux = new Cine(e.getCod_cine(), null, null, null, null, null);
        // BUSCA EL CINE CORRESPONDIENTE
        int indice = Collections.binarySearch(this.Cines, aux);
        if (indice >= 0) {
            // COMPRUEBO QUE NO ESTE CONTENIDO, LO INSETO Y RECARGO EL MODELO EMPLEADOS
            aux = this.Cines.get(indice);
            if (!aux.Empleados.contains(e)) {
                aux.Empleados.add(e);
                cargarModeloEmpleados(d, j);
            }
        }
    }

    /**
     * METODO PARA CARGAR EL MODELO EMPLEADOS
     * @param d
     * @param j 
     */
    public void cargarModeloEmpleados(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // LIMPIO EL MODELO
        limpiarModelos(j);

        // AGREGO LAS COLUMNAS A LA TABLA
        d.addColumn("Dni");
        d.addColumn("Nombre");
        d.addColumn("Apellidos");
        d.addColumn("Edad");
        d.addColumn("Puesto");
        d.addColumn("Sueldo");
        d.addColumn("Cod_cine");
        j.setModel(d);

        // BORRO LA LIST "APOYO" EMPLEADOS
        Empleados.clear();

        for (int i = 0; i < Cines.size(); i++) {
            Empleados.addAll(Cines.get(i).getEmpleados());
        }

        // CREO UN MODELO RENDERER PARA CENTRAR LOS DATOS Y PINTAR LAS FILAS
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                this.setHorizontalAlignment(SwingConstants.CENTER);

                if (row % 2 == 0) {
                    this.setOpaque(true);
                    this.setBackground(new Color(255, 255, 255));
                    this.setForeground(new Color(0, 0, 0));
                } else {
                    this.setOpaque(true);
                    this.setBackground(new Color(191, 191, 191));
                    this.setForeground(new Color(0, 0, 0));
                }

                if (isSelected) {
                    this.setOpaque(true);
                    this.setBackground(new Color(59, 115, 175));
                    this.setForeground(new Color(255, 255, 255));
                }

                return this;
            }
        };

        j.setDefaultRenderer(Object.class, modelocentrar);
        j.setGridColor(new Color(0, 0, 0));

        // VOY INGRESANDO LOS DATOS AL MODELO
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
        }
    }

    //
    // FIN OPERACIONES CON EMPLEADOS
    //   
    //
    // COMIENZO OPERACIONES CON PRODUCTORAS
    //
    
    /**
     * METODO PARA GENERAR EL ID PRODUCTORA
     * @param ca 
     */
    public void nexoProductoraId(JTextField ca) {
        // CONCATENO Y AUMENTO EL ID
        String id = "MFPr-";
        String result = id.concat(Integer.toString(this.idPr));
        ca.setText(result);
        this.idPr++;
    }

    /**
     * METODO PARA CARGAR UN JCOMBOBOX CON LOS COD'S PRODUCTORAS
     * @param co 
     */
    public void nexoProductoraCodProductora(JComboBox co) {
        // BORRO TODOS LOS ELEMENTOS Y LLENO
        co.removeAllItems();
        for (int i = 0; i < Productoras.size(); i++) {
            co.addItem(Productoras.get(i).getId_productora());
        }
    }

    /**
     * METODO PARA CREAR UNA PRODUCTORA
     * @param pr
     * @param d
     * @param j
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    public boolean insertarProductora(Productora pr, DefaultTableModel d, JTable j) {
        // COMPRUEBO QUE NO ESTE CONTENIDA LA NUEVA PRODUCTORA, LA INSERTO Y RECARGO EL MODELO PRODUCTORAS
        if (!this.Productoras.contains(pr)) {
            this.Productoras.add(pr);
            cargarModeloProductoras(d, j);
            return true;
        } else {
            return false;
        }
    }

    /**
     * METODO PARA BORRAR UNA PRODUCTORA
     * @param i
     * @param d
     * @param j 
     */
    public void borrarProductora(int i, DefaultTableModel d, JTable j) {
        // BORRO LA PRODUCTORA POR SU INDICE Y RECARGO EL MODELO PRODUCTORAS
        this.Productoras.remove(i);
        cargarModeloProductoras(d, j);
    }

    /**
     * METODO PARA MODIFICAR UNA PRODUCTORA
     * @param i
     * @param d
     * @param j
     * @param nombre
     * @param telefono
     * @param fax
     * @param e_mail
     * @param representante 
     */
    public void modificarProductora(int i, DefaultTableModel d, JTable j,
            String nombre, String telefono, String fax, String e_mail, String representante) {
        // CARGO LA PRODUCTORA POR SU INDICE, REALIZO LOS CAMBIOS PERTINENTES Y RECARGO EL MODELO PRODUCTORAS
        Productora aux = this.Productoras.get(i);
        aux.setNombre(nombre);
        aux.setTelefono(telefono);
        aux.setFax(fax);
        aux.setE_mail(e_mail);
        aux.setRepresentante(representante);
        cargarModeloProductoras(d, j);
    }

    /**
     * METODO PARA CARGAR EL MODELO PRODUCTORAS
     * @param d
     * @param j 
     */
    public void cargarModeloProductoras(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // LIMPIO EL MODELO
        limpiarModelos(j);

        // AGREGO LAS COLUMNAS A LA TABLA
        d.addColumn("Id_productora");
        d.addColumn("Nombre");
        d.addColumn("Teléfono");
        d.addColumn("Fax");
        d.addColumn("E_mail");
        d.addColumn("Representante");
        j.setModel(d);

        // CREO UN MODELO RENDERER PARA CENTRAR LOS DATOS Y PINTAR LAS FILAS
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                this.setHorizontalAlignment(SwingConstants.CENTER);

                if (row % 2 == 0) {
                    this.setOpaque(true);
                    this.setBackground(new Color(255, 255, 255));
                    this.setForeground(new Color(0, 0, 0));
                } else {
                    this.setOpaque(true);
                    this.setBackground(new Color(191, 191, 191));
                    this.setForeground(new Color(0, 0, 0));
                }

                if (isSelected) {
                    this.setOpaque(true);
                    this.setBackground(new Color(59, 115, 175));
                    this.setForeground(new Color(255, 255, 255));
                }

                return this;
            }
        };

        j.setDefaultRenderer(Object.class, modelocentrar);
        j.setGridColor(new Color(0, 0, 0));

        // VOY INSERTANDO FILAS AL MODELO
        Object[] filaProductoras = new Object[d.getColumnCount()];
        for (int i = 0; i < Productoras.size(); i++) {
            filaProductoras[0] = Productoras.get(i).getId_productora();
            filaProductoras[1] = Productoras.get(i).getNombre();
            filaProductoras[2] = Productoras.get(i).getTelefono();
            filaProductoras[3] = Productoras.get(i).getFax();
            filaProductoras[4] = Productoras.get(i).getE_mail();
            filaProductoras[5] = Productoras.get(i).getRepresentante();
            d.addRow(filaProductoras);
        }
    }

    //
    // FIN OPERACIONES CON PRODUCTORAS
    //  
    //
    // COMIENZO OPERACIONES CON PELÍCULAS
    //
    
    /**
     * METODO PARA GENERAR EL ID PELICULA
     * @param ca 
     */
    public void nexoPeliculaId(JTextField ca) {
        // CONCATENO Y VOY AUMENTANDO EL ID
        String id = "MFPe-";
        String result = id.concat(Integer.toString(this.idPe));
        ca.setText(result);
        this.idPe++;
    }

    /**
     * METODO CARGAR UN JCOMBOBOX CON LOS TITULOS PELICULA
     * @param co 
     */
    public void nexoPeliculaTituloPelicula(JComboBox co) {
        // LIMPIO EL JCOMBOBOX Y LLENO
        co.removeAllItems();
        for (int i = 0; i < Peliculas.size(); i++) {
            co.addItem(Peliculas.get(i).getNombre());
        }
    }

    /**
     * METODO CARGAR UN JCOMBOBOX CON LOS COD'S PELICULA
     * @param co 
     */
    public void nexoPeliculaCodPelicula(JComboBox co) {
        // LIMPIO EL JCOMBOBOX Y LLENO
        co.removeAllItems();
        for (int i = 0; i < Peliculas.size(); i++) {
            co.addItem(Peliculas.get(i).getId_pelicula());
        }
    }

    /**
     * METODO PARA CREAR UNA PELICULA
     * @param pe
     * @param d
     * @param j
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    public boolean insertarPelicula(Pelicula pe, DefaultTableModel d, JTable j) {
        boolean result = false;
        Productora aux = new Productora(pe.getCod_productora(), null, null, null, null, null);
        // BUSCO LA PRODUCTORA CORRESPONDIENTE
        int indice = Collections.binarySearch(this.Productoras, aux);
        if (indice >= 0) {
            // COMPRUEBO QUE NO ESTE CONTENIDA LA PELICULA, LA INSERTA Y RECARGO EL MODELO PELICULAS
            aux = this.Productoras.get(indice);
            if (!aux.Peliculas.contains(pe)) {
                aux.Peliculas.add(pe);
                cargarModeloPeliculas(d, j);
                result = true;
            }
        } else {
            result = false;
        }
        return result;
    }

    /**
     * METODO PARA BORRAR UNA PELICULA
     * @param x
     * @param y
     * @param d
     * @param j 
     */
    public void borrarPelicula(String x, String y, DefaultTableModel d, JTable j) {
        Productora aux = new Productora(y, null, null, null, null, null);
        // BUSCO LA PRODUCTORA CORRESPONDIENTE
        int indice = Collections.binarySearch(this.Productoras, aux);
        if (indice >= 0) {
            aux = this.Productoras.get(indice);
            // BORRO LA PELICULA CON EL ITERADOR Y RECARGO EL MODELO PELICULAS
            for (Iterator<Pelicula> it = aux.Peliculas.iterator(); it.hasNext();) {
                Pelicula aux2 = it.next();
                if (aux2.getId_pelicula().equals(x)) {
                    nexoBorrarProyeccion(aux2.getId_pelicula());
                    it.remove();
                }
            }
            cargarModeloPeliculas(d, j);
        }
    }

    /**
     * METODO PARA MODIFICAR UNA PELICULA
     * @param x
     * @param y
     * @param d
     * @param j
     * @param nombre
     * @param director
     * @param año
     * @param edad
     * @param pais
     * @param genero
     * @param duracion
     * @param cod_productora 
     */
    public void modificarPelicula(String x, String y, DefaultTableModel d, JTable j,
            String nombre, String director, String año, String edad, String pais,
            String genero, String duracion, String cod_productora) {
        Productora aux = new Productora(y, null, null, null, null, null);
        // BUSCO LA PRODUCTORA CORRESPONDIENTE
        int indice = Collections.binarySearch(this.Productoras, aux);
        if (indice >= 0) {
            aux = this.Productoras.get(indice);
            // REALIZO LOS CAMBIOS PERTINENTES Y RECARGO EL MODELO PELICULAS
            for (Iterator<Pelicula> it = aux.Peliculas.iterator(); it.hasNext();) {
                Pelicula aux2 = it.next();
                if (aux2.getId_pelicula().equals(x) && aux2.getCod_productora().equals(cod_productora)) {
                    aux2.setNombre(nombre);
                    aux2.setDirector(director);
                    aux2.setAño(año);
                    aux2.setEdad(edad);
                    aux2.setPais(pais);
                    aux2.setGenero(genero);
                    aux2.setDuracion(duracion);
                    aux2.setCod_productora(cod_productora);
                }
                if (aux2.getId_pelicula().equals(x) && !aux2.getCod_productora().equals(cod_productora)) {
                    it.remove();
                    aux2 = new Pelicula(x, nombre, director, año, edad, pais,
                            genero, duracion, cod_productora);
                    nexoModificarPelicula(aux2, d, j);
                }
            }
            cargarModeloPeliculas(d, j);
        }
    }

    /**
     * METODO NECESARIO PARA CUANDO UNA PELICULA CAMBIE DE PRODUCTORA
     * @param pe
     * @param d
     * @param j 
     */
    public void nexoModificarPelicula(Pelicula pe, DefaultTableModel d, JTable j) {
        // BUSCO LA PRODUCTORA CORRESPONDIENTE
        Productora aux = new Productora(pe.getCod_productora(), null, null, null, null, null);
        int indice = Collections.binarySearch(this.Productoras, aux);
        if (indice >= 0) {
            // COMPRUEBO QUE NO ESTE CONTENIDA LA PELICULA, INSERTO LA PELICULA Y RECARGO EL MODELO PELICULAS
            aux = this.Productoras.get(indice);
            if (!aux.Peliculas.contains(pe)) {
                aux.Peliculas.add(pe);
                cargarModeloPeliculas(d, j);
            }
        }
    }

    /**
     * METODO PARA CARGAR EL MODELO PELICULAS
     * @param d
     * @param j 
     */
    public void cargarModeloPeliculas(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // LIMPIO EL MODELO
        limpiarModelos(j);

        // AGREGO LAS COLUMNAS A LA TABLA
        d.addColumn("Id_película");
        d.addColumn("Nombre");
        d.addColumn("Director");
        d.addColumn("Año");
        d.addColumn("Edad");
        d.addColumn("País");
        d.addColumn("Género");
        d.addColumn("Duración");
        d.addColumn("Cod_producotra");
        j.setModel(d);

        // LIMPIO LA LIST "APOYO" PELICULAS
        Peliculas.clear();

        for (int i = 0; i < Productoras.size(); i++) {
            Peliculas.addAll(Productoras.get(i).getPeliculas());
        }

        // CREO UN MODELO RENDERER PARA CENTRAR LOS DATOS Y PINTAR LAS FILAS
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                this.setHorizontalAlignment(SwingConstants.CENTER);

                if (row % 2 == 0) {
                    this.setOpaque(true);
                    this.setBackground(new Color(255, 255, 255));
                    this.setForeground(new Color(0, 0, 0));
                } else {
                    this.setOpaque(true);
                    this.setBackground(new Color(191, 191, 191));
                    this.setForeground(new Color(0, 0, 0));
                }

                if (isSelected) {
                    this.setOpaque(true);
                    this.setBackground(new Color(59, 115, 175));
                    this.setForeground(new Color(255, 255, 255));
                }

                return this;
            }
        };

        j.setDefaultRenderer(Object.class, modelocentrar);
        j.setGridColor(new Color(0, 0, 0));

        // VOY INSERTANDO FILAS AL MODELO
        Object[] filaPeliculas = new Object[d.getColumnCount()];
        for (int i = 0; i < Peliculas.size(); i++) {
            filaPeliculas[0] = Peliculas.get(i).getId_pelicula();
            filaPeliculas[1] = Peliculas.get(i).getNombre();
            filaPeliculas[2] = Peliculas.get(i).getDirector();
            filaPeliculas[3] = Peliculas.get(i).getAño();
            filaPeliculas[4] = Peliculas.get(i).getEdad();
            filaPeliculas[5] = Peliculas.get(i).getPais();
            filaPeliculas[6] = Peliculas.get(i).getGenero();
            filaPeliculas[7] = Peliculas.get(i).getDuracion();
            filaPeliculas[8] = Peliculas.get(i).getCod_productora();
            d.addRow(filaPeliculas);
        }
    }

    //
    // FIN OPERACIONES CON PELÍCULAS
    //  
    //
    // COMIENZO OPERACIONES CON ENTRADAS
    //
    
    /**
     * METODO PARA GENERAR ID ENTRADA
     * @param ca 
     */
    public void nexoEntradaId(JTextField ca) {
        // CONCATENO Y AUMENTO EL ID
        String id = "MFEn-";
        String result = id.concat(Integer.toString(this.idEn));
        ca.setText(result);
        this.idEn++;
    }

    /**
     * METODO PARA CARGAR UN JCOMBOBOX CON LOS COD'S ENTRADAS
     * @param co 
     */
    public void nexoEntradaCodEntrada(JComboBox co) {
        // LIMPIO EL JCOMBOBOX Y LLENO
        co.removeAllItems();
        for (int i = 0; i < Entradas.size(); i++) {
            co.addItem(Entradas.get(i).getId_entrada());
        }
    }

    /**
     * METODO PARA CREAR UNA ENTRADA
     * @param en
     * @param d
     * @param j
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    public boolean insertarEntrada(Entrada en, DefaultTableModel d, JTable j) {
        // COMPRUEBO QUE NO ESTE CONTENIDA LA ENTRADA, LA INSERTO Y RECARGO EL MODELO ENTRADAS
        if (!this.Entradas.contains(en)) {
            this.Entradas.add(en);
            cargarModeloEntradas(d, j);
            return true;
        } else {
            return false;
        }
    }

    /**
     * METODO PARA BORRAR UNA ENTRADA
     * @param i
     * @param d
     * @param j 
     */
    public void borrarEntrada(int i, DefaultTableModel d, JTable j) {
        // CARGO EL OBJETO POR SU INDICE, BORRO LA ENTRADA POR SU INDICE Y RECARGO EL MODELO ENTRADAS
        Entrada aux = Entradas.get(i);
        nexoBorrarProyeccion(aux.getId_entrada());
        this.Entradas.remove(i);
        cargarModeloEntradas(d, j);
    }

    /**
     * METODO PARA MODIFICAR UNA ENTRADA
     * @param i
     * @param d
     * @param j
     * @param precio
     * @param titulo
     * @param cod_sala
     * @param cod_cine 
     */
    public void modificarEntrada(int i, DefaultTableModel d, JTable j,
            Double precio, String titulo, String cod_sala, String cod_cine) {
        // CARGO EL OBJETO POR SU INDICE, REALIZO LOS CAMBIOS PERTINENTES Y RECARGO EL MODELO ENTRADAS
        Entrada aux = this.Entradas.get(i);
        aux.setPrecio(precio);
        aux.setTitulo_pelicula(titulo);
        aux.setCod_sala(cod_sala);
        aux.setCod_cine(cod_cine);
        cargarModeloEntradas(d, j);
    }

    /**
     * METODO PARA CARGAR EL MODELO ENTRADAS
     * @param d
     * @param j 
     */
    public void cargarModeloEntradas(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // LIMPIO EL MODELO
        limpiarModelos(j);

        // AGREGO LAS COLUMNAS A LA TABLA
        d.addColumn("Id_entradas");
        d.addColumn("Precio");
        d.addColumn("Título_película");
        d.addColumn("Cod_sala");
        d.addColumn("Cod_cine");
        j.setModel(d);

        // CREO UN MODELO RENDERER PARA CENTRAR LOS DATOS Y PINTAR LAS FILAS
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                this.setHorizontalAlignment(SwingConstants.CENTER);

                if (row % 2 == 0) {
                    this.setOpaque(true);
                    this.setBackground(new Color(255, 255, 255));
                    this.setForeground(new Color(0, 0, 0));
                } else {
                    this.setOpaque(true);
                    this.setBackground(new Color(191, 191, 191));
                    this.setForeground(new Color(0, 0, 0));
                }

                if (isSelected) {
                    this.setOpaque(true);
                    this.setBackground(new Color(59, 115, 175));
                    this.setForeground(new Color(255, 255, 255));
                }

                return this;
            }
        };

        j.setDefaultRenderer(Object.class, modelocentrar);
        j.setGridColor(new Color(0, 0, 0));

        // VOY INSERTANDO FILAS AL MODELO
        Object[] filaEntradas = new Object[d.getColumnCount()];
        for (int i = 0; i < Entradas.size(); i++) {
            filaEntradas[0] = Entradas.get(i).getId_entrada();
            filaEntradas[1] = Entradas.get(i).getPrecio();
            filaEntradas[2] = Entradas.get(i).getTitulo_pelicula();
            filaEntradas[3] = Entradas.get(i).getCod_sala();
            filaEntradas[4] = Entradas.get(i).getCod_cine();
            d.addRow(filaEntradas);
        }
    }

    //
    // FIN OPERACIONES CON ENTRADAS
    //  
    //
    // COMIENZO OPERACIONES CON PROYECCIONES
    //
    
    /**
     * METODO CON EFECTO DOMINO BORRA UNA PROYECCION EN EL CASO QUE SE BORRE
     * UNA ENTRADA, SALA O PELICULA
     * @param id 
     */
    public void nexoBorrarProyeccion(String id) {
        // BORRA LA PROYECCION CON UN ITERADOR
        for (Iterator<Proyeccion> it = Proyecciones.iterator(); it.hasNext();) {
            Proyeccion aux = it.next();
            if (aux.getId_entrada().equals(id) | aux.getId_pelicula().equals(id)
                    | aux.getId_sala().equals(id)) {
                it.remove();
            }
        }
    }

    /**
     * METODO PARA CREAR UNA PROYECCION DE FORMA AUTOMATICA CUANDO CREAMOS UNA ENTRADA
     * @param idsala
     * @param identrada
     * @param titulo_pelicula
     * @param fecha_proyeccion
     * @param d
     * @param j 
     */
    public void nexoCrearProyeccion_Entrada(String idsala, String identrada,
            String titulo_pelicula, Date fecha_proyeccion, DefaultTableModel d,
            JTable j) {
        Proyeccion pro = new Proyeccion(idsala, identrada, null, fecha_proyeccion);
        for (int i = 0; i < Productoras.size(); i++) {
            for (Iterator<Pelicula> it = Productoras.get(i).Peliculas.iterator(); it.hasNext();) {
                Pelicula aux = it.next();
                if (aux.getNombre().equals(titulo_pelicula)) {
                    pro = new Proyeccion(idsala, identrada, aux.getId_pelicula(), fecha_proyeccion);
                }
            }

        }
        insertarProyeccion(pro, d, j);
    }

    /**
     * METODO PARA CREAR UNA PROYECCION
     * @param pro
     * @param d
     * @param j
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    public boolean insertarProyeccion(Proyeccion pro, DefaultTableModel d, JTable j) {
        // COMPRUEBA QUE NO ESTA CONTENIDA LA PROYECCION, LA INSERTRA YCARGO EL MODELO PROYECCIONES
        if (!this.Proyecciones.contains(pro)) {
            this.Proyecciones.add(pro);
            cargarModeloProyecciones(d, j);
            return true;
        } else {
            return false;
        }
    }

    /**
     * METODO PARA BORRAR UNA PROYECCION
     * @param i
     * @param d
     * @param j 
     */
    public void borrarProyeccion(int i, DefaultTableModel d, JTable j) {
        // BORRA LA PROYECCION POR SU INDICE
        this.Proyecciones.remove(i);
        cargarModeloProyecciones(d, j);
    }

    /**
     * METODO PARA MODIFICAR UNA PROYECCION
     * @param i
     * @param d
     * @param j
     * @param idsala
     * @param idpelicula
     * @param identrada
     * @param fecha 
     */
    public void modificarProyeccion(int i, DefaultTableModel d, JTable j,
            String idsala, String idpelicula, String identrada, Date fecha) {
        // CARGA EL OBJETO POR SU INDICE, REALIZO LOS CAMBIOS PERTIENENTES Y RECARGO EL MODELO PROYECCIONES
        Proyeccion aux = this.Proyecciones.get(i);
        aux.setId_sala(idsala);
        aux.setId_pelicula(idpelicula);
        aux.setId_entrada(identrada);
        aux.setFecha_proyeccion(fecha);
        cargarModeloProyecciones(d, j);
    }

    /**
     * METODO PARA CARGAR EL MODELO PROYECCIONES
     * @param d
     * @param j 
     */
    public void cargarModeloProyecciones(DefaultTableModel d, JTable j) {
        d = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // LIMPIO EL MODELO
        limpiarModelos(j);

        // AGREGO LAS COLUMNAS A LA TABLA
        d.addColumn("Id_sala");
        d.addColumn("Id_película");
        d.addColumn("Id_entrada");
        d.addColumn("Fecha_proyección");
        j.setModel(d);

        // CREO UN MODELO RENDERER PARA CENTRAR LOS DATOS Y PINTAR LAS FILAS
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                this.setHorizontalAlignment(SwingConstants.CENTER);

                if (row % 2 == 0) {
                    this.setOpaque(true);
                    this.setBackground(new Color(255, 255, 255));
                    this.setForeground(new Color(0, 0, 0));
                } else {
                    this.setOpaque(true);
                    this.setBackground(new Color(191, 191, 191));
                    this.setForeground(new Color(0, 0, 0));
                }

                if (isSelected) {
                    this.setOpaque(true);
                    this.setBackground(new Color(59, 115, 175));
                    this.setForeground(new Color(255, 255, 255));
                }

                return this;
            }
        };

        j.setDefaultRenderer(Object.class, modelocentrar);
        j.setGridColor(new Color(0, 0, 0));

        // VOY INSERTANDO FILAS AL MODELO
        Object[] filaProyecciones = new Object[d.getColumnCount()];
        for (int i = 0; i < Proyecciones.size(); i++) {
            filaProyecciones[0] = Proyecciones.get(i).getId_sala();
            filaProyecciones[1] = Proyecciones.get(i).getId_pelicula();
            filaProyecciones[2] = Proyecciones.get(i).getId_entrada();
            filaProyecciones[3] = Proyecciones.get(i).getFecha_proyeccion();
            d.addRow(filaProyecciones);
        }
    }

    //
    // FIN OPERACIONES CON PROYECCIONES
    //
    
    //
    // COMIENZO VARIOS
    //
    
    /**
     * MÉTODO PARA LIMPIAR TODOS LOS MODELOS EXISTENTES EN EL PROYECTO
     *
     * @param j
     */
    public void limpiarModelos(JTable j) {
        // MIENTRAS EL TOTAL DE FILAS SEA DISTINTO DE 0
        // VA BORRANDO TODAS LAS FILAS
        while (j.getRowCount() != 0) {
            ((DefaultTableModel) j.getModel()).removeRow(0);
        }
    }
    
    /**
     * METODO PARA PERMITIR EN UN JTEXTFIELD SOLO LETRAS
     * @param campo 
     */
    public void SoloPermitirLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    /**
     * METODO PARA PERMITIR EN UN JTEXTFIELD SOLO NUMEROS
     * @param campo 
     */
    public void SoloPermitirNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    /**
     * METODO PARA LIMPIAR TODOS LOS CAMPOS JTEXTFIELD
     * @param jPanel 
     */
    public void limpiarCamposJTextField(JPanel jPanel) {
        for (int i = 0; jPanel.getComponents().length > i; i++) {
            if (jPanel.getComponents()[i] instanceof JTextField) {
                ((JTextField) jPanel.getComponents()[i]).setText("");
            }
        }
    }

    /**
     * METODO PARA VALIDAR SI TODOS LOS JTEXTFIELD HAN SIDO RELLENADOS
     * @param jPanel
     * @return DEVUELVE UN VALOR BOOLEAN
     */
    public boolean comprobarCamposJTextField(JPanel jPanel) {
        boolean result = true;
        for (int i = 0; jPanel.getComponents().length > i; i++) {
            if (!result) {
                break;
            }
            if (jPanel.getComponents()[i] instanceof JTextField) {
                result = !((JTextField) jPanel.getComponents()[i]).getText().equals("") ? true : false;
            }
        }
        return result;
    }
    
    /**
     * METODO PARA MOSTRAR EN UNA ESTADISTICAS EN EL PROYECTO
     * TRABAJO CON LOS STREAM
     * @param a1
     * @param a2
     * @param a3
     * @param a4
     * @param a5
     * @param a6
     * @param a7
     * @param a8
     * @param a9
     * @param a10
     * @param a11 
     */
    public void MaxFilmEstadisticas(JLabel a1, JLabel a2, JLabel a3, JLabel a4,
            JLabel a5, JLabel a6, JLabel a7, JLabel a8, JLabel a9, JLabel a10, JLabel a11) {
        a1.setText(String.valueOf(Cines.stream().sorted().count()));
        a2.setText(String.valueOf(Salas.stream().filter(s -> s.getTipo().equals("2D")).sorted().count()));
        a3.setText(String.valueOf(Salas.stream().filter(s -> s.getTipo().equals("3D")).sorted().count()));
        a4.setText(String.valueOf(Mobiliarios.stream().sorted().count()));
        a5.setText(String.valueOf(Empleados.stream().sorted().count()));
        a6.setText(String.valueOf(VIP.stream().sorted().count()));
        a7.setText(String.valueOf(Proyecciones.stream().sorted().count()));
        a8.setText(String.valueOf(Entradas.stream().sorted().count()));
        
        double cont€ = 0.0;
        for (Entrada i : Entradas) {
            cont€ = cont€ + i.getPrecio();
        }
        
        a9.setText(String.valueOf(cont€));
        a10.setText(String.valueOf(Peliculas.stream().sorted().count()));
        a11.setText(String.valueOf(Productoras.stream().sorted().count()));
    }
    
    //
    // FIN VARIOS
    //
}
