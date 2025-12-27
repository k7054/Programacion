package b900programame;

import java.util.Scanner;

public class E920CastillosDeNaipes741 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int casos = input.nextInt();
        for (int caso = 0; caso < casos; caso++) {
            int alturaDeseada = input.nextInt();
            long naipes = 0; // Long es necesario por las especificaciones que recibimos.
            for (int diagonalActual = 1; diagonalActual <= alturaDeseada; diagonalActual++) {
                naipes = naipes + diagonalActual * 3 - 1;
            }
            System.out.println(naipes);
        }
    }
}
