/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author student
 */
public class TesteEjemploHilos {
    
    private class ProcesoA extends Thread{

        @Override
        public void run() {
            mostrarLista();
        }
        
        public void mostrarLista(){
            for(int i=0; i<200; i++)
            {
                try {
                    System.out.println("Proceso A: " + i);
                    Thread.sleep(3);
                } 
                catch (InterruptedException ex) {
                    Logger.getLogger(TesteEjemploHilos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Test
    public void probandoClasesConNombre() {
        ProcesoA procesoA = new ProcesoA();
        Thread procesoB = new Thread(){
            @Override
            public void run() {
                for(int i=0; i<200; i++)
            {
                try {
                    System.out.println("Proceso B: " + i);
                    Thread.sleep(3);
                } 
                catch (Exception e) {
                    Logger.getLogger(TesteEjemploHilos.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            }
            
        };
        
        //procesoA.mostrarLista();
        
        procesoA.start();
        procesoB.start();
        
        try {
            procesoA.join();
            procesoB.join();
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(TesteEjemploHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
                
    }
}
