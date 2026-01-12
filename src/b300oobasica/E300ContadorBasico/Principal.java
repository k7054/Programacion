package b300oobasica.E300ContadorBasico;

public class Principal {
    static void main(String[] args) {
        Contador c = new Contador(23000);
        c.incrementar();
        c.incrementar();
        c.decrementar();
        IO.println(c);

        Contador c2 = new Contador();
        c2.incrementar();
        c2.incrementar();
        c2.decrementar();
        IO.println(c2);
    }
}
