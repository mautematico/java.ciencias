
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Email implements Serializable {
    /**
     * 
     */
    private String correo;
    private int tipo;

    /**
     * @param correo: correo
     */
    public Email(String correo, int tipo) {
        this.correo = correo;
        
        if(0 <= tipo && tipo < 3){
            this.tipo = tipo;
        }
        else{
            this.tipo = 0;
        }
    }
    
    public Email(String correo){
        this(correo,0);
    }
    
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        switch(tipo){
            case 1:
                return "Personal:" + correo + "\n";
            case 2:
                return "Trabajo:" + correo+ "\n";
            default:
                return "Otro correo:" + correo+ "\n";
        }
    }
    
}