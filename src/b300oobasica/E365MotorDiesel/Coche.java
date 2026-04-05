package b300oobasica.E365MotorDiesel;

public class Coche {
    // ── Constantes físicas ────────────────────────────────────────────────
    private static final double MASA = 1400.0;  // kg

    // Factor de conversión velocidad → RPM.
    // A ~50 m/s (180 km/h) queremos ~4500 RPM → factor = (4500-800)/50 ≈ 74
    private static final double FACTOR_RPM_POR_MS = 74.0;

    // ── Estado ────────────────────────────────────────────────────────────
    private final MotorDiesel motor;
    private double velocidadActual; // en metros por segundo

    // ── Constructor ───────────────────────────────────────────────────────
    public Coche(EstrategiaCurvaPar estrategia) {
        // Composición: el Coche crea y posee su MotorDiesel
        this.motor          = new MotorDiesel(estrategia);
        this.velocidadActual = 0.0;
    }

    // ── Delegamos al motor ────────────────────────────────────────────────
    public void encender()                   { motor.encender(); }
    public void apagar()                     { motor.apagar(); }
    public void setAcelerador(double valor)  { motor.setAcelerador(valor); }

    // ── Bucle de simulación acoplado ──────────────────────────────────────
    public void actualizar(double deltaT) {
        if (!motor.isEncendido()) return;

        // VÍNCULO DINÁMICO: Las RPM se derivan de la velocidad actual.
        // Cuanto más rápido va el coche, más rápido gira el motor.
        // A velocidad 0 el motor queda en ralentí (800 RPM).
        double rpmPorVelocidad = 800.0 + velocidadActual * FACTOR_RPM_POR_MS;
        motor.setRpm(rpmPorVelocidad);  // Sustituye la integración libre del motor

        // Obtenemos el par neto del motor a esas RPM y con el acelerador actual
        double parNeto = motor.calcularParNeto();

        // Simplificación del ejercicio: par (Nm) → fuerza de empuje (N) directamente
        double fuerzaEmpuje = parNeto;

        // Segunda Ley de Newton lineal: a = F / m
        double aceleracionLineal = fuerzaEmpuje / MASA;

        // Integración numérica: v_nueva = v_actual + a × ΔT
        velocidadActual += aceleracionLineal * deltaT;

        // La velocidad no puede ser negativa (el coche no marcha atrás solo)
        velocidadActual = Math.max(0.0, velocidadActual);
    }

    // ── Getters ───────────────────────────────────────────────────────────
    public double getVelocidadMs()  { return velocidadActual; }
    public double getVelocidadKmh() { return velocidadActual * 3.6; }
    public double getRpm()          { return motor.getRpmActuales(); }
}
