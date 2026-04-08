package b800varios.E861ExcepcionesEnReloj;

public class Reloj {
    private int h;
    private int m;

    public Reloj() {
        this(8, 15);
    }

    public Reloj(int h, int m) {
        this.h = h;
        this.m = m;
        normalizar();
    }

    public Reloj(int totalMinutos) {
        this(0, totalMinutos);
    }

    public int getH() { return h; }
    public void setH(int h) { this.h = h; }
    public int getM() { return m; }
    public void setM(int m) { this.m = m; }

    public String toString() {
        return String.format("%02d:%02d", h, m);
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Reloj)) return false;
        Reloj otro = (Reloj) obj;
        return (this.h == otro.h) && (this.m == otro.m);
    }

    public Reloj clone() {
        return new Reloj(this.h, this.m);
    }

    // ----------------------------------------------------------------
    //  Métodos CON excepciones (los del mindmap)
    // ----------------------------------------------------------------

    /**
     * Avanza el reloj un minuto.
     * Lanza excepción si supera las 23:59 (en la práctica nunca ocurre
     * partiendo de un reloj válido, pero el contrato lo exige).
     */
    public void tick() throws DesbordamientoRelojException, OperacionNegativaRelojException {
        sumar(1);
    }

    /**
     * Suma los minutos indicados.
     *
     * @throws OperacionNegativaRelojException si minutos < 0
     * @throws DesbordamientoRelojException    si el resultado supera las 23:59
     */
    public void sumar(int minutos) throws DesbordamientoRelojException, OperacionNegativaRelojException {
        if (minutos < 0)
            throw new OperacionNegativaRelojException("No me pongas negativos. Inténtalo de nuevo.");
        if (totalMinutos() + minutos >= 24 * 60)
            throw new DesbordamientoRelojException("Te has intentado salir del rango.", true);

        m += minutos;
        normalizar();
    }

    /**
     * Resta los minutos indicados.
     *
     * @throws OperacionNegativaRelojException si minutos < 0
     * @throws DesbordamientoRelojException    si el resultado cae por debajo de las 00:00
     */
    public void restar(int minutos) throws DesbordamientoRelojException, OperacionNegativaRelojException {
        if (minutos < 0)
            throw new OperacionNegativaRelojException("No me pongas negativos. Inténtalo de nuevo.");
        if (totalMinutos() - minutos < 0)
            throw new DesbordamientoRelojException("Te has intentado salir del rango.", false);

        m -= minutos;
        normalizar();
    }

    // ----------------------------------------------------------------
    //  Métodos auxiliares privados
    // ----------------------------------------------------------------

    private int totalMinutos() {
        return 60 * h + m;
    }

    private void normalizar() {
        while (m <   0) { h--; m += 60; }
        while (m >= 60) { h++; m -= 60; }
        while (h <   0) { h += 24; }
        while (h >= 24) { h -= 24; }
    }

    // ----------------------------------------------------------------
    //  Métodos de cálculo (sin excepciones, sin cambiar el reloj)
    // ----------------------------------------------------------------

    public int diferenciaMinutos(Reloj otro) {
        return Math.abs(this.totalMinutos() - otro.totalMinutos());
    }

    public Reloj diferenciaReloj(Reloj otro) {
        return new Reloj(this.diferenciaMinutos(otro));
    }
}
