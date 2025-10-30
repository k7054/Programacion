void main() {
    IO.println("SUMAR NÚMEROS MAYORES QUE 100");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num;
    int suma = 0;

    do {
        num = Integer.parseInt(IO.readln(String.format("%s, introduce un número entero o 0 para parar\n", nombre)));

        if (num > 100) suma = suma + num;
    } while (num != 0);

    IO.println(String.format("La suma de los números mayores que 100 es: %d", suma));
}