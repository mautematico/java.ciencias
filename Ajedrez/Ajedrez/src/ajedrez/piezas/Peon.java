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
public class Peon extends Pieza {

    @Override
    boolean[][] posicionesPosibles() {
        boolean[][] posicionesPosibles = new boolean[8][8];
        int x = this.getPosicion().getX();
        int y = this.getPosicion().getY();
        boolean equipo = this.isEquipo();
        if (equipo) {
            if (0 < y && y  <= 7) {
                posicionesPosibles[x][y - 1] = true;
            }
        } else {
            
            if (0 <= y  && y  < 7) {
                posicionesPosibles[x][y + 1] = true;
            }
        }

        posicionesPosibles[x][y] = false;
        return posicionesPosibles;
    }

    boolean[][] posicionesParaComer() {
        boolean[][] posicionesParaComer = new boolean[8][8];
        int x = this.getPosicion().getX();
        int y = this.getPosicion().getY();
        boolean equipo = this.isEquipo();
        if (equipo) {
            if (0 < y && y  <= 7) {
                if (0 <= x && x < 7) {
                    posicionesParaComer[x + 1][y - 1] = true;
                }
                if (0 < x && x  <= 7) {
                    posicionesParaComer[x - 1][y - 1] = true;
                }
            }
        } else {
           
             if (0 <= y  && y  < 7) {
                if (0 <= x && x < 7) {
                    posicionesParaComer[x + 1][y + 1] = true;
                }
                if (0 < x && x  <= 7) {
                    posicionesParaComer[x - 1][y + 1] = true;
                }
            }
        }

        return posicionesParaComer;
    }
    
     @Override
     boolean movimientoPosible(Posicion posicionNueva, Tablero tablero){
           int x1 = getPosicion().getX();
           int y1 = getPosicion().getY();
           int x2 = posicionNueva.getX();
           int y2 = posicionNueva.getY();
         
           
       if(posicionesPosibles()[y2][x2] && (tablero.getCasillas()[y2][x2].getPieza() instanceof NoPieza))
           return true;
       
      if (posicionesParaComer()[y2][x2] && piezasDelEquipoContrario(tablero)[y2][x2])
           return true;
      if(this.isEquipo()==false && y1==1 && y2 == 3 && x2 == x1 )
          return true;
      if(this.isEquipo() && y1==6 && y2 == 4 && x2 == x1 )
          return true;
      
        return false;
    }
}
