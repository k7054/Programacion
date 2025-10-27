void main() {
    IO.println("Mayor o menor");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num;
    int numSiguiente;

    do {
        num = Integer.parseInt(IO.readln(nombre + ", introduzca un valor positivo mayor que 0:\n"));
    } while (num < 0);

    if (num == 0) {
        IO.println("FIN");
    }

    while (num > 0) {

        do {
            numSiguiente = Integer.parseInt(IO.readln(nombre + ", introduzca valores positivos y le diré si son menores o mayores, o iguales, que el anterior; o introduzca 0 para terminar:\n"));
        } while (numSiguiente < 0);

        if (numSiguiente == 0){
            IO.println("FIN");
            break;
        }

        if (numSiguiente < num) {
            IO.println("Es menor que el anterior.\n");
        } else if (numSiguiente > num) {
            IO.println("Es mayor que el anterior.\n");
        } else {
            IO.println("Es igual que el anterior.\n");
        }

        num = numSiguiente;
    }
}