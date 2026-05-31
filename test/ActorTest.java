package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Actor;

public class ActorTest {

    @Test
    void testCrearActor() {

        Actor actor =
            new Actor(
                "A001",
                "Tom",
                "Hanks");

        assertEquals(
            "Tom",
            actor.getNombre());

        assertEquals(
            "Hanks",
            actor.getApellido());
    }
}