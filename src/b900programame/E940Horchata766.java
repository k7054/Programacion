package b900programame;

import java.util.*;

// Cada persona de la cola
class Persona implements Comparable<Persona> {
    int trabajo;
    int cantidad;

    Persona(int trabajo, int cantidad) {
        this.trabajo = trabajo;
        this.cantidad = cantidad;
    }

    @Override
    public int compareTo(Persona otra) {
        // Mayor trabajo → más prioridad
        if (this.trabajo != otra.trabajo) {
            return otra.trabajo - this.trabajo;
        }
        // Empate → menos horchata pedida primero
        return this.cantidad - otra.cantidad;
    }
}

public class E940Horchata766 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int n = sc.nextInt();

        while (h != 0 || n != 0) {

            PriorityQueue<Persona> cola = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                int t = sc.nextInt();
                int c = sc.nextInt();
                cola.offer(new Persona(t, c));
            }

            int servidos = 0;

            while (!cola.isEmpty()) {
                Persona p = cola.peek();      // miramos sin extraer
                if (p.cantidad > h) break;    // no alcanza → parar
                cola.poll();                  // ahora sí la sacamos
                h -= p.cantidad;
                servidos++;
            }

            System.out.println(servidos + " " + h);

            h = sc.nextInt();
            n = sc.nextInt();
        }
    }
}
