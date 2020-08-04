package conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Febre
 */
public class Conectar {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/publicaciones";

    public Conectar() {
        conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/publicaciones",
                    "root", "root");

            if (conn != null) {
                System.out.println("Conexión establecida");
            }
        } catch (ClassNotFoundException | SQLException e) {

        }
    }

    // Con este metodo nos conectamos a la BD
    public Connection getConectar() {
        return conn;
    }

    public void desconectar() {
        conn = null;
        if (conn == null) {
            System.out.println("Conexion terminada...");
        }
    }

}
