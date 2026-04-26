package BasesDeDatos;

import java.sql.*;
import java.util.Scanner;

public class E882CrudCategorias {


    private static final String BD           = "agenda";
    private static final String URL          = "jdbc:mysql://localhost/";
    private static final String USUARIO      = "root";
    private static final String CONTRASENNA  = "";

    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver encontrado correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado. Añade Connector/J a las dependencias.");
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(URL + BD, USUARIO, CONTRASENNA);
            System.out.println("Conectado a [" + BD + "]\n");

            int opcion;
            do {
                mostrarMenu();
                opcion = leerEntero("Elige una opción: ");

                switch (opcion) {
                    case 1 -> listarCategorias(conn);
                    case 2 -> insertarCategoria(conn);
                    case 3 -> eliminarCategoria(conn);
                    case 4 -> modificarCategoria(conn);
                    case 0 -> System.out.println("¡Hasta luego!");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 0);

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║        MENÚ CATEGORÍAS       ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║  1. Listar categorías        ║");
        System.out.println("║  2. Insertar categoría       ║");
        System.out.println("║  3. Eliminar categoría       ║");
        System.out.println("║  4. Modificar categoría      ║");
        System.out.println("║  0. Salir                    ║");
        System.out.println("╚══════════════════════════════╝");
    }

    private static void listarCategorias(Connection conn) throws SQLException {
        String sqlSelectCategorias = "SELECT id, nombre FROM categoria ORDER BY nombre";
        PreparedStatement psSelectCategorias = conn.prepareStatement(sqlSelectCategorias);
        ResultSet rsSelectCategorias = psSelectCategorias.executeQuery();

        System.out.println("\n── Categorías ──────────────────");
        boolean hayResultados = false;
        while (rsSelectCategorias.next()) {
            hayResultados = true;
            int    idCat     = rsSelectCategorias.getInt("id");
            String nombreCat = rsSelectCategorias.getString("nombre");
            System.out.printf("  [%2d] %s%n", idCat, nombreCat);
        }
        if (!hayResultados) {
            System.out.println("  (No hay categorías.)");
        }
        System.out.println("────────────────────────────────");

        rsSelectCategorias.close();
        psSelectCategorias.close();
    }

    private static void insertarCategoria(Connection conn) throws SQLException {
        System.out.println("\n── Insertar categoría ──────────");

        System.out.print("Nombre de la nueva categoría (vacío para cancelar): ");
        String nombreNuevo = teclado.nextLine().trim();

        if (nombreNuevo.isEmpty()) {
            System.out.println("Operación cancelada.");
            return;
        }

        String sqlInsertCategoria = "INSERT INTO categoria (nombre) VALUES (?)";
        PreparedStatement psInsertCategoria = conn.prepareStatement(sqlInsertCategoria);
        psInsertCategoria.setString(1, nombreNuevo);
        psInsertCategoria.executeUpdate();
        System.out.println("Categoría '" + nombreNuevo + "' insertada correctamente.");
        psInsertCategoria.close();
    }

