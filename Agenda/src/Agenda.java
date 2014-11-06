import java.util.*;

/**
 * 
 */
public class Agenda {

    private ArrayList<Contacto> contactos;
    private ArrayList<Grupo> grupos;
    
    public Agenda() {
        this.contactos = new ArrayList<>();
        this.grupos = new ArrayList<>();
    }
    
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
        ArrayList<Contacto> contactosConEseNombre = new ArrayList<> ();
        for( int i = 0; i< contactos.size(); i++) {
            if(contactos.get(i).getNombre() == nombre)
                contactosConEseNombre.add(contactos.get(i));
        }
        return contactosConEseNombre;     
    }
    
    public ArrayList<Contacto> consultarContactoPorApellido(String apellido){
        ArrayList<Contacto> contactosConEseApellido = new ArrayList<Contacto> ();
        for( int i = 0; i< contactos.size(); i++) {
            if(contactos.get(i).getApellido() == apellido)
                contactosConEseApellido.add(contactos.get(i));
        }
        return contactosConEseApellido;     
    }
        
    public ArrayList<Contacto> consultarContactoPorTelefono(String telefono){
        ArrayList<Contacto> contactosConEseTelefono= new ArrayList<Contacto> ();
        
        for( int i = 0; i< contactos.size(); i++) {
            for (int j =0; j< contactos.get(i).getTelefonos().size(); j++){
                if(contactos.get(i).getTelefonos().get(j).getNumero() == telefono)
                    contactosConEseTelefono.add(contactos.get(i));
            }
        }
        return contactosConEseTelefono;     
    }
    
    public ArrayList<Contacto> consultarContactoPorEmail(String correo){
        ArrayList<Contacto> contactosConEseEmail= new ArrayList<Contacto> ();
        
        for( int i = 0; i< contactos.size(); i++) {
            for (int j =0; j< contactos.get(i).getEmails().size(); j++){
                if(contactos.get(i).getEmails().get(j).getCorreo() == correo)
                    contactosConEseEmail.add(contactos.get(i));
            }
        }
        return contactosConEseEmail;     
    }
   
    
    public Grupo crearGrupo(String nombre) {
        return crearGrupo(nombre,null);
    }
    
    public Grupo crearGrupo(String nombre, ArrayList<Contacto> contactos){
        Grupo grupoNuevo = new Grupo(nombre, contactos);
        grupos.add(grupoNuevo);
        return grupoNuevo;       
    }

    public void asignarContactoAGrupo(Contacto contacto, Grupo grupo){
        
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }
    
}
