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
public class Caballo extends Pieza {

    @Override
    boolean[][] posicionesPosibles() {
        boolean [][] posicionesPosibles = new boolean [8][8];
        int x = this.getPosicionActual().getX();
        int y = this.getPosicionActual().getY();
        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8; j++){
                if (i == x+2){
                    if(j == y+1 || j == y-1)
                        posicionesPosibles[i][j] = true;
                }   
                if (i == x+1){
                    if(j == y+2 || j == y-2)
                        posicionesPosibles[i][j] = true;
                }
                if (i == x-1){
                    if(j == y+2 || j == y-2)
                        posicionesPosibles[i][j] = true;
                }
                if (i == x-2){
                    if(j == y+1 || j == y-1)
                        posicionesPosibles[i][j] = true;
                }
            }
        }
        posicionesPosibles[x][y] = false;
        return posicionesPosibles;
    }
    
    @Override
   boolean movimientoPosible(Posicion posicionNueva, Tablero tablero){
           int x1 = getPosicionActual().getX();
           int y1 = getPosicionActual().getY();
           int x2 = posicionNueva.getX();
           int y2 = posicionNueva.getY();
         
           
       if(posicionesPosibles()[x2][y2]== false)
           return false;
       
       else
           if (piezasDelMismoEquipo(tablero)[x2][y2])
                return false;
        return true;
    }
     
}
