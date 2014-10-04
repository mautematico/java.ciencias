/*
	Programa que recibe la lista de artículos vendidos por una tienda y calcula la comisión generada por el vendedor.
	La comisión está dada por: $200 + 9% del total de ventas.

	Para este ejercicio, suponemos que en cada paso recibimos un entero entre 1 y 4 ("códigos de producto"), o un -1 para terminar.

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
public class Tienda {
	public static void main (String[] arg) {
		Scanner entrada = new Scanner(System.in);

		float precio1 = (float) 239.99,
		precio2	 = (float) 129.75,
		precio3	 = (float) 99.95,
		precio4	 = (float) 350.89;

		int codigo = 1;
		int producto1 = 0, producto2 = 0, producto3 = 0, producto4 = 0;

		while (codigo != -1) {
			System.out.println ("Ingresa un código de producto (1, 2, 3 o 4), o -1 para terminar.");
				codigo = entrada.nextInt();

			//revisamos cuál código nos acaban de dar, e incrementamos nuestro contador de ese producto.
			if(codigo == 1)
				producto1++;
			else if(codigo == 2)
				producto2++;
			else if(codigo == 3)
				producto3++;
			else if(codigo == 4)
				producto4++;
			//Notemos que si el código es incorrecto (y no es -1), no haremos nada. Simplemente lo ignoraremos y continuaremos.
		}

		//calculamos el total de dinero vendido.
		float total = precio1*producto1 + precio2*producto2 + precio3*producto3 + precio4*producto4;
		//calculamos las ganancias como habíamos quedado: 200 fijos + 9% del total.
		float ganancias = 200 + total*(float)0.09;

		System.out.printf ("El total vendido fue %f, de manera que tus ganancias son %f:\n",total,ganancias);
		

 }
}
