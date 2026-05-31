package model;

public class Actor {
    private String idActor;
    private String nombre;
    private String apellido;

    public Actor(String idActor, String nombre, String apellido) {
        this.idActor = idActor;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getIdActor() { return idActor; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }

    public String toCSV() {
        return String.format("ACTOR,%s,%s,%s", idActor, nombre, apellido);
    }
}