//String tipoCaracter(char c) {
//    return switch (c) {
//        case 'a', 'b', 'c', 'd', 'e', 'f', 'g',
//             'h', 'i', 'j', 'k', 'l', 'm', 'n',
//             'ñ', 'o', 'p', 'q', 'r', 's', 't',
//             'u', 'v', 'w', 'x', 'y', 'z'      -> "letra minúscula";
//
//        case 'A', 'B', 'C', 'D', 'E', 'F', 'G',
//             'H', 'I', 'J', 'K', 'L', 'M', 'N',
//             'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T',
//             'U', 'V', 'W', 'X', 'Y', 'Z'      -> "letra mayúscula";
//
//        default -> throw new IllegalStateException("Unexpected value: " + c);
//    };
//}
//
//void main() {
//    IO.println("TIPO DE CARÁCTER");
//    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();
//
//    String s = IO.readln(nombre + ", introduce una palabra o texto para determinar quñe tipo de carácter es cada uno:\n");
//}