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
public class Circulo extends Figura {
    //Creamos el atributo radio para nuestras figuras que seran circulos
    private double radio;

    //Creamos un constructor que recibe como parametro un numero que sera el radio
    public Circulo(double radio) throws ExcepcionCero{
        setRadio(radio);//Llamamos al metodo setRadio
    }

    //Creamos metodos accesores para esta clase
    public final void setRadio(double radio) throws ExcepcionCero{
        if(radio < 0)//Verificamos que el objeto quede en estado consistente y en caso contrario lanzamos una excepcion
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
     
    //Sobreescribimos el metodo calcularPerimetro calculando el perimetro para un circulo de forma usual
    @Override
    public void calcularPerimetro() {
        setPerimetro(Math.PI*radio*2);
    }

    //Sobreescribimos el metodo calcularArea calculando el area para un circulo de forma usual
    @Override
    public void calcularArea() {
        setArea(Math.PI*radio*radio);
    }
    
    //Por ultimo creamos el metodo toString
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
