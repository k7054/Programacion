void main() {
    IO.println("División simple");

    String nombre = IO.readln("¿Cómo te llamas?\n");

    int a = Integer.parseInt(IO.readln(nombre + ", introduce el dividendo:\n"));
    int b = Integer.parseInt(IO.readln(nombre + ", introduce el divisor:\n"));

    while ((a <= 0 && b > 0) || (a > 0 && b <= 0) || (a < 0 && b < 0)) {
        IO.println("No se puedo dividir cero y numeros negativos o entre cero y numeros negativos.");
        a = Integer.parseInt(IO.readln(nombre + ", introduce el dividendo:\n"));
        b = Integer.parseInt(IO.readln(nombre + ", introduce el divisor:\n"));
    }

    int cociente = 0;
    int resto = a;

    while (resto >= b) {
        resto = resto - b;
        cociente++;
    }

    IO.println("El resultado de " + a + " / " + b + " es " + cociente + " y resto " + resto);

}