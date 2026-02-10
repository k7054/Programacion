package b300oobasica.E330BingoSoloBombo;

public class Bombo {
    private int cantidadBolas;
    private boolean[] bolas;

    public Bombo(int cantidadBolas) {
        this.cantidadBolas = cantidadBolas;
        bolas = new boolean[cantidadBolas + 1];

        for (int i = 1; i <= cantidadBolas; i++) {
            bolas[i] = true;
        }
    }

    public String toString() {
        StringBuilder dentroFuera = new StringBuilder();

        dentroFuera.append("Dentro: ");
        for (int i = 1; i < bolas.length; i++) {
            if (bolas[i]) {
                dentroFuera.append(i + " ");
            }
        }

        dentroFuera.append("\nFuera: ");
        for (int i = 1; i < bolas.length; i++) {
            if (!bolas[i]) {
                dentroFuera.append(i + " ");
            }
        }

        return dentroFuera.toString();
    }

    public int dameBola() {
        int bola;
        do {
            bola = (int) (Math.random() * cantidadBolas + 1);
        } while (!bolaEstaDentro(bola));

        bolas[bola] = false;
        return bola;
    }

    public boolean bolaEstaDentro(int bola) {
        if (bola < 1 || bola > cantidadBolas) {
            return false;
        }

        return bolas[bola];
    }
}
