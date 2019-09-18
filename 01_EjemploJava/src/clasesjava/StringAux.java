package clasesjava;
/**
 * @author student
 */
public class StringAux {

    private String string;
    
    public StringAux(String string)
    {
        this.string= string;
    }
    
    public String getString()
    {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
    
    public String quitarEspSobrantes()
    {
        return quitarEspSobrantes(string);
    }
    
    public int contarPalabras()
    {
        return contarPalabras(string);
    }
    
    public static String quitarEspSobrantes(String frase)
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
    
    public static int contarPalabras(String texto)
    {
        return texto.split(" ").length;
    }
}
