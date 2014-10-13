/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina;

/**
 *
 * @author actuaria
 */
public class Practica7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado juan = new Empleado("Juan","Perez", "Martinez",
                new Fecha((byte)11,(byte)1,(short)1985),
                true, null, 7000, new CuentaBancaria("JUA001"));
        
        Empleado andrea = new Empleado("Andrea", "Monjaraz", "Vazquez", 
                new Fecha((byte)1,(byte)2,(short)1987), false,
                new Fecha((byte)1,(byte)1,(short)2011),
                8123, new CuentaBancaria("AND002",0.0));
        
        Empleado jessica = new Empleado("Jessica", "San Juan", "de la O",
                new Fecha((byte)15,(byte)9,(short)1991),
                false, new Fecha((byte)1,(byte)2,(short)2014),
                6800, new CuentaBancaria("JES003"));
                
       
    }
}
