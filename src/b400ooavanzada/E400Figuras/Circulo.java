package b400ooavanzada.E400Figuras;

public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return 2 * Math.PI * radio;
    }
}
