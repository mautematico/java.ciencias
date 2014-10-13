/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina;

/**
 *
 * @author
 * Navarro Miranda, Mauricio <mauricio@navarromiranda.mx>
 * González Mora, Erick Alan <erick_lann@hotmail.com>
 * Romero Garcia, Enrique Javier <enriquefi@yahoo.com.mx>
 */
public class CuentaBancaria {
    private String numero;
    private double saldo;
        
    public CuentaBancaria(String numero, double saldo){
        this.numero = numero;
        depositar(saldo);
    }
    
    public CuentaBancaria(String numero){
        this(numero,0);
    }
    
    final public void depositar(double monto){
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
    
    @Override
    public String toString(){
        return "Numero de Cuenta: "+ numero + "\n"+ "Saldo: "+saldo;
    }
}