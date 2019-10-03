package threads;
/**
 * @author student
 */
public class StringAuxV3 implements IStringAux{

    @Override
    public String quitarEspacios(String texto) {
        texto = texto.trim();
        
        while (texto.contains("  ")) {
            texto = texto.replace("  ", " ");
        }
        return texto;
    }
    
}
