String tipoCaracter(char c) {
    return switch (c) {
        case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> "dígito";

        case 'a', 'b', 'c', 'd', 'e', 'f', 'g',
             'h', 'i', 'j', 'k', 'l', 'm', 'n',
             'ñ', 'o', 'p', 'q', 'r', 's', 't',
             'u', 'v', 'w', 'x', 'y', 'z'      -> "letra minúscula";

        case 'A', 'B', 'C', 'D', 'E', 'F', 'G',
             'H', 'I', 'J', 'K', 'L', 'M', 'N',
             'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T',
             'U', 'V', 'W', 'X', 'Y', 'Z'      -> "letra mayúscula";

        case ',', '.', '-', '(', ')', '¡', '!', '¿', '?', ' ' -> "símbolo";

        default -> throw new IllegalStateException("Unexpected value: " + c);
    };
}

void main() {
    IO.println("TIPO DE CARÁCTER");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    String s = IO.readln(nombre + ", introduce una palabra o texto para determinar qué tipo es cada carácter:\n");

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        IO.println(String.format("%s: %s", c, tipoCaracter(c)));
    }
}