    private static void eliminarCategoria(Connection conn) throws SQLException {
        System.out.println("\n── Eliminar categoría ──────────");
        System.out.println("  1. Eliminar por id");
        System.out.println("  2. Eliminar por nombre");
        System.out.println("  0. Cancelar");
        int modoEliminar = leerEntero("Elige una opción: ");

        if (modoEliminar == 0) {
            System.out.println("Operación cancelada.");
            return;
        }

        if (modoEliminar == 1) {
            System.out.print("Id de la categoría a eliminar (vacío para cancelar): ");
            String lineaId = teclado.nextLine().trim();
            if (lineaId.isEmpty()) {
                System.out.println("Operación cancelada.");
                return;
            }
            int idEliminar = Integer.parseInt(lineaId);

            String sqlDeleteCategoriaId = "DELETE FROM categoria WHERE id = ?";
            PreparedStatement psDeleteCategoriaId = conn.prepareStatement(sqlDeleteCategoriaId);
            psDeleteCategoriaId.setInt(1, idEliminar);
            int filasDeleteCategoriaId = psDeleteCategoriaId.executeUpdate();
            if (filasDeleteCategoriaId > 0) {
                System.out.println("Categoría eliminada correctamente.");
            } else {
                System.out.println("No existe ninguna categoría con ese id.");
            }
            psDeleteCategoriaId.close();

        } else if (modoEliminar == 2) {
            System.out.print("Nombre de la categoría a eliminar (vacío para cancelar): ");
            String nombreEliminar = teclado.nextLine().trim();
            if (nombreEliminar.isEmpty()) {
                System.out.println("Operación cancelada.");
                return;
            }

            String sqlDeleteCategoriaNombre = "DELETE FROM categoria WHERE nombre = ?";
            PreparedStatement psDeleteCategoriaNombre = conn.prepareStatement(sqlDeleteCategoriaNombre);
            psDeleteCategoriaNombre.setString(1, nombreEliminar);
            int filasDeleteCategoriaNombre = psDeleteCategoriaNombre.executeUpdate();
            if (filasDeleteCategoriaNombre > 0) {
                System.out.println("Categoría eliminada correctamente.");
            } else {
                System.out.println("No existe ninguna categoría con ese nombre.");
            }
            psDeleteCategoriaNombre.close();

        } else {
            System.out.println("Opción no válida. Volviendo al menú.");
        }
    }

    private static void modificarCategoria(Connection conn) throws SQLException {
        System.out.println("\n── Modificar categoría ─────────");

        System.out.print("Id de la categoría a modificar (vacío para cancelar): ");
        String lineaIdMod = teclado.nextLine().trim();
        if (lineaIdMod.isEmpty()) {
            System.out.println("Operación cancelada.");
            return;
        }
        int idModificar = Integer.parseInt(lineaIdMod);

        String sqlSelectNombreActual = "SELECT nombre FROM categoria WHERE id = ?";
        PreparedStatement psSelectNombreActual = conn.prepareStatement(sqlSelectNombreActual);
        psSelectNombreActual.setInt(1, idModificar);
        ResultSet rsSelectNombreActual = psSelectNombreActual.executeQuery();

        if (!rsSelectNombreActual.next()) {
            System.out.println("No existe ninguna categoría con ese id.");
            rsSelectNombreActual.close();
            psSelectNombreActual.close();
            return;
        }
        String nombreActual = rsSelectNombreActual.getString("nombre");
        rsSelectNombreActual.close();
        psSelectNombreActual.close();

        System.out.println("Categoría actual: '" + nombreActual + "'");

        String nombreActualizado;
        while (true) {
            System.out.print("Nuevo nombre (vacío para cancelar): ");
            nombreActualizado = teclado.nextLine().trim();

            if (nombreActualizado.isEmpty()) {
                System.out.println("Operación cancelada.");
                return;
            }
            if (nombreActualizado.equals(nombreActual)) {
                System.out.println("El nombre introducido es igual al actual. Introduce uno diferente.");
                continue;
            }
            break;
        }

        String sqlUpdateCategoria = "UPDATE categoria SET nombre = ? WHERE id = ?";
        PreparedStatement psUpdateCategoria = conn.prepareStatement(sqlUpdateCategoria);
        psUpdateCategoria.setString(1, nombreActualizado);
        psUpdateCategoria.setInt   (2, idModificar);
        int filasUpdateCategoria = psUpdateCategoria.executeUpdate();
        if (filasUpdateCategoria > 0) {
            System.out.println("Categoría actualizada: '" + nombreActual + "' → '" + nombreActualizado + "'");
        } else {
            System.out.println("No se pudo actualizar la categoría.");
        }
        psUpdateCategoria.close();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = teclado.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido.");
            }
        }
    }
}
