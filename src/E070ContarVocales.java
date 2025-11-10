void main() {
    String s = "Arrivederci";

    IO.print(String.format("El string tiene %d caracteres y hay una letra %s en su posición 4.\n", s.length(), s.charAt(4)));

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        IO.println(c);
    }
}