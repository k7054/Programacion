package b400ooavanzada.E401FigurasDeColores;

public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio, String color) {
        super(color);
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    public String toString() {
        return getColor() + "Círculo, radio = " + getRadio() + ", área = " + calcularArea() + RESET;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}
