package b300oobasica.E322GlobosExplosivosFase3ConArrayList;

import java.util.Random;

public class Globo {
    private static final int CAPACIDAD_MIN = 10;
    private static final int CAPACIDAD_MAX = 50;

    private Random numRandom = new Random();
    private int capacidad = 0;
    private int cantidadAire = 0;

    public Globo() {
        this.capacidad = numRandom.nextInt(CAPACIDAD_MIN, CAPACIDAD_MAX + 1);
    }

    public Globo(int capacidad) {
        setCapacidad(capacidad);
    }

    public String toString() {
        StringBuilder cadena = new StringBuilder();

        if (!estaExplotado()) {
            cadena.append("*".repeat(cantidadAire));
            cadena.append("O".repeat(capacidad - cantidadAire));
        } else {
            cadena.append("!".repeat(capacidad));
        }

        return cadena.toString();
    }

    private void setCapacidad(int capacidad) {
        if (capacidad < CAPACIDAD_MIN)      this.capacidad = CAPACIDAD_MIN;
        else if (capacidad > CAPACIDAD_MAX) this.capacidad = CAPACIDAD_MAX;
        else                                this.capacidad = capacidad;
    }

    public void inflarGlobo(int cantidad) {
        cantidadAire = cantidadAire + cantidad;
    }

    public boolean estaExplotado() {
        return this.cantidadAire > this.capacidad;
    }
}
