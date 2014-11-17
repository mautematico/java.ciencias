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
public class Peon extends Pieza {

    @Override
    boolean[][] posicionesPosibles() {
        boolean [][] posicionesPosibles = new boolean [8][8];
        int x = this.getPosicionActual().getX();
        int y = this.getPosicionActual().getY();
        if(0<=y+1 && y+1<=7)
            posicionesPosibles[x][y+1]= true;
        
        posicionesPosibles[x][y] = false;
        return posicionesPosibles;
    }
    
    boolean [][] posicionesParaComer(){
        boolean [][] posicionesParaComer = new boolean [8][8];
        int x = this.getPosicionActual().getX();
        int y = this.getPosicionActual().getY();
        if(0<=y+1 && y+1<=7){
            if(0<=x+1 && x+1<=7)
                posicionesParaComer[x+1][y+1] = true;
            if(0<=x-1 && x-1<=7)
                posicionesParaComer[x-1][y+1] = true;
        }
        return posicionesParaComer;
    }

    
}
