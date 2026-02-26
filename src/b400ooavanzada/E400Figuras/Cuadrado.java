package b400ooavanzada.E400Figuras;

public class Cuadrado extends Rectangulo {
    public Cuadrado(double lado) {
        super(lado, lado);
    }

    public double getLado() {
        return base;
    }

    public void setLado(double lado) {
        this.base = lado;
        this.altura = lado;
    }
}
