void main() {
    IO.println("DETECTAR REPETICIONES");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int numRepMax = Integer.parseInt(IO.readln(nombre + ", introduce el número maximo de repeticiones permitidas\n"));
    int repMax = 0;

    int num = Integer.parseInt(IO.readln(nombre + ", introduce un número\n"));
    int numSiguiente;

    do {
        numSiguiente = Integer.parseInt(IO.readln(nombre + ", introduce otro número\n"));
        if (num == numSiguiente) repMax++;
        num = numSiguiente;
    } while (repMax < numRepMax);
}