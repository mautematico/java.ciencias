/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.juego;
import  ajedrez.piezas.*;
/**
 *
 * @author actuaria
 */
public class Tablero {
    private Escaque [][] casillas;
    
    public Tablero(){
        casillas = new Escaque[8][8];
        for (int i=0; i<8; i++){
            for(int j=0;j<8;j++){
                casillas[i][j] = new Escaque();
            }
        }
        for (Escaque[] escaques : casillas) {
            for (Escaque escaque : escaques) {
                escaque.setPieza( new NoPieza());
            }
        }
    }

    public Escaque[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Escaque[][] casillas) {
        this.casillas = casillas;
    }
    
    
}
