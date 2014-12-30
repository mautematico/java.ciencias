import java.util.Scanner;
/*
	Java Hello World example.
*/
public class Suma{
	public static void main(String args[]){
	//Use System.out.println() to print on console.
        System.out.println("Bienvenido al curso de Java");

	Scanner entrada = new Scanner(System.in);
	Scanner otraentrada = new Scanner(System.in);


	System.out.printf("%d + %d = %d", entrada.nextInt(), otraentrada.nextInt(), entrada.nextInt()+otraentrada.nextInt() );


//	System.out.printf("%d + %d = %d", otraentrada.nextInt(), otraentrada.nextInt(), otraentrada.nextInt()+otraentrada.nextInt() );


	

      }
}
