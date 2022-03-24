package Clases;

public class Respuesta {
    private int id;
    private String respuestaEnun;
    private Boolean acertada;
    private int preguntaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRespuestaEnun() {
        return respuestaEnun;
    }

    public void setRespuestaEnun(String respuestaEnun) {
        this.respuestaEnun = respuestaEnun;
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
