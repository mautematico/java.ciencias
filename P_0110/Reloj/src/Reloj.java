/**
 * Clase que crea relojes a partir de varios constructores y métodos.
 * Arteaga Gaona, Guillermo <guillermo_ag@ciencias.unam.mx>
 * Navarro Miranda, Mauricio <mauricio@navarromiranda.mx>
 * 
 */


public class Reloj {
    
    /**
     * Variables de instancia.
     */
    private int hora;
    private int minutos;
    private int segundos;
    
    /**
     * Constructor por defecto. Crea un reloj con la hora 12:00:00 am.
     */
    public Reloj() {
        setHora(0);
        setMinutos(0);
        setSegundos(0);
    }
    
    /**
     * Constructor que recibe el valor de la hora como parámetro.
     * @param hora - Valor entero de la hora. El valor ingresado se valida a 
     * través del método setHora(), para evitar enteros inválidos. Los minutos 
     * y segundos se inicializan en cero.
     */
    public Reloj(int hora) {
        this(hora, 0, 0);
    }
    
    /**
     * Constructor que recibe la hora y los minutos como parámetros.
     * @param hora - Valor de la hora.
     * @param minutos - Valor de los minutos.
     * El valor de los segundos se inicializa en cero.
     */
    public Reloj(int hora, int minutos) {
        this(hora, minutos, 0);
    }
    
    /**
     * Constructor que recibe la hora, los minutos y los segundos como parámetro.
     * @param hora - Valor de la hora.
     * @param minutos - Valor de los minutos.
     * @param segundos  - Valor de los segundos.
     */
    public Reloj(int hora, int minutos, int segundos) {
        setHora(hora);
        setMinutos(minutos);
        setSegundos(segundos);
    }
    
    /**
     * Método que establece la hora.
     * @param hora - Recibe el valor de la hora como un entero. 
     * Se asigna el valor que recibe como parámetro si se encuentra en un rango
     * válido (entre 0 y 24). De lo contrario asigna el valor de cero.
     */
    public final void setHora(int hora) {
        this.hora = ((hora >= 0 && hora < 24) ? hora : 0);
    }
    
    /**
     * Método que establece los minutos.
     * @param minutos - Recibe el valor de los minutos como un entero.
     * Se asigna el valor que recibe como parámetro si se encuentra en un rango
     * válido (entre 0 y 60). De lo contrario asigna el valor de cero.
     */
    public final void setMinutos(int minutos) {
        this.minutos = ((minutos >= 0 && minutos < 60) ? minutos : 0);
    }
    
    /**
     * Método que establece los segundos.
     * @param segundos - Recibe el valor de los segundos como un entero.
     * Se asigna el valor que recibe como parámetro si se encuentra en un rango
     * válido (entre 0 y 60). De lo contrario asigna el valor de cero.
     */
    public final void setSegundos(int segundos) {
        this.segundos = ((segundos >= 0 && segundos < 60) ? segundos : 0);
    }
    
    /**
     * Método que devuelve el valor de la hora.
     * @return int - Regresa el valor de la hora.
     */
    public int getHora() {
        return hora;
    }
    
    /**
     * Método que devuelve el valor de los minutos.
     * @return int - Regresa el valor de los minutos.
     */
    public int getMinutos() {
        return minutos;
    }
    
    /**
     * Método que devuelve el valor de los segundos.
     * @return int - Regresa el valor e los segundos.
     */
    public int getSegundos() {
        return segundos;
    }
    
    /**
     * Método que no recibe parámetros. Incrementa en un segundo la hora actual.
     */
    public void incrementarSegundo() {
        incrementarSegundo(1);
    }
    
    /**
     * Método que incrementa la hora en la cantidad de segundos que recibe como
     * parámetro.
     * @param segundos - Valor entero que representa la cantidad de segundos.
     */
    public void incrementarSegundo(int segundos) {
        this.segundos += segundos;
        int minutos = this.segundos/60;
        
        if(minutos>0){
            incrementarMinuto(minutos);
            this.segundos %= 60;
        }
    }
    
    /**
     * Método que no recibe parámetros. Incremente en un minuto la hora actual.
     */
    public void incrementarMinuto() {
        incrementarMinuto(1);
    }
    
    /**
     * Método que incrementa la hora en la cantidad de minutos que recibe como
     * parámetro.
     * @param minutos - Valor entero que representa la cantidad de minutos.
     */
    public void incrementarMinuto(int minutos) {
        this.minutos += minutos;
        int horas = this.minutos/60;
        
        if(horas>0){
            incrementarHora(horas);
            this.minutos %= 60;
        }
    }
    
    /**
     * Método que no recibe parámetros. Incrementa el valor de la hora en 1.
     */
    public void incrementarHora() {
        incrementarHora(1);
    }
    
    /**
     * Método que incrementa el valor de la hora en el valor que recibe como 
     * parámetro.
     * @param horas - Valor entero que representa la cantidad de horas. 
     */
    public void incrementarHora(int horas) {
        this.hora = (this.hora + horas) % 24;
    }
    
    /**
     * Método que da formato a las horas, minutos y segundos menores que 10.
     * @param numero - entero al que se le da formato.
     * @return String - Regresa el entero con formato.
     */
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
    /**
     * Método toString que representa al objeto como cadena.
     * Las horas se representan en formato de 12 horas.
     */
    public String toString() {
        String caracter;
        if (segundos%2 == 0) {
            caracter = ":";
        } else {
            caracter = " ";
        }
        
        return
            ((hora == 12 || hora == 0) ? 12: darFormatoNumeros(hora%12))
            + caracter
            + ((minutos >= 10 && minutos < 60) ? minutos: darFormatoNumeros(minutos%60))
            + caracter
            + ((segundos >= 10 && segundos < 60) ? segundos : darFormatoNumeros(segundos%60))
            + (hora < 12 ? " am" : " pm" );
    }
}