/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conjugador;

/**
 *
 * @author 
 * Mauricio Navarro Miranda
 * Gabriela Jocelyn Gutierrez Guillen
 * Facultad de Ciencias
 * 
 * 
 */
public class Conjugador { //Creamos una nueva clase suyos obletos podran conjugar algunos verbos en 3 idiomas
    
    /**
     * sacarRaiz
     * @param verbo
     * @return String raiz
     * 
     * "recorta" los dos últimos dos caracteres del verbo dado
     * y regresa un String. "correr" -> "corr"
     */
    public String sacarRaiz(String verbo){
        int tamagno = verbo.length();
        return verbo.substring(0,tamagno-2);
    }
    
    /**
     * conjugarEnEspaniol
     * @param verbo
     * @return conjugado
     * Recibe un verbo regular "-er" en Español
     * y regresa un String con el verbo conjugado en presente
     */
    public String conjugarEnEspaniol(String verbo){
       String raiz = sacarRaiz(verbo);

       return "yo \t\t"+raiz+"o\n"
            + "tú \t\t"+raiz+"es\n"
            + "él/ella \t"+raiz+"e\n"
            + "nosotros \t"+raiz+"emos\n"
            + "ustedes \t"+raiz+"en\n"
            + "ellos/ellas \t"+raiz+"en";
    }
    /**
     * conjugarEnAleman
     * @param verbo
     * @return 
     * Recibe un verbo en Alemán con terminacion -en
     * y regresa un String con el verbo conjugado en presente
     */
    public String conjugarEnAleman(String verbo){
       String raiz = sacarRaiz(verbo);

       return "ich \t\t"+raiz+"e\n"
                + "do \t\t"+raiz+"st\n"
                + "er/si/es \t"+raiz+"t\n"
                + "wir \t\t"+raiz+"en\n"
                + "ihr \t\t"+raiz+"t\n"
                + "sie/Sie \t"+raiz+"en";
    }
    /**
     * conjugarEnFrances
     * @param verbo
     * @return 
     * recibe un verbo del primer grupo del Frances
     * y regresa un String con el verbo conjugado en presente.
     * Trata bien el caso especial de los verbos que inician
     * con vocal o h
     */
    public String conjugarEnFrances(String verbo){
       String raiz = sacarRaiz(verbo);

       char primera = verbo.charAt(0); //Guardamos el primer caracter del verbo
       boolean cambiarJE = false;   // ¿Es "especial" y requiere cambiar JE?

       switch(primera){
           case 'a':
           case 'e':
           case 'i':
           case 'o':
           case 'u':
           case 'h':
               cambiarJE = true;
               break;
       }    //Si hay que cambiar Je por J', entonces cambiarJE es true
       
        return (cambiarJE  ? "j'" : "je")+ "\t\t"+raiz+"e\n"
                    + "tu \t\t"+raiz+"es\n"
                    + "il/elle \t"+raiz+"e\n"
                    + "nous \t\t"+raiz+"ons\n"
                    + "vous \t\t"+raiz+"ez\n"
                    + "ils/elles \t"+raiz+"ent";
    }
}