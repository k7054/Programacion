package b400ooavanzada.E401FigurasDeColores;

public abstract class Figura {
    public static final String RESET = "\u001B[0m";

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
