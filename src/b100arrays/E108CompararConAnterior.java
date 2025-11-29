void main() {
    IO.println("COMPARAR CON ANTERIOR");

    double[] numeros = {11.36, 1.184, 1.184, -3.98, 1495739.2};

    for (int i = 1; i < numeros.length; i++) {
        if (numeros[i] < numeros[i - 1]) IO.println(String.format("El número %d es MENOR que el número %d.", i + 1, i));
        else if (numeros[i] > numeros[i - 1]) IO.println(String.format("El número %d es MAYOR que el número %d.", i + 1, i));
        else                                IO.println(String.format("El número %d es IGUAL que el número %d.", i + 1, i));
    }
}