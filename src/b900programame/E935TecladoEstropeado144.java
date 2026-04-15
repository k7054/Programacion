package b900programame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class E935TecladoEstropeado144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linea;

        while ((linea = br.readLine()) != null) {
            LinkedList<Character> lista = new LinkedList<>();
            ListIterator<Character> cursor = lista.listIterator();

            for (char c : linea.toCharArray()) {
                switch (c) {
                    case '-': // Inicio: mover cursor al principio
                        while (cursor.hasPrevious()) {
                            cursor.previous();
                        }
                        break;

                    case '+': // Fin: mover cursor al final
                        while (cursor.hasNext()) {
                            cursor.next();
                        }
                        break;

                    case '*': // Flecha derecha: avanzar un carácter
                        if (cursor.hasNext()) {
                            cursor.next();
                        }
                        break;

                    case '3': // Supr: borrar carácter a la derecha del cursor
                        if (cursor.hasNext()) {
                            cursor.next();
                            cursor.remove();
                        }
                        break;

                    default: // Carácter normal: insertar en posición actual
                        cursor.add(c);
                        break;
                }
            }

            // Construir y mostrar el resultado
            StringBuilder sb = new StringBuilder();
            for (char c : lista) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
