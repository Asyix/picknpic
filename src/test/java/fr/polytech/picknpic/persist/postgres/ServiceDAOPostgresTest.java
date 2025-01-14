package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Service;
import fr.polytech.picknpic.bl.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceDAOPostgresTest {
    private ServiceDAOPostgres serviceDAOPostgres;
    private User loggedInUser;
    private Service service;
    @BeforeEach
    void setUp() {
        UserDAOPostgres userDAOPostgres = new UserDAOPostgres();
        loggedInUser = userDAOPostgres.login("admin", "password123");
        serviceDAOPostgres = new ServiceDAOPostgres();
    }

    @AfterEach
    void tearDown() {
        serviceDAOPostgres.deleteService(service.getIdService());
    }

    @Test
    void createService() {
        service = serviceDAOPostgres.createService(loggedInUser.getId(), "Test Service", "Test Description", 10.0f, "example_image.png", 0);
        assertNotNull(service);
        assertEquals("Test Service", service.getName());
        assertEquals("Test Description", service.getDescription());
        assertEquals(10.0f, service.getPrice());
    }
}