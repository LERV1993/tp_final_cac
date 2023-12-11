package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3308/cactpfinal";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public Connection obtenerConexion() {
        
        Connection conn = null;
        
        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            // Crear la tabla si no existe
            crearTablaUsuarios(conn);
            
            return conn;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }

    private void crearTablaUsuarios(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "dni VARCHAR(15) NOT NULL,"
                + "nombre VARCHAR(30) NOT NULL)";

        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear la tabla de usuarios", e);
        }
    }
}
