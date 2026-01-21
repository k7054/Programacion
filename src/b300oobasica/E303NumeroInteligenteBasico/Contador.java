package b300oobasica.E303NumeroInteligenteBasico;

public class Contador {
    private static final int POR_DEFECTO = 1;

    private int valor = 0;
    private int numeroPerfecto = 0;

    public Contador() {
        setValor(POR_DEFECTO);
    }

    public Contador(int valor) {
        setValor(valor);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int nuevoValor) {
        valor = nuevoValor;
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

    public boolean esPrimo() {
        if (valor == 1) return false;

        int limite = (int) Math.sqrt(valor);

        for (int i = 2; i <= limite; i++) {
            if (valor % i == 0) return false;
        }

        return true;
    }

    public boolean esPrimo(int numero) {
        if (numero == 1) return false;

        int limite = (int) Math.sqrt(numero);

        for (int i = 2; i <= limite; i++) {
            if (numero % i == 0) return false;
        }

        return true;
    }

    public int getPerfecto() {
        return numeroPerfecto;
    }

    //Utilizamos la formula de Euclides (2^{n-1} * (2^{n} - 1)),
    // siempre que (2^{n} - 1) sea primo de Mersenne.
    public boolean esPerfecto() {
        int numMersenne = (int) Math.pow(2, valor) - 1;

        if (esPrimo(numMersenne)) {
            numeroPerfecto = numMersenne * (int) Math.pow(2, valor - 1);
            return true;
        }

        return false;
    }
}
