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

    IO.println("\n".repeat(10));

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
        } else {
            IO.println("\n¡LETRA INCORRECTA!");
            fallos++;
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