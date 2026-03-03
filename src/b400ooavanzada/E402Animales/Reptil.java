package b400ooavanzada.E402Animales;

public abstract class Reptil extends Animal {
    public Reptil() {
        super();
    }

    public Reptil(int energia) {
        super(energia);
    }

    public void habla() {
        reducirEnergia(3);
    }
}
