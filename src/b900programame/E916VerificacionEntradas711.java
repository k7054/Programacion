package b900programame;

import java.util.Scanner;

public class E916VerificacionEntradas711 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int casos = entrada.nextInt();

        for (int i = 0; i < casos; i++) {
            String num = entrada.next();
            int suma = 0;

            for (int j = 0; j < num.length(); j++) {
                int digito = num.charAt(j) - '0';

                // posición impar
                if (j % 2 == 0) {
                    int menor = 9;
                    for (int k = j + 1; k < num.length(); k++) {
                        int d = num.charAt(k) - '0';
                        if (d < menor) menor = d;
                    }
                    suma = suma + digito * 3 + menor;
                }
                // posición par
                else {
                    int mayor = 0;
                    for (int k = 0; k < j; k++) {
                        int d = num.charAt(k) - '0';
                        if (d > mayor) mayor = d;
                    }
                    suma = suma + digito * 2 + mayor;
                }
            }

            System.out.println(suma);
        }
    }
}
