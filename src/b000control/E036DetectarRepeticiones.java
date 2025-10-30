void main() {
    IO.println("DETECTAR REPETICIONES");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int numRepMax = Integer.parseInt(IO.readln(nombre + ", introduce el número maximo de repeticiones permitidas\n"));
    int repeticiones = 1;

    int num;
    int numAnterior = Integer.MIN_VALUE;

    do {
        num = Integer.parseInt(IO.readln(nombre + ", introduce un número\n"));
        if (num == numAnterior) repeticiones++;
        numAnterior = num;
    } while (repeticiones < numRepMax);
}