void main() {
    IO.println("Adivinar el número");
    String nombreJugador1 = IO.readln("Eres el jugador 1, ¿Cómo te llamas?\n").toUpperCase();

    int numSecreto = Integer.parseInt(IO.readln(nombreJugador1 + ", introduce el número secreto.\n"));

    IO.print("\n\n\n\n\n\n\n\n");

    String nombreJugador2 = IO.readln("Eres el jugadro 2, ¿Cómo te llamas?\n").toUpperCase();

    int numAdivinado;

    do {
        numAdivinado = Integer.parseInt(IO.readln(nombreJugador2 + ", introduce un número para intentar adivinar el número secreto.\n"));

        if (numAdivinado > numSecreto) IO.println("Es menor");
        if (numAdivinado < numSecreto) IO.println("Es mayor");
    } while (numAdivinado != numSecreto);

    System.out.printf("¡Enhorabuena, %s!, has adivinado el número secreto.\n", nombreJugador2);
}