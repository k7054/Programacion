package b400ooavanzada.E400Figuras;

public class Principal {
    static void main(String[] args) {
        Figura f2 = new Circulo(7.59);
        Figura f3 = new Rectangulo(3.45, 8.91);
        // Figura f4 = new Cuadrado();
        Circulo c1 = new Circulo(5.55);
        Rectangulo r1 = new Rectangulo(9.05, 1);

        System.out.println(c1.calcularArea());
        System.out.println(f3.calcularArea());

        Figura[] figuras = new Figura[3];
        figuras[0] = f3;
        figuras[1] = c1;
        figuras[2] = r1;

        for (Figura f : figuras) {
            System.out.println(f.calcularArea());
        }
    }
}
