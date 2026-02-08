package b300oobasica.E322GlobosExplosivosFase3ConArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int cantidadGlobos = 5;
        ArrayList<Globo> globos = new ArrayList<>();

        int victoriasJ1 = 0;
        int victoriasJ2 = 0;

        do {
            Globo globoActual = new Globo();
            System.out.printf("Jugador 1: %d-%d :Jugador 2\n", victoriasJ1, victoriasJ2);

            int jugadorActual = 1;

            do {
                System.out.printf("Turno jugador %d:\n", jugadorActual);
                int inflar = entrada.nextInt();

                while (inflar <= 0) {
                    System.out.println("No puedes inflar 0 o menor que 0");
                    inflar = entrada.nextInt();
                }

                globoActual.inflarGlobo(inflar);
                System.out.println("\n".repeat(10));

                jugadorActual = jugadorActual == 1 ? 2 : 1;
            } while (!globoActual.estaExplotado());

            System.out.println(globoActual);
            System.out.printf("¡BOOOM!, ha ganado el jugador %d\n", jugadorActual);

            if (jugadorActual == 1) {
                victoriasJ1++;
            } else {
                victoriasJ2++;
            }

            globos.add(globoActual);

        } while (victoriasJ1 < 3 && victoriasJ2 < 3);

        System.out.printf("Jugador 1: %d-%d :Jugador 2\n", victoriasJ1, victoriasJ2);

        if (victoriasJ1 > victoriasJ2) {
            System.out.println("Ha ganado el jugador 1");
        } else {
            System.out.println("Ha ganado el jugador 2");
        }

        for (int i = 0; i < globos.size(); i++) {
            System.out.printf("Globo %d: ", i + 1);
            System.out.println(globos.get(i));
        }
    }
}
