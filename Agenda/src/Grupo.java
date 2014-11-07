
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
    
    public boolean asignarContactoAGrupo(Contacto contacto) {
        
            if (contactos.contains(contacto))
                return false;
            else {
                contactos.add(contacto);
                return true;
                    }
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
        String contactosString = "\nContactos:\n";
        for (Contacto contacto : contactos)
            contactosString += contacto.getNombre()+" " + contacto.getApellido() + "\n";
        if(contactos.isEmpty())
            contactosString="";
        return nombre  + contactosString;
    }

    
}