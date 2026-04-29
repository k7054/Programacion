package BasesDeDatos.E883CrudAgendaCompletoConConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {

    // ── Parámetros de conexión ─────────────────────────────────────────────────
    private static final String URL      = "jdbc:mysql://localhost:3306/agenda";
    private static final String USUARIO  = "root";
    private static final String PASSWORD = "";          // ajusta si tu MySQL tiene contraseña

    private Connection conexion;

    // ── Conectar / desconectar ─────────────────────────────────────────────────

    /** Abre la conexión con la base de datos. */
    public void conectar() throws SQLException {
        conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    /** Cierra la conexión si estaba abierta. No lanza excepción para facilitar el uso en finally. */
    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    // ── Preparación de sentencias ──────────────────────────────────────────────

    /**
     * Crea un PreparedStatement a partir de una cadena SQL con marcadores '?'.
     * El caller se encarga de rellenar los parámetros antes de ejecutarlo.
     */
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return conexion.prepareStatement(sql);
    }

    // ── Ejecución ──────────────────────────────────────────────────────────────

    /**
     * Ejecuta una consulta SELECT y devuelve el ResultSet resultante.
     * Usado para: SELECT.
     */
    public ResultSet ejecutarConsulta(PreparedStatement ps) throws SQLException {
        return ps.executeQuery();
    }

    /**
     * Ejecuta una sentencia de modificación (INSERT, UPDATE, DELETE).
     * No devuelve nada; si se necesita el número de filas afectadas,
     * se puede ampliar para devolver un int.
     */
    public void ejecutarActualizacion(PreparedStatement ps) throws SQLException {
        ps.executeUpdate();
    }
}
