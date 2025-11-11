int contarVocales(String s) {
    String sMinuscula = s.toLowerCase();

    int contador = 0;

    for (int i = 0; i < sMinuscula.length(); i++) {
        char c = sMinuscula.charAt(i);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú') contador++;
    }

    return contador;
}

void main() {
    IO.println("CONTAR VOCALES");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    String s = IO.readln(nombre + ", introduce una palabra o frase y te dire cuantas vocales tiene:\n");

    IO.print(String.format("%s tiene %d vocales.\n", s, contarVocales(s)));
}