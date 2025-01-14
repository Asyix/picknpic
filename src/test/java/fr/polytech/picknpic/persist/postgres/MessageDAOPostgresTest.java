package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageDAOPostgresTest {
    private MessageDAOPostgres messageDAOPostgres;

    @BeforeEach
    void setUp() {
        messageDAOPostgres = new MessageDAOPostgres();
    }

    @Test
    void getAllMessages() {
        assertNotNull(messageDAOPostgres.getAllMessages(1));

    }
}