package b400ooavanzada.E400Figuras;

public class Rectangulo extends Figura {
    protected double base, altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }
}
