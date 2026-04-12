package b800varios.E862MasExcepcionesEnReloj;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Reloj reloj = null;

        do {
            try {
                System.out.println("¿Cómo quieres crear el reloj?");
                System.out.println("1. Total de minutos");
                System.out.println("2. Horas y minutos por separado");
                int opcion = teclado.nextInt();

                if (opcion == 1) {
                    System.out.print("Introduce el total de minutos: ");
                    int totalMinutos = teclado.nextInt();
                    reloj = new Reloj(totalMinutos);
                } else if (opcion == 2) {
                    System.out.print("Introduce la hora: ");
                    int h = teclado.nextInt();
                    System.out.print("Introduce los minutos: ");
                    int m = teclado.nextInt();

                    reloj = new Reloj(h, m);
                }
            } catch (DesbordamientoRelojException e) {
                System.out.println("Te has pasado por " + e.getExcesoMinutos() + " minutos");
            } catch (HoraNoValidaException e) {
                System.out.println("La hora solo admite valores entre 0 y 23");
            } catch (MinutoNoValidoException e) {
                System.out.println("Los minutos solo admite valores entre 0 y 59");
            }
        } while (reloj == null);

        boolean operacionOK = false;

        System.out.println("Valor inicial: " + reloj + "\n");

        do {
            try {
                System.out.print("Indica los minutos que quieres sumar: ");
                int minutos = teclado.nextInt();
                reloj.sumar(minutos);
                operacionOK = true;
            } catch (OperacionNegativaRelojException e) {
                System.out.println("Error: No puedes introducir minutos negativos.");
            } catch (DesbordamientoRelojException e) {
                if (e.isSuperior()) System.out.println("Te has salido del día por ARRIBA (más de 24h).");
                else System.out.println("Te has salido del día por ABAJO (menos de 00:00).");
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número positivo válido. No me pongas letras ni cosas raras.");
                teclado.nextLine();
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                e.printStackTrace();
            }
        } while (!operacionOK);

        System.out.println("\nValor final: " + reloj);
    }
}