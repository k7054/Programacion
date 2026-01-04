package b200algoritmica;

import java.util.Scanner;

public class E213Radar {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int limite = entrada.nextInt();

        while (limite > 0) {
            int puntosControl = entrada.nextInt();
            int contadorMulta = 0;

            int segundoAnterior = 0;
            int metroAnterior = 0;

            for (int i = 0; i < puntosControl; i++) {
                int segundoActual = entrada.nextInt();
                int metroActual = entrada.nextInt();

                int diferenciaSegundo = segundoActual - segundoAnterior;
                int diferenciaMetro = metroActual - metroAnterior;

                int velocidad = diferenciaMetro / diferenciaSegundo;

                if (velocidad > limite) {
                    contadorMulta++;
                }

                segundoAnterior = segundoActual;
                metroAnterior = metroActual;
            }

            if (contadorMulta == 1) {
                System.out.println("AVISO");
            } else if (contadorMulta >= 2) {
                System.out.println("MULTA");
            } else {
                System.out.println("TODO BIEN");
            }

            limite = entrada.nextInt();
        }
    }
}
