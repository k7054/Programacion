void main() {
    IO.println("Elefantes");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    int n = Integer.parseInt(IO.readln(nombre + ", introduce un número\n"));

    for (int i = 1; i <= n; i++) {
        boolean singular = (i == 1);

        String elefante = singular ? "elefante" : "elefantes";
        String balanceaba = singular ? "balanceaba" : "balanceaban";

        if (i >= n * 0.75) elefante = elefante.toUpperCase();

        String frase = String.format("Había una vez %d %s que se %s en una hamaca a la orilla de un río.\n", i, elefante, balanceaba);

        IO.print(frase);
    }
}