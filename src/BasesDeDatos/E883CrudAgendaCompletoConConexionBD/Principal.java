package BasesDeDatos.E883CrudAgendaCompletoConConexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

    private static final ConexionBD bd = new ConexionBD();
    private static final Scanner sc   = new Scanner(System.in);

    // ══════════════════════════════════════════════════════════════════════════
    //  MAIN
    // ══════════════════════════════════════════════════════════════════════════

    public static void main(String[] args) {
        try {
            bd.conectar();
            System.out.println("Conexión establecida.");
            menuPrincipal();
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        } finally {
            bd.desconectar();
            System.out.println("Conexión cerrada. ¡Hasta luego!");
        }
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  MENÚ PRINCIPAL
    // ══════════════════════════════════════════════════════════════════════════

    private static void menuPrincipal() throws SQLException {
        int opcion;
        do {
            System.out.println("\n╔══════════════════╗");
            System.out.println("║   AGENDA MENÚ    ║");
            System.out.println("╠══════════════════╣");
            System.out.println("║ 1. Categorías    ║");
            System.out.println("║ 2. Personas      ║");
            System.out.println("║ 0. Salir         ║");
            System.out.println("╚══════════════════╝");
            System.out.print("Opción: ");
            opcion = leerInt();

            switch (opcion) {
                case 1  -> menuCategorias();
                case 2  -> menuPersonas();
                case 0  -> {}   // saldrá del bucle
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  MENÚ CATEGORÍAS
    // ══════════════════════════════════════════════════════════════════════════

    private static void menuCategorias() throws SQLException {
        int opcion;
        do {
            System.out.println("\n--- CATEGORÍAS ---");
            System.out.println("1. Listar todas");
            System.out.println("2. Obtener por id");
            System.out.println("3. Insertar");
            System.out.println("4. Eliminar");
            System.out.println("5. Modificar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = leerInt();

            switch (opcion) {
                case 1  -> listarCategorias();
                case 2  -> obtenerCategoria();
                case 3  -> insertarCategoria();
                case 4  -> eliminarCategoria();
                case 5  -> modificarCategoria();
                case 0  -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ── Listar categorías ─────────────────────────────────────────────────────

    private static void listarCategorias() throws SQLException {
        PreparedStatement ps = bd.prepareStatement(
            "SELECT id, nombre FROM categoria ORDER BY nombre");
        ResultSet rs = bd.ejecutarConsulta(ps);

        System.out.println("\nID  | Nombre");
        System.out.println("----|-------------------");
        boolean hayDatos = false;
        while (rs.next()) {
            hayDatos = true;
            System.out.printf("%-4d| %s%n", rs.getInt("id"), rs.getString("nombre"));
        }
        if (!hayDatos) System.out.println("(No hay categorías)");
    }

    // ── Obtener categoría por id ──────────────────────────────────────────────

    private static void obtenerCategoria() throws SQLException {
        System.out.print("Id de la categoría (0 = cancelar): ");
        int id = leerInt();
        if (id == 0) { System.out.println("Cancelado."); return; }

        PreparedStatement ps = bd.prepareStatement(
            "SELECT id, nombre FROM categoria WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = bd.ejecutarConsulta(ps);

        if (rs.next()) {
            System.out.printf("Categoría encontrada → [%d] %s%n",
                rs.getInt("id"), rs.getString("nombre"));
        } else {
            System.out.println("No existe ninguna categoría con id " + id + ".");
        }
    }

    // ── Insertar categoría ────────────────────────────────────────────────────

    private static void insertarCategoria() throws SQLException {
        System.out.print("Nombre de la nueva categoría (vacío = cancelar): ");
        String nombre = sc.nextLine().trim();
        if (nombre.isEmpty()) { System.out.println("Cancelado."); return; }

        PreparedStatement ps = bd.prepareStatement(
            "INSERT INTO categoria (nombre) VALUES (?)");
        ps.setString(1, nombre);
        bd.ejecutarActualizacion(ps);
        System.out.println("Categoría \"" + nombre + "\" insertada correctamente.");
    }

    // ── Eliminar categoría ────────────────────────────────────────────────────

    private static void eliminarCategoria() throws SQLException {
        System.out.println("Eliminar por:  1. Id   2. Nombre   0. Cancelar");
        System.out.print("Opción: ");
        int opc = leerInt();
        if (opc == 0) { System.out.println("Cancelado."); return; }

        PreparedStatement ps;
        if (opc == 1) {
            System.out.print("Id a eliminar: ");
            int id = leerInt();
            ps = bd.prepareStatement("DELETE FROM categoria WHERE id = ?");
            ps.setInt(1, id);
        } else if (opc == 2) {
            System.out.print("Nombre a eliminar: ");
            String nombre = sc.nextLine().trim();
            ps = bd.prepareStatement("DELETE FROM categoria WHERE nombre = ?");
            ps.setString(1, nombre);
        } else {
            System.out.println("Opción no válida.");
            return;
        }
        bd.ejecutarActualizacion(ps);
        System.out.println("Operación completada (si existía, se ha eliminado).");
    }

    // ── Modificar categoría ───────────────────────────────────────────────────

    private static void modificarCategoria() throws SQLException {
        System.out.print("Id de la categoría a modificar (0 = cancelar): ");
        int id = leerInt();
        if (id == 0) { System.out.println("Cancelado."); return; }

        // Comprobamos que existe y obtenemos el nombre actual
        PreparedStatement psSelect = bd.prepareStatement(
            "SELECT nombre FROM categoria WHERE id = ?");
        psSelect.setInt(1, id);
        ResultSet rs = bd.ejecutarConsulta(psSelect);
        if (!rs.next()) {
            System.out.println("No existe ninguna categoría con id " + id + ".");
            return;
        }
        String nombreActual = rs.getString("nombre");

        // Pedimos nuevo nombre; si es igual, volvemos a pedir
        String nuevoNombre;
        do {
            System.out.printf("Nombre actual: \"%s\". Nuevo nombre (vacío = cancelar): ", nombreActual);
            nuevoNombre = sc.nextLine().trim();
            if (nuevoNombre.isEmpty()) { System.out.println("Cancelado."); return; }
            if (nuevoNombre.equals(nombreActual)) {
                System.out.println("El nombre es idéntico al actual. Introduce uno diferente.");
            }
        } while (nuevoNombre.equals(nombreActual));

        PreparedStatement ps = bd.prepareStatement(
            "UPDATE categoria SET nombre = ? WHERE id = ?");
        ps.setString(1, nuevoNombre);
        ps.setInt(2, id);
        bd.ejecutarActualizacion(ps);
        System.out.println("Categoría actualizada correctamente.");
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  MENÚ PERSONAS
    // ══════════════════════════════════════════════════════════════════════════

    private static void menuPersonas() throws SQLException {
        int opcion;
        do {
            System.out.println("\n--- PERSONAS ---");
            System.out.println("1. Listar todas");
            System.out.println("2. Obtener por id");
            System.out.println("3. Insertar");
            System.out.println("4. Eliminar");
            System.out.println("5. Modificar");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = leerInt();

            switch (opcion) {
                case 1  -> listarPersonas();
                case 2  -> obtenerPersona();
                case 3  -> insertarPersona();
                case 4  -> eliminarPersona();
                case 5  -> modificarPersona();
                case 0  -> {}
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ── Listar personas ───────────────────────────────────────────────────────

    private static void listarPersonas() throws SQLException {
        PreparedStatement ps = bd.prepareStatement(
            "SELECT p.id, p.nombre, p.apellidos, p.telefono, p.edad, p.estrella, " +
            "       c.nombre AS categoria " +
            "FROM persona p " +
            "JOIN categoria c ON p.categoriaId = c.id " +
            "ORDER BY p.apellidos, p.nombre");
        ResultSet rs = bd.ejecutarConsulta(ps);

        System.out.println("\nID  | Nombre              | Apellidos            | Teléfono    | Edad | ⭐  | Categoría");
        System.out.println("----|---------------------|----------------------|-------------|------|-----|----------");
        boolean hayDatos = false;
        while (rs.next()) {
            hayDatos = true;
            System.out.printf("%-4d| %-20s| %-21s| %-12s| %-5d| %-4s| %s%n",
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("apellidos") != null ? rs.getString("apellidos") : "",
                rs.getString("telefono"),
                rs.getInt("edad"),
                rs.getBoolean("estrella") ? "Sí" : "No",
                rs.getString("categoria"));
        }
        if (!hayDatos) System.out.println("(No hay personas)");
    }

    // ── Obtener persona ───────────────────────────────────────────────────────

    private static void obtenerPersona() throws SQLException {
        System.out.print("Id de la persona (0 = cancelar): ");
        int id = leerInt();
        if (id == 0) { System.out.println("Cancelado."); return; }

        PreparedStatement ps = bd.prepareStatement(
            "SELECT p.*, c.nombre AS categoria " +
            "FROM persona p " +
            "JOIN categoria c ON p.categoriaId = c.id " +
            "WHERE p.id = ?");
        ps.setInt(1, id);
        ResultSet rs = bd.ejecutarConsulta(ps);

        if (rs.next()) {
            System.out.println("\n── Ficha de persona ──────────────────");
            System.out.printf("  Id:        %d%n",   rs.getInt("id"));
            System.out.printf("  Nombre:    %s %s%n", rs.getString("nombre"),
                rs.getString("apellidos") != null ? rs.getString("apellidos") : "");
            System.out.printf("  Teléfono:  %s%n",   rs.getString("telefono"));
            System.out.printf("  Edad:      %d%n",   rs.getInt("edad"));
            System.out.printf("  Estrella:  %s%n",   rs.getBoolean("estrella") ? "⭐ Sí" : "No");
            System.out.printf("  Categoría: %s%n",   rs.getString("categoria"));
            System.out.println("──────────────────────────────────────");
        } else {
            System.out.println("No existe ninguna persona con id " + id + ".");
        }
    }

    // ── Insertar persona ──────────────────────────────────────────────────────

    private static void insertarPersona() throws SQLException {
        System.out.print("Nombre (vacío = cancelar): ");
        String nombre = sc.nextLine().trim();
        if (nombre.isEmpty()) { System.out.println("Cancelado."); return; }

        System.out.print("Apellidos: ");
        String apellidos = sc.nextLine().trim();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine().trim();

        System.out.print("Edad: ");
        int edad = leerInt();

        System.out.print("¿Estrella? (1 = Sí / 0 = No): ");
        boolean estrella = leerInt() == 1;

        listarCategorias();
        System.out.print("Id de categoría: ");
        int catId = leerInt();

        PreparedStatement ps = bd.prepareStatement(
            "INSERT INTO persona (nombre, apellidos, telefono, edad, estrella, categoriaId) " +
            "VALUES (?, ?, ?, ?, ?, ?)");
        ps.setString(1, nombre);
        ps.setString(2, apellidos.isEmpty() ? null : apellidos);
        ps.setString(3, telefono);
        ps.setInt(4, edad);
        ps.setBoolean(5, estrella);
        ps.setInt(6, catId);
        bd.ejecutarActualizacion(ps);
        System.out.println("Persona insertada correctamente.");
    }

    // ── Eliminar persona ──────────────────────────────────────────────────────

    private static void eliminarPersona() throws SQLException {
        System.out.print("Id de la persona a eliminar (0 = cancelar): ");
        int id = leerInt();
        if (id == 0) { System.out.println("Cancelado."); return; }

        PreparedStatement ps = bd.prepareStatement("DELETE FROM persona WHERE id = ?");
        ps.setInt(1, id);
        bd.ejecutarActualizacion(ps);
        System.out.println("Persona eliminada (si existía).");
    }

    // ── Modificar persona ─────────────────────────────────────────────────────

    private static void modificarPersona() throws SQLException {
        System.out.print("Id de la persona a modificar (0 = cancelar): ");
        int id = leerInt();
        if (id == 0) { System.out.println("Cancelado."); return; }

        // Obtenemos los datos actuales para mostrarlos
        PreparedStatement psSelect = bd.prepareStatement(
            "SELECT * FROM persona WHERE id = ?");
        psSelect.setInt(1, id);
        ResultSet rs = bd.ejecutarConsulta(psSelect);
        if (!rs.next()) {
            System.out.println("No existe ninguna persona con id " + id + ".");
            return;
        }

        // Guardamos valores actuales
        String nombreAct    = rs.getString("nombre");
        String apellidosAct = rs.getString("apellidos");
        String telefonoAct  = rs.getString("telefono");
        int    edadAct      = rs.getInt("edad");
        boolean estrellaAct = rs.getBoolean("estrella");
        int    catIdAct     = rs.getInt("categoriaId");

        // Pedimos nuevos valores (Enter = mantener el actual)
        System.out.printf("Nombre [%s] (Enter para mantener): ", nombreAct);
        String nombre = sc.nextLine().trim();
        if (nombre.isEmpty()) nombre = nombreAct;

        System.out.printf("Apellidos [%s] (Enter para mantener): ", apellidosAct != null ? apellidosAct : "");
        String apellidos = sc.nextLine().trim();
        if (apellidos.isEmpty()) apellidos = apellidosAct;

        System.out.printf("Teléfono [%s] (Enter para mantener): ", telefonoAct);
        String telefono = sc.nextLine().trim();
        if (telefono.isEmpty()) telefono = telefonoAct;

        System.out.printf("Edad [%d] (0 para mantener): ", edadAct);
        int edadInput = leerInt();
        int edad = (edadInput == 0) ? edadAct : edadInput;

        System.out.printf("Estrella [%s] (1=Sí / 0=No / -1=mantener): ", estrellaAct ? "Sí" : "No");
        int estrellaInput = leerInt();
        boolean estrella = (estrellaInput == -1) ? estrellaAct : (estrellaInput == 1);

        listarCategorias();
        System.out.printf("Id categoría [%d] (0 para mantener): ", catIdAct);
        int catInput = leerInt();
        int catId = (catInput == 0) ? catIdAct : catInput;

        PreparedStatement ps = bd.prepareStatement(
            "UPDATE persona " +
            "SET nombre = ?, apellidos = ?, telefono = ?, edad = ?, estrella = ?, categoriaId = ? " +
            "WHERE id = ?");
        ps.setString(1, nombre);
        ps.setString(2, apellidos);
        ps.setString(3, telefono);
        ps.setInt(4, edad);
        ps.setBoolean(5, estrella);
        ps.setInt(6, catId);
        ps.setInt(7, id);
        bd.ejecutarActualizacion(ps);
        System.out.println("Persona modificada correctamente.");
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  UTILIDADES
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * Lee un entero del teclado con validación de formato.
     * Repite la pregunta si el usuario escribe algo que no es un número.
     */
    private static int leerInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Introduce un número entero válido: ");
            }
        }
    }
}
