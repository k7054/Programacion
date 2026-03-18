package b400ooavanzada.E430GlobosConJugadoresMixtos;

import java.util.Scanner;

public class JugadorHumano extends Jugador {

    private Scanner teclado;

    public JugadorHumano(String nombre, Scanner teclado) {
        super(nombre);
        this.teclado = teclado;
    }

    @Override
    public int determinarSoplo() {
        System.out.print(getNombre() + ", ¿cuánto aire soplas? ");
        int cantidad = teclado.nextInt();
        while (cantidad <= 0) {
            System.out.print("Debes soplar al menos 1. Inténtalo de nuevo: ");
            cantidad = teclado.nextInt();
        }
        return cantidad;
    }
}
