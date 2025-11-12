void main() {
    IO.println("FRASE INVERTIDA");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    String s = IO.readln(nombre + ", introduce una palabra o frase para invertirla:\n");
    StringBuilder sInvertido = new StringBuilder();

    for (int i = s.length() - 1; i >= 0; i--) {
        char c = s.charAt(i);
        sInvertido.append(c);
    }

    IO.println(String.format("%s invertido es %s", s, sInvertido));
}