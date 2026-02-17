package b200algoritmica;

import java.util.Scanner;

public class E204HistogramaDeLetras {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String frase = "En un lugar de La Mancha de cuyo nombre no quiero acordarme...".toLowerCase();

        int[] caracteres = new int[26];

        for (int i = 0; i < frase.length(); i++) {
            char caracterActual = frase.charAt(i);


            if (caracterActual >= 'a' && caracterActual <= 'z') {
                int indiceCaracteres = caracterActual - 'a';
                caracteres[indiceCaracteres]++;
            }
        }

        for (int indiceCaracter = 0; indiceCaracter < caracteres.length; indiceCaracter++) {
            char caracter = (char) ('a' + indiceCaracter);
            System.out.printf("%s: ", caracter);
            for (int asteriscos = 0; asteriscos < caracteres[indiceCaracter]; asteriscos++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
