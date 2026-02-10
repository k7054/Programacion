package b300oobasica.E325Frase;

public class Principal {
    public static void main(String[] args) {
        Frase frase1 = new Frase();
        Frase frase2 = new Frase("Frase 2");
        Frase frase3 = new Frase(3, "hola");

        frase1.anexar("Frase 1");
        System.out.println(frase1);

        System.out.print("Longitud frase 2: ");
        System.out.println(frase2.longitud());
        System.out.print("Caracter en la posicion 2: ");
        System.out.println(frase2.caracterEn(2));

        System.out.println(frase3);
        frase3.recortar(4);
        System.out.println(frase3);

        Frase frase4 = frase3.clone();
        System.out.println(frase4);

        String sonIguales = frase4.equals(frase3) ? "Si" : "No";
        System.out.println(sonIguales);
    }
}
