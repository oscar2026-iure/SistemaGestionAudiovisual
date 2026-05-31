package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Documental;

public class DocumentalTest {

    @Test
    void testCrearDocumental() {

        Documental doc =
            new Documental(
                "D001",
                "Planeta Tierra",
                2020,
                "Naturaleza");

        assertEquals(
            "Naturaleza",
            doc.getTematica());
    }
}