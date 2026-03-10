package b400ooavanzada.E404FigurasComparables;

public class Rectangulo extends Figura {
    protected double base;
    protected double altura;

    public Rectangulo(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public double calcularArea() {
        return getBase() * getAltura();
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}