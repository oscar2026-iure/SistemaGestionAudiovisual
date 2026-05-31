package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.SerieDeTV;

public class SerieDeTVTest {

    @Test
    void testCrearSerie() {

        SerieDeTV serie =
            new SerieDeTV(
                "S001",
                "Dark",
                2017,
                3);

        assertEquals("Dark", serie.getTitulo());
        assertEquals(3, serie.getTotalTemporadas());
    }
}