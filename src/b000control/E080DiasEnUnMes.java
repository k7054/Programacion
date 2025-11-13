String diasMes(int numero) {
    return switch (numero) {
        case 1, 3, 5, 7, 8, 10, 12 -> "31 días";
        case 4, 6, 9, 11 -> "30 días";
        case 2 -> "28 o 29 días si el año es bisiesto";
        default -> throw new IllegalStateException("Unexpected value: " + numero);
    };
}

void main() {
    IO.println("DÍAS EN UN MES");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int numero = Integer.parseInt(IO.readln(nombre + ", introduce un número de mes 1-12 y te diré cuántos días tiene:\n"));

    IO.println(String.format("El mes %d tiene %s.", numero, diasMes(numero)));
}