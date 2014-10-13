/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina;

/**
 *
 * @author actuaria
 */
public class Practica7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado juan = new Empleado("Juan","Perez", "Martinez",
                new Fecha((byte)11,(byte)1,(short)1985),
                true, null, 7000, new CuentaBancaria("JUA001"));
        
        Empleado andrea = new Empleado("Andrea", "Monjaraz", "Vazquez", 
                new Fecha((byte)1,(byte)2,(short)1987), false,
                new Fecha((byte)1,(byte)1,(short)2011),
                8123, new CuentaBancaria("AND002",0.0));
        
        Empleado jessica = new Empleado("Jessica", "San Juan", "de la O",
                new Fecha((byte)15,(byte)9,(short)1991),
                false, new Fecha((byte)1,(byte)2,(short)2014),
                6800, new CuentaBancaria("JES003"));
                
       Nomina[] nominas = new Nomina[3];
       
       System.out.println("Nómina de la primera quincena:");
       nominas[0] = new Nomina(jessica, juan, andrea);       //Creamos la primera nómina:
       nominas[0].setNumeroQuincena(1);
       nominas[0].mostrarNomina();
       nominas[0].pagar();
       
        System.out.println(nominas[0].getGerente());
        System.out.println(nominas[0].getIntendente());
        System.out.println(nominas[0].getSecretaria());
         
        System.out.println("\n\nNómina de la segunda quincena:");
       nominas[1] = new Nomina(nominas[0]);
       nominas[1].setNumeroQuincena(nominas[0].getNumeroQuincena() + 1);
       nominas[1].mostrarNomina();
       nominas[1].pagar();
       
        System.out.println(nominas[1].getGerente());
        System.out.println(nominas[1].getIntendente());
        System.out.println(nominas[1].getSecretaria());
       
       /*
        Para la nómina de la tercera semana, intercambio al Intendente con el Gerente:
        */ 
        System.out.println("\n\nNómina de la tercera quincena:");
       nominas[2] = new Nomina(
               nominas[1].getIntendente(),
               nominas[1].getGerente(),
               nominas[1].getSecretaria());
       nominas[2].setNumeroQuincena(nominas[1].getNumeroQuincena() + 1);
       nominas[2].mostrarNomina();
       nominas[2].pagar();
       
        System.out.println(nominas[2].getGerente());
        System.out.println(nominas[2].getIntendente());
        System.out.println(nominas[2].getSecretaria());
        
        nominas[2].mostrarNomina();
    }
}
