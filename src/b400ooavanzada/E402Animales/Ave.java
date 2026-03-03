package b400ooavanzada.E402Animales;

public abstract class Ave extends Animal {
    public Ave() {
        super();
    }

    public Ave(int energia) {
        super(energia);
    }

    public void habla() {
        reducirEnergia(2);
    }
}
