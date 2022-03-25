package controller.model;

public class Ronda {
    private int id;
    private String nombre;
    private int puntaje;

    public Ronda(int id, String nombreRonda, int puntaje) {
        this.id = id;
        this.nombre = nombreRonda;
        this.puntaje = puntaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
