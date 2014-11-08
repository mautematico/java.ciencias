//Hecho por: Arévalo Loyola Alma Rosario, Gutiérrez Guillén Gabriela Jocelyn, Navarro Miranda Mauricio
import java.io.Serializable;
import java.util.*;//Importamos el paquete java.util
public class Contacto implements Serializable{//Inicia la clase contacto
    //Declaramos las variables de instancia
    private String nombre;
    private String apellido;
    private ArrayList<Telefono> telefonos;
    private ArrayList<Email> emails;

  //Creamos constructores
    public Contacto(String nombre, String apellido, Telefono telefono, Email email) {
        this.nombre = nombre;
        this.apellido = apellido;

        this.telefonos = new ArrayList<>();
        this.emails = new ArrayList<>();
                
                
                
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

//Creamos metodos accesores para esta clase y sobreescribimos el metodo toString
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

    @Override
    public String toString() {
        
        String telefonosString = "\nTeléfonos:\n";
        for (Telefono tel : telefonos)
            telefonosString += tel;
        if (telefonos.isEmpty())
            telefonosString = "";
        
        String emailsString = "\nEmails:\n";
        for (Email email : emails)
            emailsString += email;
        if (emails.isEmpty())
            emailsString = "";
        
        return  nombre + " " + apellido + telefonosString + emailsString + "\n\n";
    }

  
   /**
     * TODO: Agregar el teléfono a la lista solamente si no está ya en ella
     * Opcionalmente, podríamos también revisar si alguno de los telefonos(i).numero 
     * coincide con el que queremos agregar
     */
    public boolean agregarTelefono(Telefono telefono) {
        for ( Telefono tel: telefonos){
            if (tel.getNumero().equals(telefono.getNumero()))
                return false;
        }
        telefonos.add(telefono);
        return true;
    }
    
    public void eliminarTelefono(Telefono telefono) {
               telefonos.remove(telefono);
    }

    /**
     * TODO: similar al caso de agregarTelefono
     */
    
    public boolean agregarEmail(Email email) {
        for (Email correo : emails){
            if (email.getCorreo().equals(correo.getCorreo()))
                return false;
        }
        emails.add(email);
        return true;
    }

   
    public void eliminarEmail(Email email) {
            emails.remove(email);//eliminamos el email dado de la lista de eails
    }
    
    /**
     * TODO: similar al caso de agregarTelefono
     */
    public void asignarContactoAGrupo(Grupo grupo) {
        grupo.getContactos().add(this);
    }


    public void excluirContactoDeGrupo(Grupo grupo) {
        grupo.getContactos().remove(this);//obtenemos la lista de contactos del grupo dado y eliminamos este contacto de ella
        
    }

    public void setTelefonos(ArrayList<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }
   

}
