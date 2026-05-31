package model;

public class Temporada {
    private String idSerie;
    private int numeroTemporada;
    private int cantidadEpisodios;

    public Temporada(String idSerie, int numeroTemporada, int cantidadEpisodios) {
        this.idSerie = idSerie;
        this.numeroTemporada = numeroTemporada;
        this.cantidadEpisodios = cantidadEpisodios;
    }

    public String getIdSerie() { return idSerie; }
    public int getNumeroTemporada() { return numeroTemporada; }
    public int getCantidadEpisodios() { return cantidadEpisodios; }

    public String toCSV() {
        return String.format("TEMPORADA,%s,%d,%d", idSerie, numeroTemporada, cantidadEpisodios);
    }
}