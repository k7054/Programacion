package b400ooavanzada.E404FigurasComparables;

import java.util.Arrays;

public class Principal {
    static void main(String[] args) {
        int[] numeros = new int[] {7, 4, 2, 3, 1};
        Figura[] figuras = new Figura[3];
        figuras[0] = new Circulo(8.27);
        figuras[1] = new Rectangulo(7.1, 5.0);
        figuras[2] = new Cuadrado(10.0);

        Arrays.sort(numeros);
        Arrays.sort(figuras);

        for (int numero : numeros) {
            System.out.println(numero);
        }
        System.out.println();

        for (Figura figura : figuras) {
            System.out.println(figura);
        }
    }
}