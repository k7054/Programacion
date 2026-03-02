package b400ooavanzada.E401FigurasDeColores;

public class Cuadrado extends Rectangulo {
    public Cuadrado(double lado, String color) {
        super(lado, lado, color);
    }

    public String toString() {
        return getColor() + "Cuadrado, lado = " + getLado() + ", área = " + calcularArea() + RESET;
    }

    public double getLado() {
        return base;
    }

    public void setLado(double lado) {
        this.base = lado;
        this.altura = lado;
    }
}
