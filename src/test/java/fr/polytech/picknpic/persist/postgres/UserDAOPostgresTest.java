package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.JDBCConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOPostgresTest {

    private UserDAOPostgres userDAOPostgres;

    @BeforeEach
    void setUp() {
        userDAOPostgres = new UserDAOPostgres();
    }

    @Test
    void login() {
        User loggedInUser = userDAOPostgres.login("admin", "password123");
        assertNotNull(loggedInUser);
        assertEquals("admin", loggedInUser.getUsername());
    }
}