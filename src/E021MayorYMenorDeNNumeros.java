void main() {
    IO.println("Mayor y menor de N números");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int cantidadNum = Integer.parseInt(IO.readln(nombre + ", ¿Cuántos números desea introducir?\n"));

    IO.println(nombre + ", introduce los números a continuación:");

    int mayor = Integer.MIN_VALUE;
    int menor = Integer.MAX_VALUE;

    for (int i = 1; i <= cantidadNum; i++) {
        int numeros = Integer.parseInt(IO.readln());

        if (numeros > mayor) mayor = numeros;
        if (numeros < menor) menor = numeros;
    }

    System.out.printf("El menor es %d y el mayor es %d\n", menor, mayor);
}