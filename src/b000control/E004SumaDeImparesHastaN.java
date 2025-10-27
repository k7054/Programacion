void main() {
    IO.println("Mayor y menor de N números");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num = Integer.parseInt(IO.readln(nombre + ", introduce un número\n"));
    int suma = 0;

    for (int i = 1; i <= num; i++) {
        if (i % 2 == 1) {
            suma = suma + i;
        }
    }

    System.out.printf("La suma de los impares hasta %d es %d\n", num, suma);
}