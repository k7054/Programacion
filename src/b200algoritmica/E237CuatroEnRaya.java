package b200algoritmica;

import java.util.Scanner;

public class E237CuatroEnRaya {
    public static final int[][] matriz = new int[4][4];

    public static int ganador() {
        for (int f = 0; f < matriz.length; f++) {
            if (matriz[f][0] == matriz[f][1] && matriz[f][1] == matriz[f][2] && matriz[f][2] == matriz[f][3] && matriz[f][0] != 0) {
                return matriz[f][0];
            }
        }

        for (int c = 0; c < matriz.length; c++) {
            if (matriz[0][c] == matriz[1][c] && matriz[1][c] == matriz[2][c] && matriz[2][c] == matriz[3][c] && matriz[0][c] != 0) {
                return matriz[0][c];
            }
        }

        if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[2][2] == matriz[3][3] && matriz[0][0] != 0) {
            return matriz[0][0];
        }

        if (matriz[0][3] == matriz[1][2] && matriz[1][2] == matriz[2][1] && matriz[2][1] == matriz[3][0] && matriz[0][3] != 0) {
            return matriz[0][3];
        }

        return 0;
    }

    public static boolean tableroLleno() {
        for (int fil = 0; fil < matriz.length; fil++) {
            for (int col = 0; col < matriz[fil].length; col++) {
                if (matriz[fil][col] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void mostrarTablero() {
        for (int fil = 0; fil < matriz.length; fil++) {
            for (int col = 0; col < matriz[fil].length; col++) {
                if (matriz[fil][col] == 1) {
                    System.out.print("[X]");
                } else if (matriz[fil][col] == 2) {
                    System.out.print("[O]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

   public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        mostrarTablero();

        int jugadorActual = 2;
        int resultado;

        do {
            jugadorActual = 3 - jugadorActual;

            int fila;
            int columna;

            do {
                System.out.printf("Turno jugador %d:\n", jugadorActual);
                System.out.println("Fila: ");
                fila = entrada.nextInt();
                System.out.println("Columna: ");
                columna = entrada.nextInt();
            } while (fila >= matriz.length || columna >= matriz.length || fila < 0 || columna < 0);

            matriz[fila][columna] = jugadorActual;

            mostrarTablero();
            System.out.println();

            resultado = ganador();

            if (resultado == 1) {
                System.out.println("¡Ha ganado el jugador 1!");
            } else if (resultado == 2) {
                System.out.println("¡Ha ganado el jugador 2!");
            }

        } while (resultado == 0);
    }
}
