package b400ooavanzada.E430GlobosConJugadoresMixtos;

public class Juego {
    private static final int RONDAS_PARA_GANAR = 3;

    private Jugador j1;
    private Jugador j2;

    public Juego(Jugador j1, Jugador j2) {
        this.j1 = j1;
        this.j2 = j2;
    }

    public void jugar() {
        System.out.println("GLOBOS EXPLOSIVOS");

        int ronda = 1;

        while (j1.getVictorias() < RONDAS_PARA_GANAR
                && j2.getVictorias() < RONDAS_PARA_GANAR) {

            System.out.println("\nRONDA " + ronda);
            Globo globo = new Globo();
            Jugador perdedor = jugarRonda(globo);

            Jugador ganadorRonda = (perdedor == j1) ? j2 : j1;
            ganadorRonda.sumarVictoria();

            System.out.println("\nRonda " + ronda + " ganada por: " + ganadorRonda.getNombre());
            mostrarMarcador();
            ronda++;
        }

        Jugador ganador = (j1.getVictorias() >= RONDAS_PARA_GANAR) ? j1 : j2;
        System.out.println("  GANADOR DE LA PARTIDA: " + ganador.getNombre());
    }

    private Jugador jugarRonda(Globo globo) {
        Jugador[] turno = {j1, j2};
        int indice = 0;

        while (!globo.explotado()) {
            Jugador jugadorActual = turno[indice % 2];

            mostrarCabecera(jugadorActual);

            int soplo = jugadorActual.determinarSoplo();
            globo.inflar(soplo);

            if (globo.explotado()) {
                System.out.println("Globo: " + globo);
                System.out.println("¡¡BOOM!! El globo ha explotado en las manos de "
                        + jugadorActual.getNombre() + ".");
                return jugadorActual;
            }

            indice++;
        }

        // No debería llegar aquí, pero por si acaso
        return turno[indice % 2];
    }

    private void mostrarCabecera(Jugador jugadorActual) {
        System.out.println();
        System.out.printf("%s [%s]   vs   %s [%s]%n",
                j1.getNombre(), marcadorIconos(j1),
                j2.getNombre(), marcadorIconos(j2));
        System.out.println("Turno de: " + jugadorActual.getNombre());
    }

    private String marcadorIconos(Jugador j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < RONDAS_PARA_GANAR; i++) {
            sb.append(i < j.getVictorias() ? "v " : "· ");
        }
        return sb.toString().trim();
    }

    private void mostrarMarcador() {
        System.out.printf("  Marcador — %s: %d  |  %s: %d%n",
                j1.getNombre(), j1.getVictorias(),
                j2.getNombre(), j2.getVictorias());
    }
}
