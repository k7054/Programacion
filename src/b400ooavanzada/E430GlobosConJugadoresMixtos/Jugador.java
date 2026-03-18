package b400ooavanzada.E430GlobosConJugadoresMixtos;

public abstract class Jugador {

    private String nombre;
    private int victorias = 0;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public void sumarVictoria() {
        victorias++;
    }

    public abstract int determinarSoplo();
}
