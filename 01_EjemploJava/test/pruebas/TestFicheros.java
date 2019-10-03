/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import threads.HiloFichero;
import threads.StringAuxV1;
import threads.StringAuxV2;

/**
 *
 * @author student
 */
public class TestFicheros {
    
    interface IObservador{ //Observer de java
        void updateTerminado(String nombre, double tiempo);
    }
    
    class MiObservador implements IObservador{

        @Override
        public void updateTerminado(String nombre, double tiempo) {
            System.out.println("El hilo" + nombre + " ha tardado " + tiempo);
        }
    }
    
    class Observado{ //Observable de java
        IObservador observador; //Seria una lista
        
        public void addObserver(IObservador observador){
            this.observador = observador;
        }
        
        public void notificar(double tiempo){
            //Recorrer todos los observadores
            observador.updateTerminado(this.getClass().toString(), tiempo);
        }
    }
    
    class HiloObservadoV1 extends Observado implements Runnable{

        @Override
        public void run() {
            double tiempoIni = (new Date()).getTime();
            HiloFichero hiloFichero = new HiloFichero(new StringAuxV1());
            hiloFichero.leerFicherosEjem("textoespaciado.txt");
            notificar((new Date()).getTime() - tiempoIni);
        }
        
    }
    
    class HiloObservadoV2 extends Observado implements Runnable{

        @Override
        public void run() {
            double tiempoIni = (new Date()).getTime();
            HiloFichero hiloFichero = new HiloFichero(new StringAuxV2());
            hiloFichero.leerFicherosEjem("textoespaciado.txt");
            notificar((new Date()).getTime() - tiempoIni);
        }
        
    }
    
    public TestFicheros() {
    }

    //@Test
    public void generacionFicheroAleatorio() {
        HiloFichero hiloFichero = new HiloFichero(new StringAuxV1());
        hiloFichero.crearFicheroEjem("C:\\Users\\student\\Desktop\\ESCUELA_JAVA\\escuela_java.git\\01_EjemploJava\\textoespaciado.txt");
    }
    
    //@Test
    public void lecturaFicheroAleatorio() {
        HiloFichero hiloFichero = new HiloFichero(new StringAuxV1());
        hiloFichero.leerFicherosEjem("C:\\Users\\student\\Desktop\\ESCUELA_JAVA\\escuela_java.git\\01_EjemploJava\\textoespaciado.txt");
    }
    
    @Test
    public void lanzarHilosFichero() {
        
        MiObservador miObservador = new MiObservador();
        HiloObservadoV1 hiloV1 = new HiloObservadoV1();
        HiloObservadoV2 hiloV2 = new HiloObservadoV2();
        
        hiloV1.addObserver(miObservador);
        hiloV2.addObserver(miObservador);
        
        Thread threadV1 = new Thread(hiloV1);
        Thread threadV2 = new Thread(hiloV2);
        threadV1.start();
        threadV2.start();
        
        try {
            threadV1.join();
            threadV2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
