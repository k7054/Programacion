package b900programame;

import java.util.Scanner;

public class E970JardinesAlhambra769 {
    // Las hacemos globales para no pasarlas como parámetro en cada llamada recursiva
    public static char[][] mapa;
    public static int filas, columnas;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            filas = sc.nextInt();
            columnas = sc.nextInt();
            mapa = new char[filas][columnas];

            // Leemos el mapa fila a fila
            for (int i = 0; i < filas; i++) {
                mapa[i] = sc.next().toCharArray();
            }

            int cortacespedes = 0;

            // Recorremos todas las celdas
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    // Si encontramos un jardín, "pintamos" toda la zona
                    // y contamos un cortacésped más
                    if (mapa[i][j] == '#') {
                        rellenar(i, j);
                        cortacespedes++;
                    }
                }
            }

            System.out.println(cortacespedes);
        }

        sc.close();
    }

    // Marca como visitado ('.') todo el jardín conectado a esta celda
    static void rellenar(int f, int c) {
        // Casos base: salimos si nos salimos del mapa o no es jardín
        if (f < 0 || f >= filas) return;
        if (c < 0 || c >= columnas) return;
        if (mapa[f][c] != '#') return;

        mapa[f][c] = '.'; // Marcamos como visitado para no volver a entrar

        // Llamamos a los 4 vecinos
        rellenar(f - 1, c); // arriba
        rellenar(f + 1, c); // abajo
        rellenar(f, c - 1); // izquierda
        rellenar(f, c + 1); // derecha
    }
}
