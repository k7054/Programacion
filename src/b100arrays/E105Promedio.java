void main() {
    IO.println("PROMEDIO");

    double[] valores = {7.5, 5, 8, 3, 0.5};

    double suma = 0;

    for (double valor : valores) {
        suma = suma + valor;
    }

    IO.println(String.format("El promedio es %.2f.", suma / valores.length));
}