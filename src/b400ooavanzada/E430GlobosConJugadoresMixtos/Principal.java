package b400ooavanzada.E430GlobosConJugadoresMixtos;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("GLOBOS EXPLOSIVOS — Selección de modo");
        System.out.println("  1. Humano vs Humano  (HH)");
        System.out.println("  2. Humano vs CPU     (HC)");
        System.out.println("  3. CPU    vs Humano  (CH)");
        System.out.println("  4. CPU    vs CPU     (CC)");
        System.out.print("Elige una opción (1-4): ");

        int opcion = 0;
        while (opcion < 1 || opcion > 4) {
            if (teclado.hasNextInt()) {
                opcion = teclado.nextInt();
            } else {
                teclado.next();
            }
            if (opcion < 1 || opcion > 4) {
                System.out.print("Opción no válida. Elige entre 1 y 4: ");
            }
        }

        Jugador j1;
        Jugador j2;

        switch (opcion) {
            case 1:
                j1 = new JugadorHumano("J1", teclado);
                j2 = new JugadorHumano("J2", teclado);
                break;
            case 2:
                j1 = new JugadorHumano("J1", teclado);
                j2 = new JugadorCpu("J2");
                break;
            case 3:
                j1 = new JugadorCpu("J1");
                j2 = new JugadorHumano("J2", teclado);
                break;
            default:
                j1 = new JugadorCpu("J1");
                j2 = new JugadorCpu("J2");
                break;
        }

        Juego juego = new Juego(j1, j2);
        juego.jugar();

        teclado.close();
    }
}
