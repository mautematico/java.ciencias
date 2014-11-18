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
public class Torre extends Pieza {

    @Override
     boolean[][] posicionesPosibles() {
        boolean [][] posicionesPosibles = new boolean [8][8];
        int x = this.getPosicionActual().getX();
        int y = this.getPosicionActual().getY();
        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8; j++){
                if (i == x || j == y )
                    posicionesPosibles[i][j] = true;
                                
            }
        }
        posicionesPosibles[x][y] = false;
        return posicionesPosibles;
    }
    
    
    private boolean casillasIntermediasVacias(Posicion posicionNueva, Tablero tablero) {
           int x1 = getPosicionActual().getX();
           int y1 = getPosicionActual().getY();
           int x2 = posicionNueva.getX();
           int y2 = posicionNueva.getY();
           int minX = Math.min(x1, x2);
           int maxX = Math.max(x1, x2);
           int minY = Math.min(y1,y2);
           int maxY = Math.max(y1,y2);
           
           if(x1 == x2)
               for(int i = minY + 1; i< maxY; i++)
                   if(tablero.getCasillas()[x1][i].getPieza() instanceof NoPieza == false)
                       return false;
                  
           if(y1 == y2)
               for(int i = minX + 1; i< maxX; i++)
                   if(tablero.getCasillas()[i][y1].getPieza() instanceof NoPieza == false)
                       return false;
                   
           return true;
                   
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
           else
              if (casillasIntermediasVacias(posicionNueva, tablero) == false)
                  return false;
        return true;
    }
    
}
