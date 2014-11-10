package Figuras;

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
public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado){
        setLado(lado);
        calcularPerimetro();
        calcularArea();
    }
    
    public final void setLado(double lado){
        if(lado < 0)
            throw new ExcepcionNumeroNegativo();
        if(lado == 0)
            throw new ExcepcionCero();
        this.lado = lado;
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
