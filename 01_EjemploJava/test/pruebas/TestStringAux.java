/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import clasesjava.ProbandoString;
import clasesjava.StringAux;
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
public class TestStringAux {
    
    public TestStringAux() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void ProbandoQuitarEspacios() 
    {
        String texto = "En un lugar de La Mancha de cuyo nombre no quiero acordarme, vivia...";
        String texto2 =  "En un lugar de Madrid...";
        String texto3 = "       en   un    LUGAR   ";
        String resultadoOK = "en un LUGAR";
        
        StringAux stringAux = new StringAux(texto3);
        String resultadoAUX = stringAux.quitarEspSobrantes();
        assertEquals(resultadoOK, resultadoAUX);
        
    }
}
