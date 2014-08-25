/*
	v:0.1.1
	Programa que lee cinco enteros
		determina el mínimo y el máxio
		e imprime a pantalla mínimo y máximo.
	Mauricio Navarro Miranda
	mauricio@navarromiranda.mx
	414043987
	Facultad de Ciencias.
*/
//Importamos el paquete necesario para usar Scanner
import java.util.Scanner;
public class MinimoYmaximo{
	public static void main(String args[]){
		//Preparamos una instancia de Scanner para leer de la entrada estándar
		Scanner entrada = new Scanner(System.in);

		//Le pedimos al usuario el primer entero, y lo guardamos en actual. Notemos que éste entero es, hasta ahora, el máximo y también el mínimo.
		System.out.print("Dame el primer entero... ");
		int actual = entrada.nextInt();
		int maximo = actual;
		int minimo = actual;

		System.out.print("Dame el segundo entero... ");
		//leemos el segundo entero
		actual = entrada.nextInt();
		//Si el entero que acabamos de leer es mayor que nuestro mayor almacenado, actualizamos mayor.
		if(actual > maximo)
		    maximo = actual;
		//Análogamente para el menor.
		if(actual < minimo)
		    minimo = actual;
    
		//Repetimos tres veces las lineas anteriores, para los otros tres enteros. Omitiré los comentarios a propósito.
		System.out.print("Dame el tercer entero... ");
		actual = entrada.nextInt();
		if(actual > maximo)
		    maximo = actual;
		if(actual < minimo)
		    minimo = actual;
 
		System.out.print("Dame el cuarto entero... ");
		actual = entrada.nextInt();
		if(actual > maximo)
		    maximo = actual;
		if(actual < minimo)
		    minimo = actual;
   
		System.out.print("Dame el quinto entero... ");
		actual = entrada.nextInt();
		if(actual > maximo)
		    maximo = actual;
		if(actual < minimo)
		    minimo = actual;
    
		//Ya hemos leído los cinco enteros. Ahora, int maximo tiene al máximo de ellos, mientras que el mínimo está en int minimo.
		System.out.printf("El máximo de los enteros es %d, y el mínimo es %d\n", maximo, minimo);

	}
}