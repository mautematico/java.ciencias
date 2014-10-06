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
        
        System.out.println("Reloj con constructor sin parámetros:");
        Reloj reloj = new Reloj();
        System.out.println(reloj);
        
        System.out.println("Reloj con Reloj(23):");
        reloj = new Reloj(23);
        System.out.println(reloj);

        System.out.println("Reloj con Reloj(2,17):");
        reloj = new Reloj(2,17);
        System.out.println(reloj);

        System.out.println("Reloj con Reloj(2,17,13):");
        reloj = new Reloj(2,17,13);
        System.out.println(reloj);
        
        
        reloj.incrementarSegundo();
        System.out.println(reloj);

        reloj.incrementarSegundo(787219);
        System.out.println(reloj);

        reloj.incrementarMinuto();
        System.out.println(reloj);
        reloj.incrementarMinuto(5876);
        System.out.println(reloj);

        reloj.incrementarHora();
        System.out.println(reloj);
        reloj.incrementarHora(47857);
        System.out.println(reloj);

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