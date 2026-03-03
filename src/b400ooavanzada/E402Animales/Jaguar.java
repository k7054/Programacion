package b400ooavanzada.E402Animales;

public class Jaguar extends Mamifero {
    public Jaguar() {
        super();
    }

    public Jaguar(int energia) {
        super(energia);
    }

    public void habla() {
        if (energia < 30) {
            System.out.println("grrrrrrrr-uhhh");
        } else if (energia >= 30 && energia < 70) {
            System.out.println("grrr-uh");
        } else {
            System.out.println("¡GRRRRRR-UH!");
        }

        super.habla();
    }

    public void come(int cantidad) {
        setEnergia(getEnergia() + (cantidad * 20));
    }
}
