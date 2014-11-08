/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GABI
 */
import java.io.*;
import com.google.gson.*;
public class Importador {
    public static Agenda leer (String nombreDeArchivo){
        String JSON = null;
        Gson gson = new Gson();
           
        try {
            File file = new File(nombreDeArchivo);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int)file.length()];
            fis.read(data);
            fis.close();
            JSON = new String(data, "UTF-8");
          }
        catch (Exception e) {
            e.printStackTrace();
        }   
        
      Agenda importada = gson.fromJson(JSON, Agenda.class);  
      return importada;              
    }
    
    public static Agenda leerAgenda(String fichero) {
        try {
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fichero));
            
            // Se lee el primer objeto
            Object agenda = ois.readObject();
            
            // Mientras haya objetos
            if (agenda!=null)
            {
                if (agenda instanceof Agenda)
                    return (Agenda) agenda;
            }
            ois.close();
        }
        catch (EOFException e1) {
            System.out.println ("Fin de fichero");
        }
        catch (IOException | ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        
        Agenda agenda = new Agenda();
        
        for(int i = 0; i< 11; i++){
            Telefono telefono = new Telefono("f9ygu0" + i);
            Email email = new Email("juan" + i +"@elmail.chido");
            
//            Contacto fulano = new Contacto("Juan "+i,"Hijo del " + i +"maestro del aire",telefono);
//            fulano.agregarEmail(email);
            agenda.ingresarContacto("Juan " + i,"Hijo del " + i + " maestro del aire", telefono);
            agenda.getContactos().get(i).agregarEmail(email);
        }
        
        agenda.crearGrupo("Hijos");
        Grupo hijos = agenda.getGrupos().get(0);
        
        for (Contacto contacto : agenda.getContactos()) {
            hijos.asignarContactoAGrupo(contacto);
        }
                
        return agenda;
    }
}
