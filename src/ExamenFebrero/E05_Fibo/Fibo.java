package ExamenFebrero.E05_Fibo;

public class Fibo {
    // TODO Implementa aquí lo que se pide
    private int numAnterior = 0;
    private int numActual   = 1;
    private int numSiguiente;

    public Fibo() {
    }

    public String toString() {
        return "" + numSiguiente;
    }

    public int obtenerSiguiente() {
        if (numAnterior == 0 && numActual == 1) {

        }

        numSiguiente = numAnterior + numActual;
        numAnterior = numActual;
        numActual = numSiguiente;
        return numSiguiente;
    }
}
