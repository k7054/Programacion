package b400ooavanzada.E430GlobosConJugadoresMixtos;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Jugador j1 = new JugadorCpu("Fulanito");
        Jugador j2 = new JugadorCpu("Menganita");
        Jugador jugadorActual = j1;

        for (int ronda = 1; ronda <= 5; ronda++) {
            System.out.printf(
                    "\n\n\nRONDA %d -- %s %d victorias, %s %d victorias\n\n",
                    ronda,
                    j1,
                    j2
            );

            Globo globo = new Globo();
            System.out.println(globo);

            do {
                int soplo = jugadorActual.determinarSoplo();
                System.out.printf("\n%s sopla %d\n", jugadorActual, soplo);
                globo.inflar(soplo);
                System.out.println(globo);
                jugadorActual = (jugadorActual == j1) ? j2 : j1;
            } while (!globo.explotado());

            jugadorActual.incrementarVictorias();
        }

        Jugador ganador = (j1.compareTo(j2) > 0) ? j1 : j2;

        System.out.printf("\n\n\n¡¡¡Ha ganado %s!!!", ganador);


        //        int cantidadGlobos = 5;
        //        Globo[] globos = new Globo[cantidadGlobos];
        //        int globoActual = 0;
        //
        //        int victoriasJ1 = 0, victoriasJ2 = 0;
        //        int jugadorActual = 1;
        //
        //        System.out.println("Bienvenido al juego de los globos explosivos");
        //
        //        do { // Rondas
        //            globos[globoActual] = new Globo();
        //
        //            do { // Soplidos
        //                System.out.printf("J1 " + "v ".repeat(victoriasJ1) + "· ".repeat(3 - victoriasJ1) + "      TURNO: J%d      " + "J2 " + "v ".repeat(victoriasJ2) + "· ".repeat(3 - victoriasJ2) + "\n", jugadorActual);
        //
        //                System.out.println(globos[globoActual]);
        //
        //                System.out.println("Introduce la cantidad que quieres inflar: ");
        //                int cantidadInflar = teclado.nextInt();
        //                while (cantidadInflar <= 0) {
        //                    System.out.println("No puedes soplar 0 ó menos");
        //                    cantidadInflar = teclado.nextInt();
        //                }
        //
        //                globos[globoActual].inflar(cantidadInflar);
        //
        //                jugadorActual = jugadorActual == 1 ? 2 : 1; // Alterna el jugador.
        //
        //                if (globos[globoActual].explotado()) {
        //                    System.out.println("¡Explotó!");
        //                    System.out.println(globos[globoActual]);
        //
        //                    if (jugadorActual == 1) victoriasJ1++;
        //                    else victoriasJ2++; // Victoria para el jugador que NO soplaba (acabamos de alternar).
        //                }
        //            } while (!globos[globoActual].explotado());
        //
        //            globoActual++;
        //        } while (victoriasJ1 < cantidadGlobos/2 && victoriasJ2 < cantidadGlobos/2);
        //
        //        // Ya se ha cambiado el jugador pero es correcto, ya que acaba de explotar
        //        // un globo y habrá ganado el jugador al que NO le ha explotado el globo.
        //        System.out.printf("Ha ganado el jugador %d\n", jugadorActual);
    }
}