void main() {
    IO.println("TABLAS DE MULTIPLICAR");

    for (int a = 1; a <= 10; a++) {
        IO.println("Tabla del " + a);
        for (int b = 0; b <= 10; b++) {
            IO.println(String.format("%d x %d = %d", a, b, a * b));
        }
        IO.println();
    }
}