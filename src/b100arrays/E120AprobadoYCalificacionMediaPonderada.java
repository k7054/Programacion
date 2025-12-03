void main() {
    IO.println("APROBADO Y CALIFICACIÓN MEDIA PONDERADA");

    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    double[] calificaciones = {5.7, 9.5, 4.9, 0.0, 7.75};
    double[] pesos = {0.15, 0.20, 0.25, 0.30, 0.10};

    double media = 0;

    boolean notaSuperiorAlMinimo = true;

    for (int i = 0; i < calificaciones.length; i++) {
        media = media + (calificaciones[i] * pesos[i]);
        if (calificaciones[i] < 4) notaSuperiorAlMinimo = false;
    }

    String aprobadoSiNo = (notaSuperiorAlMinimo && media >= 5) ? "sí" : "no";

    IO.println(String.format("%s, %s aprueba con una calificación de %.2f.", nombre, aprobadoSiNo, media));
}