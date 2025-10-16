void main() {
    IO.println("Contar y sumar dígitos");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int num;

    do {
        num = Integer.parseInt(IO.readln(nombre + ", introduce un valor entero positivo:\n"));
    } while (num <= 0);

    int digitos;
    int cantidadDigitos = 0;
    int sumaDigitos = 0;

    while (num > 0) {
        digitos = num % 10;
        num = num / 10;
        cantidadDigitos++;
        sumaDigitos = sumaDigitos + digitos;
    }

    String resultado = String.format("Tiene %d dígitos y su suma es %d", cantidadDigitos, sumaDigitos);
    IO.println(resultado);
}