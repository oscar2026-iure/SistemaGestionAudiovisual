package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import repository.ContenidoRepository;

public class ContenidoRepositoryTest {

    @Test
    void testCrearRepositorio() {

        ContenidoRepository repo =
                new ContenidoRepository(
                        "datos_test.csv");

        assertNotNull(repo);
    }
}