package b400ooavanzada.E402Animales;

public class Pajaro extends Ave {
    public Pajaro() {
        super();
    }

    public Pajaro(int energia) {
        super(energia);
    }

    public void habla() {
        if (energia < 30) {
            System.out.println("piooooo");
        } else if (energia >= 30 && energia < 70) {
            System.out.println("pio");
        } else {
            System.out.println("¡PIO!");
        }

        super.habla();
    }

    public void come(int cantidad) {
        setEnergia(getEnergia() + (cantidad * 5));
    }
}
