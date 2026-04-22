package BasesDeDatos;

import java.sql.*;
import java.util.Scanner;

public class E881ListarYEliminarCategorias {
    private static final String BD          = "agenda";
    private static final String URL         = "jdbc:mysql://localhost/";
    private static final String USUARIO     = "root";
    private static final String CONTRASENNA = "";

    public static void main(String[] args) {

        // ── Comprobar driver ────────────────────────────────────────────────
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado. Asegúrate de tener Connector/J en las dependencias.");
            return;
        }

        // ── Conectar ────────────────────────────────────────────────────────
        try {
            Connection conn = DriverManager.getConnection(URL + BD, USUARIO, CONTRASENNA);
            Scanner teclado = new Scanner(System.in);

            // ── Bucle del menú ───────────────────────────────────────────────
            int opcion;
            do {
                System.out.println("_______________________________");
                System.out.println("|        MENÚ CATEGORÍAS       |");
                System.out.println("|  1. Listar categorías        |");
                System.out.println("|  2. Eliminar categoría       |");
                System.out.println("|  0. Salir                    |");
                System.out.println("_______________________________");
                System.out.print("Elige una opción: ");
                opcion = Integer.parseInt(teclado.nextLine().trim());

                switch (opcion) {
                    case 1 -> listarCategorias(conn);
                    case 2 -> eliminarCategoria(conn, teclado);
                    case 0 -> System.out.println("¡Hasta luego!");
                    default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
                }

            } while (opcion != 0);

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    // CASO DE USO 1: Listar categorías ordenadas por nombre
    // ════════════════════════════════════════════════════════════════════════
    private static void listarCategorias(Connection conn) throws SQLException {

        PreparedStatement ps = conn.prepareStatement(
                "SELECT id, nombre FROM categoria ORDER BY nombre");
        ResultSet rs = ps.executeQuery();

        System.out.println("\n── Categorías ──────────────────");
        boolean hayAlguna = false;
        while (rs.next()) {
            hayAlguna = true;
            System.out.printf("  [%2d] %s%n", rs.getInt("id"), rs.getString("nombre"));
        }
        if (!hayAlguna) {
            System.out.println("  (No hay categorías.)");
        }
        System.out.println("────────────────────────────────");

        rs.close();
        ps.close();
    }

    // ════════════════════════════════════════════════════════════════════════
    // CASO DE USO 2: Eliminar categoría (por id o por nombre, con cancelación)
    // ════════════════════════════════════════════════════════════════════════
    private static void eliminarCategoria(Connection conn, Scanner teclado) throws SQLException {

        // ── Submenú: elegir modo de búsqueda ─────────────────────────────
        System.out.println("\n¿Cómo quieres identificar la categoría a eliminar?");
        System.out.println("  1. Por id");
        System.out.println("  2. Por nombre");
        System.out.println("  0. Cancelar");
        System.out.print("Elige una opción: ");
        String lineaModo = teclado.nextLine().trim();

        if (lineaModo.equals("0")) {
            System.out.println("Operación cancelada.");
            return;
        }

        if (!lineaModo.equals("1") && !lineaModo.equals("2")) {
            System.out.println("Opción no válida. Volviendo al menú.");
            return;
        }

        int modo = Integer.parseInt(lineaModo);

        // ── Leer el criterio de búsqueda ──────────────────────────────────
        PreparedStatement ps;

        if (modo == 1) {
            System.out.print("Introduce el id de la categoría a eliminar (o deja vacío para cancelar): ");
            String lineaId = teclado.nextLine().trim();

            if (lineaId.isEmpty()) {
                System.out.println("Operación cancelada.");
                return;
            }

            int id = Integer.parseInt(lineaId);
            ps = conn.prepareStatement("DELETE FROM categoria WHERE id = ?");
            ps.setInt(1, id);

        } else {
            System.out.print("Introduce el nombre de la categoría a eliminar (o deja vacío para cancelar): ");
            String nombre = teclado.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("Operación cancelada.");
                return;
            }

            ps = conn.prepareStatement("DELETE FROM categoria WHERE nombre = ?");
            ps.setString(1, nombre);
        }

        // ── Ejecutar el borrado ───────────────────────────────────────────
        int filas = ps.executeUpdate();
        ps.close();

        if (filas > 0) {
            System.out.println("Categoría eliminada correctamente.");
        } else {
            System.out.println("No se encontró ninguna categoría con ese criterio.");
        }
    }
}
