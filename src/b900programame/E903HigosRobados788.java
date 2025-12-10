package b900programame;

import java.util.Scanner;

public class E903HigosRobados788 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int casos = entrada.nextInt();

        for (int i = 0; i < casos; i++) {
            int numPersonas = entrada.nextInt();
            int totalHigos = entrada.nextInt();
            int repartoHigos = totalHigos % numPersonas;
            int higosManola = totalHigos / numPersonas + repartoHigos;
            System.out.println(higosManola);
        }
    }
}
