package controller.model;

public class Pregunta {

    private int id;
    private String enunciado;
    private int ronda;

    public Pregunta(int id, String enunciado, int rondaId) {
        this.id = id;
        this.enunciado = enunciado;
        this.ronda = rondaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }
}
