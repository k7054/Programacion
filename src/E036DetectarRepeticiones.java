void main() {
    IO.println("DETECTAR REPETICIONES");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num;
    int numSiguiente;

    do {
        num = Integer.parseInt(IO.readln(nombre + ", introduce un número\n"));
        numSiguiente = Integer.parseInt(IO.readln(nombre + ", introduce otro número\n"));
    } while (numSiguiente != num);
}