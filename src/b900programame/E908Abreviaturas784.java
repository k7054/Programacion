package b900programame;

import java.util.Scanner;

public class E908Abreviaturas784 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int casos = entrada.nextInt();

        entrada.nextLine();

        for (int i = 0; i < casos; i++) {
            String letras = entrada.nextLine();
            StringBuilder abreviatura = new StringBuilder();

            for (int j = 0; j < letras.length(); j++) {
                char caracter = letras.charAt(j);
                if (caracter != '.' && caracter != ' ') {
                    abreviatura.append(caracter);
                    abreviatura.append(caracter);
                } else {
                    abreviatura.append(caracter);
                }
            }
            System.out.println(abreviatura);
        }
    }
}
