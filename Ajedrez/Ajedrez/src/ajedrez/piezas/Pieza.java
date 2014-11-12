/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.piezas;

/**
 *
 * @author mautematico
 */
public abstract class Pieza {
    private Posicion posicionActual;
    
   abstract boolean[][] posicionesPosibles();
   
   private boolean mover(Posicion posicionNueva){
       if(posicionesPosibles()[posicionActual.getX()][posicionActual.getY()]){
           posicionActual.setX(posicionNueva.getX());
           posicionActual.setY(posicionNueva.getY());
           return true;
       }
       //Lanzar una excepcion de tipo "MovimientoInvalido"
       return false;
   }
}
