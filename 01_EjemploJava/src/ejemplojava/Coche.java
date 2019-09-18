package ejemplojava;

public class Coche { 

 
    enum TipoColor {BLANCO, NEGRO, ROJO, VERDE, AZUL, PLATEADO};
    enum TipoCarburante {GASOLINA, DIESEL, ELECTRICO};
    
    public static final int CAPACIDAD_DEPOSITO = 60;
    
    private final byte numRuedas;   // Valor constante por el final
    private final String marca;
    //private final boolean esGasolina;
    private double nivDeposito;
    private boolean arrancado;
    private TipoColor color;
    private TipoCarburante carburante;
  
    public Coche(String marca, TipoColor color, TipoCarburante carburante) {
        this.numRuedas = 4;
        this.marca = marca;
        this.color = color;
        this.carburante = carburante;
    }
    
    public Coche(String marca, String color, TipoCarburante carburante) {
        this.numRuedas = 4;
        this.marca = marca;
        this.color = compruebaColor(color.toUpperCase());//TipoColor.valueOf(color.toUpperCase());
        this.carburante = carburante;
    }
    
    public double getNivelDep() {
        return nivDeposito;
    }

    public byte getNumRuedas() {
        return numRuedas;
    }
    
    
    public void echarCarburante(double cantidad) {
        if (cantidad > 0)
            this.nivDeposito += cantidad;
        
        if (nivDeposito > CAPACIDAD_DEPOSITO)
            nivDeposito = CAPACIDAD_DEPOSITO;
    }
    
    public void acelerar() {
        if (arrancado)
        {
            nivDeposito -= 0.1;
            explosionCilindro();
        }
    }
    
    public void vaciarDeposito() {
        // float nivelDeposito = 2;
        this.nivDeposito = 3;
        System.out.println("Deposito vaciado de " + this.toString()
                /*+ "\n   Nivel: " + nivelDeposito*/ );  
    }
    public String toString() {
        return "Coche " + marca + " nivel " + nivDeposito + " color " + color + " carburante " + carburante;
    }
    public void mostrar() {
        System.out.println(this.toString()); 
    }

    public String getMarca() {
        return marca;
    }

    public boolean isArrancado() {
        return arrancado;
    }

    public double getNivDeposito() {
        return nivDeposito;
    }

    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }
    
    private TipoColor compruebaColor(String colorUsuario) {
        
        TipoColor colorCoche=TipoColor.BLANCO;
        
        try
        {
            colorCoche=TipoColor.valueOf(colorUsuario);
        }
        catch(Exception e)
        {
            System.out.println("El color introducido no esta disponible. Se le asigna el color por defecto(BLANCO)");
        }
        return colorCoche;    
    }
    
    protected void explosionCilindro()
    {
        System.out.println("Motor funcionando");
    }

    protected void setNivDeposito(double nivDeposito) {
        this.nivDeposito = nivDeposito;
    }
    
}
