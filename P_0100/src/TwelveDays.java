/*
	v:1.1
	Programa que usa repeticiones y selecciones
		para imprimir la canción Los doce días de Navidad.
	Mauricio Navarro Miranda
	mauricio@navarromiranda.mx
	414043987
	Alma Rosario Arévalo Loyola
	olaverax@gmail.com

	Facultad de Ciencias.
*/
public class TwelveDays{
  public static void main(String[]args){
    int dia = 1;	//Usaremos esta variable para recorrer los doce días.
    String diaS = "";	//Usaremos esta variable para guardar el "nombre ordinal" del día.
			//diaS hace referencia a "String día"

    for (dia = 1; dia <= 12; dia++){
    
    //El primer switch guardará en diaS el nombre del día en curso.
      switch(dia){
	case 1: diaS = "First";		break;
	case 2: diaS = "Second";	break;
	case 3: diaS = "Third";	  	break;
	case 4: diaS = "Fourth";	break;
	case 5: diaS = "Fifth";	  	break;
	case 6: diaS = "Sixth";	  	break;
	case 7: diaS = "Secenth";	break;
	case 8: diaS = "Eighth";	break;
	case 9: diaS = "Ninth";	  	break;
	case 10: diaS = "Tenth";	break;
	case 11: diaS = "Eleventh";	break;
	case 12: diaS = "Twelfth";	break;
      }
      System.out.printf("On the %s day of Christmas my true love sent to me\n", diaS);

    /*En el segundo switch, imprimiremos TODOS los regalos que correspondan a días menores o iguales al actual,
      por eso no usamos break al final de cada case.
    */
    switch(dia){
	case 12: System.out.println("Twelve Drummers Drumming,");
	case 11: System.out.println("Eleven Pipers Piping,");
	case 10: System.out.println("Ten Lords-a-Leaping,");
	case 9: System.out.println("Nine Ladies Dancing,");
	case 8: System.out.println("Eight Maids-a-Milking,");
	case 7: System.out.println("Seven Swans-a-Swimming,");
	case 6: System.out.println("Six Geese-a-Laying,");
	case 5: System.out.println("Five Gold Rings,");
	case 4: System.out.println("Four Calling Birds,");
	case 3: System.out.println("Trhee French Hens,");
	case 2: System.out.println("Two Turtle Doves");
	case 1:
		if(dia != 1)
		  System.out.print("and "); 
		System.out.println("a Partridge in a Pear Tree.\n");
      }//fin switch de regalos
    }//fin for de 12 días
  }//fin main()
}//fin TwelveDays