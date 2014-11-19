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
    private boolean equipoEnTurno;
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
        }
        for ( int i = 0; i<8; i++){
            for (int j = 0; j<8; j++)
               tablero.getCasillas() [i][j].getPieza().getPosicion().setPosicion(i, j);
        }
       
    }
    
        private void cambiarTurno() {
            equipoEnTurno = !equipoEnTurno;
        }
        
        private void moverPieza(Escaque escaqueActual, Escaque escaqueDestino){
         
            Pieza piezaAMover = escaqueActual.getPieza();
            Pieza piezaAReemplazar = escaqueDestino.getPieza();
            Posicion posicionActual = piezaAMover.getPosicion();
            Posicion posicionDestino = piezaAReemplazar.getPosicion();
            boolean seMovio;
            
            if (piezaAMover.isEquipo() != equipoEnTurno ) {
                //lanzar excepcion "EsTurno de equipoEnTurno"
            }
            
            if(!piezaAMover.mover(piezaAReemplazar.getPosicion(), tablero)){
                //lanzar excepcion "Movimiento invalido"
            }
                   
            if (juegoEnJaque(equipoEnTurno)){
                piezaAMover.setPosicion(posicionActual);
                piezaAReemplazar.setPosicion(posicionDestino);
                escaqueActual.setPieza(piezaAMover);
                escaqueDestino.setPieza(piezaAReemplazar);
                //lanzar excepcion "Movimiento suicida"
            }
                
               
            
            
            if(piezaAMover instanceof Peon){
                coronacion((Peon) piezaAMover);
            }
        }
        
        private void coronacion(Peon peon){
            boolean equipo = peon.isEquipo();
            int x = peon.getPosicion().getX();
            int y = peon.getPosicion().getY();
            if(equipo==false && y==7){
                tablero.getCasillas()[x][y].setPieza(new Reina());
            }
            if(equipo==true && y==0){
                tablero.getCasillas()[x][y].setPieza(new Reina());
                tablero.getCasillas() [x][y].getPieza().setEquipo(true);
            }
            tablero.getCasillas()[x][y].getPieza().getPosicion().setPosicion(x, y);
        }
        
        private boolean juegoEnJaque(){
            Pieza[] reyes = new Pieza[2];
            
            for (int i=0; i<8; i++) {
                for(int j = 0; j<8; j++){
                    Pieza rey = tablero.getCasillas()[i][j].getPieza();
                    if( rey instanceof Rey){
                        if (rey.isEquipo() )
                            int equipo = 0;
                        
                    }
                }
                
            }
            return false;
        }
}
