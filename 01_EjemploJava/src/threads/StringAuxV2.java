package threads;
/**
 * @author student
 */
public class StringAuxV2 implements IStringAux{

    @Override
    public String quitarEspacios(String texto) {
        texto = texto.trim();
        String[] palabras = texto.split(" ");
        String result = "";
        for (String palabra : palabras) {
            if ( ! palabra.isEmpty())
                result += palabra + " ";
        }
        return result.trim();
    }
    
}
