/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.excepciones;

/**
 *
 * @author GABI
 */
public class ExcepcionTurnoEquivocado extends RuntimeException {
    public ExcepcionTurnoEquivocado(){
        super("Es turno del equipo contrario");
    }
}
