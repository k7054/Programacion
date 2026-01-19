package b900programame;

import java.util.Scanner;

public class E920LlenandoPiscinas131 {
    static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);


        int litrosPiscinaYo;
        int litrosBarrenioYo;
        int litrosPerdidosYo;

        int litrosPiscinaVecino;
        int litrosBarrenioVecino;
        int litrosPerdidosVecino;

        int viajesYO;
        int viajesVecino;

        do {
            System.out.println("YO");
            litrosPiscinaYo = entrada.nextInt();
            litrosBarrenioYo = entrada.nextInt();
            litrosPerdidosYo = entrada.nextInt();

            System.out.println("VECINO");
            litrosPiscinaVecino = entrada.nextInt();
            litrosBarrenioVecino = entrada.nextInt();
            litrosPerdidosVecino = entrada.nextInt();

            viajesYO = litrosPiscinaVecino % (litrosBarrenioVecino - litrosPerdidosVecino);
            viajesVecino = litrosPiscinaYo % (litrosBarrenioYo - litrosPerdidosYo);

            if (viajesYO < viajesVecino) {
                System.out.printf("YO %d", viajesYO);
            } else if (viajesVecino < viajesYO) {
                System.out.printf("VECINO %d", viajesVecino);
            } else {
                System.out.printf("EMPATE %d", viajesYO);
            }
        } while (litrosPiscinaYo != 0 && litrosPiscinaVecino != 0);
    }
}
