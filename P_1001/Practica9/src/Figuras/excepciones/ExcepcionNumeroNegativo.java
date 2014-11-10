/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figuras.excepciones;

/**
 *
 * @author GABI
 */
public class ExcepcionNumeroNegativo extends RuntimeException {
    
   public ExcepcionNumeroNegativo(){
        super("El valor ingresado es negativo");
   }
   
}
