package ExamenFebrero.E06_Iluminacion;

import java.util.Random;

public class Bombilla {
    // TODO Implementa aquí lo que se pide
    private static final Random num = new Random();

    private boolean encendida;
    private boolean fundida;
    private int vidaUtil;

    public Bombilla() {
        vidaUtil = num.nextInt(9) + 2; // 2 a 10
        encendida = false;
        fundida = false;
    }

    public void encender() {
        if (fundida) return;

        if (!encendida) {
            consumirVida();
            if (!fundida) {
                encendida = true;
            }
        }
    }

    public void apagar() {
        if (fundida) return;

        if (encendida) {
            consumirVida();
            encendida = false;
        }
    }

    public void conmutar() {
        if (fundida) return;

        consumirVida();
        if (!fundida) {
            encendida = !encendida;
        }
    }

    private void consumirVida() {
        vidaUtil--;
        if (vidaUtil <= 0) {
            fundida = true;
            encendida = false;
        }
    }

    public boolean estaEncendida() {
        return encendida;
    }
}