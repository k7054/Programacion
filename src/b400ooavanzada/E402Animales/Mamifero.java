package b400ooavanzada.E402Animales;

public abstract class Mamifero extends Animal {
    public Mamifero() {
        super();
    }

    public Mamifero(int energia) {
        super(energia);
    }

    public void habla() {
        reducirEnergia(5);
    }
}
