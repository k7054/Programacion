void main() {
    IO.println("Suma de positivos y negativos");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num;
    int sumaPositivos = 0;
    int sumaNegativos = 0;
    int totalNumeros = 0;

    do {
        num = Integer.parseInt(IO.readln(nombre + ", introduce un número o un 0 para parar:\n"));
        if (num < 0) sumaNegativos = sumaNegativos + num;
        if (num > 0) sumaPositivos = sumaPositivos + num;
        if (num != 0) totalNumeros++;
    } while (num != 0);

    System.out.printf("Suma positivos: %d\nSuma negativos: %d\nTotal números: %d\n", sumaPositivos, sumaNegativos, totalNumeros);
}