boolean esPalindromo(String texto) {
    String sMinuscula = texto.toLowerCase().replace(" ", "");
    boolean esIgual = true;

    for (int i = 0; i < sMinuscula.length() / 2; i++) {
        char izq = sMinuscula.charAt(i);
        char der = sMinuscula.charAt(sMinuscula.length() - 1 - i);
        esIgual = (izq == der);
    }
    return esIgual;
}

void main() {
    IO.println("Palíndromo");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    String s = IO.readln(nombre + ", introduce una palabra para determinar si es palíndroma o no:\n");

    String respuesta = esPalindromo(s) ? "sí" : "no";
    IO.println(String.format("%s %s es palíndroma.", s, respuesta));
}