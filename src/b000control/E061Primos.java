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

    int numeros = Integer.parseInt(IO.readln(nombre + ", introduce un número y te diré qué números son primos desde 1 hasta n.\n"));

    for (int i = 1; i <= numeros; i++) {
        if (esPrimo(i)) {
            IO.println(i + ": SÍ");
        } else {
            IO.println(i + ": NO");
        }
    }

    int n = Integer.parseInt(IO.readln(nombre + ", introduce un número y te diré los primeros n números que son primos.\n"));
    int numActual = 2;
    int contador = 0;

    while (contador < n) {
        if (esPrimo(numActual)){
            IO.println(numActual);
            contador++;
        }
        numActual++;
    }
}