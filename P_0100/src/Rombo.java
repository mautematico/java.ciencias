/*
	v:1.1
	Programa que lee un entero
		e imprime un rombo bien chido.
	Alma Rosario Arévalo Loyola
	olaverax@gmail.com
	Mauricio Navarro Miranda
	mauricio@navarromiranda.mx
	414043987

	Facultad de Ciencias.
*/
//importamos el paquete Scanner, que usaremos para leer de la entrada estandar.
import java.util.Scanner;
public class Rombo {
	public static void main (String[]args) {

		Scanner entrada = new Scanner (System.in);
		System.out.println("Introduce un valor entero");//Pedimos un entero
		int valor = entrada.nextInt();//leemos y guardamos el entero
		/*
		  En las siguientes líneas dibujaremos la "mitad superior" del rombo,
		  imprimiendo espacios al en caso necesario para alinear las filas al centro.
		*/
		for (int i = 1; i<valor; i++){
			for (int j = valor; j>=1; j--){
				if (j>i)
					System.out.print(" ");
				else
					System.out.print(j);
			}
			/*
			  La parte de arriba del rombo la dividimos, a su vez, en dos triángulos
			  La parte "derecha" es escencialmente idéntica a la de la izquierda (sólo que reflejada y sin espacios)
			*/
			for (int j = 2; j<=valor; j++){
				if (j>i);
					//System.out.print(" ");
				else
					System.out.print(j);
			}
			System.out.println("");
		}//Fin del triángulo superior.

		/*
		  Para la mitad inferior del rombo
		  hacemos algo similar a lo que hicimos para la mitad superior;
		  simplemente invertimos el orden de los números y de los rangos que imprimirmos.
		*/
		for (int i = valor; i>=1; i--){
			for (int j = valor; j>=1; j--){
				if (j>i)
					System.out.print(" ");
				else
					System.out.print(j);
			}
			for (int j = 2; j<=valor; j++){
				if (j>i);
					//System.out.print(" ");
				else
					System.out.print(j);
			}
			System.out.println("");
		}
	}
}