package b200algoritmica;

public class E206FibonacciConArray {
    public static void main(String[] args) {

        int[] numeros = new int[30];
        numeros[0] = 0;
        numeros[1] = 1;

        for (int i = 2; i < numeros.length; i++) {
            numeros[i] = numeros[i - 1] + numeros[i - 2];
        }

        for (int numero : numeros) {
            System.out.printf("%d ", numero);
        }
    }
}
