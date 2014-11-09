//Hecho por: Arévalo Loyola Alma Rosario, Gutiérrez Guillén Gabriela Jocelyn, Navarro Miranda Mauricio
import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class Grupo implements Serializable {
  
//Creamos variables de instancia para esta clase
    private String nombre;
    private ArrayList<Contacto> contactos;
    
//este constructor manda a llamar al constructor siguiente 
    public Grupo(String nombre) {
        this(nombre,null);
    }
//Creamos un constructor que reciba todos los parametros y verificamos si el arraylist esta inicializado       
    public Grupo(String nombre, ArrayList<Contacto> contactos) {
        
        this.nombre = nombre;       
        if(contactos == null)
            this.contactos = new ArrayList<>(); 
        else this.contactos = contactos;
    }


//este metodo verifica si el contacto esta o no en el grupo y si no, lo agrega y regresa un true
    public boolean asignarContactoAGrupo(Contacto contacto) {
        
            if (contactos.contains(contacto))
                return false;
            else {
                contactos.add(contacto);
                return true;
                    }
    }
//con este metodo quitamos a un contacto de la lista de contactos del grupo
    public void excluirContactoDeGrupo(Contacto contacto) {
        contactos.remove(contacto);
        
    }
//creamos metodos accesores para esta clase
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
//Sobreescribimos el metodo toString
    @Override
    public String toString() {
        String contactosString = "\nContactos:\n";
        for (Contacto contacto : contactos)
            contactosString += contacto.getNombre()+" " + contacto.getApellido() + "\n";
        if(contactos.isEmpty())
            contactosString="";
        return nombre  + contactosString;
    }

    
}