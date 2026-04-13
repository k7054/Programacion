package b900programame;

import java.util.Scanner;

public class E916Telegramas637 {
    public static String getMorse(char c) {
        switch (c) {
            case 'A': return ".-";
            case 'B': return "-...";
            case 'C': return "-.-.";
            case 'D': return "-..";
            case 'E': return ".";
            case 'F': return "..-.";
            case 'G': return "--.";
            case 'H': return "....";
            case 'I': return "..";
            case 'J': return ".---";
            case 'K': return "-.-";
            case 'L': return ".-..";
            case 'M': return "--";
            case 'N': return "-.";
            case 'O': return "---";
            case 'P': return ".--.";
            case 'Q': return "--.-";
            case 'R': return ".-.";
            case 'S': return "...";
            case 'T': return "-";
            case 'U': return "..-";
            case 'V': return "...-";
            case 'W': return ".--";
            case 'X': return "-..-";
            case 'Y': return "-.--";
            case 'Z': return "--..";
            case '!': return "-.-.--";
            case '?': return "..--..";
            default:  return "";
        }
    }

    public static int duracionLetra(char c) {
        String codigo = getMorse(c);
        int duracion = 0;

        for (int i = 0; i < codigo.length(); i++) {
            // Pausa entre símbolos
            if (i > 0) {
                duracion = duracion + 1;
            }

            // Punto vale 1, raya vale 3
            if (codigo.charAt(i) == '.') {
                duracion = duracion + 1;
            } else {
                duracion = duracion + 3;
            }
        }
        return duracion;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int numCasos = Integer.parseInt(teclado.nextLine().trim());
        for (int i = 0; i < numCasos; i++) {
            String linea = teclado.nextLine();
            String[] palabras = linea.split(" ");
            int total = 0;

            for (int p = 0; p < palabras.length; p++) {
                // Pausa entre palabras
                if (p > 0) {
                    total = total + 5;
                }

                String palabra = palabras[p];
                for (int l = 0; l < palabra.length(); l++) {
                    // Pausa entre letras
                    if (l > 0) {
                        total = total + 3;
                    }
                    total = total + duracionLetra(palabra.charAt(l));
                }
            }

            System.out.println(total);
        }
    }
}
