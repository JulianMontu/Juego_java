package Principal;

import controller.controller.*;
import controller.model.*;

import javax.swing.*;
import java.util.List;

public class MainPreguntas {
    public static int puntaje = 0;

    public static void main(String[] args) {
        String userName = JOptionPane.showInputDialog("Digita tu nombre");
        boolean isGameActive = true;
        while (isGameActive) {
            isGameActive = play(userName);
        }
    }

    public static boolean play(String userName) {
        JugadorController jugadorController = new JugadorController();
        Jugador jugador = jugadorController.saveJugador(userName);
        List<Ronda> rondas = listarRondas();
        for (Ronda ronda : rondas) {
            for (Pregunta pregunta : listarPreguntasPorRonda(ronda.getId())) {
                List<Respuesta> respuestas = listarRespuestasPorPregunta(pregunta);
                int respuesta = Integer.parseInt(JOptionPane.showInputDialog(construirPregunta(pregunta, respuestas)));
                if (respuestas.get(respuesta - 1).getAcertada()) {
                    puntaje += ronda.getPuntaje();
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Obtuviste " + puntaje + " puntos", "Has Perdido !!!!",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    salvarJuego(new Juego(jugador.getId(), ronda.getId(), puntaje));
                    return false;
                }
            }
        }
        JOptionPane.showMessageDialog(
                null,
                "Obtuviste " + puntaje + " puntos", "Felicidades Ganaste !!!!",
                JOptionPane.INFORMATION_MESSAGE
        );
        salvarJuego(new Juego(jugador.getId(), rondas.get(rondas.size()-1).getId(), puntaje));
        return false;
    }

    public static List<Ronda> listarRondas() {
        RondaController rondaController = new RondaController();
        return rondaController.getRondas();
        /*
        List<Ronda> rondas = new ArrayList<>();
        rondas.add(new Ronda(1, "Ronda 1", 2));
        rondas.add(new Ronda(2, "Ronda 2", 4));
        rondas.add(new Ronda(3, "Ronda 3", 6));
        rondas.add(new Ronda(4, "Ronda 4", 8));
        rondas.add(new Ronda(5, "Ronda 5", 10));
        return rondas;
        */
    }

    public static List<Pregunta> listarPreguntasPorRonda(int ronda) {
        PreguntaController pregunta = new PreguntaController();
        return pregunta.getPreguntas(ronda);
        /*List<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta(1, "Quieres Jugar", ronda));
        return preguntas;*/
    }

    public static List<Respuesta> listarRespuestasPorPregunta(Pregunta pregunta) {
        RespuestaController respuestaController = new RespuestaController();
        return respuestaController.getRespuesta(pregunta.getId());
        /*List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(new Respuesta(1, "enunciado", false, pregunta.getId()));
        respuestas.add(new Respuesta(2, "enunciado", false, pregunta.getId()));
        respuestas.add(new Respuesta(3, "enunciado", false, pregunta.getId()));
        respuestas.add(new Respuesta(4, "enunciado", true, pregunta.getId()));
        return respuestas;*/
    }

    public static void salvarJuego(Juego juego) {
        JuegoController juegoController = new JuegoController();
        juegoController.saveJuego(juego);
    }

    public static String construirPregunta(Pregunta pregunta, List<Respuesta> respuestas) {
        String enunciado = pregunta.getEnunciado() + "\n\n";
        for (int i = 0; i < respuestas.size(); i++) {
            enunciado += i + 1 + ". " + respuestas.get(i).getEnunciado() + "\n";
        }
        enunciado += "\n";
        return enunciado;
    }
}
