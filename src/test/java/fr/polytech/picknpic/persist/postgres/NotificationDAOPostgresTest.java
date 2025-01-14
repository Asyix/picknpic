package fr.polytech.picknpic.persist.postgres;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationDAOPostgresTest {
    private NotificationDAOPostgres notificationDAOPostgres;

    @BeforeEach
    void setUp() {
        notificationDAOPostgres = new NotificationDAOPostgres();
    }

    @Test
    void displayNotification() {
        assertNotNull(notificationDAOPostgres.displayNotification(1));
    }
}