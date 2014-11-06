/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mautematico
 */
import com.google.gson.*;

public class prueba {
    public static void main(String[] args){
            Telefono miTelefono = new Telefono("07913128993120");
            Agenda miAgenda = new Agenda();
   
            miAgenda.ingresarContacto("juan","perez",miTelefono);
 
            miAgenda.ingresarContacto("juan","sánchez",miTelefono);
           miAgenda.ingresarContacto("juan","andrade",miTelefono);
            miAgenda.ingresarContacto("juan","rival",miTelefono);
            miAgenda.ingresarContacto("juan","real",miTelefono);
            
            Grupo juanes = miAgenda.crearGrupo("Juanes");
            
            juanes.asignarContactoAGrupo(miAgenda.getContactos().get(1));
            juanes.asignarContactoAGrupo(miAgenda.getContactos().get(2));
            juanes.asignarContactoAGrupo(miAgenda.getContactos().get(3));
            juanes.asignarContactoAGrupo(miAgenda.getContactos().get(0));
            

            
            Exportador.escribir("/tmp/miAgenda.txt",miAgenda);
            
            Agenda Otra = new Agenda();
            
            Otra = Importador.leer("/tmp/miAgenda.txt");
            System.out.println(miAgenda);
            System.out.println(Otra);

    }
}
