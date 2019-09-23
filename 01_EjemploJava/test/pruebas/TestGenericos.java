/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
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
public class TestGenericos {
   
    @Test
    public void metodosGenericos() 
    {
        ArrayList<Integer> listaInt = new ArrayList<>();
        insertarDobleGenerico(listaInt, 10);
        insertarDobleGenerico(listaInt, 10);
        System.out.println("Enteros: " + listaInt.toString());
        
        ArrayList<String> listaStr = new ArrayList<>();
        insertarDobleGenerico(listaStr, "Texto 1");
        insertarDobleGenerico(listaStr, "Texto 2");
        System.out.println("Textos: " + listaStr.toString());
        
        String[] array = new String[3];
        array[0]="Texto 1111";
        array[1]="Texto 2222";
        array[2]="Texto 3333";
        
        pintarLista(array);
        
        ArrayList<String> arraListConvertido = convertirArray(array);
        
        for(String obj : arraListConvertido)
        {
            System.out.println("Array convertido " + obj.toString());
        }
    }
    
    public static <Tipo> void insertarDobleGenerico(ArrayList<Tipo> lista, Tipo valor)
    {
        lista.add(valor);
        lista.add(valor);
    }
    
    public static <Tipo> void pintarLista(Tipo[] array)
    {
        for(Tipo valor:array)
        {
            System.out.println(valor.toString());
        }
    }
    
    public static <Tipo> ArrayList<Tipo> convertirArray(Tipo[] array)
    {
        ArrayList<Tipo> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(array));
        return arrayList;
    }
}
