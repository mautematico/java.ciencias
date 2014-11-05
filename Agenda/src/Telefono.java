
import java.util.*;

/**
 * 
 */
public class Telefono {
    
    private String numero;
    private int tipo;

    public Telefono(String numero, int tipo) {
        if(0<=tipo && tipo<=3){
            this.tipo = tipo;
        }
        else{
            this.tipo = 0;
        }
        this.numero = numero;
    }
    
    public Telefono(String numero){
        this(numero,0);
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String toSring(){
        switch(tipo){
            case 1:
                return "Telefono movil:" + numero;
            case 2:
                return "Telefono de casa:" + numero;
            case 3:
                return "Telefono de oficina:" + numero;
            default:
                return "Otro telefono:" + numero;
        }
        
    }
    
}