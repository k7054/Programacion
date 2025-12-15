package b900programame;

import java.util.Scanner;

public class E907Coetaneos751 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int casos = entrada.nextInt();

        for (int i = 0; i < casos; i++) {
            int nacimientoA = entrada.nextInt();
            int muerteA = entrada.nextInt();

            int nacimientoB = entrada.nextInt();
            int muerteB = entrada.nextInt();

            if (nacimientoA < 1 || nacimientoA > 1900 || muerteA - nacimientoA > 100 ||
                    nacimientoB < 1 || nacimientoB > 1900 || muerteB - nacimientoB > 100) {
                break;
            }

            int inicioCoincidencia = 0;

            if (nacimientoA > nacimientoB) inicioCoincidencia = nacimientoA;
            else                           inicioCoincidencia = nacimientoB;

            int finCoincidencia = 0;

            if (muerteA < muerteB) finCoincidencia = muerteA;
            else                   finCoincidencia = muerteB;

            int numAnios = 0;
            if (inicioCoincidencia <= finCoincidencia) {
                numAnios = finCoincidencia - inicioCoincidencia + 1;
            }

            System.out.println(numAnios);
        }
    }
}
