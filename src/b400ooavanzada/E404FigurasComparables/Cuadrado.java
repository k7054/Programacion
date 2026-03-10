package b400ooavanzada.E404FigurasComparables;


public class Cuadrado extends Rectangulo {
    public Cuadrado(double lado) {
        super(lado, lado);
    }

    public String toString() {
        return "Cuadrado, lado = " + getLado() + ", área = " + calcularArea();
    }

    public void setBase(double base) {
        super.setBase(base);
        super.setAltura(base);
    }

    public void setAltura(double altura) {
        super.setBase(altura);
        super.setAltura(altura);
    }

    public double getLado() {
        return base;
    }

    public void setLado(double lado) {
        this.base = lado;
        this.altura = lado;
    }
}