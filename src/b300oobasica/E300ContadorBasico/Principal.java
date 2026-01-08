package b300oobasica.E300ContadorBasico;

public class Principal {
    static void main(String[] args) {

        Contador c = new Contador();
        c.setValor(35);
        c.incrementar();
        c.incrementar();
        c.decrementar();
        IO.println(c.getValor());
    }
}
