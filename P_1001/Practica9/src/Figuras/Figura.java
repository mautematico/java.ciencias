package Figuras;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GABI
 */
public abstract class Figura {
    private double perimetro;
    private double area;
    
    public abstract void calcularPerimetro();
    public abstract void calcularArea();
    
    public void setPerimetro (double perimetro){
        this.perimetro = perimetro;
    }
    public void setArea (double area){
        this.area = area;
    }
    public double getPerimetro(){
        return perimetro;
    }
    public double getArea(){
        return area;
    }
}
