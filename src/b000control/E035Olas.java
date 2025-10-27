void main() {
    IO.println("Olas");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int numOlas = Integer.parseInt(IO.readln(nombre + ", introduce la cantidad de olas que quieres imprimir:\n"));
    int amplitudOlas = Integer.parseInt(IO.readln(nombre + ", introduce la amplitud maxima de olas:\n"));

    for (int ola = 1; ola <= numOlas; ola++) {
        for (int linea = 1; linea <= amplitudOlas; linea++) {
            for (int asterisco = 1; asterisco <= linea; asterisco++) {
                IO.print("*");
            }
            IO.println();
        }

        for (int linea = amplitudOlas - 1; linea >= 1; linea--) {
            for (int asterisco = 1; asterisco <= linea; asterisco++) {
                IO.print("*");
            }
            IO.println();
        }
    }
}