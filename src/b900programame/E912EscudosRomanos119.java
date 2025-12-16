package b900programame;

import java.util.Scanner;

public class E912EscudosRomanos119 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            int numLegionarios = entrada.nextInt();

            if (numLegionarios == 0) break;

            int formacion = numLegionarios;
            while (true) {
                int formacionActual = (int) Math.sqrt(formacion);
                formacion = formacionActual;
                System.out.println(formacion);
                if (formacionActual == 1) break;
            }
        }
    }
}
