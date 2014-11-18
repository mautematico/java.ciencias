/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.excepciones;

/**
 *
 * @author actuaria
 */
public class ExcepcionMovimientoSuicida extends RuntimeException {
   public ExcepcionMovimientoSuicida(){
       super("Movimiento suicida");
   }
}
