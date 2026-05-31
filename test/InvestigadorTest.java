package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Investigador;

public class InvestigadorTest {

    @Test
    void testCrearInvestigador() {

        Investigador inv =
            new Investigador(
                "I001",
                "Juan Perez",
                "Biología");

        assertEquals(
            "Biología",
            inv.getEspecialidad());
    }
}