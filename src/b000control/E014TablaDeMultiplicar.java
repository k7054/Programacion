void multiplicacion(int numero) {
    for (int i = 0; i <= 10; i++) {
        IO.println(String.format("%d x %d = %d", numero, i, numero * i));
    }
}

void main() {
    IO.println("Tabla de multiplicar");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num;

    do {
        num = Integer.parseInt(IO.readln(nombre + ", introduce un número entero positivo:\n"));
    } while (num < 0);

    IO.println();
    multiplicacion(num);
}