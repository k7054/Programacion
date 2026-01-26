package b800varios;

public class E822SumaTotalRecursivo {

    public static int sumaTotal(int numero) {
        if (numero == 0) {
            return 0;
        } else {
            return numero + sumaTotal(numero - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(sumaTotal(10));
    }
}
