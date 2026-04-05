package b300oobasica.E365MotorDiesel;

public class Principal {
    public static void main(String[] args) {

        // Usamos la estrategia más realista: la parábola
        EstrategiaCurvaPar estrategia = new EstrategiaFuncionMatematica();
        Coche coche = new Coche(estrategia);

        double deltaT        = 0.1;   // Paso de tiempo: 100 ms
        double tiempoTotal   = 15.0;  // Simulamos 15 segundos
        double tiempoSoltar  = 10.0;  // A los 10s soltamos el acelerador

        // ── Preparamos el coche ───────────────────────────────────────────
        coche.encender();
        coche.setAcelerador(0.8);   // 80% de acelerador

        // ── Cabecera de la tabla ──────────────────────────────────────────
        System.out.println("╔═══════════╦══════════════╦════════════╦═══════════════╗");
        System.out.println("║ Tiempo(s) ║ Velocidad km/h ║ RPM        ║ Acelerador    ║");
        System.out.println("╠═══════════╬══════════════╬════════════╬═══════════════╣");

        // ── Bucle de simulación ───────────────────────────────────────────
        for (double t = 0; t <= tiempoTotal; t += deltaT) {

            // A los 10 segundos: soltamos el acelerador
            if (t >= tiempoSoltar && t < tiempoSoltar + deltaT) {
                coche.setAcelerador(0.0);
                System.out.println("╠═══════════╩══════════════╩════════════╩═══════════════╣");
                System.out.println("║          >>> ACELERADOR SUELTO <<<                    ║");
                System.out.println("╠═══════════╦══════════════╦════════════╦═══════════════╣");
            }

            // Avanzamos la simulación un paso de tiempo
            coche.actualizar(deltaT);

            // Imprimimos solo cada 10 pasos (cada 1 segundo) para no saturar la consola
            if (Math.round(t * 10) % 10 == 0) {
                String aceleradorStr = (t < tiempoSoltar) ? "████████░░ 80%" : "░░░░░░░░░░  0%";
                System.out.printf("║ %7.1f s ║  %8.2f      ║ %8.1f   ║ %s ║%n",
                        t,
                        coche.getVelocidadKmh(),
                        coche.getRpm(),
                        aceleradorStr);
            }
        }

        System.out.println("╚═══════════╩══════════════╩════════════╩═══════════════╝");
    }
}
