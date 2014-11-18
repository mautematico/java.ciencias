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
public class NoPieza extends Pieza {

    @Override
    boolean[][] posicionesPosibles() {
        return new boolean[8][8]; 
    }
    @Override
    boolean movimientoPosible( Posicion posicionNueva, Tablero tablero){
        return false;
    }

    
}
