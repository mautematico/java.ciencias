/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina;

/**
 * Clase que crea fechas,
 * permite acceder a sus campos
 * y las ofrece en formato AAMMDD
 * @author
 * Navarro Miranda, Mauricio <mauricio@navarromiranda.mx>
 * González Mora, Erick Alan <erick_lann@hotmail.com>
 * Romero Garcia, Enrique Javier <enriquefi@yahoo.com.mx>
 */
public class Fecha {
    /**
    Variables de instancia, todas privadas
    */
    private byte dia;
    private byte mes;
    private short anio;
    /*
    Constructor de una fecha "completa"
    */
    public Fecha(byte dia , byte mes, short anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    /*
    Constructor de una fecha "tipo cumpleaños"
    */
    public Fecha(byte dia, byte mes){
        this(dia,mes,(short)0);
    }
    /*
    Constructor de una fecha en blanco (00-00-00)
    */
    public Fecha(){
        
    }
    /*
    Métodos para acceder a los campos, y también para alterarlos
    */
    public byte getDia(){
        return dia;
    }
    
    public void setDia(byte dia){
        this.dia = dia;
    }
    
    public byte getMes(){
        return mes;
    }
    
    public void setMes(byte mes){
        this.mes = mes;
    }
    
    public short getAnio(){
        return anio;
    }
    
    public void setAnio(short anio){
        this.anio = anio;
    }
    
    public String anioToString(){
        return ""+anio;
    }
    /**
     * Método que construye un String en formato AAMMDD
     * @return 
     */
    public String fechaFormatoRfc(){
        String anioTerminacion = anioToString().substring(2,4);
        String mesFormato;
        String diaFormato;
        if(mes < 10){
            mesFormato = "0"+mes;
        }
        else{
            mesFormato = ""+mes;
        }
        if(dia < 10){
            diaFormato = "0"+dia;
        }
        else{
            diaFormato = ""+dia;
        }
        
        return anioTerminacion + mesFormato + diaFormato;
    }
    
    @Override
    public String toString(){
        return "Dia: "+dia+"\n"+"Mes: "+mes+"\n"+"Año: "+anio;
    }
}
