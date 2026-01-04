package b200algoritmica;

import java.util.Arrays;
import java.util.Scanner;

public class E220DesplazamientoCircular {
    private static int[] arrayNums = {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println(Arrays.toString(arrayNums));

        char derIzqSalir;

        do {
            System.out.println("Introduce i para izquierda o d para derecha, o x para salir.");
            derIzqSalir = entrada.next().charAt(0);
        } while (derIzqSalir != 'i' && derIzqSalir != 'd' && derIzqSalir != 'x');

        do {
            int numSaltos;

            do {
                System.out.println("Dime cuántos saltos quieres hacer en esa dirección (mínimo 1).");
                numSaltos = entrada.nextInt();
            } while (numSaltos < 1);

            if (derIzqSalir == 'd') {
                for (int i = 0; i < numSaltos % arrayNums.length; i++) {
                    int numAlmacenado = arrayNums[arrayNums.length - 1];

                    for (int posicion = arrayNums.length - 1; posicion > 0; posicion--) {
                        arrayNums[posicion] = arrayNums[posicion - 1];
                    }

                    arrayNums[0] = numAlmacenado;
                }

                System.out.println(Arrays.toString(arrayNums));

            } else if (derIzqSalir == 'i') {
                for (int i = 0; i < numSaltos % arrayNums.length; i++) {
                    int numAlmacenado = arrayNums[0];

                    for (int posicion = 0; posicion < arrayNums.length - 1; posicion++) {
                        arrayNums[posicion] = arrayNums[posicion + 1];
                    }

                    arrayNums[arrayNums.length - 1] = numAlmacenado;
                }

                System.out.println(Arrays.toString(arrayNums));
            }

            do {
                System.out.println("Introduce i para izquierda o d para derecha, o x para salir.");
                derIzqSalir = entrada.next().charAt(0);
            } while (derIzqSalir != 'i' && derIzqSalir != 'd' && derIzqSalir != 'x');

        } while (derIzqSalir == 'i' || derIzqSalir == 'd');
    }
}
