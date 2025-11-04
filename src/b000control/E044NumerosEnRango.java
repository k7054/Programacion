void main() {
    IO.println("NÚMEROS EN RANGO");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num1;

    do {
        num1 = Integer.parseInt(IO.readln(nombre + ", introduce el primer número entero positivo:\n"));
    } while (num1 < 0);

    int num2;

    do {
        num2 = Integer.parseInt(IO.readln(nombre + ", introduce el segundo número entero positivo, tiene que ser mayor que el primer número:\n"));
    } while ((num2 < num1));

    int resto = num1 % 3;

    int suma = (3 - resto) % 3;

    for (int i = num1 + suma; i <= num2; i= i + 3) {
        IO.println(i);
    }
}