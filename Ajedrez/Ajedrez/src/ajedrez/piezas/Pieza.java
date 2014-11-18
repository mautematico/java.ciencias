/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.piezas;

import ajedrez.juego.Tablero;

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
   abstract boolean movimientoPosible( Posicion posicionNueva, Tablero tablero);
   
   public boolean [][] piezasDelMismoEquipo(Tablero tablero){
        boolean [][] piezasDelMismoEquipo = new boolean [8][8];
        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8; j++){
                if ((tablero.getCasillas()[i][j].getPieza().isEquipo() == this.isEquipo()) && (tablero.getCasillas()[i][j].getPieza() instanceof NoPieza == false))
                    piezasDelMismoEquipo[i][j] = true;
            }    
        }
        return piezasDelMismoEquipo;
    }
   
     public boolean [][] piezasDelEquipoContrario(Tablero tablero){
        boolean [][] piezasDelEquipoContrario = new boolean [8][8];
        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8; j++){
                if ((tablero.getCasillas()[i][j].getPieza().isEquipo() != this.isEquipo()) && (tablero.getCasillas()[i][j].getPieza() instanceof NoPieza == false))
                    piezasDelEquipoContrario[i][j] = true;
            }    
        }
        return piezasDelEquipoContrario;
    }
   
    
     public boolean[][] movimientosPosibles(Tablero tablero) {
        boolean [][] movimientosPosibles = new boolean [8][8];
       
        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8; j++){
                if (movimientoPosible(tablero.getCasillas()[i][j].getPieza().getPosicionActual(), tablero))
                    movimientosPosibles[i][j] = true;                
            }
        } 
        return movimientosPosibles;
    }
    
   
   public boolean mover(Posicion posicionNueva, Tablero tablero){
       if(movimientosPosibles(tablero)[posicionNueva.getX()][posicionNueva.getY()]){
           posicionActual.setX(posicionNueva.getX());
           posicionActual.setY(posicionNueva.getY());
           return true;
       }
       //Lanzar una excepcion de tipo "MovimientoInvalido"
       return false;
   }
}
