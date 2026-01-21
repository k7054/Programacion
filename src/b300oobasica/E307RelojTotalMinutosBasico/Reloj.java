package b300oobasica.E307RelojTotalMinutosBasico;

public class Reloj {
    private int totalMinutos;

    public Reloj() {
        this(8, 15);
    }

    public Reloj(int h, int m) {
        this.totalMinutos = h * 60 + m;
        normalizar();
    }

    public Reloj(int totalMinutos) {
        this.totalMinutos = totalMinutos;
        normalizar();
    }

    public int getH() {
        return totalMinutos / 60;
    }

    public int getM() {
        return totalMinutos % 60;
    }

    public String toString() {
        return String.format("%02d:%02d", getH(), getM());
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Reloj)) return false;

        Reloj otro = (Reloj) obj;
        return this.totalMinutos == otro.totalMinutos;
    }

    public Reloj clone() {
        return new Reloj(this.totalMinutos);
    }

    private void normalizar() {
        totalMinutos = totalMinutos % 1440;

        if (totalMinutos < 0) {
            totalMinutos = totalMinutos + 1440;
        }
    }

    public void tick() {
        sumarMinutos(1);
    }
    public void sumarMinutos(int minutos) {
        totalMinutos = totalMinutos + minutos;
        normalizar();
    }
    public void restarMinutos(int minutos) {
        totalMinutos = totalMinutos - minutos;
        normalizar();
    }

    public int diferenciaMinutos(Reloj otro) {
        return Math.abs(this.totalMinutos - otro.totalMinutos);
    }

    public Reloj diferenciaReloj(Reloj otro) {
        return new Reloj(diferenciaMinutos(otro));
    }
}
