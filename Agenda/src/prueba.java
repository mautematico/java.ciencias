/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mautematico
 */
public class prueba {
    public static void main(String[] args){
            Telefono miTelefono = new Telefono("07913128993120");
            Agenda miAgenda = new Agenda();
   
            miAgenda.ingresarContacto("juan","perez",miTelefono);
 
            miAgenda.ingresarContacto("juan","perez",miTelefono);
           miAgenda.ingresarContacto("juan","perez",miTelefono);
            miAgenda.ingresarContacto("juan","perez",miTelefono);
            miAgenda.ingresarContacto("juan","perez",miTelefono);
     
            Exportador.escribir("/tmp/miagenda",miAgenda);

    }
}
