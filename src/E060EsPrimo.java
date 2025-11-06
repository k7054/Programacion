boolean esDivisible(int dividendo, int divisor) {
    return dividendo % divisor == 0;
}

boolean esPrimo(int numero) {
    if (numero == 1) return false;

    for (int i = 2; i <= numero -1; i++) {
        if (esDivisible(numero, i)) return false;
    }

    return true;
}

void main() {
    IO.println("ES PRIMO");
    String nombre = IO.readln("¿Cómo te llamas?\n");

    int numero = Integer.parseInt(IO.readln(nombre + ", introduce un número y te diré si es primo o no\n"));

    if (esPrimo(numero)) {
        IO.println("Es primo");
    } else {
        IO.println("No es primo");
    }
}