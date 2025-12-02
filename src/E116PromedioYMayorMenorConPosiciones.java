void main() {
    IO.println("PROMEDIO Y MAYOR Y MENOR CON POSICIONES");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int cantidadNum;


    do {
        cantidadNum = Integer.parseInt(IO.readln(nombre + ", introduzca la cantidad de números deseada(mínimo 2):\n"));
    } while (cantidadNum < 2);

    int[] numeros = new int[cantidadNum];
    double sumaTotal = 0;

    int mayor = Integer.MIN_VALUE;
    int menor = Integer.MAX_VALUE;

    int posicionMayor = 0;
    int posicionMenor = 0;

    for (int i = 0; i < numeros.length; i++) {
        numeros[i] = Integer.parseInt(IO.readln(String.format("%s, introduce el número %d:\n", nombre, i + 1)));

        int numero = numeros[i];

        if (numero > mayor){
            mayor = numero;
            posicionMayor = i + 1;
        }

        if (numero < menor){
            menor = numero;
            posicionMenor = i + 1;
        }

        sumaTotal = sumaTotal + numero;
    }

    IO.println(String.format("El promedio es %.1f", sumaTotal / numeros.length));
    IO.println(String.format("El mayor es %d(posición %d) y el menor es %d(posición %d).", mayor, posicionMayor, menor, posicionMenor));
}