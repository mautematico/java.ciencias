//Hecho por: Arévalo Loyola Alma Rosario, Gutiérrez Guillén Gabriela Jocelyn, Navarro Miranda Mauricio
import java.io.Serializable;
import java.util.*;

/**
 *
 */
public class Telefono implements Serializable {

//Creamos variables de instancia para la clase telefono
    private String numero;
    private int tipo;

//creamos un constructor que recibe un numero y un tipo y verificamos el tipo
    public Telefono(String numero, int tipo) {
        if (0 <= tipo && tipo <= 3) {
            this.tipo = tipo;
        } else {
            this.tipo = 0;
        }
        this.numero = numero;
    }
    
//Creamos un constructor que asigna un tipo determinado
    public Telefono(String numero) {
        this(numero, 0);
    }

//creamos metodos accesores para esta clase
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

//Sobreescribimos el metodo toString
    @Override
    public String toString() {
        switch (tipo) {
            case 1:
                return "Celular: " + numero + "\n";
            case 2:
                return "Casa: " + numero+ "\n";
            case 3:
                return "Oficina: " + numero+ "\n";
            default:
                return "Otro: " + numero+ "\n";
        }

    }

}
