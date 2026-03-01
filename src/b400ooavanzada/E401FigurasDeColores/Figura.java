package b400ooavanzada.E401FigurasDeColores;

public abstract class Figura {
    public String color;

    public Figura(String color) {
        this.color = color;
    }

    public abstract double calcularArea();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
