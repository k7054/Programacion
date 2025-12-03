void main() {
    IO.println("ADIVINAR LETRAS");

    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int cantidadLetras;

    do {
        cantidadLetras = Integer.parseInt(IO.readln(nombre + ", introduzca la cantidad de letras deseada(mínimo 1):\n"));
    } while (cantidadLetras <= 0);

    char[] letras = new char[cantidadLetras];

    for (int i = 0; i < letras.length; i++) {
        letras[i] = IO.readln(String.format("%s, introduce la letra secreta %d:\n", nombre, i + 1)).charAt(0);
    }

    IO.println(String.format("\n\n\n\n\n\n\n\n\n Hay %d letra(s) secreta(s)", cantidadLetras));

    boolean[] letrasAdivinadas = new boolean[cantidadLetras];
    boolean todoAcertado;
    int intentos = cantidadLetras;

    do {
        char letraIntentada = IO.readln(String.format("%s, introduce la letra intentada:\n", nombre)).charAt(0);

        boolean encontrada = false;

        for (int i = 0; i < letras.length; i++) {
            if (letraIntentada == letras[i]) {
                letrasAdivinadas[i] = true;
                encontrada = true;
            }
        }

        if (encontrada) {
            IO.println("¡LETRA ADIVINADA!");
        } else {
            IO.println("¡LETRA INCORRECTA!");
            intentos--;
        }

        todoAcertado = true;

        for (boolean acertado : letrasAdivinadas) {
            if (!acertado) {
                todoAcertado = false;
                break;
            }
        }
    } while (!todoAcertado && intentos > 0);
}