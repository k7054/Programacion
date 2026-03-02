package ExamenFebrero.E04_CompresionRLE;

public class E04_CompresionRLE {
    // TODO: Implementa la lógica de este método
    public static String comprimirTexto(String texto) {
        StringBuilder string = new StringBuilder();

        int contador = 1;
        for (int i = 1; i < texto.length(); i++) {
            if (texto.charAt(i) == texto.charAt(i - 1)) {
                contador++;
            } else {
                string.append(texto.charAt(i - 1));
                string.append(contador);
                contador = 1;
            }
        }

        string.append(texto.charAt(texto.length() - 1));
        string.append(contador);

        return string.toString();
    }

    public static void main(String[] args) {
        String[] pruebas = {
                "aaabbcccc",
                "xxyyzz",
                "wwwww",
                "abc",
                "abracadabra"
        };

        for (int i = 0; i < pruebas.length; i++) {
            String original = pruebas[i];
            String comprimido = comprimirTexto(original);

            // TODO: Modifica este print; añade las operaciones necesarias para calcular y mostrar también el porcentaje de ocupación.
            System.out.printf("Original: '%s' -> Comprimido: '%s' | %d%%\n", original, comprimido, comprimido.length() * 100 / original.length());
        }
    }
}