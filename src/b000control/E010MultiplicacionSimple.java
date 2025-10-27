void main() {
    IO.println("Multiplicación simple");

    String nombre = IO.readln("¿Cómo te llamas?\n");

    int a = Integer.parseInt(IO.readln(nombre + ", introduce un número:\n"));
    int b = Integer.parseInt(IO.readln(nombre + ", introduce otro número:\n"));

    int resultado = 0;

    for (int i = 1; i <= b; i++) {
        resultado = resultado + a;
    }

    IO.println("El resultado de " + a + " x " + b + " es: " + resultado);

}