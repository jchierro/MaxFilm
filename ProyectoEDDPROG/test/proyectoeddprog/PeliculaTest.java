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
public class PeliculaTest {
    
    public PeliculaTest() {
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
     * Test getId_pelicula.
     */
    @Test
    public void testGetId_pelicula() {
        System.out.println("getId_pelicula");
        Pelicula instance = new Pelicula("MFPe-1","Se nos fue de las manos",
                "Philippe Lacheau","2014","18","Francia","Comedia","85","MFPr-1");
        String expResult = "MFPe-1";
        String result = instance.getId_pelicula();
        assertEquals(expResult, result);
    }

    /**
     * Test getNombre.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Pelicula instance = new Pelicula("MFPe-1","Se nos fue de las manos",
                "Philippe Lacheau","2014","18","Francia","Comedia","85","MFPr-1");
        String expResult = "Se nos fue de las manos";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test getDirector.
     */
    @Test
    public void testGetDirector() {
        System.out.println("getDirector");
        Pelicula instance = new Pelicula("MFPe-1","Se nos fue de las manos",
                "Philippe Lacheau","2014","18","Francia","Comedia","85","MFPr-1");
        String expResult = "Philippe Lacheau";
        String result = instance.getDirector();
        assertEquals(expResult, result);
    }

    /**
     * Test getAño.
     */
    @Test
    public void testGetAño() {
        System.out.println("getAño");
        Pelicula instance = new Pelicula("MFPe-1","Se nos fue de las manos",
                "Philippe Lacheau","2014","18","Francia","Comedia","85","MFPr-1");
        String expResult = "2014";
        String result = instance.getAño();
        assertEquals(expResult, result);
    }

    /**
     * Test getEdad.
     */
    @Test
    public void testGetEdad() {
        System.out.println("getEdad");
        Pelicula instance = new Pelicula("MFPe-1","Se nos fue de las manos",
                "Philippe Lacheau","2014","18","Francia","Comedia","85","MFPr-1");
        String expResult = "18";
        String result = instance.getEdad();
        assertEquals(expResult, result);
    }

    /**
     * Test getPais.
     */
    @Test
    public void testGetPais() {
        System.out.println("getPais");
        Pelicula instance = new Pelicula("MFPe-1","Se nos fue de las manos",
                "Philippe Lacheau","2014","18","Francia","Comedia","85","MFPr-1");
        String expResult = "Francia";
        String result = instance.getPais();
        assertEquals(expResult, result);
    }

    /**
     * Test getGenero.
     */
    @Test
    public void testGetGenero() {
        System.out.println("getGenero");
        Pelicula instance = new Pelicula("MFPe-1","Se nos fue de las manos",
                "Philippe Lacheau","2014","18","Francia","Comedia","85","MFPr-1");
        String expResult = "Comedia";
        String result = instance.getGenero();
        assertEquals(expResult, result);
    }

    /**
     * Test getDuracion.
     */
    @Test
    public void testGetDuracion() {
        System.out.println("getDuracion");
        Pelicula instance = new Pelicula("MFPe-1","Se nos fue de las manos",
                "Philippe Lacheau","2014","18","Francia","Comedia","85","MFPr-1");
        String expResult = "85";
        String result = instance.getDuracion();
        assertEquals(expResult, result);
    }

    /**
     * Test getCod_productora.
     */
    @Test
    public void testGetCod_productora() {
        System.out.println("getCod_productora");
        Pelicula instance = new Pelicula("MFPe-1","Se nos fue de las manos",
                "Philippe Lacheau","2014","18","Francia","Comedia","85","MFPr-1");
        String expResult = "MFPr-1";
        String result = instance.getCod_productora();
        assertEquals(expResult, result);
    }
}
