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
        this("rey");
    }

    public Ajedrez(String escenario){
        tablero = new Tablero();

        switch(escenario){
            case "coronar":
                 tablero.getCasillas() [6][6].setPieza(new Peon());            
                break;
                
            case "torre":
                 tablero.getCasillas() [0][0].setPieza(new Torre());            
                break;
            case "rey":
                tablero.getCasillas() [4][5].setPieza(new Rey());
                break;  

            default:
                colocarPiezasDeAjedrez();    
        }
        setPosicionesAPiezas();
        equipoEnTurno = false;
    }

    public Tablero getTablero(){
        return tablero;
    }
    
    private final void colocarPiezasDeAjedrez(){
        tablero.getCasillas() [0][0].setPieza(new Torre());
        tablero.getCasillas() [7][0].setPieza(new Torre());
        tablero.getCasillas() [1][0].setPieza(new Caballo());
        tablero.getCasillas() [6][0].setPieza(new Caballo());
        tablero.getCasillas() [2][0].setPieza(new Alfil());
        tablero.getCasillas() [5][0].setPieza(new Alfil());
        tablero.getCasillas() [3][0].setPieza(new Reina());
        tablero.getCasillas() [4][0].setPieza(new Rey());
        for (int i = 0; i<8; i++)
             tablero.getCasillas() [i][1].setPieza(new Peon());
        
        tablero.getCasillas() [0][7].setPieza(new Torre());
        tablero.getCasillas() [7][7].setPieza(new Torre());
        tablero.getCasillas() [1][7].setPieza(new Caballo());
        tablero.getCasillas() [6][7].setPieza(new Caballo());
        tablero.getCasillas() [2][7].setPieza(new Alfil());
        tablero.getCasillas() [5][7].setPieza(new Alfil());
        tablero.getCasillas() [3][7].setPieza(new Reina());
        tablero.getCasillas() [4][7].setPieza(new Rey());
        for (int i = 0; i<8; i++)
             tablero.getCasillas() [i][6].setPieza(new Peon());
        
        for (int i = 0; i<8; i++){
            for (int j = 6; j<8; j++)
                tablero.getCasillas() [i][j].getPieza().setEquipo(true);
        }
        
        setPosicionesAPiezas();
       
    }
    
    public void setPosicionesAPiezas(){
        for ( int i = 0; i<8; i++){
            for (int j = 0; j<8; j++){
                System.out.println(tablero.getCasillas()[i][j].getPieza());
               tablero.getCasillas() [i][j]
                       .getPieza()
                       .getPosicion()
                       .setPosicion(i, j);
               
            }
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
            if (movimientoAJaque(escaqueActual, escaqueDestino)){
                throw new ExcepcionMovimientoSuicida();
            }
            if(!piezaAMover.mover(posicionDestino, tablero)){
                throw new ExcepcionMovimientoInvalido();
            } else {
                tablero.getCasillas()[posicionActual.getX()][posicionActual.getY()].setPieza(new NoPieza());
             
                tablero.getCasillas()[posicionDestino.getX()][posicionDestino.getY()].setPieza(piezaAMover);
                setPosicionesAPiezas();
            }
                  
           
            if(juegoEnJaque(!equipoEnTurno)){
                if(jaqueMate(!equipoEnTurno)){
                //GANA EQUIPOENTURNO
                }
                else {

                    //avisar Jaque (NuevoEquipo EN Turno)
                }
                
            }
                
            if(piezaAMover instanceof Peon){
                coronacion((Peon) piezaAMover);
            }
            cambiarTurno();
            System.out.println("Pieza movida");//que pedo?
        
        }
        
        
        private void coronacion(Peon peon){
            boolean equipo = peon.isEquipo();
            int x = peon.getPosicion().getX();
            int y = peon.getPosicion().getY();
            if(equipo==false && y==7){
                tablero.getCasillas()[x][y].setPieza(new Reina());
                tablero.getCasillas() [x][y].getPieza().setEquipo(equipo);
            }
            if(equipo==true && y==0){
                tablero.getCasillas()[x][y].setPieza(new Reina());
                tablero.getCasillas() [x][y].getPieza().setEquipo(equipo);
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
              
            
            
            return false;
        }
        
        public boolean movimientoAJaque (Escaque escaqueActual, Escaque escaqueDestino){
            Pieza piezaAMover = escaqueActual.getPieza();
            Pieza piezaAReemplazar = escaqueDestino.getPieza();
            Posicion posicionActual = piezaAMover.getPosicion();
            Posicion posicionDestino = piezaAReemplazar.getPosicion();
            boolean movimientoAJaque = false;
           
       
            if(piezaAMover.mover(posicionDestino, tablero)){
              
                   
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
