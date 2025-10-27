void main() {
    IO.println("Mayor y menor de N números");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num = Integer.parseInt(IO.readln(nombre + ", introduce un número a continuacion"));

    for (int i = num; i > 0; i--) {
        IO.println(i);
    }
    IO.println("¡Despegue!");
}