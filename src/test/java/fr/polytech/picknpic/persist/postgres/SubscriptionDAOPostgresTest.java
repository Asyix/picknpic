package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionDAOPostgresTest {
    private SubscriptionDAOPostgres subscriptionDAOPostgres;
    private User loggedInUser;

    private User provider;

    @BeforeEach
    void setUp() {
        UserDAOPostgres userDAOPostgres = new UserDAOPostgres();
        subscriptionDAOPostgres = new SubscriptionDAOPostgres();
        loggedInUser = userDAOPostgres.login("admin", "password123");
        provider = userDAOPostgres.login("Alex", "alex");
    }

    @Test
    void subscribe() {
        subscriptionDAOPostgres.subscribe(loggedInUser.getId(), provider.getId());
        assertTrue(subscriptionDAOPostgres.isSubscribed(loggedInUser.getId(), provider.getId()));
    }

    @AfterEach
    void tearDown() {
        subscriptionDAOPostgres.unsubscribe(loggedInUser.getId(), provider.getId());
    }
}