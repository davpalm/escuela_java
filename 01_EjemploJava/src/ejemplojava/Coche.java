/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojava;

/**
 *
 * @author student
 */
public class Coche {
    
    private final byte numRuedas;
    private String marca;
    private int capacidadDeposito;
    private boolean gasolina;
    private double nivelDeposito;
    private boolean arrancado;

    public Coche(String marca, int capacidadDeposito, boolean gasolina) {
        this.numRuedas=4;
        this.marca=marca;
        this.capacidadDeposito=capacidadDeposito;
        this.gasolina=gasolina;
    }
    
    public void echarCarburante(double cantidad)
    {
        if(cantidad >0)
        {
            this.nivelDeposito += cantidad;
        }
        
        if(this.nivelDeposito > this.capacidadDeposito)
        {
           this.nivelDeposito = this.capacidadDeposito;
        }
    }
    
    public void acelerar()
    {
        if(this.arrancado)
        {
            this.nivelDeposito -= 0.1;
        }
    }
    
    public void vaciarDeposito()
    {
        this.nivelDeposito=3;
        System.out.println("Deposito vaciado de " + this.toString());
    }

    @Override
    public String toString() {
        return "Coche{" + "numRuedas=" + numRuedas + ", marca=" + marca + ", capacidadDeposito=" + capacidadDeposito + ", gasolina=" + gasolina + ", nivelDeposito=" + nivelDeposito + '}';
    }

    public byte getNumRuedas() {
        return numRuedas;
    }

    public String getMarca() {
        return marca;
    }

    public int getCapacidadDeposito() {
        return capacidadDeposito;
    }

    public boolean isGasolina() {
        return gasolina;
    }

    public double getNivelDeposito() {
        return nivelDeposito;
    }
    
    public void setNivelDeposito(double nivelDeposito) {
        this.nivelDeposito = nivelDeposito;
    }

    public boolean isArrancado() {
        return arrancado;
    }

    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }    
    
}
