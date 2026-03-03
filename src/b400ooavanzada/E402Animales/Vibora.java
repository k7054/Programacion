package b400ooavanzada.E402Animales;

public class Vibora extends Reptil {
    public Vibora() {
        super();
    }

    public Vibora(int energia) {
        super(energia);
    }

    public void habla() {
        if (energia < 30) {
            System.out.println("sssssssssssssss");
        } else if (energia >= 30 && energia < 70) {
            System.out.println("tsssss-hhh");
        } else {
            System.out.println("¡TSSSSS-HHH!");
        }

        super.habla();
    }

    public void come(int cantidad) {
        setEnergia(getEnergia() + (cantidad * 10));
    }
}
