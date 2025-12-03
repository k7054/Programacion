void imprimirAhorcado(int numFallos) {
    System.out.println(" ____");

    switch (numFallos) {
        case 1 -> {
            System.out.println(" |  0");
            System.out.println(" |");
            System.out.println(" |");
        }
        case 2 -> {
            System.out.println(" |  0");
            System.out.println(" |  |");
            System.out.println(" |");
        }
        case 3 -> {
            System.out.println(" |  0");
            System.out.println(" | -|");
            System.out.println(" |");
        }
        case 4 -> {
            System.out.println(" |  0");
            System.out.println(" | -|-");
            System.out.println(" |");
        }
        case 5 -> {
            System.out.println(" |  0");
            System.out.println(" | -|-");
            System.out.println(" | /");
        }
        case 6 -> {
            System.out.println(" |  0");
            System.out.println(" | -|-");
            System.out.println(" | / \\ ");
        }
    }
    System.out.println("_|_");
    System.out.println();
}

void main() {
    IO.println("ADIVINAR LETRAS");

    String nombreJugador1 = IO.readln("Jugador 1, ¿Cómo te llamas?\n").toUpperCase();

    int cantidadLetras;

    do {
        cantidadLetras = Integer.parseInt(IO.readln(nombreJugador1 + ", introduzca la cantidad de letras deseada(mínimo 1):\n"));
    } while (cantidadLetras <= 0);

    char[] letras = new char[cantidadLetras];

    for (int i = 0; i < letras.length; i++) {
        letras[i] = IO.readln(String.format("%s, introduce la letra secreta %d:\n", nombreJugador1, i + 1)).charAt(0);
    }

    IO.println("\n\n\n\n\n\n\n\n\n");

    int limiteFallos = 6;

    String nombreJugador2 = IO.readln("Jugador 2, ¿Cómo te llamas?\n").toUpperCase();

    IO.println(String.format("%s, tienes un limite de %d fallos", nombreJugador2, limiteFallos));

    boolean[] letrasAdivinadas = new boolean[cantidadLetras];
    boolean todoAcertado;
    int fallos = 0;

    do {
        char letraIntentada = IO.readln(String.format("%s, introduce la letra intentada:\n", nombreJugador2)).charAt(0);

        boolean encontrada = false;

        for (int i = 0; i < letras.length; i++) {
            if (letraIntentada == letras[i]) {
                letrasAdivinadas[i] = true;
                encontrada = true;
            }

            if (letrasAdivinadas[i]) {
                IO.print(letras[i] + " ");
            } else {
                IO.print("_ ");
            }
        }

        if (encontrada) {
            IO.println("\n¡LETRA ADIVINADA!");
            imprimirAhorcado(fallos);
        } else {
            IO.println("\n¡LETRA INCORRECTA!");
            fallos++;
            imprimirAhorcado(fallos);
        }

        todoAcertado = true;

        for (boolean acertado : letrasAdivinadas) {
            if (!acertado) {
                todoAcertado = false;
                break;
            }
        }
    } while (!todoAcertado && fallos < limiteFallos);
}