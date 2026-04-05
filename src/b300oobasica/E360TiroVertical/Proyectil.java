package b300oobasica.E360TiroVertical;

public class Proyectil {
    // Constante física (negativa porque va hacia abajo)
    private static final double GRAVEDAD = -9.81;

    // Atributos privados: el "estado" del proyectil
    private double altura;    // metros sobre el suelo
    private double velocidad; // metros por segundo

    // Constructor: recibe velocidad inicial, altura empieza en 0
    public Proyectil(double velocidadInicial) {
        this.velocidad = velocidadInicial;
        this.altura = 0.0;
    }

    // Getters para poder leer los valores desde fuera
    public double getAltura() {
        return altura;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void actualizar(double deltaTiempo) {

        // PASO A: La gravedad cambia la velocidad
        // "Cada segundo, la velocidad cae 9.81 m/s"
        // Si solo pasó 0.1 segundos, solo cae 0.981 m/s
        velocidad = velocidad + (GRAVEDAD * deltaTiempo);

        // PASO B: La velocidad cambia la posición
        // "Si voy a 30 m/s y pasó 0.1 segundos, subí 3 metros"
        altura = altura + (velocidad * deltaTiempo);
    }
}
