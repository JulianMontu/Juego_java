package controller.controller;

import Utils.DatabaseConnection;
import controller.model.Respuesta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RespuestaController {
    private final String LIST_QUERY = "Select * From RESPUESTA r where r.PREGUNTA_ID = ?";
    private Connection connection;

    public RespuestaController() {
        connection = DatabaseConnection.getConnection();
    }

    public List<Respuesta> getRespuesta(int idPregunta) {
        List<Respuesta> respuestas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(LIST_QUERY);
            preparedStatement.setInt(1, idPregunta);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                respuestas.add(
                        new Respuesta(
                                resultSet.getInt("ID"),
                                resultSet.getString("ENUNCIADO"),
                                resultSet.getBoolean("ACERTADA"),
                                resultSet.getInt("PREGUNTA_ID")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error consultando respuestas");
        }
        return respuestas;
    }
}
