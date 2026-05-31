package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import controller.ContenidoController;
import repository.ContenidoRepository;
import model.Pelicula;

public class ContenidoControllerTest {

    @Test
    void testAgregarContenido() {

        ContenidoRepository repo =
                new ContenidoRepository("test.csv");

        ContenidoController controller =
                new ContenidoController(repo);

        controller.agregarContenido(
                new Pelicula(
                        "P001",
                        "Avatar",
                        2009,
                        162));

        assertEquals(
                1,
                controller.getContenidos().size());
    }
}