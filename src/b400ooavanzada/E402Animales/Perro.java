package b400ooavanzada.E402Animales;

public class Perro extends Mamifero {
    public Perro() {
        super();
    }

    public Perro(int energia) {
        super(energia);
    }

    public void habla() {
        if (energia < 30) {
            System.out.println("guauuuuu");
        } else if (energia >= 30 && energia < 70) {
            System.out.println("guau");
        } else {
            System.out.println("¡GUAU!");
        }

        super.habla();
    }

    public void come(int cantidad) {
        setEnergia(getEnergia() + (cantidad * 7));
    }
}
