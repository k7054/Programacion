package ExamenFebrero.E03_NumeroAbundante;

public class E03_NumeroAbundante {
    // TODO: Implementa aquí el método esNumeroAbundante

    public static boolean esNumeroAbundante(int numero) {
        int suma = 0;

        for (int i = 1; i <= numero - 1; i++) {
            if (numero % i == 0) suma = suma + i;
        }

        if (suma <= numero) return false;

        return true;
    }

    public static void main(String[] args) {
        // TODO: Crea el bucle del 1 al 100 y utiliza el método esNumeroAbundante para imprimir solo aquellos que lo sean.
        for (int i = 1; i <= 100; i++) {
            if (esNumeroAbundante(i)) {
                System.out.println(i);
            }
        }
    }
}