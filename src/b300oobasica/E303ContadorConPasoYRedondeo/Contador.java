package b300oobasica.E303ContadorConPasoYRedondeo;

public class Contador {
    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final int POR_DEFECTO = 50;

    private int valor = 0;
    private int paso = 1;
    private boolean redondeo = false;

    public Contador() {
        setValor(POR_DEFECTO);
    }

    public Contador(int valor) {
        setValor(valor);
    }

    public Contador(int valor, int paso) {
        setPaso(paso);
        setValor(valor);
    }

    public Contador(int valor, int paso, boolean redondeo) {
        setPaso(paso);
        setRedondeo(redondeo);
        setValor(valor);
    }

    public String toString() {
        return "Valgo " + valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int nuevoValor) {
        int valorRedondeado = ((nuevoValor + paso - 1) / paso) * paso;

        if (isRedondeo()) {
            nuevoValor = valorRedondeado;
        }

        if (nuevoValor < MIN) {
            valor = MIN;
        } else if (nuevoValor > MAX) {
            valor = MAX;
        } else {
            valor = nuevoValor;
        }
    }

    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        if (paso < 1) paso = 1;
        this.paso = paso;
    }

    public boolean isRedondeo() {
        return redondeo;
    }

    public void setRedondeo(boolean redondeo) {
        this.redondeo = redondeo;
    }

    public void resetear() {
        setValor(POR_DEFECTO);
    }

    public void incrementar() {
        setValor(valor + paso);
    }

    public void incrementar(int incremento) {
        setValor(valor + incremento);
    }

    public void decrementar() {
        setValor(valor - paso);
    }

    public void decrementar(int decremento) {
        setValor(valor - decremento);
    }
}
