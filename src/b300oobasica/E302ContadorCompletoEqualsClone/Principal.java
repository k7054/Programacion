package b300oobasica.E302ContadorCompletoEqualsClone;

public class Principal {
    static void main(String[] args) {
        Contador a = new Contador(7);
        Contador b = new Contador(7);

        System.out.println(a);
        System.out.println(b);

        if (a.equals(a)) {
            System.out.println("Iguales");
        } else {
            System.out.println("Distintos");
        }

        b.incrementar(3);

        System.out.println(a);
        System.out.println(b);

        if (a.equals(b)) {
            System.out.println("Iguales");
        } else {
            System.out.println("Distintos");
        }

        Contador c = a.clone();

        System.out.println(a);
        System.out.println(c);

        if (a.equals(c)) {
            System.out.println("Iguales");
        } else {
            System.out.println("Distintos");
        }
    }
}
