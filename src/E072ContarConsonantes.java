int contarConsonantes(String s) {
    String sMinuscula = s.toLowerCase();

    int contador = 0;

    for (int i = 0; i < sMinuscula.length(); i++) {
        char c = sMinuscula.charAt(i);
        if (c >= 'b' && c <= 'z' && c != 'e' && c != 'i' && c != 'o' && c != 'u' || c == 'ñ') contador++;
    }

    return contador;
}

void main() {
    IO.println("CONTAR CONSONANTES");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    String s = IO.readln(nombre + ", introduce una palabra o frase y te dire cuantas consonantes tiene:\n");

    IO.print(String.format("%s tiene %d consonantes.\n", s, contarConsonantes(s)));
}