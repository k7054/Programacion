void main() {
    IO.println("División simple");

    String nombre = IO.readln("¿Cómo te llamas?\n");

    int a = Integer.parseInt(IO.readln(nombre + ", introduce el dividendo:\n"));
    int b = Integer.parseInt(IO.readln(nombre + ", introduce el divisor:\n"));

    while ((a == 0 && b > 0) || (a == 0 && b < 0) || (a > 0 && b == 0) || (a < 0 && b == 0)) {
        IO.println("No se puedo dividir cero o entre cero.");
        a = Integer.parseInt(IO.readln(nombre + ", introduce el dividendo:\n"));
        b = Integer.parseInt(IO.readln(nombre + ", introduce el divisor:\n"));
    }

    int dividendo = Math.abs(a);
    int divisor = Math.abs(b);

    int cociente = 0;
    int resto = dividendo;

    while (resto >= divisor) {
        resto = resto - divisor;
        cociente++;
    }

    if ((a < 0 && b > 0) || (a > 0 && b < 0)) cociente = -cociente;

    IO.println("El resultado de " + a + " / " + b + " es " + cociente + " y resto " + resto);
}