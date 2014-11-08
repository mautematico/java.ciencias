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
public class Exportador {
    public static void escribir ( String nombreDeArchivo, Agenda agenda){
        FileWriter fichero = null;
        PrintWriter pw = null;

        Gson gson = new Gson();         
        String JSON = gson.toJson(agenda);
  
        try
        {
            fichero = new FileWriter(nombreDeArchivo);
            pw = new PrintWriter(fichero);
            pw.print(JSON);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    public static void escribirAgenda(String fichero, Agenda agenda) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(fichero));
                oos.writeObject(agenda);
            oos.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
