package b900programame;

import java.util.Scanner;

public class E913DibujarTablerosAjedrez162 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            int tamanio = entrada.nextInt();
            if (tamanio == 0) break;

            char caracterNegro = entrada.next().charAt(0);

            for (int fila = 0; fila < tamanio * 8; fila++) {
                for (int col = 0; col < tamanio * 8; col++) {
                    int escaqueFila = fila / tamanio;
                    int escaqueCol = col / tamanio;

                    if ((escaqueFila + escaqueCol) % 2 == 1) {
                        System.out.print(caracterNegro);
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
