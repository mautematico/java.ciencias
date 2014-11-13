/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.juego;

import ajedrez.piezas.Pieza;

/**
 *
 * @author actuaria
 */
public class Escaque {
    private boolean color;
    private Pieza pieza;

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    
    
    
}
