void main() {
    IO.println("Potencias de 2 hasta N");
    String nombre = IO.readln("¿Cómo te llamas?\n");

    int base = Integer.parseInt(IO.readln(nombre + ", introduce la base\n"));
    int exponente = Integer.parseInt(IO.readln(nombre + ", introduce el exponente\n"));
    double resultado = 1;

    int a = Math.abs(base);
    int b = Math.abs(exponente);

    for (int i = 1; i <= b; i++) {
        resultado = resultado * a;
    }

    if (base < 0) resultado = -resultado;
    if (exponente < 0) resultado = 1 / resultado;

    System.out.printf("%d ^ %d = %.3f", base, exponente, resultado);
}