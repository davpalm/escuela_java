package threads;

import clasesjava.StringAux;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * @author student
 */
public class HiloFichero {
    
    IStringAux iStrAux;
    
    public HiloFichero(IStringAux iStringAux){
        iStrAux = iStringAux;
    }
    
    public void crearFicheroEjem(String rutaFichero) {
        //String[] palabras = {"Aaaaa", "Bbbbbb", "Ccccc", "Dddddd"};
        String[] palabras = new String['Z' - 'A' + 1];
        Random random = new Random(new Date().getTime());
        for(char c='A'; c < 'Z' + 1; c++)
        {
            int repe= 2 + Math.abs(random.nextInt() % 8); //numeros aleatorios entre 2 y 9
            palabras[c - 'A']="";
            for(int i=0; i < repe; i++)
            {
                palabras[c - 'A'] += "" + c;
            }
        }
        
        System.out.println("> " + Arrays.toString(palabras));
        
        //Crear fichero
        FileWriter fileWriter= null;
        try{
            fileWriter = new FileWriter(rutaFichero, false);
            for(int i=0; i<200000; i++){
                //Numero aleatorio entre 0 y 2 (3-1)
                if(random.nextInt(2) == 0){
                    fileWriter.write(palabras[random.nextInt(palabras.length)]);
                }
                
                if(random.nextInt(2) == 0){  
                    for(int j=0; j<5; j++){
                        fileWriter.write(" ");
                    }
                }
                
                if(random.nextInt(12) == 0){
                    fileWriter.write("\n\r");
                }
            }
            
        }
        catch(IOException ex){
            System.err.println("Error en escritura: " + ex.getMessage());
        }
        catch(Exception ex){
            System.err.println("Error en escritura: " + ex.getMessage());
        }
        finally{
            try {
                if(fileWriter != null){
                    fileWriter.close();
                }
            } catch (IOException ex) {
                System.err.println("Error en escritura: " + ex.getMessage());
            }
        }
        
    }
    
    public void leerFicherosEjem(String rutaFichero){
        File file = new File(rutaFichero);
        Scanner scanner = null;
        
        try{
            scanner = new Scanner(file);
            while(scanner.hasNext()){
                String linea=scanner.nextLine();
                StringAux strAux = new StringAux(linea);
                System.out.println(iStrAux.quitarEspacios(linea));
            }
        }
        catch(Exception ex){
            System.err.println("Error en lectura: " + ex.getMessage());
        }
        finally{
            try {
                if(scanner != null){
                    scanner.close();
                }
            } catch (Exception ex) {
                System.err.println("Error en lectura: " + ex.getMessage());
            }
        }
    }
}
