package b300oobasica.E360TiroVertical;

public class Principal {
    public static void main(String[] args) {

        // Probamos con tres valores de deltaTiempo
        double[] deltas = {1.0, 0.1, 0.01};

        for (double deltaTiempo : deltas) {

            System.out.println("Simulación con dt = " + deltaTiempo);
            System.out.printf("%-10s %-15s %-15s%n", "Tiempo", "Altura", "Velocidad");

            // Creamos un proyectil fresco para cada simulación
            Proyectil p = new Proyectil(60.0); // 60 m/s hacia arriba

            double tiempo = 0.0;

            int imprimirCada = 1;

            // El bucle continúa mientras el proyectil esté sobre el suelo
            while (p.getAltura() >= 0) {
                if (imprimirCada == 1) {
                    // Imprimimos el estado ANTES de actualizar
                    System.out.printf("%-10.2f %-15.4f %-15.4f%n",
                            tiempo, p.getAltura(), p.getVelocidad());
                    imprimirCada = (int) (1 / deltaTiempo);
                } else {
                    imprimirCada--;
                }

                // Actualizamos la física
                p.actualizar(deltaTiempo);

                // Sumamos el tiempo transcurrido
                tiempo += deltaTiempo;
            }

            System.out.println("Tiempo final: " + tiempo + " s");
            System.out.println();
        }
    }
}
