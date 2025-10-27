boolean esPositivo(int numero) {
    return (numero >= 0);
}

void main() {
    int num = Integer.parseInt(IO.readln("Introduce un número para decir si es positivo o negativo\n"));

    if (esPositivo(num)) {
        System.out.printf("El número %d es positivo\n", num);
    } else {
        System.out.printf("El número %d es negativo\n", num);
    }
}