package b400ooavanzada.E431GlobosDeDistintosTipos;

public class GloboDefectuoso extends Globo {
    private boolean explotado = false;

    public GloboDefectuoso() {
        super();
    }

    public GloboDefectuoso(int capacidad) {
        super(capacidad);
    }

    @Override
    public void inflar(int cantidad) {
        super.inflar(cantidad);

        double porcentajeCapacidadNominal = (double) aire / capacidad;

        if (porcentajeCapacidadNominal >= 1.0) {
            explotado = true;
        } else if (porcentajeCapacidadNominal > 0.6) {
            double porcentajeCaminoRestante = (porcentajeCapacidadNominal - 0.6) / 0.4;
            explotado = (Math.random() < porcentajeCaminoRestante);
        }
    }

    @Override
    public boolean explotado() {
        return explotado;
    }
}
