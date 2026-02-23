package b200algoritmica;

public class E224AnalizadorDeTexto {
    private static int contarTotalPalabras(String frase) {
        int contador = 1;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                contador++;
            }
        }

        return contador;
    }

    private static int contarPalabrasLargas(String frase) {
        int contadorLetras = 0;
        int contadorPalabrasLargas = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != ' ') {
                contadorLetras++;
            } else {
                contadorLetras = 0;
            }

            if (contadorLetras == 5) {
                contadorPalabrasLargas++;
            }
        }

        return contadorPalabrasLargas;
    }

    private static StringBuilder obtenerPalabraMasLarga(String frase) {
        int contadorLetras = 0;

        StringBuilder palabraActual = new StringBuilder();
        StringBuilder palabraMasLarga = new StringBuilder();
        int longitudActual = 0;
        int maxLongitud = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != ' ') {
                palabraActual.append(frase.charAt(i));
                longitudActual++;
            } else {
                if (longitudActual > maxLongitud) {
                    palabraMasLarga.setLength(0);
                    palabraMasLarga.append(palabraActual.toString());
                    maxLongitud =longitudActual;
                }

                palabraActual.setLength(0);
                longitudActual = 0;
            }
        }

        if (longitudActual > maxLongitud) {
            palabraMasLarga.setLength(0);
            palabraMasLarga.append(palabraActual.toString());
        }

        return palabraMasLarga;
    }

    public static void main(String[] args) {
        String frase = "Hola adiós bla bla";

        System.out.printf("El texto tiene %d palabras.\n", contarTotalPalabras(frase));

        System.out.printf("De ellas, %d son largas (5 caracteres o más).\n", contarPalabrasLargas(frase));

        System.out.printf("La palabra más larga es %s y tiene %d caracteres.\n", obtenerPalabraMasLarga(frase), obtenerPalabraMasLarga(frase).length());
    }
}
