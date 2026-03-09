package b200algoritmica.E231TresEnRayaCasiOO;

public class Tablero {
    private static int[][] matriz = new int[3][3];
    private static int jugadorActual = 1;

    public static void dibujar() {
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

    public static void marcar(int fil, int col) {
        matriz[fil][col] = jugadorActual;
    }

    public static int getJugadorActual() {
        return jugadorActual;
    }

    public static void alternarJugador() {
        jugadorActual = 3 - jugadorActual;
    }

    public static int buscarGanador() {
        for (int f = 0; f < matriz.length; f++) {
            if (matriz[f][0] == matriz[f][1] && matriz[f][1] == matriz[f][2] && matriz[f][0] != 0) {
                return matriz[f][0];
            }
        }

        for (int c = 0; c < matriz.length; c++) {
            if (matriz[0][c] == matriz[1][c] && matriz[1][c] == matriz[2][c] && matriz[0][c] != 0) {
                return matriz[0][c];
            }
        }

        if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] != 0) {
            return matriz[0][0];
        }

        if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[2][0] != 0) {
            return matriz[2][0];
        }

        for (int fil = 0; fil < matriz.length; fil++) {
            for (int col = 0; col < matriz[fil].length; col++) {
                if (matriz[fil][col] == 0) {
                    return -1;
                }
            }
        }

        return 0;
    }
}