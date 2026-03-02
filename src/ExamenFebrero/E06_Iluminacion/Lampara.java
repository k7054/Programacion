package ExamenFebrero.E06_Iluminacion;

import java.util.ArrayList;

public class Lampara {
    // TODO Implementa aquí lo que se pide
    private ArrayList<Bombilla> bombillas;

    public Lampara(int numBombillas) {
        bombillas = new ArrayList<>();

        for (int i = 0; i < numBombillas; i++) {
            bombillas.add(new Bombilla());
        }
    }

    public void encenderTodas() {
        for (int i = 0; i < bombillas.size(); i++) {
            bombillas.get(i).encender();
        }
    }

    public void apagarTodas() {
        for (int i = 0; i < bombillas.size(); i++) {
            bombillas.get(i).apagar();
        }
    }

    public void conmutarBombilla(int indice) {
        bombillas.get(indice).conmutar();
    }

    public double obtenerPorcentajeIluminacion() {
        int encendidas = 0;

        for (int i = 0; i < bombillas.size(); i++) {
            if (bombillas.get(i).estaEncendida()) {
                encendidas++;
            }
        }

        return encendidas * 100.0 / bombillas.size();
    }
}