/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.juego;
import ajedrez.excepciones.ExcepcionMovimientoInvalido;
import ajedrez.excepciones.ExcepcionMovimientoSuicida;
import ajedrez.excepciones.ExcepcionTurnoEquivocado;
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
    
    public Tablero getTalero(){
        return tablero;
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
        
        public void moverPieza(Escaque escaqueActual, Escaque escaqueDestino){
         
            Pieza piezaAMover = escaqueActual.getPieza();
            Pieza piezaAReemplazar = escaqueDestino.getPieza();
            Posicion posicionActual = piezaAMover.getPosicion();
            Posicion posicionDestino = piezaAReemplazar.getPosicion();
           
       
            
            if (piezaAMover.isEquipo() != equipoEnTurno ) {
                throw new ExcepcionTurnoEquivocado();
            }
            
            if(!piezaAMover.mover(piezaAReemplazar.getPosicion(), tablero)){
                throw new ExcepcionMovimientoInvalido();
            }
                   
            if (movimientoAJaque(escaqueActual, escaqueDestino)){
                throw new ExcepcionMovimientoSuicida();
            }
            if(jaqueMate(!equipoEnTurno)){
                //GANA EQUIPOENTURNO
            }
            else {
                cambiarTurno();
            }
            if(juegoEnJaque(!equipoEnTurno)){
                //avisar Jaque
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
        public boolean juegoEnJaque(boolean equipo){
            Rey rey = new Rey();
            
            for (int i=0; i<8; i++) {
                for(int j = 0; j<8; j++){
                    Pieza pieza = tablero.getCasillas()[i][j].getPieza();
                    if( pieza instanceof Rey){
                        if (pieza.isEquipo() == equipo )
                            rey = (Rey) pieza;
                    }
                }
                
            }
            if (rey != null){
              Posicion posicion = rey.getPosicion();
              boolean[][] piezasContrarias = rey.piezasDelEquipoContrario(tablero);  
              for(int i=0; i<8; i++){
                  for(int j=0; j<8; j++){
                      if(piezasContrarias[i][j]== true){
                         boolean[][] movimientosPosibles = tablero.getCasillas()[i][j].getPieza().movimientosPosibles(tablero);
                         if(movimientosPosibles[posicion.getX()][posicion.getY()])
                             return true;
                      }
                  }
              }
              
            }
            
            return false;
        }
        
        public boolean movimientoAJaque (Escaque escaqueActual, Escaque escaqueDestino){
            Pieza piezaAMover = escaqueActual.getPieza();
            Pieza piezaAReemplazar = escaqueDestino.getPieza();
            Posicion posicionActual = piezaAMover.getPosicion();
            Posicion posicionDestino = piezaAReemplazar.getPosicion();
            boolean movimientoAJaque = false;
           
       
            if(piezaAMover.mover(piezaAReemplazar.getPosicion(), tablero)){
              
                   
                if (juegoEnJaque(piezaAMover.isEquipo()))
                     movimientoAJaque = true;
                
                piezaAMover.setPosicion(posicionActual);
                piezaAReemplazar.setPosicion(posicionDestino);
                escaqueActual.setPieza(piezaAMover);
                escaqueDestino.setPieza(piezaAReemplazar);
                 
            }
        return movimientoAJaque;
        }
        
        public boolean jaqueMate (boolean equipo){
            Pieza piezaEquipo = new Peon();
            piezaEquipo.setEquipo(equipo);
            boolean jaqueMate = true;
            
            for (int i=0; i<8; i++) {
                for(int j = 0; j<8; j++){
                    Pieza pieza = tablero.getCasillas()[i][j].getPieza();
                        if (pieza.isEquipo() == equipo )
                             piezaEquipo = pieza;
                }
                
            }
            boolean[][] piezasDelEquipo = piezaEquipo.piezasDelMismoEquipo(tablero);
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(piezasDelEquipo[i][j]){
                        Escaque escaqueInicial = tablero.getCasillas()[i][j];
                        boolean[][] movimientosPosibles = escaqueInicial.getPieza().movimientosPosibles(tablero);
                        for(int n=0; n<8; n++){
                            for(int m=0; m<8; m++){
                                if(movimientosPosibles[n][m]){
                                    Escaque escaqueFinal = tablero.getCasillas()[n][m];
                                    if(!(movimientoAJaque(escaqueInicial,escaqueFinal))){
                                        jaqueMate = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return jaqueMate;
        }
}
