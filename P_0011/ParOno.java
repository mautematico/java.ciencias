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

import java.util.Scanner;
public class ParOno{
	public static void main(String args[]){
		Scanner entrada = new Scanner(System.in);
		
		int numero = entrada.nextInt();
		
		if(numero % 2 == 1)
		    System.out.printf("%d es un número impar", numero);
		if(numero % 2 == 0)
		    System.out.printf("%d es un número par", numero);

	}
}
