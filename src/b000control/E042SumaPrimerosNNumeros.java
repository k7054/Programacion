void main() {
    IO.println("SUMA DE PRIMEROS N NÚMEROS");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num;

    do {
        num = Integer.parseInt(IO.readln(nombre + ", introduce un número entero positivo:\n"));
    } while (num <= 0);

    int suma = 0;

    for (int i = 1; i <= num; i++) {
        suma = suma + i;
    }

    IO.println(String.format("La suma de los números de 1 a %d es %d\n", num, suma));
}