package controller.controller;

import Utils.DatabaseConnection;
import controller.model.Ronda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RondaController {

    private final String LIST_QUERY = "Select * From RONDA r";

    private Connection connection;

    public RondaController() {
        connection = DatabaseConnection.getConnection();
    }

    public List<Ronda> getRondas() {
        List<Ronda> rondas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LIST_QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                rondas.add(
                        new Ronda(
                                resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getInt("PUNTAJE")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error consultando rondas");
        }
        return rondas;
    }

}
