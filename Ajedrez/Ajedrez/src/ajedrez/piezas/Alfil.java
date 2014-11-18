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
public class Alfil extends Pieza {

    @Override
    boolean[][] posicionesPosibles() {
        boolean [][] posicionesPosibles = new boolean [8][8];
        int x = this.getPosicionActual().getX();
        int y = this.getPosicionActual().getY();
        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8; j++){
                if (i-x == j-y|| i-x == y-j )
                    posicionesPosibles[i][j] = true;
                                
            }
        }
        posicionesPosibles[x][y] = false;
        return posicionesPosibles;
    }
    
       private boolean mover(Posicion posicionNueva, Tablero tableroActual){
           int x1 = getPosicionActual().getX();
           int y1 = getPosicionActual().getY();
           int x2 = posicionNueva.getX();
           int y2 = posicionNueva.getY();
       if(posicionesPosibles()[x2][y2]== false){
           return false;
       }
       else
           if ((tableroActual.getCasillas()[x2][y2].getPieza().isEquipo() == this.isEquipo()) && (tableroActual.getCasillas()[x2][y2].getPieza() intanceof NoPieza == false) )
                return false;
                
       
          
           
           
           
           
           
           
           
           
           
           
           posicionActual.setX(posicionNueva.getX());
           posicionActual.setY(posicionNueva.getY());
           return true;
       }
       
   }

   
    
}
