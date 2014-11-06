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
}
