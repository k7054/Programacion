void main() {
    // TODO Debes eliminar uno de los arrays con el objetivo de simplificar el programa pero manteniendo la funcionalidad completa.

    int[] votos = {1463183, 1004599, 557780, 506164, 21742, 7652, 6749, 3784, 3407, 2902, 1751}; // Generales 2023 al Congreso, circunscripción de Madrid.
     // No es imprescindible, ya que, teniendo ya un array con los escannos, podríamos prescindir de este array ya que el divisor siempre va a ser los escaños+1.
    int[] escannos = new int[votos.length];
    int numEscannos = 37; // Los escaños que hay que repartir en una circunscripción.
    int totalVotos = 0;

    // Se inicializan los arrays que lo necesitan, y se acumula el total general de votos.
    for (int numPartido = 0; numPartido<votos.length; numPartido++) {
        // escannos[numPartido] = 0; // Esta inicialización NO ES necesaria (Java garantiza la inicialización de ints a 0).
        totalVotos = totalVotos + votos[numPartido];
    }

    // Se asignan los escannos según el método D'Hondt:
    for (int numEscanno = 1; numEscanno <= numEscannos; numEscanno++) {
        // Determinar a qué partido se le va a asignar el próximo escaño.

        // Cargamos valores irreales para forzar a que se actualicen en la primera vuelta del for de partidos.
        double pujaMax = -1;
        int partidoProximoEscanno = -1;

        // El for irá de 1 a "n-1" (NO de 0 a "n-1"), porque el caso 0 ya está tratado.
        for (int numPartido = 0; numPartido < votos.length; numPartido++) {
            double puja = (double) votos[numPartido] / (escannos[numPartido] + 1);

            if (puja > pujaMax) {
                pujaMax = puja;
                partidoProximoEscanno = numPartido;
            }
        }

        // En este punto, la variable partidoProximoEscanno contiene el índice
        // del partido que se tiene que llevar EFECTIVAMENTE el próximo escaño.

        escannos[partidoProximoEscanno]++; // Se asigna efectivamente el próximo escaño.
        // Así como su divisor correspondiente:

        // Y se informa de la asignación:
        IO.println(String.format("Escaño para el partido %2d.", partidoProximoEscanno+1));
    }

    // Se presentan los resultados.
    IO.println();
    for (int partido = 0; partido < votos.length; partido++) {
        IO.println(String.format(
                "Partido %2d: %,9d votos (%5.2f%%) --> %2d escaños (proporcionalmente serían %5.2f escaños).",
                partido+1,
                votos[partido],
                100.00*votos[partido]/totalVotos,
                escannos[partido],
                1.00*numEscannos*votos[partido]/totalVotos
        ));
    }
}