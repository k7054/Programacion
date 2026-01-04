package b200algoritmica;

public class E207FibonacciSinArray {
    public static void main(String[] args) {

        int num1 = 0;
        int num2 = 1;
        int contador = 0;

        System.out.printf("%d %d ", num1, num2);

        while (contador < 28) {
            int num = num2 + num1;
            System.out.printf("%d ", num);
            contador++;
            num1 = num2;
            num2 = num;
        }
    }
}
