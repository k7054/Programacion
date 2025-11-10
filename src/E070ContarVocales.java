void main() {
    String s = "Arrivederci".toLowerCase();

    int contador = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú') contador++;
    }

    IO.print(String.format("El string tiene %d caracteres y tiene %d vocales.\n", s.length(), contador));
}