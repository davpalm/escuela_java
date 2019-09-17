/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojava;

/**
 *
 * @author student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Empezando POO");
//        Coche mCoche = new Coche("Kia", 60, true);
//        mCoche.echarCarburante(30);
//        mCoche.setArrancado(false);
//        
//        System.out.println("UN COCHE");
//        System.out.println("========");
//        System.out.println("Coche creador: " + mCoche.getMarca());
//        System.out.println("Capacidad deposito: " + mCoche.getCapacidadDeposito());
//        System.out.println("Gasolina: " + mCoche.isGasolina());
//        System.out.println("Numero de ruedas: " + mCoche.getNumRuedas());
//        System.out.println("Nivel del deposito: " + mCoche.getNivelDeposito() + " litros");
        
        Coche otroCoche = new Coche("Seat", 70, false);
        otroCoche.echarCarburante(50);
        otroCoche.setArrancado(true);
        
        System.out.println("OTRO COCHE");
        System.out.println("==========");
        System.out.println("Coche creador: " + otroCoche.getMarca());
        System.out.println("Capacidad deposito: " + otroCoche.getCapacidadDeposito());
        System.out.println("Gasolina: " + otroCoche.isGasolina());
        System.out.println("Numero de ruedas: " + otroCoche.getNumRuedas());
        System.out.println("Nivel del deposito: " + otroCoche.getNivelDeposito() + " litros");
        
        //vaciarDeposito(otroCoche);
        
        //otroCoche.vaciarDeposito();
        //otroCoche.echarCarburante(30);
        
        System.out.println("Arrancamos el coche");
        for(int i=0; i<3; i++)
        {
            otroCoche.acelerar();
        }
        System.out.println(otroCoche.toString());
        
    }
    
//    public static void vaciarDeposito(Coche coche)
//    {
//        coche.capacidadDeposito=3;
//        System.out.println("Deposito vaciado de " + coche.marca + "\n Nivel: " + coche.capacidadDeposito);
//    }
    
}
