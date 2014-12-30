/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conjugador;

/**
 *
 * @author 
 * Mauricio Navarro Miranda
 * Gabriela Jocelyn Gutierrez Guillen
 * Facultad de Ciencias
 * 
 * Clase principal, para probar la clase Conjugador
 * 
 */
public class Prueba {
    public static void main (String [] args){
        
            //creamos un nuevo objeto de la clase conjugador
        Conjugador conjugador1 = new Conjugador();
        
        
        /*
            Probamos el conjugador con tres verbos "er" en español,
            los imprimimos para visualizar el resultado.
        */
        System.out.println("correr");
        System.out.println(conjugador1.conjugarEnEspaniol("correr"));
        System.out.println("prometer");
        System.out.println(conjugador1.conjugarEnEspaniol("prometer"));
        System.out.println("barrer");
        System.out.println(conjugador1.conjugarEnEspaniol("vivir"));
        
        /*
            Probamos el conjugador con tres verbos en alemán,
            los imprimimos para visualizar el resultado.
        */
        System.out.println("bergen");
        System.out.println(conjugador1.conjugarEnAleman("bergen"));
        System.out.println("betonen");
        System.out.println(conjugador1.conjugarEnAleman("betonen"));
        System.out.println("planen");
        System.out.println(conjugador1.conjugarEnAleman("planen"));
        /*
            Probamos el conjugador con tres verbos en francés,
            los imprimimos para visualizar el resultado.
        */
        System.out.println("habiter:");
        System.out.println(conjugador1.conjugarEnFrances("habiter"));
        System.out.println("abriter:");
        System.out.println(conjugador1.conjugarEnFrances("abriter"));
        System.out.println("chanter:");
        System.out.println(conjugador1.conjugarEnFrances("chanter"));
        
    }
    
}