package b900programame;

import java.util.Scanner;

public class E901CasasColgadas763 {
    private static final String ENTRADA = """
            3
            colgadas
            COLGANTES
            ColgadaS
            """;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int casos = entrada.nextInt();

        for (int i = 0; i < casos; i++) {
            String palabra = entrada.next();
            palabra = palabra.toLowerCase();

            if (palabra.equals("colgadas")) {
                System.out.println("Bien");
            } else {
                System.out.println("Mal");
            }
        }
    }
}
