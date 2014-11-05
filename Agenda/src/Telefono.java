
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

    


}