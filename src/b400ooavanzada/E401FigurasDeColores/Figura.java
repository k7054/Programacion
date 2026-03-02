package b400ooavanzada.E401FigurasDeColores;

public abstract class Figura {
    public static final String RESET = "\u001B[0m";
    public static final String rojo = "\u001B[31m";
    public static final String verde = "\u001B[32m";
    public static final String azul = "\u001B[34m";

    public String color;

    public Figura(String color) {
        this.color = color;
    }

    public abstract String toString();

    public abstract double calcularArea();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
