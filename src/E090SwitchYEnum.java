void main() {
    IO.println("SWITCH Y ENUM");
    String nombre = IO.readln("¿Cómo te llamas?\n").toUpperCase();

    IO.println("Ejercicio 1:");
    int num = Integer.parseInt(IO.readln(nombre + ", introduce un número del 1 al 7 y te diré qué día de la semana corresponde.\n"));

    switch (num) {
        case 1 -> IO.println("Lunes");
        case 2 -> IO.println("Martes");
        case 3 -> IO.println("Miércoles");
        case 4 -> IO.println("Jueves");
        case 5 -> IO.println("Viernes");
        case 6 -> IO.println("Sábado");
        case 7 -> IO.println("Domingo");
    }

    IO.println("\n");

    IO.println("Ejercicio 2:");
    enum Meses {
        Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre, Diciembre
    }

    String s = IO.readln(nombre + ", introduce un mes del año y te diré su estación correspondiente:\n");

    Meses mes = Meses.valueOf(s);

    switch (mes) {
        case Diciembre, Enero, Febrero -> IO.println("Invierno");
        case Marzo, Abril, Mayo -> IO.println("Primavera");
        case Junio, Julio, Agosto -> IO.println("Verano");
        case Septiembre, Octubre, Noviembre -> IO.println("Otoño");
    }

    IO.println("\n");

    IO.println("Ejercicio 3:");
    int numCalificacion = Integer.parseInt(IO.readln(
            nombre + ", introduce una calificación numérica del 0 al 10 y te diré el equivalente en letras.\n"
    ));

    String calificacion = switch (numCalificacion) {
        case 0, 1, 2, 3, 4 -> "Suspenso";
        case 5, 6 -> "Aprobado";
        case 7, 8 -> "Notable";
        case 9, 10 -> "Sobresaliente";
        default -> throw new IllegalStateException("Unexpected value: " + numCalificacion);
    };

    IO.println(String.format("Un %d en al calificación equivale a un %s", numCalificacion, calificacion));

    IO.println("\n");

    IO.println("Ejercicio 4:");
    enum Direccion {Norte, Sur, Este, Oeste}

    String direccion = IO.readln(nombre + ", introduce una dirección (Norte, Sur, Este, Oeste) para avanzar retroceder o desplazarse:");

    Direccion direcciones = Direccion.valueOf(direccion);

    String rumbo = switch (direcciones) {
        case Norte -> "Avanzar hacia el norte";
        case Sur -> "Retroceder hacia el sur";
        case Este -> "Desplazarse hacia la derecha";
        case Oeste -> "Desplazarse hacia la izquierda";
    };

    IO.println(rumbo);
}