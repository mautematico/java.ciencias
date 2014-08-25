/*
	v:0.1
	Programa que
		calcula
		e imprime los cuadrados y los cubos de los primeros once naturales.
	Mauricio Navarro Miranda
	mauricio@navarromiranda.mx
	414043987
	Facultad de Ciencias.
*/
public class Potencias{
	public static void main(String args[]){
		int numero = 0;

		System.out.println("Número\tCuadrado\tCubo");
		//Iniciamos con numero = 0
		System.out.printf("%d\t%d\t\t%d\n", numero, numero*numero, numero*numero*numero);
		
		/*
			Ahora, haremos diez veces lo siguiente:
				incrementaremos el número en 1.
				imprimiremos la fila de la tabla con el nuevo número, su cuadrado y su cubo.
		*/
		numero+=1;
		System.out.printf("%d\t%d\t\t%d\n", numero, numero*numero, numero*numero*numero);
		numero+=1;
		System.out.printf("%d\t%d\t\t%d\n", numero, numero*numero, numero*numero*numero);
		numero+=1;
		System.out.printf("%d\t%d\t\t%d\n", numero, numero*numero, numero*numero*numero);
		numero+=1;
		System.out.printf("%d\t%d\t\t%d\n", numero, numero*numero, numero*numero*numero);
		numero+=1;
		System.out.printf("%d\t%d\t\t%d\n", numero, numero*numero, numero*numero*numero);
		numero+=1;
		System.out.printf("%d\t%d\t\t%d\n", numero, numero*numero, numero*numero*numero);
		numero+=1;
		System.out.printf("%d\t%d\t\t%d\n", numero, numero*numero, numero*numero*numero);
		numero+=1;
		System.out.printf("%d\t%d\t\t%d\n", numero, numero*numero, numero*numero*numero);
		numero+=1;
		System.out.printf("%d\t%d\t\t%d\n", numero, numero*numero, numero*numero*numero);
		numero+=1;
		System.out.printf("%d\t%d\t\t%d\n", numero, numero*numero, numero*numero*numero);
	}
}
