package b400ooavanzada.E430GlobosConJugadoresMixtos;

public abstract class Jugador implements Comparable<Jugador> {
    protected static final int SOPLO_MINIMO = 1;
    protected static final int SOPLO_MAXIMO = 10;

    protected String nombre;
    protected int victorias = 0;

    public Jugador(String nombre) {
        setNombre(nombre);
    }

    public String toString() {
        return String.format("%s %s (%d victorias)",
                getClass().getSimpleName(),
                getNombre(),
                victorias
        );
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract int determinarSoplo();

    public void incrementarVictorias() {
        victorias++;
    }

    public int compareTo(Jugador otro) {
        return this.victorias - otro.victorias;
    }
}
