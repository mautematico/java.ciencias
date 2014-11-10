package Figuras;

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
public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) throws ExcepcionCero{
        setRadio(radio);
    }

    
    public final void setRadio(double radio) throws ExcepcionCero{
        if(radio < 0)
            throw new ExcepcionNumeroNegativo();
        if(radio == 0)
            throw new ExcepcionCero();
        this.radio = radio;
        calcularPerimetro();
        calcularArea();
    }
    
    public double getRadio(){
        return radio;
    }
            
    @Override
    public void calcularPerimetro() {
        setPerimetro(Math.PI*radio*2);
    }

    @Override
    public void calcularArea() {
        setArea(Math.PI*radio*radio);
    }
    @Override
    public String toString(){
        double perimetro = this.getPerimetro();
        double area = this.getArea();
       return "Tipo de figura: Circulo"
               + "\nRadio = " + radio
               +"\nPerimetro = " + perimetro
               +"\nArea = " + area;
    }
}
