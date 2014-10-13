/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina;

/**
 *
 * @author actuaria
 */
public class Fecha {
    private byte dia;
    private byte mes;
    private short anio;
    
    public Fecha(byte dia , byte mes, short anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    public Fecha(byte dia, byte mes){
        this(dia,mes,(short)0);
    }
    
    public Fecha(){
        
    }
    
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
