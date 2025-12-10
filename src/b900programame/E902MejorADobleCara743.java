package b900programame;

import java.util.Scanner;

public class E902MejorADobleCara743 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int documentos;

        while (true) {
            documentos = entrada.nextInt();
            if (documentos == 0) break;

            int hojasAhorradas = 0;

            for (int i = 0; i < documentos; i++) {
                int numPaginas = entrada.nextInt();
                int hojasDobles = (numPaginas + 1) / 2;
                hojasAhorradas = hojasAhorradas - hojasDobles;
            }

            System.out.println(hojasAhorradas);
        }
    }
}
