package model;

public class Documental extends ContenidoAudiovisual {
    private String tematica;

    public Documental(String id, String titulo, int anoEstreno, String tematica) {
        super(id, titulo, anoEstreno);
        this.tematica = tematica;
    }

    public String getTematica() { return tematica; }

    @Override
    public String toCSV() {
        return String.format("DOCUMENTAL,%s,%s,%d,%s", getId(), getTitulo(), getAnoEstreno(), tematica);
    }
}