/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author
 * Arteaga Gaona, Guillermo <guillermo_ag@ciencias.unam.mx>
 * Navarro Miranda, Mauricio <mauricio@navarromiranda.mx>
 * 
 */
public class PruebaReloj {
    public static void main (String [] args) {
        
        Reloj reloj2 = new Reloj(11, 59, 56);
       
        for (int i=1; i>=1; i++) {
            try {        
                Thread.sleep(1000);
            }
            catch (InterruptedException ex){
                System.err.print(ex);
            }

            reloj2.incrementarSegundo(1);
            System.out.println("\r" + reloj2);
        }
    }
}