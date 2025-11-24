boolean esDivisible(int dividendo, int divisor) {
    return dividendo % divisor == 0;
}

boolean esPrimo(int numero) {
    if (numero == 1) return false;

    int limite = (int) Math.sqrt(numero);

    for (int i = 2; i <= limite; i++) {
        if (esDivisible(numero, i)) return false;
    }

    return true;
}

void main() {
    IO.println("ES PRIMO");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int numero = Integer.parseInt(IO.readln(nombre + ", introduce un número y te diré si es primo o no\n"));

    if (esPrimo(numero)) {
        IO.println("Es primo");
    } else {
        IO.println("No es primo");
    }
    IO.println();
}