package b400ooavanzada.E401FigurasDeColores;

public class Principal {
    public static final String rojo = "\u001B[31m";
    public static final String verde = "\u001B[32m";
    public static final String azul = "\u001B[34m";

    static void main(String[] args) {
        Figura f1 = new Circulo(70, rojo);
        Figura f2 = new Cuadrado(20, verde);
        Figura f3 = new Rectangulo(23, 45, azul);
        Circulo c1 = new Circulo(60, rojo);
        Cuadrado q2 = new Cuadrado(30, verde);
        Rectangulo r3 = new Rectangulo(26, 67, azul);

        Figura[] figuras = new Figura[6];
        figuras[0] = f1;
        figuras[1] = f2;
        figuras[2] = f3;
        figuras[3] = c1;
        figuras[4] = q2;
        figuras[5] = r3;

        double areaTotal = 0;
        for (Figura figura : figuras) {
            System.out.println(figura);
            areaTotal = areaTotal + figura.calcularArea();
        }

        System.out.println(areaTotal);
    }
}
