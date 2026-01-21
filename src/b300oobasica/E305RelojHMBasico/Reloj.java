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
        conversorMinutos((h * 60) + m);
    }

    public Reloj(int totalMinutos) {
        conversorMinutos(totalMinutos);
    }

    public void conversorMinutos(int minutosTotales) {
        horas = minutosTotales / 60;
        minutos = minutosTotales % 60;
    }

    public String toString() {
        return String.format("%02d:%02d", horas, minutos);
    }

    public void tick() {
        sumarMinutos(1);
    }

    public void sumarMinutos(int minutosSumados) {
        int totalMinutos = horas * 60 + minutos;
        totalMinutos = totalMinutos + minutosSumados;

        totalMinutos = totalMinutos % 1440;

        conversorMinutos(totalMinutos);
    }

    public void restarMinutos(int minutosRestados) {
        int totalMinutos = horas * 60 + minutos;
        totalMinutos = totalMinutos - minutosRestados;

        totalMinutos = ((totalMinutos % 1440) + 1440) % 1440;

        conversorMinutos(totalMinutos);
    }

    public int diferenciaMinutos(Reloj otro) {
        return Math.abs((horas * 60 + minutos) - (otro.horas * 60 + otro.minutos));
    }

    public Reloj diferenciaReloj(Reloj otro) {
        int diferencia = diferenciaMinutos(otro);

        int hora = diferencia / 60;
        int minuto = diferencia % 60;

        return new Reloj(hora, minuto);
    }
}
