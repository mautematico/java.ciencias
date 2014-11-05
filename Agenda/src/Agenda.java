
import java.util.*;

/**
 * 
 */
public class Agenda {

    /**
     * 
     */
    public Agenda() {
    }

    /**
     * 
     */
    private ArrayList<Contacto> contactos;

    /**
     * 
     */
    private ArrayList<Grupo> grupos;



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

    public void ingresarContacto(){
        
    }
    
    public void eliminarContacto(){
        
    }
    
    public void consultarContacto(){
        
    }
    
    
    public void crearGrupo() {
        // TODO implement here
    }

    public void asignarContactoAGrupo(){
        
    }
}