
import java.util.*;

/**
 * 
 */
public class Contacto {

    /**
     * 
     */
    public Contacto(String nombre, String apellido, Telefono telefono, Email email) {
        this.nombre = nombre;
        this.apellido = apellido;
        
        if( telefono != null ){
            this.telefonos.add(telefono);
        }
        if( email != null ){
            this.emails.add(email);
        }
    }
    public Contacto(String nombre, String apellido, Telefono telefono){
        this(nombre, apellido, telefono, null);
    }
    
    public Contacto(String nombre, String apellido, Email email){
        this(nombre, apellido, null, email);
    }


    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String apellido;

    /**
     * 
     */
    private ArrayList<Telefono> telefonos;

    /**
     * 
     */
    private ArrayList<Email> emails;

    /**
     * 
     */
    public String grupos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    public String getGrupos() {
        return grupos;
    }

    /**
     * 
     */
    public void eliminarTelefono() {
        // TODO implement here
    }

    /**
     * 
     */
    public void agregarEmail() {
        // TODO implement here
    }

    /**
     * @param telefono
     */
    public void agregarTelefono(Telefono telefono) {
        // TODO implement here
    }

    /**
     * 
     */
    public void modificarContacto() {
        // TODO implement here
    }

    /**
     * 
     */
    public void agregarGrupo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Operation1() {
        // TODO implement here
    }

}