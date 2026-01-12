package b300oobasica.E300ContadorBasico;

public class Contador {
    private static final int MIN = 0;
    private static final int MAX = 100;

    private int valor = 0;
    private String etiqueta;

    public Contador() {
        setValor(MIN);
    }

    public Contador(int valor) {
        setValor(valor);
    }

    public String toString() {
        return "Valgo" + valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int nuevoValor) {
        if (nuevoValor < MIN)      valor = MIN;
        else if (nuevoValor > MAX) valor = MAX;
        else                   valor = nuevoValor;

        //valor = Math.min(Math.max(nuevoValor, MIN), MAX);
    }

    public void incrementar() {
        setValor(valor + 1);
    }

    public void decrementar() {
        setValor(valor - 1);
    }
}
