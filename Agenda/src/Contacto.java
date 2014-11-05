
import java.util.*;

/**
 * 
 */
public class Contacto {
    
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


    /**
     * 
     */

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
     * @param email
     */
    public void agregarEmail(Email email) {
            this.emails.add(email);
    }

    /**
     * @param telefono
     */
    public void agregarTelefono(Telefono telefono) {
            this.telefonos.add(telefono);
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
