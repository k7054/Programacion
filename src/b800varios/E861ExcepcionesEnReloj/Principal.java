package b800varios.E861ExcepcionesEnReloj;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // ============================================================
        //  EJEMPLO 1 (del mindmap): sumar minutos con reintento
        //  — solo captura DesbordamientoRelojException
        // ============================================================
        Reloj a = new Reloj(23, 57);
        boolean operacionOK = false;

        System.out.println("=== Ejemplo 1: sumar minutos ===");
        System.out.println("Valor inicial: " + a + "\n");

        do {
            try {
                System.out.print("Indica los minutos que quieres sumar: ");
                int minutos = teclado.nextInt();
                a.sumar(minutos);
                operacionOK = true;
            } catch (DesbordamientoRelojException e) {
                if (e.isSuperior())
                    System.out.println("Te has intentado salir del día por arriba. Inténtalo de nuevo.");
                else
                    System.out.println("Te has intentado salir del día por abajo. Inténtalo de nuevo.");
            } catch (OperacionNegativaRelojException e) {
                // En sumar no debería llegar aquí porque el usuario introduce
                // un entero positivo, pero el compilador lo exige.
                System.out.println(e.getMessage());
            }
        } while (!operacionOK);

        System.out.println("Valor final tras sumar: " + a + "\n");


        // ============================================================
        //  EJEMPLO 2 (extra): restar minutos con reintento
        //  — captura AMBAS excepciones por separado para dar mensajes
        //    distintos según el error cometido
        // ============================================================
        Reloj b = new Reloj(1, 10);   // 01:10 → poco margen hacia abajo
        operacionOK = false;

        System.out.println("=== Ejemplo 2: restar minutos ===");
        System.out.println("Valor inicial: " + b + "\n");
        System.out.println("(Prueba a poner un número negativo o uno muy grande)");

        do {
            try {
                System.out.print("Indica los minutos que quieres restar: ");
                int minutos = teclado.nextInt();
                b.restar(minutos);
                operacionOK = true;

            } catch (OperacionNegativaRelojException e) {
                // El usuario escribió un número negativo
                System.out.println("Error: " + e.getMessage());

            } catch (DesbordamientoRelojException e) {
                // El resultado caería por debajo de las 00:00
                System.out.println("Error: restar esa cantidad dejaría el reloj fuera del día. Inténtalo de nuevo.");
            }
        } while (!operacionOK);

        System.out.println("Valor final tras restar: " + b);

        teclado.close();
    }
}
