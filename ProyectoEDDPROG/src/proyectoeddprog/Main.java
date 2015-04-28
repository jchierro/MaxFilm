/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeddprog;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jchierro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // CARGA EL LOOKANDFEEL USADO EN ESTE PROYECTO
        try {  
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");  
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {  
            System.out.println(ex);
        }  
        
        VentanaPrincipal x = new VentanaPrincipal();
        x.setVisible(true);
    }
    
}
