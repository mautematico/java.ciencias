//Hecho por: Arévalo Loyola Alma Rosario, Gutiérrez Guillén Gabriela Jocelyn, Navarro Miranda Mauricio
import java.io.Serializable;
import java.util.*;


public class Email implements Serializable {
    
//creamos variables de instacia para la clase email
    private String correo;
    private int tipo;

//creamos constructores verificando que el tipo este en los rangos 
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
    
//creamos metodos accesores para esta clase     
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
//sobreescribimos el metodo toString
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