package b200algoritmica.E236TresEnRayaComprobarUltimaPos;

public class Tablero {
    private static int[][] matriz = new int[3][3];
    private static int jugadorActual = 1;
    private static int ultimaPosMarcadaFil = -1;
    private static int ultimaPosMarcadaCol = -1;
    private static int casillasMarcadas = 0;

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
        ultimaPosMarcadaFil = fil;
        ultimaPosMarcadaCol = col;
        casillasMarcadas++;
    }

    public static int getJugadorActual() {
        return jugadorActual;
    }

    public static void alternarJugador() {
        jugadorActual = 3 - jugadorActual;
    }

    public static int buscarGanador() {
        // Si aún no se ha marcado ninguna casilla, no hay ganador ni tablas
        if (ultimaPosMarcadaFil == -1) {
            return -1;
        }

        int f = ultimaPosMarcadaFil;
        int c = ultimaPosMarcadaCol;
        int jugador = matriz[f][c];

        // Comprobar fila de la última casilla marcada
        if (matriz[f][0] == jugador && matriz[f][1] == jugador && matriz[f][2] == jugador) {
            return jugador;
        }

        // Comprobar columna de la última casilla marcada
        if (matriz[0][c] == jugador && matriz[1][c] == jugador && matriz[2][c] == jugador) {
            return jugador;
        }

        // Comprobar diagonal principal solo si la casilla pertenece a ella
        if (f == c) {
            if (matriz[0][0] == jugador && matriz[1][1] == jugador && matriz[2][2] == jugador) {
                return jugador;
            }
        }

        // Comprobar diagonal secundaria solo si la casilla pertenece a ella
        if (f + c == 2) {
            if (matriz[0][2] == jugador && matriz[1][1] == jugador && matriz[2][0] == jugador) {
                return jugador;
            }
        }

        // Comprobar tablas: si se han marcado las 9 casillas y no hay ganador
        if (casillasMarcadas == 9) {
            return 0;
        }

        // Todavía quedan casillas libres y no hay ganador
        return -1;
    }
}