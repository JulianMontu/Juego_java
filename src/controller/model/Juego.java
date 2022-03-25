package controller.model;

public class Juego {
    private int id;
    private int idJugador;
    private int idRonda;
    private int puntaje;

    public Juego(int idJugador, int idRonda, int puntaje) {
        this.idJugador = idJugador;
        this.idRonda = idRonda;
        this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
