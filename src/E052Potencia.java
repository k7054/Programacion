int calcularPotencia(int base, int exponente) {
    int resultado = 1;

    for (int i = 1; i <= exponente; i++) {
        resultado = resultado * base;
    }

    return resultado;
}

void main() {
    IO.println("POTENCIA");
    String nombre = IO.readln("¿Cómo te llamas?\n");

    int base;
    int exponente;

    do {
        base = Integer.parseInt(IO.readln(nombre + ", introduce la base:\n"));
        exponente = Integer.parseInt(IO.readln(nombre + ", introduce el exponente:\n"));
    } while (base <= 1 || exponente <= 1);

    IO.println(String.format("%d ^ %d = %d", base, exponente, calcularPotencia(base, exponente)));
}