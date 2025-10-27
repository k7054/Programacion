void main() {
    IO.println("DETECTAR REPETICIONES");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num = Integer.parseInt(IO.readln(nombre + ", introduce un número\n"));
    int numSiguiente;

    while (num < 0) {
        numSiguiente = Integer.parseInt(IO.readln(nombre + ", introduce otro número\n"));
        num = numSiguiente;
    }
}