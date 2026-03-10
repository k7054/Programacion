package b400ooavanzada.E404FigurasComparables;

public abstract class Figura implements Comparable<Figura> {
    public abstract double calcularArea();

    public int compareTo(Figura otra) {
        double diferencia = this.calcularArea() - otra.calcularArea();

        //Una forma:
        if (diferencia < 0) return -1;
        else if (diferencia > 0) return 1;
        else return 0;

        //Otra forma:
//        if (diferencia < 0) diferencia--;
//        else if (diferencia > 0) diferencia++;
//        return (int) Math.round(diferencia);
    }
}