package b900programame;

import java.util.Scanner;

public class E920PruebasYoda430 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            int p = entrada.nextInt();
            if (p == 0) break;

            int dia = 0;

            for (int i = 0; i < p; i++) {
                int d = entrada.nextInt();
                int n = entrada.nextInt();

                while (dia >= d) {
                    d = d + n;
                }

                dia = d;
            }

            System.out.println(dia);
        }
    }
}
