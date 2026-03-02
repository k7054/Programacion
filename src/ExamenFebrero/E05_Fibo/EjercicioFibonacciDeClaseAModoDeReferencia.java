package ExamenFebrero.E05_Fibo;

public class EjercicioFibonacciDeClaseAModoDeReferencia {
    // ESTE CÓDIGO ES SOLO DE REFERENCIA.
    // Muestra la lógica matemática tradicional de la sucesión de Fibonacci.

    public static void main(String[] args) {
        final int HASTA = 30;

        int anterior = 0;
        int actual = 1;

        System.out.print(anterior);

        if (HASTA >= 2) {
            System.out.print(String.format(", %d", actual));
        }

        for (int i = 3; i <= HASTA; i++) {
            int siguiente = anterior + actual;
            anterior = actual;
            actual = siguiente;
            System.out.print(String.format(", %d", actual));
        }
    }
}