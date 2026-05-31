package model;

public class Pelicula extends ContenidoAudiovisual {
    private int duracionMinutos;

    public Pelicula(String id, String titulo, int anoEstreno, int duracionMinutos) {
        // Llama de forma correcta al constructor de la clase padre (ContenidoAudiovisual)
        super(id, titulo, anoEstreno);
        this.duracionMinutos = duracionMinutos;
    }

    public int getDuracionMinutos() { 
        return duracionMinutos; 
    }

    @Override
    public String toCSV() {
        // Ahora sí se puede acceder a los métodos get del padre de manera limpia
        return String.format("PELICULA,%s,%s,%d,%d", getId(), getTitulo(), getAnoEstreno(), duracionMinutos);
    }
}