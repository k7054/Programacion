void main() {
    IO.println("MAYOR Y MENOR");

    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int cantidadNum;

    do {
        cantidadNum = Integer.parseInt(IO.readln(nombre + ", introduce la cantidad de números que vas a introducir posteriormente(mayor que 0):\n"));
    } while (cantidadNum < 1);

    int[] numeros = new int[cantidadNum];

    for (int i = 0; i < numeros.length; i++) {
        numeros[i] = Integer.parseInt(IO.readln(nombre + ", introduce un número entero:\n"));
    }

    int mayor = Integer.MIN_VALUE;
    int menor = Integer.MAX_VALUE;

    for (int numero : numeros) {
        if (numero > mayor) mayor = numero;
        if (numero < menor) menor = numero;
    }

    IO.println(String.format("El mayor es %d y el menor es %d.", mayor, menor));
}