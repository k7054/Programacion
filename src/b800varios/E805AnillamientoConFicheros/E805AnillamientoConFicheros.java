package b800varios.E805AnillamientoConFicheros;

import java.io.*;
import java.util.Scanner;

public class E805AnillamientoConFicheros {
    public static void main(String[] args) {
        Scanner entrada = null;
        PrintWriter salida = null;

        try {
            entrada = new Scanner(new BufferedReader(new FileReader("src/b800varios/E805AnillamientoConFicheros/entrada.txt")));
            salida = new PrintWriter(new BufferedWriter(new FileWriter("src/b800varios/E805AnillamientoConFicheros/salida.txt")));

            int campanias;

            while (entrada.hasNext()) {
                campanias = entrada.nextInt();
                if (campanias == 0) break;
                int totalCapturadas = 0;

                for (int i = 0; i < campanias; i++) {
                    int avesCapturadas = entrada.nextInt();
                    int avesAnilladas = entrada.nextInt();
                    totalCapturadas = totalCapturadas + (avesCapturadas - avesAnilladas);
                }

                salida.println(totalCapturadas);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (entrada != null) entrada.close();
            if (salida != null) salida.close();
        }
    }
}
