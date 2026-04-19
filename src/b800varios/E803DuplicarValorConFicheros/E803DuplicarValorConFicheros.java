package b800varios.E803DuplicarValorConFicheros;

import java.io.*;
import java.util.Scanner;

public class E803DuplicarValorConFicheros {
    public static void main(String[] args) {
        Scanner entrada = null;
        PrintWriter salida = null;

        try {
            entrada = new Scanner(new BufferedReader(new FileReader("src/b800varios/E803DuplicarValorConFicheros/entrada.txt")));
            salida = new PrintWriter(new BufferedWriter(new FileWriter("src/b800varios/E803DuplicarValorConFicheros/salida.txt")));

            while (entrada.hasNext()) {
                int num = entrada.nextInt();
                num = num * 2;
                salida.println(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (entrada != null) entrada.close();
            if (salida != null) salida.close();
        }
    }
}
