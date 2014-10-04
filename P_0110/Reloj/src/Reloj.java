/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * Arteaga Gaona, Guillermo <guillermo_ag@ciencias.unam.mx>
 * Navarro Miranda, Mauricio <mauricio@navarromiranda.mx>
 * 
 */
public class Reloj {
    private int hora;
    private int minutos;
    private int segundos;
    
    public Reloj() {
        setHora(0);
        setMinutos(0);
        setSegundos(0);
    }
    
    public Reloj(int hora) {
        this(hora, 0, 0);
    }
    
    public Reloj(int hora, int minutos) {
        this(hora, minutos, 0);
    }
    
    public Reloj(int hora, int minutos, int segundos) {
        setHora(hora);
        setMinutos(minutos);
        setSegundos(segundos);
    }
    
    public final void setHora(int hora) {
        this.hora = ((hora >= 0 && hora < 24) ? hora : 0);
    }
    
    public final void setMinutos(int minutos) {
        this.minutos = ((minutos >= 0 && minutos < 60) ? minutos : 0);
    }
    
    public final void setSegundos(int segundos) {
        this.segundos = ((segundos >= 0 && segundos < 60) ? segundos : 0);
    }
    
    public int getHora() {
        return hora;
    }
    
    public int getMinutos() {
        return minutos;
    }
    
    public int getSegundos() {
        return segundos;
    }
    
    public void incrementarSegundo() {
        if ((segundos++) >= 60) {
            segundos = (segundos++)%60;
            incrementarMinuto();
                  
        } else {
            segundos++;
        }
    }
    
    public void incrementarSegundo(int segundos) {
        if ((this.segundos + segundos) >= 60) {
            this.segundos = (this.segundos + segundos)%60;
            minutos++;
            if (minutos >= 60) {
                minutos%=60;
                this.hora++;
            }
        } else {
            this.segundos += segundos;
        }
    }
    
    public void incrementarMinuto() {
        if ((minutos++) >= 60) {
            incrementarHora();
            minutos = (minutos++)%60;
        } else {
            minutos++;
        }
    }
    
    public void incrementarMinuto(int minutos) {
        if ((this.minutos + minutos) >= 60) {
            hora++;
            this.minutos = (this.minutos + minutos)%60;
        } else {
            this.minutos += minutos;
        }
    }
    
    public void incrementarHora() {
        hora++;
    }
    
    public void incrementarHora(int horas) {
        hora += horas;
    }
    
    public String darFormatoNumeros(int numero) {
      String numeroFormateado; 
      if (numero >= 0 && numero < 10) {
          numeroFormateado = "0" + numero;
      } else {
          numeroFormateado = numero + "";
      }
      return numeroFormateado;
    }
    
    @Override
    public String toString() {
        String caracter;
        if (segundos%2 == 0) {
            caracter = ":";
            
        } else {
            caracter = " ";
        }
        
        return ((hora == 12 || hora == 0) ? 12: darFormatoNumeros(hora%12))
                    + caracter + ((minutos >= 10 && minutos < 60) ? minutos: 
                    darFormatoNumeros(minutos%60)) + caracter + 
                    ((segundos >= 10 && segundos < 60) ? segundos :
                    darFormatoNumeros(segundos%60)) +
                    (hora < 12 ? " AM" : " PM" );
        
    }
}