/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina;

/**
 * Clase que crea cuentas bancarias con
 * Numero de cuenta y saldo
 * y permite conocer el saldo, así como hacer depósitos y retiros
 * @author
 * Navarro Miranda, Mauricio <mauricio@navarromiranda.mx>
 * González Mora, Erick Alan <erick_lann@hotmail.com>
 * Romero Garcia, Enrique Javier <enriquefi@yahoo.com.mx>
 */
public class CuentaBancaria {
    private String numero;
    private double saldo;
    /**
     * Constructor de una CuentaBancaria completa
     * @param numero de cuenta a crear
     * @param saldo a depositar
     * El saldo no aparece mágicamente, es depositado.
     */    
    public CuentaBancaria(String numero, double saldo){
        this.numero = numero;
        depositar(saldo);
    }
    
    public CuentaBancaria(String numero){
        this(numero,0);
    }
    /**
     * Método para depositar dinero
     * @param monto a depositar
     */
    final public void depositar(double monto){
        saldo += monto;
    }
    /**
     * Método para retirar. Es un alias de depositar
     * @param monto a retirar
     */
    public void retirar(double monto){
        depositar(-1*monto);
    }
    
    /*
     * Métodos accesores y toString 
     */
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