//Hecho por: Arévalo Loyola Alma Rosario, Gutiérrez Guillén Gabriela Jocelyn, Navarro Miranda Mauricio
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Agenda implements Serializable{
//Creamos atributos para esta clase 
    private ArrayList<Contacto> contactos;
    private ArrayList<Grupo> grupos;
    private String archivo;
//Creamos un contructor que no recibe parametros y manda a llamar al constructor siguiente    
    public Agenda() {
        this(null,null,"miAgenda.json");
    }
//Creamos un contructor que recibe todos los parametros y verificamos el contenido de los parametros que recibimos
    public Agenda(ArrayList<Contacto> contactos, ArrayList<Grupo> grupos, String archivo) {
        if(contactos != null)
            this.contactos = contactos;
        else
            this.contactos = new ArrayList<>();
    
        if(grupos != null)
            this.grupos = grupos;
        else
            this.grupos = new ArrayList<>();        
        if(archivo != null || archivo.equals(""))
            this.archivo = archivo;
        else
            archivo = "miAgenda.json";
    }
    
    /**
     * 
     */
//Creamos el metodo iniciar agenda que carga todos los contactos mandando a llamar a tal metodo
    public void iniciarAgenda() {
        cargarContactos();
    }
    
    
//Creamos el metodo cargar contactos, que importara contactos de un archivo  
    public void cargarContactos(){
        if(archivo == null || archivo.equals(""))
            archivo = "miAgenda.json"; //Revisamos si el atributo archivo esta inicializado por defecto y en tal caso le damos un nombre de archivo
        importarContactosDeUnArchivo(archivo);//mandamos a llamar al metodo importar contactos con el nombre de archivo que le acabamos de poner
    }

    /**
     * 
     */
//Creamos el metodo guardaar cambios sin parametros 
    public void guardarCambios(){
        if(archivo == null || archivo.equals(""))
            archivo = "miAgenda.json";//verificamos si el nombre del arcivo es null o vacio y en tal caso le asignamos un nmbre predeterminado
        exportarContactosAUnArchivo(archivo);//llamamos al matodo esportar contactos a un archivo y la damos como parametro el atributo archivo de este objeto
    }

    /**
     * 
     */
//Creamos el metodo importar contactos de un archivo que recibe un string que sera el nombre del archio   
    public void importarContactosDeUnArchivo(String nombreDelArchivo) {
        Agenda importada = Importador.leerAgenda(nombreDelArchivo);//leer es un metodo static de la clase importador que nos regresa una agenda, dandole un nombre de archivo
        this.contactos = importada.getContactos();
        this.grupos = importada.getGrupos();
    }

    /**
     * 
     * @param nombreDelArchivo
     */
//Creamos el metodo exportar contactos de un archivo que recibe un String con el nombre del archivo
    private void exportarContactosAUnArchivo(String nombreDelArchivo) {
        Exportador.escribirAgenda(nombreDelArchivo, this);//mandamos a llamar al metodo escribir (que es estatico) de la clase importados y le damos como parametros esta agenda y el String que recibe este metodo
    }

    public boolean ingresarContacto(Contacto contacto){
        if (contactos.contains(contacto))
            return false;
        else{
            contactos.add(contacto);
            return true;
        }
    }

    public void ingresarContacto(String nombre, String apellido, Telefono telefono){
        Contacto contacto = new Contacto (nombre, apellido, telefono);
        contactos.add(contacto);
                
    }
    
    public void ingresarContacto(String nombre, String apellido, Email email){
        Contacto contacto = new Contacto (nombre, apellido, email);
        contactos.add (contacto);
    }
    
    public void eliminarContacto(Contacto contacto){
        for (Grupo grupo : grupos) {
            if(grupo.getContactos().contains(contacto)){
                grupo.excluirContactoDeGrupo(contacto);
            }
        }
        contactos.remove(contacto);
    }
    
    public ArrayList<Contacto> consultarContactoPorNombre(String nombre){
        ArrayList<Contacto> contactosConEseNombre = new ArrayList<> ();
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)) {
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

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
}
