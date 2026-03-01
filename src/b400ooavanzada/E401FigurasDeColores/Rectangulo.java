package b400ooavanzada.E401FigurasDeColores;

public class Rectangulo extends Figura {
    protected double base, altura;

    public Rectangulo(double base, double altura, String color) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }

    public String toString() {
        return getColor() + "Rectángulo, base = " + base + ", altura = " + altura + ", área = " + calcularArea() + "\u001B[0m";
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
