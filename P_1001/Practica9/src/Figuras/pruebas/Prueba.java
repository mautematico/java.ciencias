package Figuras.pruebas;

import Figuras.Circulo;
import Figuras.Cuadrado;
import Figuras.Figura;
import figuras.excepciones.ExcepcionCero;
import figuras.excepciones.ExcepcionNumeroNegativo;

/**
 *
 * @author 
 * Arévalo Loyola,  Alma Rosario    <alma.arevalo@ciencias.unam.mx>
 * Gutiérrez Guillén,   Gabriela Jocelyn    <gabriiela_guthiierrez@hotmail.com>
 * Navarro Miranda, Mauricio    <mauricio@navarromiranda.mx>
 * 
 * Licenciatura en Matemáticas,
 * Facultad de Ciencias
 * 
 */
public class Prueba {

    public static void main(String[] args) {
   
        Figura[] figuras = new Figura[5];//Declaramos un arreglo de figuras
        
        //Declaramos bloques try catch para tratar las excepciones y que nuestro programa no termine antes de tiempo
        try {
                figuras[0] = new Circulo(4);
            } catch (ExcepcionNumeroNegativo ex) {
                System.err.println("Valor ingresado no válido\n" + ex);
            } catch (ExcepcionCero ex) {
                System.err.println("Valor ingresado no válido\n" + ex);
            } catch (Exception ex) {
                System.err.println("Ocurrió otro tipo de excepción\n" + ex);
            }

        try {
                figuras[1] = new Circulo(0);
            } catch (ExcepcionNumeroNegativo ex) {
                System.err.println("Valor ingresado no válido\n" + ex);
            } catch (ExcepcionCero ex) {
                System.err.println("Valor ingresado no válido\n" + ex);
            } catch (Exception ex) {
                System.err.println("Ocurrió otro tipo de excepción\n" + ex);
            }
        
        try {
                figuras[2] = new Cuadrado(4);
            } catch (ExcepcionNumeroNegativo ex) {
                System.err.println("Valor ingresado no válido\n" + ex);
            } catch (ExcepcionCero ex) {
                System.err.println("Bloque número no válido\n" + ex);
            } catch (Exception ex) {
                System.err.println("Ocurrió otro tipo de excepción\n" + ex);
            }
        
        try {
                figuras[3] = new Cuadrado(-4);
            } catch (ExcepcionNumeroNegativo ex) {
                System.err.println("Valor ingresado no válido\n" + ex);
            } catch (ExcepcionCero ex) {
                System.err.println("Valor ingresado no válido\n" + ex);
            } catch (Exception ex) {
                System.err.println("Ocurrió otro tipo de excepción\n" + ex);
            }
        
        try {
                figuras[4] = new Cuadrado(4);
            } catch (ExcepcionNumeroNegativo ex) {
                System.err.println("Valor ingresado no válido\n" + ex);
            } catch (ExcepcionCero ex) {
                System.err.println("Valor ingresado no válido\n" + ex);
            } catch (Exception ex) {
                System.err.println("Ocurrió otro tipo de excepción\n" + ex);
            }
        

        for (Figura figura : figuras) {
            try {
                System.out.println(figura);                                
            } catch (ExcepcionNumeroNegativo ex) {
                System.err.println("Valor ingresado no válido\n" + ex);
            }catch (Exception ex) {
                System.err.println("Ocurrió otro tipo de excepción\n" + ex);
            }
        }
    }
}
