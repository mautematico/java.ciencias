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
public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado) throws ExcepcionCero{
        setLado(lado);
    }
    
    public final void setLado(double lado) throws ExcepcionCero{
        if(lado < 0)
            throw new ExcepcionNumeroNegativo();
        if(lado == 0)
            throw new ExcepcionCero();
        this.lado = lado;
        calcularPerimetro();
        calcularArea();
    }
    
    public double getLado (){
        return lado;
    }
    
    @Override
    public void calcularPerimetro() {
       setPerimetro(4*lado);
    }

    @Override
    public void calcularArea() {
        setArea(lado*lado);
    }
    
    @Override
    public String toString(){
        double perimetro = this.getPerimetro();
        double area = this.getArea();
       return "Tipo de figura: Cuadrado\n"
               + "Lado = "+ lado
               +"\nPerimetro = " + perimetro
               +"\nArea = " + area;
    }
}
