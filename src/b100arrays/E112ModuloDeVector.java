void main() {
    IO.println("MÓDULO DE VECTOR");

    double[] valores = {4, 3, 6, 2};

    IO.println(Arrays.toString(valores));

    double suma = 0;

    for (double valor : valores) {
        suma = suma + Math.pow(valor, 2);
    }

    IO.println(String.format("\nEl módulo del vector es %.2f", Math.sqrt(suma)));
}