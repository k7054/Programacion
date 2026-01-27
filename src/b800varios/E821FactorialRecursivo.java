package b800varios;

public class E821FactorialRecursivo {

    public static int factorial(int numero) {
        if (numero == 0 || numero == 1) {
            return  1;
        } else {
            return numero * factorial(numero - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(10));
    }
}
