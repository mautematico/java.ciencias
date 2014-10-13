/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nomina;

/**
 *
 * @author erick alan
 */
public class Nomina {
    private Empleado gerente;
    private Empleado intendente;
    private Empleado secretaria;
    private int numeroQuincena;
    private boolean quincenaPagada;
    private static int contadorQuincenas;
    
    public Nomina(Nomina nomina){
        this.gerente = nomina.getGerente();
        this.intendente = nomina.getIntendente();
        this.secretaria = nomina.getSecretaria();
    }
    
    public Nomina(Empleado gerente, Empleado intendente, Empleado secretaria){
        this.gerente = gerente;
        this.intendente = intendente;
        this.secretaria = secretaria;
    }
    
    public void pagar(){
        if(quincenaPagada){
            return;
        }
        
        gerente.cobrar();
        intendente.cobrar();
        secretaria.cobrar();
        quincenaPagada = true;
        contadorQuincenas++;
    }
    
    public void mostrarNomina(){
        System.out.println();
    }

    public Empleado getGerente() {
        return gerente;
    }
    
    public void setGerente(Empleado gerente){
        this.gerente = gerente;
    }
    
    public Empleado getIntendente(){
        return intendente;
    }
    
    public void setIntendente(Empleado intendente){
        this.intendente = intendente;
    }
    
    public Empleado getSecretaria(){
        return secretaria;
    }
    
    public void setSecretaria(Empleado secretaria){
        this.secretaria = secretaria;
    }
    
    public int getNumeroQuincena(){
        return numeroQuincena;
    }
    
    public void setNumeroQuincena(int numeroQuincena){
        this.numeroQuincena = numeroQuincena;
    }
    
    public boolean getQuincenaPagada(){
        return quincenaPagada;
    }
       
    public int getContadorQuincenas(){
        return contadorQuincenas;
    }
}