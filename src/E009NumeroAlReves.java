void main() {
    IO.println("Número invertido");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num;

    do {
        num = Integer.parseInt(IO.readln(nombre + ", introduce un valor entero positivo:\n"));
    } while (num <= 0);

    int digito;
    int numInvertido = 0;

    while (num > 0) {
        digito = num % 10;
        num = num / 10;
        numInvertido = numInvertido * 10 + digito;
    }

    IO.println("Número invertido: " + numInvertido);
}