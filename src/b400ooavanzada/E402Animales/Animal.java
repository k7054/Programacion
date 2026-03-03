package b400ooavanzada.E402Animales;

public abstract class Animal {
    public static final int ENERGIA_MIN = 0;
    public static final int ENERGIA_MAX = 100;

    protected int energia;

    public Animal() {
        this.energia = ENERGIA_MAX;
    }

    public Animal(int energia) {
        setEnergia(energia);
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if (energia > ENERGIA_MAX) {
            this.energia = ENERGIA_MAX;
        } else if (energia < ENERGIA_MIN) {
            this.energia = ENERGIA_MIN;
        } else {
            this.energia = energia;
        }
    }

    public abstract String hablar();
    public abstract int come(int cantidadComida);
}
