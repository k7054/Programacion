void main() {
    IO.println("Modulos varios");

    for (int i = 0; i < 50; i++) {
        boolean esMultiplo = (i % 7 == 0);
        String siNo = esMultiplo ? "SÍ" : "NO";

        IO.println(String.format("Vamos por el número %d. %d módulo 5 es %d. El número %s es múltiplo de 7", i, i, i % 5, siNo));
    }
}