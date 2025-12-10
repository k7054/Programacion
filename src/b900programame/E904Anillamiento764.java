package b900programame;

import java.util.Scanner;

public class E904Anillamiento764 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int campanias;

        while (true){
            campanias = entrada.nextInt();
            if (campanias == 0) break;
            int totalCapturadas = 0;

            for (int i = 0; i < campanias; i++) {
                int avesCapturadas = entrada.nextInt();
                int avesAnilladas = entrada.nextInt();
                totalCapturadas = totalCapturadas + (avesCapturadas - avesAnilladas);
            }

            System.out.println(totalCapturadas);
        }
    }
}
