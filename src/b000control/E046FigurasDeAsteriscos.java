void main() {
    IO.println("FIGURAS DE ASTERISCOS");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int n = Math.abs(Integer.parseInt(IO.readln(nombre + ", introduce un número para la base:\n")));
    int m = Math.abs(Integer.parseInt(IO.readln(nombre + ", introduce un número para la altura:\n")));

    IO.println("Cuadrado o rectángulo");

    for (int a = 1; a <= m; a++) {
        for (int b = 1; b <= n; b++) {
            if ((a == 1) || (a == m) || (b == 1) || (b == n)) {
                IO.print(" * ");
            } else {
                IO.print("   ");
            }
        }
        IO.println();
    }

    IO.println("Triángulo");

    for (int a = 1; a <= m; a++) {
        for (int b = 1; b <= a; b++) {
            if ((a == 1) || (a == m) || (b == 1) || (b <= n)) {
                IO.print(" * ");
            } else {
                IO.print("   ");
            }
        }
        IO.println();
    }
}