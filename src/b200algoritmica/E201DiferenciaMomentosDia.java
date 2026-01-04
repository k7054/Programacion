void main() {
    IO.println("DIFERENCIA MOMENTOS DÍA");

    int h1 = 05, m1 = 10;
    int h2 = 20, m2 = 55;

    int totalMinutosH1;
    int totalMinutosH2;

    totalMinutosH1 = (h1 * 60 + m1);
    totalMinutosH2 = (h2 * 60 + m2);

    int diferenciaMinTotal = Math.abs(totalMinutosH1 - totalMinutosH2);

    int horas = diferenciaMinTotal / 60;
    int minutos = diferenciaMinTotal % 60;

    IO.println(String.format("La diferencia es de %02d:%02d.", horas, minutos));
}