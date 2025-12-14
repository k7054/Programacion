package b900programame;

import java.util.Scanner;

public class E912Checkmult750 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            int num = entrada.nextInt();
            if (num == 0) break;

            int ceros = 0;
            int multiplicacion;

            while (num > 9) {
                int digito;
                multiplicacion = 1;
                while (num > 0) {
                    digito = num % 10;
                    num = num / 10;
                    if (digito == 0) {
                        ceros++;
                    } else {
                        multiplicacion = multiplicacion * digito;
                    }
                }
                num = multiplicacion;
            }
            System.out.println();
            System.out.printf("%d%d\n", num, ceros);
        }
    }
}
