void main() {
    IO.println("ORDENACIÓN BURBUJA");

    int[] lista = {5, 8, 15, 20, 3, 8, 10, 7};

    for (int i = 0; i < lista.length - 1; i++) {
        for (int k = 0; k < lista.length - 1 - k; k++) {
            int numAlmacenado;
            if (lista[k] > lista[k + 1]) {
                numAlmacenado = lista[k + 1];
                lista[k + 1] = lista[k];
                lista[k] = numAlmacenado;
            }
        }
    }

    IO.println(Arrays.toString(lista));
}