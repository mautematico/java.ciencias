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
    //Creamos variables de instancia para esta clase que las tendran en comun todas las figuras
    private double perimetro;
    private double area;
    
    //Declaramos los metodos abstractos calcular area y perimetro, y son abstractoas ya que la forma de calcularlos dependen del tipo de figura
    public abstract void calcularPerimetro();
    public abstract void calcularArea();
    
    //Por ultimo creamos metodos accesores para nuestra clase 
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
