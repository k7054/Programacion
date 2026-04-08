package b800varios.E861ExcepcionesEnReloj;

public class DesbordamientoRelojException extends Exception {
    private static final long serialVersionUID = 1L;

    private boolean superior;

    public DesbordamientoRelojException(String mensaje, boolean superior) {
        super(mensaje);
        this.superior = superior;
    }

    public boolean isSuperior() {
        return superior;
    }

    public void setSuperior(boolean superior) {
        this.superior = superior;
    }
}
