package Figuras;

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
