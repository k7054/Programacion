package b300oobasica.E308RelojTotalMinutosBasico;

public class PrincipalTotalMinutos {
    static void main(String[] args) {
        Reloj reloj1 = new Reloj();
        Reloj reloj2 = new Reloj(150);
        Reloj reloj3 = new Reloj(3, 45);

        System.out.println(reloj1);
        System.out.println(reloj2);
        System.out.println(reloj3);

        reloj1.tick();

        reloj1.sumarMinutos(-80);

        System.out.println("Tras tick y sumar unos pocos minutos: " + reloj1);

        reloj1.restarMinutos(20000);

        System.out.println("Restado muchos minutos: " + reloj1);

        int diferenciaMinutos = reloj2.diferenciaMinutos(reloj3);

        System.out.println("Diferencia en minutos entre reloj2 y reloj3: " + diferenciaMinutos);

        Reloj difReloj = reloj2.diferenciaReloj(reloj3);

        System.out.println("Diferencia en Reloj entre reloj2 y reloj3: " + difReloj);

        System.out.println("Creando una nueva variable con un nuevo clon:");
        Reloj reloj4 = reloj1.clone();
        System.out.println("Reloj1 y Reloj4: " + reloj1 + " y " + reloj4);
        reloj1.tick();
        System.out.println("Reloj1 y Reloj4: " + reloj1 + " y " + reloj4);

        System.out.println("Creando una nueva variable apuntando al mismo objeto:");
        Reloj reloj5 = reloj1;
        System.out.println("Reloj1 y Reloj5: " + reloj1 + " y " + reloj5);
        reloj1.tick();
        System.out.println("Reloj1 y Reloj5: " + reloj1 + " y " + reloj5);

        if (reloj1.equals(reloj5)) System.out.println("R1 y R5 Iguales");
        else System.out.println("R1 y R5 Distintos");

        if (reloj1.equals(reloj2)) System.out.println("R1 y R2 Iguales");
        else System.out.println("R1 y R2 Distintos");
    }
}
