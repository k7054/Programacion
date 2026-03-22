package b200algoritmica;

import java.util.Scanner;

public class E238ConectaCuatro {
    public static final int[][] matriz = new int[6][7];

    public static int ganador(int fil, int col) {
        int contadorVer = 1;
        for (int f = fil + 1; f < matriz.length; f++) {
            if (matriz[f][col] == matriz[fil][col]) {
                contadorVer++;
            } else {
                break;
            }
        }

        if (contadorVer >= 4) {
            return matriz[fil][col];
        }

        int contadorHor = 1;
        for (int c = col + 1; c < matriz[0].length; c++) {
            if (matriz[fil][c] == matriz[fil][col]) {
                contadorHor++;
            } else {
                break;
            }
        }

        for (int c = col - 1; c >= 0; c--) {
            if (matriz[fil][c] == matriz[fil][col]) {
                contadorHor++;
            } else {
                break;
            }
        }

        if (contadorHor >= 4) {
            return matriz[fil][col];
        }

        int contadorDiag1 = 1;
        for (int f = fil + 1, c = col + 1; f < matriz.length && c < matriz[0].length; f++, c++) {
            if (matriz[f][c] == matriz[fil][col]) {
                contadorDiag1++;
            } else {
                break;
            }
        }

        for (int f = fil - 1, c = col - 1; f >= 0 && c >= 0; f--, c--) {
            if (matriz[f][c] == matriz[fil][col]) {
                contadorDiag1++;
            } else {
                break;
            }
        }

        if (contadorDiag1 >= 4) {
            return matriz[fil][col];
        }

        int contadorDiag2 = 1;
        for (int f = fil + 1, c = col - 1; f < matriz.length && c >= 0; f++, c--) {
            if (matriz[f][c] == matriz[fil][col]) {
                contadorDiag2++;
            } else {
                break;
            }
        }

        for (int f = fil - 1, c = col + 1; f >= 0 && c < matriz[0].length; f--, c++) {
            if (matriz[f][c] == matriz[fil][col]) {
                contadorDiag2++;
            } else {
                break;
            }
        }

        if (contadorDiag2 >= 4) {
            return matriz[fil][col];
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

        int[] fichasColumna = new int[matriz[0].length];

        int jugadorActual = 2;
        int resultado;

        do {
            jugadorActual = 3 - jugadorActual;

            int fila;
            int columna;

            do {
                System.out.printf("Turno jugador %d:\n", jugadorActual);
                System.out.println("Columna: ");
                columna = entrada.nextInt();
            } while (columna >= matriz[0].length || columna < 0 || fichasColumna[columna] >= matriz[0].length);

            fila = (matriz.length - 1) - fichasColumna[columna];
            matriz[fila][columna] = jugadorActual;
            fichasColumna[columna]++;

            mostrarTablero();
            System.out.println();

            resultado = ganador(fila, columna);

        } while (resultado == 0 && !tableroLleno());

        if (resultado == 1) {
            System.out.println("¡Ha ganado el jugador 1!");
        } else if (resultado == 2) {
            System.out.println("¡Ha ganado el jugador 2!");
        } else {
            System.out.println("¡Empate!");
        }
    }
}
