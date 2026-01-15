package b300oobasica.E305RelojHMBasico;

public class Principal {
    static void main(String[] args) {
        Reloj reloj1 = new Reloj();
        Reloj reloj2 = new Reloj(150);
        Reloj reloj3 = new Reloj(3, 45);

        System.out.println(reloj1);
        System.out.println(reloj2);
        System.out.println(reloj3);

        reloj1.tick();



        System.out.println("Tras tick y sumar unos pocos minutos: " + reloj1);


    }
}
