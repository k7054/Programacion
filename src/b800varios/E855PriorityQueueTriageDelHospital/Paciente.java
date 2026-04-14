package b800varios.E855PriorityQueueTriageDelHospital;

public class Paciente implements Comparable<Paciente> {
    public enum NivelGravedad {
        CRITICO,
        URGENTE,
        LEVE
    }

    private String nombre;
    private String sintoma;
    private NivelGravedad nivelGravedad;

    public Paciente(String nombre, String sintoma, NivelGravedad nivelGravedad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.nivelGravedad = nivelGravedad;
    }

    public String toString() {
        return "Paciente: " + getNombre() + " / Síntoma: " + getSintoma() + " / Nivel: " + getNivelGravedad();
    }

    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public NivelGravedad getNivelGravedad() {
        return nivelGravedad;
    }

    public int compareTo(Paciente otro) {
        int diferencia = this.nivelGravedad.ordinal() - otro.nivelGravedad.ordinal();

        if (diferencia < 0) return -1;
        else if (diferencia > 0) return 1;
        else return 0;
    }
}
