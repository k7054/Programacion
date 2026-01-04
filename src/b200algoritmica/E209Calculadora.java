package b200algoritmica;

import java.util.Scanner;

public class E209Calculadora {
    public static double suma(double num1, double num2) {
        return num1 + num2;
    }

    public static double resta(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicacion(double num1, double num2) {
        return num1 * num2;
    }

    public static double division(double num1, double num2) {
        return num1 / num2;
    }

    public static double potencia(double num1, double num2) {
        return Math.pow(num1, num2);
    }

    public static double raiz(double indice, double radicando) {
        return Math.pow(radicando, 1.0 / indice);
    }

    public static void main(String[] args) {
        System.out.println("CALCULADORA");
        Scanner entrada = new Scanner(System.in);

        System.out.println("Hola, ¿cómo te llamas?");
        String nombre = entrada.nextLine().toUpperCase();

        System.out.printf("""
                Bienvenido %s, \
                esto es una calculadora básica y funciona de la siguiente forma:
                El usuario introduce dos números de tipo double y \
                elige una operación matemática entre suma (+), resta (-), multiplicación (*), división (/), potencias (^) o raíces (√),
                (Para las raíces el primer número es el índice de la raíz y ya el segundo número es el radicando).
                Una vez introducidos los datos, el programa realiza el cálculo correspondiente y muestra el resultado con dos decimales.
                Después de mostrar el resultado, la calculadora vuelve al inicio y permite al usuario realizar otra operación.
                En caso que el usuario desea salir del programa debe de introducir la palabra (exit).""", nombre);

        System.out.println("\n");

        String exit;

        do {
            System.out.printf("%s, introduce el primer número:\n", nombre);
            double num1 = entrada.nextDouble();

            System.out.printf("%s, introduce la operación:\n", nombre);
            char operacion = entrada.next().charAt(0);

            System.out.printf("%s, introduce el segundo número:\n", nombre);
            double num2 = entrada.nextDouble();


            switch (operacion) {
                case '+' -> System.out.printf("%.2f + %.2f = %.2f\n", num1, num2, suma(num1, num2));

                case '-' -> System.out.printf("%.2f - %.2f = %.2f\n", num1, num2, resta(num1, num2));

                case '*' -> System.out.printf("%.2f * %.2f = %.2f\n", num1, num2, multiplicacion(num1, num2));

                case '/' -> {
                    if (num2 == 0) {
                        IO.println("No se puede dividir entre cero.");
                        break;
                    }

                    System.out.printf("%.2f / %.2f = %.2f\n", num1, num2, division(num1, num2));
                }

                case '^' -> System.out.printf("%.2f ^ %.2f = %.2f\n", num1, num2, potencia(num1, num2));
                case '√' -> System.out.printf("%.2f √ %.2f = %.2f\n", num1, num2, raiz(num1, num2));

                default -> System.out.println("Operación no válida");
            }

            entrada.nextLine();

            do {
                System.out.printf("%s, introduce (exit) si deseas salir del programa, en caso contrario introduce (.) para seguir en el programa:\n", nombre);
                exit = entrada.nextLine().toLowerCase();
            } while (!exit.equals("exit") && !exit.equals("."));

        } while (exit.equals("."));
    }
}
