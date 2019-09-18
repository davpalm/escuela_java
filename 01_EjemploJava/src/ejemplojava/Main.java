/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojava;

import clasesjava.ProbandoString;


public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        ProbandoString.tratarCadenas();
    }
    
    
    public static void mainCoches(String[] args) {
        
        System.out.println("Empezando POO");
        Coche miCoche;
        
        miCoche = new Coche("Kia", "ROJO", Coche.TipoCarburante.GASOLINA); // La instanciacion se hace con new
        
        
        miCoche.echarCarburante(30); // Empezamos con medio deposito
        
        System.out.println("Todos los coches tienen: " + Coche.CAPACIDAD_DEPOSITO);
        System.out.println("Coche creado: " + miCoche.getMarca());
        System.out.println("Nivel deposito: " + miCoche.getNivelDep() + " litros");
        
        
        Coche otroCoche = miCoche; // new Coche();
        // otroCoche.marca = "Seat"; YA NO SE PUEDE
        System.out.println("Coche creado: " + otroCoche.getMarca());
        // vaciarDeposito(miCoche);
        miCoche.vaciarDeposito();
        System.out.println("Nivel deposito: " + otroCoche.getNivelDep() + " litros");
        
        miCoche.setArrancado(true);
        miCoche.echarCarburante(-2);
        for (int i = 0; i < 3; i++)
        {
            miCoche.acelerar();
        }
        
        miCoche.mostrar();
        
        CocheRally cocheRally = new CocheRally("TOYOTA", Coche.TipoColor.ROJO, Coche.TipoCarburante.GASOLINA, 2.1f);
        cocheRally.echarCarburante(40);
        cocheRally.setArrancado(true);
        cocheRally.acelerar();
        cocheRally.acelerar();
        cocheRally.derrapar();
        cocheRally.mostrar();
        
        Coche rallyNormal= cocheRally;
        rallyNormal.explosionCilindro();
        rallyNormal.acelerar();
        rallyNormal.mostrar();
        
        CocheRally cr = (CocheRally)rallyNormal;
        System.out.println("Y el rozamiento?" + cr.getRozamiento());
        
        //cr = (CocheRally)miCoche;
        //System.out.println("Y el rozamiento?" + cr.getRozamiento());
        
    }    
}
