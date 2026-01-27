package b800varios;

public class E827CadenaAlReves {

    public static void cadenaAlReves(String cadena) {
        if (cadena == null || cadena.length() == 0) {
            return;
        }

        System.out.print(cadena.charAt(cadena.length() - 1));

        cadenaAlReves(cadena.substring(0, cadena.length() - 1));
    }

    public static void main(String[] args) {
        cadenaAlReves("ajos");
    }
}
