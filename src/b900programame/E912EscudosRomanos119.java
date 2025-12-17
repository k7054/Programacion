package b900programame;

import java.util.Scanner;

public class E912EscudosRomanos119 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int numLegionarios = entrada.nextInt();

        while (numLegionarios != 0) {
            int escudosTotales = 0;

            while (numLegionarios > 0) {
                int lado = (int) Math.sqrt(numLegionarios);
                int cabezas = lado * lado; // Cuántos legionarios hay en esta formación.

                escudosTotales = escudosTotales + cabezas + (4 * lado);

                numLegionarios = numLegionarios - cabezas;
            }

            System.out.println(escudosTotales);

            numLegionarios = entrada.nextInt();
        }
    }
}
