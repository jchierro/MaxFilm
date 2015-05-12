/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jchierro
 */
public class MobiliarioTest {
    
    public MobiliarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test getId_mobiliario.
     */
    @Test
    public void testGetId_mobiliario() {
        System.out.println("getId_mobiliario");
        Mobiliario instance = new Mobiliario("MFM-1","Butacas","30","26.05.2015",true,"MFS-1");
        String expResult = "MFM-1";
        String result = instance.getId_mobiliario();
        assertEquals(expResult, result);
    }

    /**
     * Test getNombre.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Mobiliario instance = new Mobiliario("MFM-1","Butacas","30","26.05.2015",true,"MFS-1");
        String expResult = "Butacas";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test getCantidad.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        Mobiliario instance = new Mobiliario("MFM-1","Butacas","30","26.05.2015",true,"MFS-1");
        String expResult = "30";
        String result = instance.getCantidad();
        assertEquals(expResult, result);
    }

    /**
     * Test getFecha.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Mobiliario instance = new Mobiliario("MFM-1","Butacas","30","26.05.2015",true,"MFS-1");
        String expResult = "26.05.2015";
        String result = instance.getFecha();
        assertEquals(expResult, result);
    }

    /**
     * Test getEstado.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Mobiliario instance = new Mobiliario("MFM-1","Butacas","30","26.05.2015",true,"MFS-1");
        Boolean expResult = true;
        Boolean result = instance.getEstado();
        assertEquals(expResult, result);
    }

    /**
     * Test getCod_sala.
     */
    @Test
    public void testGetCod_sala() {
        System.out.println("getCod_sala");
        Mobiliario instance = new Mobiliario("MFM-1","Butacas","30","26.05.2015",true,"MFS-1");
        String expResult = "MFS-1";
        String result = instance.getCod_sala();
        assertEquals(expResult, result);
    }
}
