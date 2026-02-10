package b300oobasica.E330BingoSoloBombo;

public class Principal {
    public static void main(String[] args) {
        Bombo b = new Bombo(10);

        for (int i = 0; i < 5; i++) {
            int bola = b.dameBola();
            System.out.println("Ha salido la bola: " + bola);
            System.out.println(b);
        }
    }
}
