package clasesjava;
/**
 * @author student
 */
public class ProbandoString {
    
    public static void tratarCadenas()
    {
        String texto = "En un lugar de La Mancha de cuyo nombre no quiero acordarme, vivia...";
        System.out.println(texto);
        System.out.println("Cuarta letra " + texto.charAt(3));
        
        //Comparaciones
        String texto2 =  "En un lugar de Madrid...";
        System.out.println("Comparacion: " + texto.compareTo(texto2));
        
        texto2= texto2.substring(0,10);
        System.out.println("texto2 ahora es: " + texto2);
        
        if(texto.contains(texto2))
        {
            System.out.println("texto contiene texto2");
        }
        else
        {
            System.out.println("texto no contiene texto2");
        }
        
        System.out.println("\"Mancha\" esta en la posicion " + texto.indexOf("Mancha"));
        texto = texto.replace("lugar", "bar");
        System.out.println(texto);
        
        String texto3="       en   un    LUGAR   ";
        texto3 = texto3.toUpperCase().trim();
        System.out.println(texto3);
        
        texto3 = texto3.replaceAll(" +", " ").trim();
        System.out.println(texto3);
        
        int longitud =texto3.split(" ").length;
        System.out.println("Numero de palabras: " + longitud);
        
        String frasenueva = quitarEspacios("dadaw qew        ew   weqw      qwdqw");
        System.out.println(frasenueva);
        
        System.out.println("Numero de palabras: " + contarPalabras(frasenueva));
        
    }
    
    public static String quitarEspacios(String frase)
    {
        String frasenueva="";
        for(int i=0; i<frase.length(); i++)
        {
            if(frase.charAt(i)==' ' && i+1<frase.length())
            {  
                if(frase.charAt(i+1)!=' ')
                {
                    frasenueva=frasenueva + frase.charAt(i);
                }
            }
            else
            {
                frasenueva=frasenueva + frase.charAt(i);
            }
        }
        
        return frasenueva.trim();
    }
    
    public static int contarPalabras(String frase)
    {
        return frase.split(" ").length;
    }
}
