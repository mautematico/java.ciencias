import java.util.*;

/**
 * 
 */
public class Agenda {

    private ArrayList<Contacto> contactos;
    private ArrayList<Grupo> grupos;
    private String archivo;
    
    public Agenda() {
        this(null,null,"miAgenda.json");
    }
    
    public Agenda(ArrayList<Contacto> contactos, ArrayList<Grupo> grupos, String archivo) {
        if(contactos != null)
            this.contactos = contactos;
        else
            this.contactos = new ArrayList<>();
    
        if(grupos != null)
            this.grupos = grupos;
        else
            this.grupos = new ArrayList<>();        
        if(archivo != null)
            this.archivo = archivo;
        else
            archivo = "miAgenda.json";
    }
    
    /**
     * 
     */
    public void iniciarAgenda() {
        cargarContactos();
    }
    
    
    
    public void cargarContactos(){
        if(archivo == null)
            archivo = "miAgenda.json";
        importarContactosDeUnArchivo(archivo);
    }

    /**
     * 
     */
    public void guardarCambios() {
        guardarCambios(null);
    }
    public void guardarCambios(String archivo){
        if(archivo == null)
            archivo = "miAgenda.json";
        exportarContactosAUnArchivo(archivo);
    }

    /**
     * 
     */
    public void importarContactosDeUnArchivo(String nombreDelArchivo) {
        Agenda importada = Importador.leer(nombreDelArchivo);
        this.contactos = importada.getContactos();
        this.grupos = importada.getGrupos();
    }

    /**
     * 
     * @param nombreDelArchivo
     */
    private void exportarContactosAUnArchivo(String nombreDelArchivo) {
        Exportador.escribir(nombreDelArchivo, this);
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
        for (Contacto contacto : contactos) {
            if (contacto.getNombre() == nombre) {
                contactosConEseNombre.add(contacto);
            }
        }
        return contactosConEseNombre;     
    }
    
    public ArrayList<Contacto> consultarContactoPorApellido(String apellido){
        ArrayList<Contacto> contactosConEseApellido = new ArrayList<> ();
        for (Contacto contacto : contactos) {
            if (contacto.getApellido().equals(apellido)) {
                contactosConEseApellido.add(contacto);
            } 
        }
        return contactosConEseApellido;     
    }
        
    public ArrayList<Contacto> consultarContactoPorTelefono(String telefono){
        ArrayList<Contacto> contactosConEseTelefono= new ArrayList<> ();
        
        for (Contacto contacto : contactos) {
            for (Telefono tel: contacto.getTelefonos() ) {
                if ( tel.getNumero().equals(telefono)) {
                    contactosConEseTelefono.add(contacto);
                }
            }
        }
        return contactosConEseTelefono;     
    }
    
    public ArrayList<Contacto> consultarContactoPorEmail(String correo){
        ArrayList<Contacto> contactosConEseEmail= new ArrayList<> ();
        
        for (Contacto contacto : contactos) {
            for (Email email: contacto.getEmails() ) {
                if ( email.getCorreo().equals(correo)) {
                    contactosConEseEmail.add(contacto);
                }
            }
        }
        return contactosConEseEmail;     
    }
    
    public ArrayList<Contacto> consultarContactoPorGrupo(Grupo grupo){
        
        return grupo.getContactos();
    }
   
    
    public Grupo crearGrupo(String nombre) {
        return crearGrupo(nombre,null);
    }
    public void eliminarGrupo(Grupo grupo){
        grupos.remove(grupo);
    }
    
    public Grupo crearGrupo(String nombre, ArrayList<Contacto> contactos){
        Grupo grupoNuevo = new Grupo(nombre, contactos);
        grupos.add(grupoNuevo);
        return grupoNuevo;       
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
