/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina;

/**
 * Clase que crea Empleados, los cuales tienen nombre, sexo, RFC, antiguedad
 * y una CuentaBancaria en la cual se le paga la nómina
 * @author
 * Navarro Miranda, Mauricio <mauricio@navarromiranda.mx>
 * González Mora, Erick Alan <erick_lann@hotmail.com>
 * Romero Garcia, Enrique Javier <enriquefi@yahoo.com.mx>
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
    /**
     * Construimos un empleado con todos los parámetros no-calculables.
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param fechaNacimiento
     * @param esHombre
     * @param fechaIngreso
     * @param salarioBase
     * @param cuentaBancaria 
     */
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
        calcularAntiguedad();
    }
    /*
    Métodos de acceso y modificación de los campos
    */
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
        calcularAntiguedad();
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
    /**
     * El empleado cobra directamente en su cuentaBancaria asociada
     */
    public void cobrar(){
        cuentaBancaria.depositar(salarioBase);    
    }
    
    /**
     * Método para calcular el RFC (sin homoclave) del empleado
     */
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
    /**
     * a) no planteamos el escenario donde obtenemos la fecha actual, para calcular la antiguedad
     * b) somos gandallas y no reconocemos la angtiguedad de nuestros empleados
     */
    private void calcularAntiguedad(){
        this.antiguedad = 0;
    }
    @Override
    public String toString(){
        return "Nombre completo: " +nombre +" " +apellidoPaterno +" " +apellidoMaterno
                +"\nRFC: " +rfc
                +"\nDinero"
                +"\n"+this.cuentaBancaria;
    }
}