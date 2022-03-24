package ConectionBd;

import java.sql.DriverManager;
import java.sql.Connection;


public class ConnBD {
    static final String user = "root";
    static final String password = "";
    static final String url = "jdbc:mysql://localhost:3306/trivia_preguntas";
    static final String driver = "com.mysql.cj.jdbc.Driver";

    public static ConnBD instance;



    public static Connection getConnection() {
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conecxion exitods");
            }

        } catch (Exception e) {
            System.out.println("Error en la conexion" + e.getMessage());

        }
        return conn;
    }
}

