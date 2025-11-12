int contarVocales(String s) {
    String sMinuscula = s.toLowerCase();

    int contador = 0;

    for (int i = 0; i < sMinuscula.length(); i++) {
        char c = sMinuscula.charAt(i);
        switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> contador++;
        }
    }

    return contador;
}

void main() {
    IO.println("CONTAR VOCALES CON SWITCH");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    String s = IO.readln(nombre + ", introduce una palabra o frase y te dire cuantas vocales tiene:\n");

    IO.print(String.format("%s tiene %d vocales.\n", s, contarVocales(s)));
}