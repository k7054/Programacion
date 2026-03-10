package b400ooavanzada.E404FigurasComparables;


public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        setRadio(radio);
    }

    public double calcularArea() {
        return Math.PI * getRadio() * getRadio();
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}