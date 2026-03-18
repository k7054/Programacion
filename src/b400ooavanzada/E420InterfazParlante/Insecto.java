package b400ooavanzada.E420InterfazParlante;

public class Insecto extends Animal {
    public static final int GASTO_POR_HABLAR = 1;

    public Insecto(int aprovechamientoComida, String nombre) {
        super(aprovechamientoComida, GASTO_POR_HABLAR, nombre);
    }

    public Insecto(int aprovechamientoComida, String nombre, int energia) {
        super(aprovechamientoComida, GASTO_POR_HABLAR, nombre, energia);
    }
}
