package b300oobasica.E300ContadorBasico;

public class Contador {
    private static final int MIN = 0;
    private static final int MAX = 100;

    private int valor = 0;
    private String etiqueta;

    public int getValor() {
        return valor;
    }

    public void setValor(int nuevoValor) {
        if (valor <= MIN)      valor = MIN;
        else if (valor >= MAX) valor = MAX;
        else                   valor = nuevoValor;

        //valor = Math.min(Math.max(nuevoValor, 0), 100);
    }

    public void incrementar() {
        if (valor < MAX) valor++;
    }

    public void decrementar() {
        if (valor > MIN) valor--;
    }
}
