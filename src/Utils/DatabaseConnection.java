package Utils;

import java.sql.DriverManager;
import java.sql.Connection;


public class DatabaseConnection {
    static final String user = "root";
    static final String password = "";
    static final String url = "jdbc:mysql://localhost:3306/softka";
    static final String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection connection;


    public static Connection getConnection() {
        try {
            Class.forName(driver);
            connection = (connection == null) ? DriverManager.getConnection(url, user, password) : connection;
            if (connection != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (Exception e) {
            System.out.println("Error en la conexión" + e.getMessage());
        }
        return connection;
    }
}

