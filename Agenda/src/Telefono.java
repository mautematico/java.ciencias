import java.util.*;

/**
 *
 */
public class Telefono {

    private String numero;
    private int tipo;

    public Telefono(String numero, int tipo) {
        if (0 <= tipo && tipo <= 3) {
            this.tipo = tipo;
        } else {
            this.tipo = 0;
        }
        this.numero = numero;
    }

    public Telefono(String numero) {
        this(numero, 0);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        switch (tipo) {
            case 1:
                return "Celular: " + numero + "\n";
            case 2:
                return "Casa: " + numero+ "\n";
            case 3:
                return "Oficina: " + numero+ "\n";
            default:
                return "Otro: " + numero+ "\n";
        }

    }

}
