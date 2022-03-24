package Principal;
import ConectionBd.ConnBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainPreguntas {
    public static void main(String[] args) {
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/trivia_preguntas";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection connection;
        try {
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(url,user,password);
            if (connection!=null){
                System.out.println("Conecxion exitods");
            }

        }catch (Exception e){
            System.out.println("Error en la conexion"+e.getMessage());

        }


    }
}
