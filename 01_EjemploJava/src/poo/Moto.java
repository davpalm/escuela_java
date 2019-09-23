package poo;

public class Moto extends Vehiculo implements Rodable {

    private final byte numRuedas;
    
    public Moto(String marca) {
        super(marca, "SIN MATRICULAR");
        this.numRuedas = 2;
    }
    @Override
    public void abrirPuerta() {        
        System.out.println(  "Loco, no hay puertas, no te tires");
    }

    @Override
    public void acelerar() {
        System.out.println("Moto " + getMatricula() + "acelerando ");
    }

    @Override
    public byte getNumRuedas() {
        return numRuedas;
    }

    @Override
    public void moverse() {
        System.out.println("AVANNZA LA MOTO! " + toString());
    }
    
}
