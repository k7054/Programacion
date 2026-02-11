package b300oobasica.E325Frase;

public class Frase {
    private StringBuilder texto;

    public Frase() {
        texto = new StringBuilder();
    }

    public Frase(String cadena) {
        texto = new StringBuilder(cadena);
    }

    public Frase(int rep, String cadena) {
        texto = new StringBuilder();

        for (int i = 0; i < rep; i++) {
            anexar(cadena);
        }
    }

    public String toString() {
        return texto.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Frase)) return false;

        Frase otra = (Frase) obj;
        return this.texto.toString().equals(otra.texto.toString());
    }

    public Frase clone() {
        return new Frase(this.texto.toString());
    }

    public char caracterEn(int posicion) {
        return texto.charAt(posicion);
    }

    public int longitud() {
        return texto.length();
    }

    public void anexar(String cadena) {
        if (!texto.isEmpty()) {
            texto.append(" ");
        }

        texto.append(cadena);
    }

    public void recortar(int numCaracteres) {
        texto.setLength(texto.length() - numCaracteres);

        if (!texto.isEmpty() && texto.charAt(texto.length() - 1) == ' ') {
            texto.setLength(texto.length() - 1);
        }
    }
}
