package b300oobasica.E302ContadorCompletoEqualsClone;

public class Contador {
    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final int POR_DEFECTO = 50;

    private int valor = 0;
    private String etiqueta = "unidades";

    public Contador() {
        setValor(MIN);
        setEtiqueta(etiqueta);
    }

    public Contador(int valor) {
        setValor(valor);
    }

    public Contador(String etiqueta) {
        setEtiqueta(etiqueta);
    }

    public Contador(int valor, String etiqueta) {
        setValor(valor);
        setEtiqueta(etiqueta);
    }

    public String toString() {
        return "Valgo " + valor + " " + etiqueta;
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

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String nuevaEtiqueta) {
        etiqueta = nuevaEtiqueta;
    }

    public void resetear() {
        setValor(POR_DEFECTO);
    }

    public void incrementar() {
        setValor(valor + 1);
    }

    public void incrementar(int incremento) {
        setValor(valor + incremento);
    }

    public void decrementar() {
        setValor(valor - 1);
    }

    public void decrementar(int decremento) {
        setValor(valor - decremento);
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Contador)) return false;

        Contador otro = (Contador) obj;
        return this.valor == otro.valor;
    }

    public Contador clone() {
        return new Contador(this.valor, this.etiqueta);
    }
}
