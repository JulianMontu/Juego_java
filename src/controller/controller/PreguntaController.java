package controller.controller;

import Utils.DatabaseConnection;
import controller.model.Pregunta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreguntaController {

    private final String LIST_QUERY = "Select * From PREGUNTA p where p.RONDA_ID = ?";

    private Connection connection;

    private PreparedStatement comando;

    public PreguntaController() {
        connection = DatabaseConnection.getConnection();
    }

    public List<Pregunta> getPreguntas(int idRonda) {
        List<Pregunta> preguntas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LIST_QUERY);
            preparedStatement.setInt(1, idRonda);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                preguntas.add(
                        new Pregunta(
                                resultSet.getInt("ID"),
                                resultSet.getString("ENUNCIADO"),
                                resultSet.getInt("RONDA_ID")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error consultando preguntas");
        }
        return preguntas;
    }

}
