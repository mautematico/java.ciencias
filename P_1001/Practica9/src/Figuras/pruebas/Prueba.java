package Figuras.pruebas;

import Figuras.Circulo;
import Figuras.Cuadrado;
import Figuras.Figura;
import Figuras.excepciones.ExcepcionCero;
import Figuras.excepciones.ExcepcionNumeroNegativo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GABI
 */
public class Prueba {

    public static void main(String[] args) {
   
        Figura[] figuras = new Figura[5];
        try {
                figuras[0] = new Circulo(4);
            } catch (ExcepcionNumeroNegativo ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (ExcepcionCero ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (Exception ex) {
                System.err.println("Ocurrió otro tipo de excepción\n" + ex);
            }

        try {
                figuras[2] = new Circulo(0);
            } catch (ExcepcionNumeroNegativo ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (ExcepcionCero ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (Exception ex) {
                System.err.println("Ocurrió otro tipo de excepción\n" + ex);
            }
        
        try {
                figuras[2] = new Cuadrado(4);
            } catch (ExcepcionNumeroNegativo ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (ExcepcionCero ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (Exception ex) {
                System.err.println("Ocurrió otro tipo de excepción\n" + ex);
            }
        
        try {
                figuras[3] = new Cuadrado(-4);
            } catch (ExcepcionNumeroNegativo ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (ExcepcionCero ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (Exception ex) {
                System.err.println("Ocurrió otro tipo de excepción\n" + ex);
            }
        
        try {
                figuras[4] = new Cuadrado(4);
            } catch (ExcepcionNumeroNegativo ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (ExcepcionCero ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (Exception ex) {
                System.err.println("Ocurrió otro tipo de excepción\n" + ex);
            }
        

        for (int i = 0; i < figuras.length; i++) {
            try {
                System.out.println(figuras[i]);
            } catch (ExcepcionNumeroNegativo ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (ExcepcionCero ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (Exception ex) {
                System.err.println("Ocurrió otro tipo de excepción\n" + ex);
            }

        }
    }
}
