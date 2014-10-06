/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
/**
 * Prueba de la Clase Reloj.
 * Arteaga Gaona, Guillermo <guillermo_ag@ciencias.unam.mx>
 * Navarro Miranda, Mauricio <mauricio@navarromiranda.mx>
 * 
 */

public class PruebaReloj {
    
    public static void main (String [] args) {
        
        Reloj reloj1 = new Reloj();
        Reloj reloj2 = new Reloj(21);
        Reloj reloj3 = new Reloj(13,8);
        Reloj reloj4 = new Reloj (7,23);
        Reloj reloj5 = new Reloj(11, 59, 56);
        
        System.out.println("ESTE RELOJ PRUEBA EL CONSTRUCTOR POR DEFECTO: ");
        System.out.println("La hora es " + reloj1);
        System.out.println("PROBANDO LOS MÉTODOS DE INCREMENTAR MINUTOS, "
                + "SEGUNDOS Y HORAS.");
        reloj1.incrementarSegundo();
        System.out.println("Incrementando la hora en un segundo: ");
        System.out.println("La nueva hora es: " + reloj1);
        System.out.println("Incrementando la hora en 20 minutos: ");
        reloj1.incrementarMinuto(20);
        System.out.println("La nueva hora es: " + reloj1);
        System.out.println("Incrementando la hora en 10 horas: ");
        reloj1.incrementarHora(10);
        System.out.println("La nueva hora es: " + reloj1 + "\n");
        
        
        System.out.println("ESTE RELOJ PRUEBA EL CONSTRUCTOR QUE RECIBE LA HORA"
                + " COMO PARÁMETRO: ");
        System.out.println("La hora es " + reloj2);
        System.out.println("PROBANDO LOS MÉTODOS DE INCREMENTAR MINUTOS, "
                + "SEGUNDOS Y HORAS.");
        reloj2.incrementarSegundo(50);
        System.out.println("Incrementando la hora en 50 segundos: ");
        System.out.println("La nueva hora es: " + reloj2);
        System.out.println("Incrementando la hora en un minuto: ");
        reloj2.incrementarMinuto();
        System.out.println("La nueva hora es: " + reloj2);
        System.out.println("Incrementando la hora en una hora: ");
        reloj2.incrementarHora();
        System.out.println("La nueva hora es: " + reloj2 + "\n");
        
        System.out.println("ESTE RELOJ PRUEBA EL CONSTRUCTOR QUE RECIBE LA HORA"
                + " Y LOS MINUTOS COMO PARÁMETRO: ");
        System.out.println("La hora es " + reloj3 + "\n");
        
        
        System.out.println("ESTE RELOJ PRUEBA EL CONSTRUCTOR QUE RECIBE LA HORA"
                + ", LOS MINUTOS y LOS SEGUNDOS COMO PARÁMETRO: ");
        System.out.println("la hora es " + reloj4 + "\n");
       
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
                
        System.out.println("INCREMENTANDO LOS SEGUNDOS DE MANERA INDEFINIDA: ");
        System.out.println(reloj5);
        
        while(true) {            
            try {        
                Thread.sleep(1000);
                }
            catch (InterruptedException ex){
                System.err.print(ex);
            }
    
            reloj5.incrementarSegundo(1);
            char escCode = 0x1B;
            int row = 29; int column = 0;
            System.out.print(String.format("%c[%d;%df",escCode,row,column));  
            System.out.println(reloj5);
        }
    }
}