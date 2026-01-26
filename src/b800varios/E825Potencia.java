package b800varios;

public class E825Potencia {

    public static int potencia(int num, int exp) {
        if (exp == 0) {
            return 1;
        } else {
            return num * potencia(num, exp - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(potencia(2, 3));
    }
}
