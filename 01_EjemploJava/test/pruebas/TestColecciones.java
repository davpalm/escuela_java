package pruebas;

import poo.Coche;
import poo.CocheRally;
import poo.TipoCarburante;
import poo.TipoColor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;
import poo.Pelota;

public class TestColecciones {
    
    //@Test
    public void arrays() {
        Coche[] coches = new Coche[3]; //  Coche coches[];
        coches[0] = new Coche("Fiat", TipoCarburante.DIESEL, TipoColor.AZUL);
        coches[1] = new Coche("Audi", TipoCarburante.GASOLINA, TipoColor.ROJO);
        coches[2] = new Coche("Kia", TipoCarburante.ELECTRICO, TipoColor.VERDE);
        
        Coche[] cochesBis = { coches[2], 
            coches[1], 
            new Coche("Kia", TipoCarburante.ELECTRICO, TipoColor.VERDE)
        };
        Coche elMio = new Coche("Kia", TipoCarburante.ELECTRICO, TipoColor.ROJO);
        elMio = coches[2];
        elMio.setArrancado(true);
        elMio.acelerar();
        ///////////////
        coches[2].mostrar();
        
        ArrayList arrayListObj = new ArrayList(); // ArrayList NO genérico, 
        arrayListObj.add(42);               // Todos los elementos son objetos
        arrayListObj.add("Aaaaaa");
        arrayListObj.add(elMio);
        arrayListObj.add(false);
        for (Object obj : arrayListObj) {
            System.out.println(" OBJ: " + obj);
        }
        ArrayList<Integer> ventasAnuales = new ArrayList<Integer>();
        Integer objEntero = new Integer(200);
        objEntero.longValue();
        ventasAnuales.add(objEntero);
        ventasAnuales.add(30000);
        // ventasAnuales.add("oooooo no");
        
        ArrayList<Coche> cochesParaVender = new ArrayList<>();
        cochesParaVender.add(new Coche("Sinca", TipoCarburante.GASOLINA, TipoColor.AZUL));
        cochesParaVender.add(coches[0]);
        cochesParaVender.add(coches[1]);
        cochesParaVender.add(coches[2]);
        
        cochesParaVender.add(new CocheRally("Subaru Imprezza"));
        if (cochesParaVender.contains(coches[0])) {
            System.out.println("El coche existe");
        }
        TestColecciones.mostrarCoche(elMio);
       cochesParaVender.forEach( TestColecciones::mostrarCoche );
       // FUNCION LAMBDA
       cochesParaVender.forEach(  (coche) -> { 
                    System.out.println(" -> " + coche.toString());
                });
//        cochesParaVender.add("Que no se puede");
    }
    public static void mostrarCoche(Coche coche) {
        System.out.println(" -> " + coche.toString());
    }
    
    //@Test
    public void sets()
    {
        HashSet<Pelota> pelotas = new HashSet<Pelota>();
        Pelota p1 = new Pelota();
        Pelota p2 = new Pelota();
        Pelota p3 = new Pelota();
        
        pelotas.add(p1);
        pelotas.add(p2);
        pelotas.add(p3);
        
        System.out.println("Set pelotas: " + pelotas);
        assertEquals(pelotas.size(), 3);
    }
    
    @Test
    public void maps(){
        HashMap<String, Boolean> coloresCalidos = new HashMap<String, Boolean>();
        coloresCalidos.put("BLANCO", Boolean.FALSE);
        coloresCalidos.put("ROJO", true);
        coloresCalidos.put("AZUL", false);
        coloresCalidos.put("VERDE", false);
        coloresCalidos.put("NARANJA", true);
        
        if(coloresCalidos.get("ROJO"))
        {
            System.out.println("Rojo es cálido");
        }
        if(coloresCalidos.get("AZUL"))
        {
            System.out.println("Azul es cálido");
        }
        
        System.out.println("Naran");
    }
}



