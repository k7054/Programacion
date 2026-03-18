package b400ooavanzada.E430GlobosConJugadoresMixtos;

public class JugadorCpu extends Jugador {
    private static final int MAX_SOPLO = 10;

    public JugadorCpu(String nombre) {
        super(nombre);
    }

    @Override
    public int determinarSoplo() {
        int soplo = (int) (Math.random() * MAX_SOPLO) + 1;
        System.out.println(getNombre() + " (CPU) sopla: " + soplo);
        return soplo;
    }
}
