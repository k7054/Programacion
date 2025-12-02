void main() {
    IO.println("APROBADO Y CALIFICACIÓN MEDIA PONDERADA");

    double[] calificaciones = {5.7, 9.5, 4.9, 0.0, 7.75};
    double[] pesos = {0.15, 0.20, 0.25, 0.30, 0.10};

    double media = 0;

    for (int i = 0; i < calificaciones.length; i++) {
        media = media + (calificaciones[i] * pesos[i]);
    }

}