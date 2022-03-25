package controller.model;

public class Respuesta {
    private int id;
    private String enunciado;
    private Boolean acertada;
    private int preguntaId;

    public Respuesta(int id, String enunciado, Boolean acertada, int preguntaId) {
        this.id = id;
        this.enunciado = enunciado;
        this.acertada = acertada;
        this.preguntaId = preguntaId;
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

    public Boolean getAcertada() {
        return acertada;
    }

    public void setAcertada(Boolean acertada) {
        this.acertada = acertada;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }
}
