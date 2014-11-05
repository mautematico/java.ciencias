
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

  
   /**
     * @param telefono
     */
    public void agregarTelefono(Telefono telefono) {
            telefonos.add(telefono);
    }
    
    public void eliminarTelefono(Telefono telefono) {
               telefonos.remove(telefono);
    }

    /**
     * 
     * @param email
     */
    public void agregarEmail(Email email) {
            emails.add(email);
    }

   
    public void eliminarEmail(Email email) {
            emails.remove(email);
    }
    
    
    public void asignarContactoAGrupo(Grupo grupo) {
        grupo.getContactos().add(this);
    }

    /**
     * 
     */
    public void excluirContactoDeGrupo(Grupo grupo) {
        grupo.getContactos().add(this);
        
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
    


}
