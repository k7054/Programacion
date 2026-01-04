package b200algoritmica;

import java.util.Random;
import java.util.Scanner;

public class E222GeneradorContrasennas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Voy a generar tu contraseña.");

        int numCaracteres;

        do {
            System.out.println("¿Cuántos caracteres quieres que tenga? (Entre 4 y 30)");
            numCaracteres = entrada.nextInt();
        } while (numCaracteres < 4 || numCaracteres > 30);

        char siNo;

        do {
            System.out.println("¿Te parece bien si aparecen caracteres especiales? (s/n)");
            siNo = entrada.next().toLowerCase().charAt(0);
        } while (siNo != 's' && siNo != 'n');

        char[] caracterEspecial = {'#', '$', '%', '&'};
        StringBuilder contrasenna = new StringBuilder();

        int tipoCaracter;

        for (int i = 0; i < numCaracteres; i++) {
            if (siNo == 's') tipoCaracter = random.nextInt(4);
            else             tipoCaracter = random.nextInt(3);

            switch (tipoCaracter) {
                case 0 -> contrasenna.append((char) random.nextInt(65, 90 + 1));
                case 1 -> contrasenna.append((char) random.nextInt(97, 122 + 1));
                case 2 -> contrasenna.append((char) random.nextInt(48, 57 + 1));
                case 3 -> contrasenna.append(caracterEspecial[random.nextInt(caracterEspecial.length)]);
            }
        }

        System.out.print("*".repeat(numCaracteres));
        System.out.println();
        System.out.println("Contraseña generada.");

        String ok;
        entrada.nextLine();

        do {
            System.out.println("Introduce 'ok' para ver la contraseña.");
            ok = entrada.nextLine();
        } while (!ok.equals("ok"));

        System.out.printf("La contraseña generada es %s", contrasenna);
    }
}
