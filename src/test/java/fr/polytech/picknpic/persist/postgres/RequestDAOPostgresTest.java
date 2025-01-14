package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestDAOPostgresTest {
    private RequestDAOPostgres requestDAOPostgres;
    private User loggedInUser;

    @BeforeEach
    void setUp() {
        UserDAOPostgres userDAOPostgres = new UserDAOPostgres();
        requestDAOPostgres = new RequestDAOPostgres();
        loggedInUser = userDAOPostgres.login("admin", "password123");
    }

    @AfterEach
    void tearDown() {
        requestDAOPostgres.changeRequestStatus(loggedInUser.getId(), "accepted waiting");
    }

    @Test
    void createRequest() {
        int id_user_buyer = loggedInUser.getId();
        int id_service = 1;
        int id_chat = 1;
        String message = "Test Message";
        String image = "example_image.png";
        String status = "waiting";

        assertNotNull(requestDAOPostgres.createRequest(id_user_buyer, id_service, id_chat, message, image, status));
    }
}