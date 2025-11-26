void main() {
    IO.println("ARRAYS LITERALES");

    int[] numeros = {17, 23, 5, 21};
    double[] longitudes = {11.36, 0.0, 1.184, -3.98, 1495739.2};
    boolean[] indicadores = {false, false, true, false, true};

    for (int numeroActual : numeros) {
        IO.print(numeroActual + " ");
    }

    IO.println();

    for (double longitudActual : longitudes) {
        IO.print(longitudActual + " ");
    }

    IO.println();

    for (boolean indicadorActual : indicadores) {
        IO.print(indicadorActual + " ");
    }
}