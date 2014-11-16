/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.juego;
import ajedrez.piezas.*;

/**
 *
 * @author mautematico 
*/
public class Ajedrez {
    private Tablero tablero;
    public Ajedrez(){
        tablero = new Tablero();
        colocarPiezasDeAjedrez();
    }
    
    private final void colocarPiezasDeAjedrez(){
        tablero.getCasillas() [0][0].setPieza(new Torre());
        tablero.getCasillas() [0][7].setPieza(new Torre());
        tablero.getCasillas() [0][1].setPieza(new Caballo());
        tablero.getCasillas() [0][6].setPieza(new Caballo());
        tablero.getCasillas() [0][2].setPieza(new Alfil());
        tablero.getCasillas() [0][5].setPieza(new Alfil());
        tablero.getCasillas() [0][3].setPieza(new Reina());
        tablero.getCasillas() [0][4].setPieza(new Rey());
        for (int i = 0; i<8; i++)
             tablero.getCasillas() [1][i].setPieza(new Peon());
        
        tablero.getCasillas() [7][0].setPieza(new Torre());
        tablero.getCasillas() [7][7].setPieza(new Torre());
        tablero.getCasillas() [7][1].setPieza(new Caballo());
        tablero.getCasillas() [7][6].setPieza(new Caballo());
        tablero.getCasillas() [7][2].setPieza(new Alfil());
        tablero.getCasillas() [7][5].setPieza(new Alfil());
        tablero.getCasillas() [7][4].setPieza(new Reina());
        tablero.getCasillas() [7][3].setPieza(new Rey());
        for (int i = 0; i<8; i++)
             tablero.getCasillas() [6][i].setPieza(new Peon());
        
        for (int i = 6; i<8; i++){
            for (int j = 0; j<8; j++)
                tablero.getCasillas() [i][j].getPieza().setEquipo(true);
        
        for ( i = 0; i<8; i++){
            for (int j = 0; j<8; j++)
               tablero.getCasillas() [i][j].getPieza().getPosicionActual().setPosicion(i, j);
    }
    
        private void moverPieza(int x1, int y1, int x2, int x2){
            
        }
}
