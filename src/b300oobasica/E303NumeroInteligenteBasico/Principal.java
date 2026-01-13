package b300oobasica.E303NumeroInteligenteBasico;

public class Principal {
    static void main(String[] args) {
        NumeroInteligente n1 = new NumeroInteligente();

        for (int i = 1; i <= 100; i++) {
            n1.setValor(i);
            if (n1.esPrimo()) {
                IO.println(i + ": SÍ ES PRIMO");
            } else {
                IO.println(i + ": NO ES PRIMO");
            }
        }

        IO.println();

        IO.println("Primero 100 números primos:");
        NumeroInteligente n2 = new NumeroInteligente(2);

        int contador = 0;

        while (contador < 100) {
            if (n2.esPrimo()){
                IO.println(n2.getValor());
                contador++;
            }
            n2.incrementar();
        }

        IO.println();

        NumeroInteligente n3 = new NumeroInteligente();

        IO.println("Utilizamos la formula de Euclides (2^{n-1} * (2^{n} - 1)), siempre que (2^{n} - 1) sea primo de Mersenne.");
        for (int i = 1; i <= 15; i++) {
            n3.setValor(i);
            if (n3.esPerfecto()) {
                IO.println(n3.getPerfecto() + " ES PERFECTO");
            }
        }
    }
}
