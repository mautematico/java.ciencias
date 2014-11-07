
import java.util.*;

/**
 * 
 */
public class Grupo {
  
    private String nombre;
    private ArrayList<Contacto> contactos;
    

    public Grupo(String nombre) {
        this(nombre,null);
    }
    
    public Grupo(String nombre, ArrayList<Contacto> contactos) {
        
        this.nombre = nombre;       
        if(contactos == null)
            this.contactos = new ArrayList<>(); 
        else this.contactos = contactos;
    }


    /**
     * @param contacto
     */
    public void asignarContactoAGrupo(Contacto contacto) {
        contactos.add(contacto);
    }

    public void excluirContactoDeGrupo(Contacto contacto) {
        contactos.remove(contacto);
        
    }

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

    @Override
    public String toString() {
        return "Grupo{" + "Nombre=" + nombre + ", Contactos=" + contactos + '}';
    }

    
}