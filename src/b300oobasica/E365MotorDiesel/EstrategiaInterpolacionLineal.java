package b300oobasica.E365MotorDiesel;

public class EstrategiaInterpolacionLineal implements EstrategiaCurvaPar {
    // Puntos clave de la curva: {rpm, par_en_Nm}
    private final double[][] puntosClave = {
            {  800.0, 100.0 },   // Al ralentí, poco par
            { 2000.0, 350.0 },   // Par máximo cerca de 2000 RPM
            { 4500.0,  50.0 }    // A altas RPM, el diésel pierde fuerza
    };

    @Override
    public double calcularPar(double rpm) {
        // Fuera del rango de la tabla → devolvemos 0
        if (rpm < puntosClave[0][0] || rpm > puntosClave[puntosClave.length - 1][0]) {
            return 0.0;
        }

        // Buscamos entre qué dos puntos clave se encuentran las RPM actuales
        for (int i = 0; i < puntosClave.length - 1; i++) {
            double x1 = puntosClave[i][0];
            double y1 = puntosClave[i][1];
            double x2 = puntosClave[i + 1][0];
            double y2 = puntosClave[i + 1][1];

            if (rpm >= x1 && rpm <= x2) {
                return y1 + (rpm - x1) * (y2 - y1) / (x2 - x1);
            }
        }

        return 0.0;
    }
}
