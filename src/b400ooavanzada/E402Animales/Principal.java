package b400ooavanzada.E402Animales;

import java.util.ArrayList;

public class Principal {
    static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList<>();

        animales.add(new Perro(80));
        animales.add(new Gato(60));
        animales.add(new Jaguar(90));

        animales.add(new Pajaro(70));

        animales.add(new Vibora(50));

        for (Animal a : animales) {
            if (Math.random() < 0.30) {

                int comida = (int)(Math.random() * 3) + 1;
                System.out.println(a.getClass().getSimpleName() +
                        " come " + comida + " unidad(es).");

                a.come(comida);
            }

            System.out.print(a.getClass().getSimpleName() + " dice: ");
            a.habla();

            System.out.println("Energía actual: " + a.getEnergia());
            System.out.println();
        }
    }
}
