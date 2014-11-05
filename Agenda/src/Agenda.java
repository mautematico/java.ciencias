
import java.util.*;

/**
 * 
 */
public class Agenda {

    private ArrayList<Contacto> contactos;

    /**
     * 
     */
    private ArrayList<Grupo> grupos;
    /**
     * 
     */
    public Agenda() {
    }

    /**
     * 
     */




    /**
     * 
     */
    public void iniciarAgenda() {
        cargarContactos();
    }
    
    
    public void cargarContactos () {
        importarContactosDeUnArchivo("archivoPorDefecto");
    }

    /**
     * 
     */
    public void guardarCambios() {
        exportarContactosAUnArchivo("archivoPorDefecto");
    }

    /**
     * 
     */
    public void importarContactosDeUnArchivo(String nombreDelArchivo) {
        // TODO implement here
    }

    /**
     * 
     */
    public void exportarContactosAUnArchivo(String nombreDelArchivo) {
        // TODO implement here
    }

    public void ingresarContacto(String nombre, String apellido, Telefono telefono){
        Contacto contacto = new Contacto (nombre, apellido, telefono);
        contactos.add (contacto);
                
    }
    
    public void ingresarContacto(String nombre, String apellido, Email email){
        Contacto contacto = new Contacto (nombre, apellido, email);
        contactos.add (contacto);
    }
    
    public void eliminarContacto(Contacto contacto){
        contactos.remove(contacto);
    }
    
    public ArrayList<Contacto> consultarContactoPorNombre(String nombre){
        ArrayList<Contacto> contactosConEseNombre = new ArrayList<Contacto> ();
        for( int i = 0; i< contactos.size(); i++) {
            if(contactos.get(i).getNombre() == nombre)
                contactosConEseNombre.add(contactos.get(i));
        }
        return contactosConEseNombre;
            
    }
    
    public void consultarContactoPorApellido(String apellido){
        
    }
    
    public void crearGrupo(String nombre) {
        // TODO implement here
    }

    public void asignarContactoAGrupo(Contacto contacto, Grupo grupo){
        
    }
    
}