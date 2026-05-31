package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Temporada;

public class TemporadaTest {

    @Test
    void testCrearTemporada() {

        Temporada temp =
            new Temporada(
                "S001",
                1,
                10);

        assertEquals(
            10,
            temp.getCantidadEpisodios());
    }
}