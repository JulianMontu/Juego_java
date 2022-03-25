package controller.controller;

import Utils.DatabaseConnection;
import controller.model.Juego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JuegoController {

    private final String SAVE_QUERY = "INSERT INTO JUEGO( PUNTAJE, RONDA_ID, JUGADOR_ID) VALUES (?,?,?)";

    private Connection connection;

    public JuegoController() {
        connection = DatabaseConnection.getConnection();
    }

    public boolean saveJuego(Juego juego) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_QUERY);
            preparedStatement.setInt(1, juego.getPuntaje());
            preparedStatement.setInt(2, juego.getIdRonda());
            preparedStatement.setInt(3, juego.getIdJugador());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error guardando el juego");
            return false;
        }
    }

}
