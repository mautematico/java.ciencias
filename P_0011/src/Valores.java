/*
	Programa que imprime la lista de los valores entros entre dos valores dados.

	Arévalo Loyola, Alma Rosario
	alma.arevalo@ciencias.unam.mx
	Navarro Miranda, Mauricio
	mauricio@navarromiranda.mx
	Romero Chávez, Luis Alfonso
	alfonsoromero@ciencias.unam.mx

	Facultad de Ciencias

	
*/
//Importamos el paquete de Scanner
import java.util.Scanner;
public class Valores {
	public static void main (String[] arg) {
		//Se declaran las variables a utilizar
		int numero1 = 0, numero2 = 0, temporal = 0;
		//Se  declara la variable que guarda los valores
		Scanner entrada = new Scanner(System.in);
		//Se piden los valores a utilizar
		System.out.println ("Dame el primer número");
		numero1 = entrada.nextInt();
		System.out.println ("Dame el segundo número");
		numero2 = entrada.nextInt();



		//Se comparan los valores para acomodarlos de mayor a menor
		if (numero1  < numero2) {
			temporal = numero2;
			numero2 = numero1;
			numero1 = temporal;
		}

		System.out.println ("Los valores son");
		System.out.printf ("%d\n", numero1);
		while (numero1 > numero2) {
			numero1 = numero1 - 1;
			System.out.printf ("%d\n", numero1);
		}
 }
}
