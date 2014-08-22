/*
	v:0.1
	Programa que lee cinco enteros
		determina el mínimo y el máxio
		e imprime a pantalla mínimo y máximo.
	Mauricio Navarro Miranda
	mauricio@navarromiranda.mx
	414043987


	Facultad de Ciencias.
*/

import java.util.Scanner;
public class MinimoYmaximo{
	public static void main(String args[]){
		Scanner entrada = new Scanner(System.in);
		
		int actual = entrada.nextInt();
		int maximo = actual;
		int minimo = actual;
		
		//leemos el segundo entero
		actual = entrada.nextInt();
		//Si el entero que acabamos de leer es mayor que nuestro mayor almacenado, actualizamos mayor.
		if(actual > maximo)
		    maximo = actual;
		//Análogamente para el menor.
		if(actual < minimo)
		    minimo = actual;
		    
		//Repetimos tres veces las lineas anteriores, para los otros tres enteros. Omitiré los comentarios a propósito.

		actual = entrada.nextInt();
		if(actual > maximo)
		    maximo = actual;
		if(actual < minimo)
		    minimo = actual;
		 
		actual = entrada.nextInt();
		if(actual > maximo)
		    maximo = actual;
		if(actual < minimo)
		    minimo = actual;
		   
		actual = entrada.nextInt();
		if(actual > maximo)
		    maximo = actual;
		if(actual < minimo)
		    minimo = actual;
		    
		//Ya hemos leído los cinco enteros. Ahora, int maximo tiene al máximo de ellos, mientras que el mínimo está en int minimo.
		
		System.out.printf("El máximo de los enteros es %d, y el mínimo es %d\n", maximo, minimo);
		
	}
}
