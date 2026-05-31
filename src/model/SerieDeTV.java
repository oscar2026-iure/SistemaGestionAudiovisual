package model;

public class SerieDeTV extends ContenidoAudiovisual {
    private int totalTemporadas;

    public SerieDeTV(String id, String titulo, int anoEstreno, int totalTemporadas) {
        super(id, titulo, anoEstreno);
        this.totalTemporadas = totalTemporadas;
    }

    public int getTotalTemporadas() { return totalTemporadas; }

    @Override
    public String toCSV() {
        return String.format("SERIE,%s,%s,%d,%d", getId(), getTitulo(), getAnoEstreno(), totalTemporadas);
    }
}