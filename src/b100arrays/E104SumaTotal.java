void main() {
    IO.println("SUMA TOTAL");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int cantidadNum;

    do {
        cantidadNum = Integer.parseInt(IO.readln(nombre + ", introduce la cantidad de números que vas a introducir posteriormente(mayor que 0):\n"));
    } while (cantidadNum < 1);

    int[] numeros = new int[cantidadNum];

    for (int i = 0; i < numeros.length; i++) {
        numeros[i] = Integer.parseInt(IO.readln(nombre + ", introduce un número entero:\n"));
    }

    int sumaTotal = 0;

    for (int numero : numeros) {
        sumaTotal = sumaTotal + numero;
    }

    IO.println(String.format("La suma total es igual a %d.", sumaTotal));
}