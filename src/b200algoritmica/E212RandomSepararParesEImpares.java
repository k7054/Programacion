package b200algoritmica;

import java.util.Arrays;
import java.util.Random;

public class E212RandomSepararParesEImpares {
    public static void main(String[] args) {
        int[] todos = new int[20];
        int cantidadPares = 0;
        int cantidadImpares = 0;
        int posPares = 0;
        int posImpares = 0;

        Random numerosRandom = new Random();

        for (int i = 0; i < todos.length; i++) {
            todos[i] = numerosRandom.nextInt(100) + 1;
        }

        for (int i = 0; i < todos.length; i++) {
            if (todos[i] % 2 == 0) cantidadPares++;
            else                   cantidadImpares++;
        }

        int[] pares = new int[cantidadPares];
        int[] impares = new int[cantidadImpares];

        for (int i = 0; i < todos.length; i++) {
            if (todos[i] % 2 == 0) {
                pares[posPares] = todos[i];
                posPares++;
            } else {
                impares[posImpares] = todos[i];
                posImpares++;
            }
        }

        System.out.println(Arrays.toString(pares));
        System.out.println(Arrays.toString(impares));
    }
}
