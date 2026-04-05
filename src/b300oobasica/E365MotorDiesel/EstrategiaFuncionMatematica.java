package b300oobasica.E365MotorDiesel;

public class EstrategiaFuncionMatematica implements EstrategiaCurvaPar {
    // Vértice de la parábola: par máximo (350 Nm) a 2500 RPM
    private final double h = 2500.0;  // RPM del par máximo
    private final double k = 350.0;   // Par máximo en Nm

    // Coeficiente de apertura. Negativo = parábola invertida (∩)
    // Cuanto más pequeño en valor absoluto, más "ancha" la curva
    private final double a = -0.00008;

    // Rango de funcionamiento del motor
    private final double RPM_MINIMA = 800.0;
    private final double RPM_MAXIMA = 4500.0;

    @Override
    public double calcularPar(double rpm) {
        // Fuera del rango de encendido → motor no produce par
        if (rpm < RPM_MINIMA || rpm > RPM_MAXIMA) {
            return 0.0;
        }

        // Ecuación canónica de la parábola: y = a*(x-h)² + k
        double par = a * Math.pow(rpm - h, 2) + k;

        // El par no puede ser negativo (el motor no "frena" por sí solo en este modelo)
        return Math.max(par, 0.0);
    }
}
