package model;

public abstract class ContenidoAudiovisual {
    private String id;
    private String titulo;
    private int anoEstreno;

    public ContenidoAudiovisual(String id, String titulo, int anoEstreno) {
        this.id = id;
        this.titulo = titulo;
        this.anoEstreno = anoEstreno;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getAnoEstreno() { return anoEstreno; }

    // Método abstracto para que cada hijo defina su formato en el archivo CSV
    public abstract String toCSV();
}