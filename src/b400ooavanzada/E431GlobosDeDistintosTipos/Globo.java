package b400ooavanzada.E431GlobosDeDistintosTipos;

import java.util.Random;

public abstract class Globo {
    public static final int RANDOM_MIN = 10;
    public static final int RANDOM_MAX = 50;

    private Random random = new Random();
    protected int capacidad;
    protected int aire = 0;

    public Globo() {
        this.capacidad = random.nextInt(RANDOM_MIN, RANDOM_MAX+1);
    }

    public Globo(int valor) {
        this.capacidad = valor;
    }

    public String toString() {
        StringBuilder cadena = new StringBuilder();

        for (int i = 0; (i < aire) && (i < capacidad); i++) {
            cadena.append("*");
        }
        for (int i = aire; i < capacidad; i++) {
            cadena.append("O");
        }
        for (int i = capacidad; i < aire; i++) {
            cadena.append("!");
        }

        return cadena.toString();
    }

    public void inflar(int cantidad) {
        aire = aire + cantidad;
    }

    public abstract boolean explotado();
}
