package b200algoritmica;

import java.util.Arrays;

public class E210EliminarDuplicados {
    public static void main(String[] args) {
        int[] numeros = {8, 10, 4, 10, 8, 5, 5, 10, 17, 2};

        int contadorNoDuplicados = 0;
        boolean repetido;
        for (int i = 0; i < numeros.length; i++) {
            repetido = false;
            for (int j = 0; j < i; j++) {
                if (numeros[i] == numeros[j]) {
                    repetido = true;
                    break;
                }
            }

            if (!repetido) contadorNoDuplicados++;
        }

        int[] numerosNoDuplicados = new int[contadorNoDuplicados];
        int posicion = 0;

        for (int i = 0; i < numeros.length; i++) {
            repetido = false;
            for (int j = 0; j < i; j++) {
                if (numeros[i] == numeros[j]) {
                    repetido = true;
                    break;
                }
            }

            if (!repetido) {
                numerosNoDuplicados[posicion] = numeros[i];
                posicion++;
            }
        }

        System.out.println(Arrays.toString(numerosNoDuplicados));
    }
}
