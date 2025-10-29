import java.util.Scanner;

void main() {
    Scanner teclado = new Scanner(System.in);

    System.out.print("Introduzca el número secreto: ");
    int numSecreto = teclado.nextInt();

    // Comprobación de la entrada, por si no es válida.
    while (numSecreto <= 0) {
        System.out.println ("No se admiten valores negativos ni cero, introduzca otro número: ");
        System.out.print ("Introduzca el número secreto: ");
        numSecreto = teclado.nextInt();
    }

    // El núm. secreto en este punto es != 0.



    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");



    int numIntentado;
    int cantIntentosGastados = 0;
    int cantIntentosDisponibles = 5;
    int diferencia;

    System.out.printf ("Tienes %d intentos.\n", cantIntentosDisponibles);

    do {
        System.out.println ("Introduzca un número:");
        numIntentado = teclado.nextInt();
        cantIntentosGastados++;

        if (numIntentado > numSecreto) {
            diferencia = (numIntentado - numSecreto) / 10;
            IO.print("*".repeat(diferencia));
            IO.println();
            if (diferencia > 4) IO.println("helado");
            if (diferencia == 3) IO.println("frío");
            if (diferencia == 2) IO.println("templado");
            if (diferencia == 1) IO.println("caliente");
            if (diferencia == 0) IO.println("te quemas");
            System.out.printf ("Intento número %d, el número es más pequeño.\n", cantIntentosGastados);
        }
        if (numIntentado < numSecreto) {
            diferencia = (numSecreto - numIntentado) / 10;
            IO.print("*".repeat(diferencia));
            IO.println();
            if (diferencia > 4) IO.println("helado");
            if (diferencia == 3) IO.println("frío");
            if (diferencia == 2) IO.println("templado");
            if (diferencia == 1) IO.println("caliente");
            if (diferencia == 0) IO.println("te quemas");
            System.out.printf ("Intento número %d, el número es mas grande.\n", cantIntentosGastados);
        }
    } while (cantIntentosGastados < cantIntentosDisponibles && numIntentado != numSecreto);

    if (numIntentado == numSecreto) System.out.println ("Muy bien, ¡has acertado! El número secreto era: " + numSecreto);
    if (numIntentado != numSecreto) System.out.println("Intentos agotados.");
}
