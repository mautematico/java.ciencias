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
        
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();        
        
        String cadena = gson.toJson(agenda);
        System.out.println(cadena);
        try
        {
            fichero = new FileWriter(nombreDeArchivo);
            pw = new PrintWriter(fichero);
 
            pw.print(cadena);
 
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
}
