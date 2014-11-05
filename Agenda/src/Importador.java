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

public class Importador {
    public static String leer (String nombreDeArchivo){
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      String cadena = "";
 
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (nombreDeArchivo);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
         while((linea = br.readLine())!=null)
            cadena += linea;
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta
         // una excepcion.
         try{                   
            if( null != fr ){  
               fr.close();    
            }                 
         }catch (Exception e2){
            e2.printStackTrace();
         }
      }
      return cadena;
    }
}
