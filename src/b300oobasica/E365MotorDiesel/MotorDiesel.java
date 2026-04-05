package b300oobasica.E365MotorDiesel;

public class MotorDiesel {
    // ── Constantes físicas ────────────────────────────────────────────────
    // Inercia: qué tanto "cuesta" cambiar las RPM. Mayor valor = motor más lento de responder.
    private static final double INERCIA_MOTOR  = 0.2;
    // Fricción interna del motor: siempre está restando par, aunque no aceleres.
    private static final double FRICCION_BASE  = 20.0;
    private static final double RPM_MINIMA     = 800.0;
    private static final double RPM_MAXIMA     = 4500.0;

    // La estrategia que este motor usará para calcular el par
    private final EstrategiaCurvaPar estrategia;

    // ── Estado interno ────────────────────────────────────────────────────
    private double rpmActuales;
    private double acelerador;   // 0.0 = suelto, 1.0 = a fondo
    private boolean encendido;

    // ── Constructor ───────────────────────────────────────────────────────
    public MotorDiesel(EstrategiaCurvaPar estrategia) {
        this.estrategia  = estrategia;
        this.rpmActuales = 0.0;
        this.acelerador  = 0.0;
        this.encendido   = false;
    }

    // ── Interfaz pública ──────────────────────────────────────────────────
    public void encender() {
        encendido    = true;
        rpmActuales  = RPM_MINIMA;  // El motor arranca en ralentí
    }

    public void apagar() {
        encendido    = false;
        rpmActuales  = 0.0;
    }

    public void setAcelerador(double valor) {
        // Aseguramos que el valor siempre esté entre 0.0 y 1.0
        this.acelerador = Math.max(0.0, Math.min(1.0, valor));
    }

    // ── Método central: calcula el par neto en el estado actual ───────────
    // Lo separamos para que Coche también pueda usarlo sin duplicar código
    public double calcularParNeto() {
        // A: Par que el motor PUEDE dar a estas RPM (según la curva)
        double parDisponible = estrategia.calcularPar(rpmActuales);

        // B: De ese par, solo usamos la fracción que el acelerador permite
        //    Si acelerador=0.8 y parDisponible=350 → parGenerado=280 Nm
        double parGenerado = parDisponible * acelerador;

        // C y D: Restamos la fricción interna del motor
        //         Si no aceleramos nada → parNeto es negativo → frena el motor
        return parGenerado - FRICCION_BASE;
    }

    // ── Bucle de simulación (Fase 2, motor autónomo) ──────────────────────
    public void actualizar(double deltaT) {
        if (!encendido) return;

        // D: Par neto (ya implementado arriba)
        double parNeto = calcularParNeto();

        // E: Segunda Ley de Newton rotacional: α = τ / I
        //    (Aceleración angular = par neto / inercia)
        double aceleracionAngular = parNeto / INERCIA_MOTOR;

        // F: Integración numérica: RPM_nuevas = RPM_actuales + α × ΔT
        double rpmNuevas = rpmActuales + aceleracionAngular * deltaT;

        // G: Limitamos las RPM al rango físico del motor
        rpmActuales = Math.max(RPM_MINIMA, Math.min(RPM_MAXIMA, rpmNuevas));
    }

    // ── Métodos para que Coche pueda leer y escribir el estado ───────────
    public void setRpm(double rpm) {
        if (encendido) {
            rpmActuales = Math.max(RPM_MINIMA, Math.min(RPM_MAXIMA, rpm));
        }
    }

    public double getRpmActuales() { return rpmActuales; }
    public boolean isEncendido()   { return encendido; }
}
