package b400ooavanzada.E431GlobosDeDistintosTipos;

public class GloboFlexible extends Globo {
    private int ultimoSoplo = 0;

    public GloboFlexible() {
        super();
    }

    public GloboFlexible(int capacidad) {
        super(capacidad);
    }

    @Override
    public void inflar(int cantidad) {
        ultimoSoplo = cantidad;
        super.inflar(cantidad);
    }

    @Override
    public boolean explotado() {
        double limiteExtendido = capacidad * 1.1;
        double sopleSuave = capacidad * 0.05;

        if (aire <= capacidad) {
            return false;
        } else if (aire > limiteExtendido) {
            return true;
        } else {
            return ultimoSoplo > sopleSuave;
        }
    }
}
