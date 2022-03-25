package controller.controller;

import Utils.DatabaseConnection;
import controller.model.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JugadorController {

    private final String LIST_BY_NAME_QUERY = "Select * From JUGADOR j where j.NOMBRE = ?";
    private final String LIST_QUERY = "INSERT INTO JUGADOR(NOMBRE) VALUES (?)";
    private Connection connection;

    public JugadorController() {
        connection = DatabaseConnection.getConnection();
    }

    public Jugador saveJugador(String nombre) {
        Jugador jugador = getJugador(nombre);
        if (jugador == null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(LIST_QUERY);
                preparedStatement.setString(1, nombre);
                preparedStatement.executeUpdate();

                ResultSet rs = preparedStatement.getGeneratedKeys();

                return (rs.next()) ? new Jugador(rs.getInt(1), nombre) : null;
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error guardando jugadores");
                return null;
            }
        } else {
            return jugador;
        }
    }

    public Jugador getJugador(String name) {
        Jugador jugador = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LIST_BY_NAME_QUERY);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                jugador = new Jugador(
                        resultSet.getInt("ID"),
                        resultSet.getString("NOMBRE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error consultando jugadores");
        }
        return jugador;
    }


}
