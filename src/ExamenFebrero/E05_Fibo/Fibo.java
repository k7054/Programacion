package ExamenFebrero.E05_Fibo;

public class Fibo {
    // TODO Implementa aquí lo que se pide
    private int numAnterior = -1;
    private int numActual   = 1;
    private int numSiguiente;

    public Fibo() {
    }

    public String toString() {
        return "" + numSiguiente;
    }

    public int obtenerSiguiente() {
        numSiguiente = numAnterior + numActual;
        numAnterior = numActual;
        numActual = numSiguiente;
        return numSiguiente;
    }
}
