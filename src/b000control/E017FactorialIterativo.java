void main() {
    IO.println("Factorial iterativo");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num = Integer.parseInt(IO.readln(nombre + ", introduce un número para calcular el factorial de ese número\n"));
    int resultado = 1;

    for (int i = 1; i <= num; i++) {
        resultado = resultado * i;
    }

    IO.println(num + "! = " + resultado);
}