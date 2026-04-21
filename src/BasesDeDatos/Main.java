package BasesDeDatos;

public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver encontrado. Todo bien.");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha podido encontrar el driver...");
        }

    }
}
