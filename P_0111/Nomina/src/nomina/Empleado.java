/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina;

/**
 *
 * @author actuaria
 */
public class Empleado {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Fecha fechaNacimiento;
    private String rfc;
    private boolean esHombre;
    private Fecha fechaIngreso;
    private int antiguedad;
    private double salarioBase;
    private CuentaBancaria cuentaBancaria;
    
    public Empleado(){
        
    }
    
    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno,
            Fecha fechaNacimiento, boolean esHombre,Fecha fechaIngreso,
            double salarioBase, CuentaBancaria cuentaBancaria){
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.esHombre= esHombre;
        this.fechaIngreso = fechaIngreso;
        this.salarioBase = salarioBase;
        this.cuentaBancaria = cuentaBancaria;
        calcularRfc();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
        calcularRfc();
    }
    
    public String getApellidoPaterno(){
        return apellidoPaterno;
    }
    
    public void setApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno = apellidoPaterno;
        calcularRfc();
    }
    
    public String getApellidoMaterno(){
        return apellidoMaterno;
    }
    
    public void setApellidoMaterno(String apellidoMaterno){
        this.apellidoMaterno = apellidoMaterno;
        calcularRfc();
    }
    
    public boolean getEsHombre(){
        return esHombre;
    }
    
    public void setEsHombre(boolean esHombre){
        this.esHombre = esHombre;
        calcularRfc();
    }
    
    public String getFechaNacimiento(){
        return fechaNacimiento.toString();
    }
    
    public void setFechaNacimiento(Fecha fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
        calcularRfc();
    }
    
    public String getFechaIngreso(){
        return fechaIngreso.toString();
    }
    
    public void setFechaIngreso(Fecha fechaIngreso){
        this.fechaIngreso = fechaIngreso;
    }
    
    public double getSalarioBase(){
        return salarioBase;
    }
    
    public void setSalarioBase(double salarioBase){
        this.salarioBase = salarioBase;
    }
    
    public String getCuentaBancaria(){
        return cuentaBancaria.toString();
    }
    
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria){
        this.cuentaBancaria = cuentaBancaria;
    }
    
    public void cobrar(){
        cuentaBancaria.depositar(salarioBase);    
    }
    
    private void calcularRfc(){
        char inicialApellidoPaterno = (apellidoPaterno.charAt(0));
        char primeraVocal = 'X';
        char inicialApellidoMaterno = apellidoMaterno.charAt(0);
        char inicialNombre = nombre.charAt(0);
        for(int i = 1; i<apellidoPaterno.length();i++){
            switch(apellidoPaterno.charAt(i)){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    primeraVocal = apellidoPaterno.charAt(i);
            }
            if (primeraVocal != 'X') break;
        }
        String letras = ""+inicialApellidoPaterno + primeraVocal + inicialApellidoMaterno + inicialNombre;
        letras = letras.toUpperCase();
        
        this.rfc = letras + fechaNacimiento.fechaFormatoRfc();
    }
    
    @Override
    public String toString(){
        return "Nombre completo: " +nombre +" " +apellidoPaterno +" " +apellidoMaterno
                +"\nRFC: " +rfc
                +"\nDinero"
                +"\n"+this.cuentaBancaria;
    }
}