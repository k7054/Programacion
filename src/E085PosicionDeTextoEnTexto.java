int encuentraPosicionEnElTexto(String textoBuscado, String textoPrincipal) {
    for (int i = 0; i < textoPrincipal.length(); i++) {
        boolean encontrado = true;
        for (int j = 0; j < textoBuscado.length(); i++) {
            if (textoBuscado.charAt(j) != textoPrincipal.charAt(i + j)) {
                encontrado = false;
                break;
            }
        }

        if (encontrado) return i;
    }

    return -1;
}

void main() {
    IO.println("POSICIÓN DE TEXTO EN TEXTO");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    String textoBuscado = IO.readln(nombre + ", introduce un texto para buscarlo dentro del segundo texto:\n");
    String textoPrincipal = IO.readln(nombre + ", introduce un texto:\n");

    IO.println(encuentraPosicionEnElTexto(textoBuscado, textoPrincipal));
}