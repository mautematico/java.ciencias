import java.util.Scanner;
public class RangoDeCaracteres{
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);

		System.out.print("Dame el inicio del rango\n");
		int inicio = entrada.nextInt();
		System.out.print("Dame el final del rango\n");
		int fin = entrada.nextInt();

		if(inicio > fin){
			int temp = inicio; inicio = fin; fin = temp;
		}
		
		while(inicio <= fin){
			System.out.print((char)inicio++);
		}

	}
}
