void main() {


    int[] buscados = {17, 23, 3};
    int[] lista = {8, 23, 30, 47, 17, 5, 17, 21, 2};

    int contador = 0;

    for (int i = 0; i < buscados.length; i++) {
        for (int j = 0; j < lista.length; j++) {
            if (buscados[i] == lista[j]) contador++;
        }
    }

    IO.println(String.format("Los números buscados aparecen %d veces.", contador));
}