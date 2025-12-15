package b900programame;

import java.util.Scanner;

public class E910EntrenamientoCiclistaProgresivo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int casos = entrada.nextInt();

        for (int i = 0; i < casos; i++) {
            int kmTotales = 0;
            int kmMaximo = 0;

            while (true) {
                int kmAvanzados = entrada.nextInt();
                if (kmAvanzados == 0) break;

                kmMaximo = kmMaximo + kmAvanzados;
                kmTotales = kmTotales + (kmMaximo * 2);
            }

            System.out.println(kmTotales);
        }
    }
}
