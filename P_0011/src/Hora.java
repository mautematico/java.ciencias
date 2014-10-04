/*
	Programa que solicita la hora actual al usuario y le indica qué hora será dentro de 30 minutos.
	Además, indica error si la hora introducida es inválida.

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
public class Hora {
	public static void main (String[] arg) {

		//Se declaran las variables a utilizar
		int hour = 0, minutos = 0, newhour = 0, newminutos = 0, modificadedhour = 0;
		Scanner in = new Scanner(System.in);
		//Se declaran las indicaciones que el usuario ha de seguir
		System.out.println ("Este programa indica que hora será dentro de 30 minutos");
		System.out.println ("Introduce la hora en formato de 24 hrs.");
		System.out.println ("Contando las 0:00");
		System.out.println ("Dame la hora");
		hour = in.nextInt();
		//Se verifica si es una hora posible
		if (hour >= 0) {
			if (hour >= 24)
				System.out.println ("Te habeís equivocado, inténtalo de nuevo");
			else {		
				System.out.println ("Dame los minutos");
				minutos = in.nextInt();
				if (minutos >= 0) {
					//Se verifica si los minutos son posibles
					if (minutos > 60) 
						System.out.println ("Te habeís equivocado, inténtalo de nuevo");
					else {
						//Revisamos si se pasa a una nueva hora
        		        		if (minutos + 30 >= 60) {
							newhour = hour + 1;
							newminutos = minutos - 30;
						}
						else {
							newhour = hour;
							newminutos = minutos + 30;
						}	
						//Revisamos que el valor de la hora sea menor a 24
						modificadedhour = newhour%24;
						
							System.out.printf ("Ya que ahora son las %02d:%02d \n", hour, minutos); 
						System.out.printf ("Dentro de 30 minutos serán las %02d:%02d \n", modificadedhour, newminutos); 	
        		                }
				}
				else 
					System.out.println ("Te habeís equivocado, inténtalo de nuevo");
        	         }
		}
		else 
			System.out.println ("Te habeís equivocado, inténtalo de nuevo");
 }
}	 
