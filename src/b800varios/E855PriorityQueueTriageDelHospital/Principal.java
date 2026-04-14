package b800varios.E855PriorityQueueTriageDelHospital;

import java.util.PriorityQueue;

public class Principal {
    public static void main(String[] args) {
        PriorityQueue<Paciente> pacientes = new PriorityQueue<>();

        pacientes.add(new Paciente("Elena", "Brazo roto", Paciente.NivelGravedad.URGENTE));
        pacientes.add(new Paciente("Marcos", "Dolor de garganta", Paciente.NivelGravedad.LEVE));
        pacientes.add(new Paciente("Sofia", "Ataque cardiaco", Paciente.NivelGravedad.CRITICO));
        pacientes.add(new Paciente("Luis", "Fiebre alta", Paciente.NivelGravedad.URGENTE));
        pacientes.add(new Paciente("Carmen", "Corte leve", Paciente.NivelGravedad.LEVE));
        pacientes.add(new Paciente("Jorge", "Dificultad para respirar", Paciente.NivelGravedad.CRITICO));

        while (!pacientes.isEmpty()) {
            Paciente paciente = pacientes.poll();
            System.out.println(paciente);

            if (Math.random() < 0.30) {
                Paciente.NivelGravedad[] niveles = Paciente.NivelGravedad.values();
                Paciente.NivelGravedad nivelAleatorio = niveles[(int)(Math.random() * niveles.length)];
                pacientes.add(new Paciente("Maria", "Esguince muñeca", nivelAleatorio));
            }
        }
    }
}
