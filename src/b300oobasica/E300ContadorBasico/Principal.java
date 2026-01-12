package b300oobasica.E300ContadorBasico;

import java.util.Scanner;

public class Principal {
    static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Contador c = new Contador(23000, "balones");
        c.incrementar();
        c.incrementar();
        c.decrementar();
        IO.println(c);
        c.incrementar(10);
        IO.println(c);

        Contador c2 = new Contador();
        c2.incrementar();
        c2.incrementar();
        c2.decrementar();
        IO.println(c2);
        c.decrementar(10);
        IO.println(c2);
        c2.resetear();
        IO.println(c2);

        Contador c3 = new Contador("coches");
        c3.incrementar();
        c3.incrementar();
        c3.decrementar();
        IO.println(c3);
        c.decrementar(10);
        IO.println(c3);
        c3.resetear();
        IO.println(c3);

        Contador c4 = new Contador(23);
        c4.incrementar();
        c4.incrementar();
        c4.decrementar();
        IO.println(c4);
        c.decrementar(10);
        IO.println(c4);
        c4.resetear();
        IO.println(c4);
    }
}
