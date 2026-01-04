package b200algoritmica;

import java.util.Arrays;

public class E208FibonacciN {
    public static final int N = 4; // El "tipo" de serie de Fibonacci, es decir, con cuántos números fijos comenzamos y cuántos sumamos cada vez.
    public static final int HASTA = 30; // Cuántos valores de esta serie queremos ver en la pantalla, en total.

    public static void main(String[] args) {
        int[] numeros = new int[HASTA];

        numeros[N - 1] = 1;

        for (int i = N; i < numeros.length; i++) {
            int suma = 0;

            for (int j = i - 1; j >= i - N; j--) {
                suma = suma + numeros[j];
            }

            numeros[i] = suma;
        }

        System.out.println(Arrays.toString(numeros));
    }
}
