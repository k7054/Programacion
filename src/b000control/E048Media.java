void main() {
    IO.println("MEDIA ARITMÉTICA");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    double num;
    double suma = 0;
    int contador = 0;

    do {
        num = Double.parseDouble(IO.readln(nombre + ", introduzca un valor positivo o 0 para parar:\n"));
        if (num > 0) {
            suma = suma + num;
            contador++;
        } else if (num < 0) {
            IO.println("Introduce un valor positivo o 0 para parar.");
        }
    } while (num != 0);

    IO.println(String.format("La media aritmética es %.2f", suma / contador));
}