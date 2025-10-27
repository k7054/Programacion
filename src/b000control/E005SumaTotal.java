void main() {
    int cantidadNumeros = Integer.parseInt(IO.readln("¿Cuántos números desea sumar?\n"));

    while (cantidadNumeros <= 1) {
        IO.println("Introduce un número mayor a 1:");
        cantidadNumeros = Integer.parseInt(IO.readln());
    }

    IO.println("Introduce los números a continuación:");

    int suma = 0;

    for (int i = 1; i <= cantidadNumeros; i++) {
        int numeros = Integer.parseInt(IO.readln());
        suma = suma + numeros;
    }

    IO.print("La suma da: " + suma);

}