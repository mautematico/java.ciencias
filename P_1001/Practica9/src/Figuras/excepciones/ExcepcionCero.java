/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras.excepciones;

/**
 * Clase que extiende a Exception
 * @author Armand
 */
public class ExcepcionCero extends Exception {

    public ExcepcionCero() {
        //Se construye la excepción llamando al constructor de la superclase
        //que recibe un String, dicho String es un mensaje que ayuda a entender 
        //mejor la causa del error
        super("El número es 0");
    }
    
}