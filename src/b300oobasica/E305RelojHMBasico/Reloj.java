package b300oobasica.E305RelojHMBasico;

public class Reloj {
    private static final int HORA = 8;
    private static final int MINUTO = 15;

    private int horas;
    private int minutos;

    public Reloj() {
        horas = HORA;
        minutos = MINUTO;
    }

    public Reloj(int h, int m) {
        horas = h;
        minutos = m;
    }

    public Reloj(int totalMinutos) {
        horas = totalMinutos / 60;
        minutos = totalMinutos % 60;
    }

    public String toString() {
        return String.format("%02d:%02d", horas, minutos);
    }

    public void tick() {
        minutos++;
    }
}
