package b900programame;

import java.util.ArrayList;
import java.util.Scanner;

public class E928Avituallamiento122 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            ArrayList<Integer> etapa = new ArrayList<>();

            while (true) {
                int x = entrada.nextInt();
                if (x == -1) break;
                etapa.add(x);
            }

            if (etapa.isEmpty()) break;

            int tramoInicial = -1;
            int tramoActual = 0;
            int mejorInicio = -1;
            int mejorTramo = 0;

            for (int i = 0; i < etapa.size() - 1; i++) {
                if (etapa.get(i).equals(etapa.get(i + 1))) {
                    if (tramoActual == 0) {
                        tramoInicial = i;
                    }
                    tramoActual++;
                } else {
                    tramoActual = 0;
                }

                if (tramoActual > mejorTramo) {
                    mejorTramo = tramoActual;
                    mejorInicio = tramoInicial;
                }
            }

            if (mejorTramo == 0) {
                System.out.println("HOY NO COMEN");
            } else {
                System.out.println(mejorInicio + " " + mejorTramo);
            }
        }
    }
}
