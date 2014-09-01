/*
	v:0.1
	Programa que lee un entero
		determina
		e imprime si es par o impar.
	Mauricio Navarro Miranda
	mauricio@navarromiranda.mx
	414043987
	Facultad de Ciencias.
*/
//Importamos el paquete necesario para usar Scanner
import java.util.Scanner;
public class ParOno{
	public static void main(String args[]){
		//Preparamos una entrada de Scanner, para leer la entrada estándar.
		Scanner entrada = new Scanner(System.in);

		//Pedimos al usuario que nos proporcione el entero que vamos a evaluar.
		System.out.print("Dame un número entero... ");
		//Leemos el siguiente entero en la entrada
		int numero = entrada.nextInt();

		//Si el número es congruente a 1 (módulo 2), entonces es impar.
		if(numero % 2 == 1)
		    System.out.printf("%d es un número impar\n", numero);
		//Si el número es congruente a 0 (módulo 2), entonces es par.
		if(numero % 2 == 0)
		    System.out.printf("%d es un número par\n", numero);

	}
}
