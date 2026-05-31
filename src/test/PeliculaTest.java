package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Pelicula;

public class PeliculaTest {

    @Test
    void testCrearPelicula() {

        Pelicula pelicula = new Pelicula(
                "P001",
                "Avatar",
                2009,
                162);

        assertEquals("Avatar", pelicula.getTitulo());
        assertEquals(162, pelicula.getDuracionMinutos());
    }
}