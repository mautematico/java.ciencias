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
    private boolean equipo;

    public Pieza(boolean equipo) {
        this.equipo = equipo;
    }
    public Pieza(){
        
    }
            

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }

    public boolean isEquipo() {
        return equipo;
    }

    public void setEquipo(boolean equipo) {
        this.equipo = equipo;
    }
    
    
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
