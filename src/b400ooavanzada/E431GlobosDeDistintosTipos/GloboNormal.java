package b400ooavanzada.E431GlobosDeDistintosTipos;

public class GloboNormal extends Globo {
    public GloboNormal() {
        super();
    }

    public GloboNormal(int capacidad) {
        super(capacidad);
    }

    @Override
    public boolean explotado() {
        return aire > capacidad;
    }
}
