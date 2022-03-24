package Clases;

public class Jugador  {
    private int id;
    private String name;
    private  String cedula;
    private int totalPuntos;
    private int rondaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getTotalPuntos() {
        return totalPuntos;
    }

    public void setTotalPuntos(int totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

    public int getRondaId() {
        return rondaId;
    }

    public void setRondaId(int rondaId) {
        this.rondaId = rondaId;
    }


}
