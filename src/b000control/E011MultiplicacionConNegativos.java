void main() {
    IO.println("Multiplicación simple con negativos");

    String nombre = IO.readln("¿Cómo te llamas?\n");

    int a = Integer.parseInt(IO.readln(nombre + ", introduce un número:\n"));
    int b = Integer.parseInt(IO.readln(nombre + ", introduce otro número:\n"));

    int num1 = Math.abs(a);
    int num2 = Math.abs(b);

    int resultado = 0;

    for (int i = 1; i <= num2; i++) {
        resultado = resultado + num1;
    }

    if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
        resultado = -resultado;
    }

    IO.println("El resultado de " + a + " x " + b + " es: " + resultado);

}