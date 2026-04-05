package b300oobasica.E365MotorDiesel;

public class EstrategiaTramosFijos implements EstrategiaCurvaPar {
    public double calcularPar(double rpm) {
        if (rpm >= 800 && rpm < 1500) {
            return 150.0;
        } else if (rpm >= 1500 && rpm <= 2500) {
            return 350.0;
        } else {
            return 0.0;
        }
    }
}
