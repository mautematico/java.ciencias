
import java.util.*;

/**
 * 
 */
public class Email {

    /**
     * @param correo: correo
     */
    public Email(String correo) {
        this.correo = correo;
    }
    public Email(){

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * 
     */
    private String correo;


}