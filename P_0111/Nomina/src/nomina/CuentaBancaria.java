/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina;

/**
 *
 * @author actuaria
 */
public class CuentaBancaria {
    private String numero;
    private double saldo;
    
    public CuentaBancaria(){
        
    }
    
    public CuentaBancaria(String numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }
    public CuentaBancaria(String numero){
        this(numero,0);
    }
    
    public void depositar(double monto){
        saldo += monto;
    }
    
    public void retirar(double monto){
        depositar(-1*monto);
    }
    
    public String getNumero(){
        return numero;
    }
        
    public double getSaldo(){
        return saldo;
    }
        
    public String toString(){
        return "Numero de Cuenta: "+ numero + "\n"+ "Saldo: "+saldo;
    }
}
