package figuras;

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
    //Creamos el atributo lado para nuestras figuras que seran cuadrados
    private double lado;

    //Creamos un constructor que recibe como parametro un numero que sera el lado
    public Cuadrado(double lado) throws ExcepcionCero{
        setLado(lado);//Llamamos al metodo setLado
    }
    
    //Creamos metodos accesores para esta clase
    public final void setLado(double lado) throws ExcepcionCero{
        if(lado < 0)//Verificamos que el objeto quede en estado consistente y en caso contrario lanzamos una excepcion
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
    
    //Sobreescribimos el metodo calcularPerimetro calculando el perimetro para un cuadrado de forma usual
    @Override
    public void calcularPerimetro() {
       setPerimetro(4*lado);
    }

    //Sobreescribimos el metodo calcularArea calculando el area para un cuadrado de forma usual
    @Override
    public void calcularArea() {
        setArea(lado*lado);
    }
    
    //Por ultimo creamos el metodo toString
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
