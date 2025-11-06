double calcularHipotenusa(double cateto1, double cateto2) {
    return Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
}

void main() {
    IO.println("HIPOTENUSA");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    double cateto1;
    double cateto2;

    do {
        cateto1 = Double.parseDouble(IO.readln(nombre + ", introduce el primer cateto, tiene que ser positivo mayor que 0:\n"));
        cateto2 = Double.parseDouble(IO.readln(nombre + ", introduce el segundo cateto, tiene que ser positivo mayor que 0:\n"));
    } while (cateto1 <= 0 || cateto2 <= 0);

    IO.println("La hipotenusa es " + calcularHipotenusa(cateto1, cateto2));
}