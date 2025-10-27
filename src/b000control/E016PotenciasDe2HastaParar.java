void main() {
    IO.println("Potencias de N hasta parar");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int base = Integer.parseInt(IO.readln(nombre + ", introduce la base\n"));
    char letra = Character.toLowerCase(IO.readln(nombre + ", introduce una s para imprimir una potencia de N o una n para parar.\n").charAt(0));

    while ((letra != 'n') && (letra != 's')) {
        letra = Character.toLowerCase(IO.readln("¡Error!, introduce una s para imprimir una potencia de N o una n para parar.\n").charAt(0));
    }

    int exponente = 0;
    int resultado = 1;

    if (base < 0) resultado = -resultado;

    int a = Math.abs(base);

    while (letra == 's') {

        System.out.printf("%d ^ %d = %d\n", base, exponente, resultado);

        resultado = resultado * a;
        exponente++;

        letra = Character.toLowerCase(IO.readln(nombre + ", introduce una s para imprimir una potencia de N o una n para parar.\n").charAt(0));
    }
}