package ejemplojava;
/**
 * @author student
 */
public class CocheRally extends Coche{
    
    private float rozamiento;
    
    public CocheRally(String marca, TipoColor color, TipoCarburante carburante, float rozamiento) {
        super(marca, color, carburante);
        this.rozamiento=rozamiento;
    }
    
    public void derrapar()
    {
        System.out.println("Derrapeeeee!");
        super.explosionCilindro();
    }
    
    public void derrapar(float cuanto)
    {
        System.out.println("Derrapeeeee!");
        super.explosionCilindro();
    }
    
    //SOBREESCRITURA DE METODOS
    @Override
    public void acelerar()
    {
        System.out.println("Acelerando a lo bestia");
        if (isArrancado())
        {
            setNivDeposito(getNivDeposito()-0.1);
            explosionCilindro();
        }
    }
            
    public CocheRally(String marca, String color, TipoCarburante carburante, float rozamiento) {
        super(marca, color, carburante);
        this.rozamiento=rozamiento;
    }
    

    public float getRozamiento() {
        return rozamiento;
    }

    public void setRozamiento(float rozamiento) {
        this.rozamiento = rozamiento;
    }
    
    
    
}
