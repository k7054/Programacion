package b300oobasica.E304ContadorConMinMaxConfigurables;

public class Principal {
    static void main(String[] args) {
        Contador c1 = new Contador(); // Valor inicial por defecto 50, paso por defecto 1, no redondeo.
        Contador c2 = new Contador(77); // Valor inicial 77, paso por defecto 1, no redondeo.
        Contador c3 = new Contador(77, 5, 5, 85); // Valor inicial 77, paso 5, no redondeo.
        Contador c4 = new Contador(77, 5, true); // Valor inicial (redondeado) 75, paso 5, sí redondeo.

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        c1.incrementar();
        System.out.println("Tras incrementar: " + c1);

        c2.incrementar(10);
        System.out.println("Tras incrementar (10): " + c2);

        c3.decrementar();
        System.out.println("Tras decrementar: " + c3);

        c4.decrementar(10);
        System.out.println("Tras decrementar (10): " + c4);
    }
}
