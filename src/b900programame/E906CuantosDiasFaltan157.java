package b900programame;

import java.util.Scanner;

public class E906CuantosDiasFaltan157 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] diasMes = {
                31, // Enero
                28, // Febrero
                31, // Marzo
                30, // Abril
                31, // Mayo
                30, // Junio
                31, // Julio
                31, // Agosto
                30, // Septiembre
                31, // Octubre
                30, // Noviembre
                31  // Diciembre
        };

        int casos = entrada.nextInt();

        for (int i = 0; i < casos; i++) {
            int dia = entrada.nextInt();
            int mes = entrada.nextInt();
            int diasRestantesMes = diasMes[mes - 1] - dia;

            int sumaDiasRestantesMeses = 0;

            for (int j = mes; j < diasMes.length; j++) {
                sumaDiasRestantesMeses = sumaDiasRestantesMeses + diasMes[j];
            }

            int diasRestantesNochevieja = diasRestantesMes + sumaDiasRestantesMeses;

            System.out.println(diasRestantesNochevieja);
        }
    }
}
