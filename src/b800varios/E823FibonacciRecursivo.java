package b800varios;

public class E823FibonacciRecursivo {

    public static int fibonacci(int numero) {
        if (numero == 1) {
            return 0;
        } else if (numero == 2) {
            return 1;
        } else {
            return fibonacci(numero - 1) + fibonacci(numero - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
