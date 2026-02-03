package b300oobasica.E321ArrayListBasico;

import java.util.ArrayList;
import java.util.Iterator;

public class Principal {
    public static void main(String[] args) {
        // Se declara una lista con ESPACIO INICIAL para 10 posiciones
        // (pero con CERO posiciones con datos y por tanto con tamaño CERO).
        // La lista se parametriza con el tipo Integer.
        ArrayList<Integer> lista = new ArrayList<Integer>();

        // Se imprime el tamaño de la lista.
        System.out.println(lista.size());
        System.out.println();

        // Se añaden algunos valores, que deberán ser de tipo Integer
        // pero gracias a la ayuda del compilador autoboxing/autounboxing
        // podemos escribir en forma de int normales (¡pero NO son int-s!).
        lista.add(17);
        lista.add(new Integer(8));
        lista.add(31);

        // Se imprime el tamaño de la lista.
        System.out.println(lista.size());
        System.out.println();

        // Se recorre la lista mediante una VARIABLE de control clásica:
        for (int i = 0; i < lista.size(); i++) {
            Integer elem = lista.get(i);

            System.out.println(elem);
        }

        System.out.println();

        // Se recorre la lista mediante un FOREACH:
        for (Integer elem : lista) {
            System.out.println(elem);
        }

        System.out.println();

        // Se recorre la lista mediante un ITERATOR parametrizado a Integer:
        for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext(); ) {
            Integer elem = iterator.next();

            System.out.println(elem);
        }
    }
}
