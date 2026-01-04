package b200algoritmica;

import java.util.Arrays;

public class E214EscannosDHondt {
    public static void main(String[] args) {
        int[] votos = {1463183, 1004599, 557780, 506164, 21742, 7652, 6749, 3784, 3407, 2902, 1751}; // Generales 2023 al Congreso, circunscripción de Madrid.
        int[] divisores = new int[votos.length];
        int[] escannos = new int[votos.length];
        int numEscannos = 37; // Los escaños que hay que repartir en esta circunscripción.
        int totalGeneralDeVotos = 0;
        int numPartidos = votos.length;

        for (int voto : votos) {
            totalGeneralDeVotos = totalGeneralDeVotos + voto;
        }

        for (int i = 0; i < divisores.length; i++) {
            divisores[i] = 1;
        }

        int[] numVotos = new int[numPartidos];

        for (int numEscanno = 0; numEscanno < numEscannos; numEscanno++) {
            int mayorNumVotos = Integer.MIN_VALUE;
            int indicePartidoProxEscanno = 0;

            for (int numPartido = 0; numPartido < numPartidos; numPartido++) {
                numVotos[numPartido] = votos[numPartido] / divisores[numPartido];

                if (numVotos[numPartido] > mayorNumVotos) {
                    mayorNumVotos = numVotos[numPartido];
                    indicePartidoProxEscanno = numPartido;
                }
            }

            escannos[indicePartidoProxEscanno]++;
            divisores[indicePartidoProxEscanno]++;
        }

        System.out.println(Arrays.toString(escannos));
    }
}
