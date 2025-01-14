package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Photo;
import fr.polytech.picknpic.bl.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhotoDAOPostgresTest {
    private PhotoDAOPostgres photoDAOPostgres;

    @BeforeEach
    void setUp() {
        UserDAOPostgres userDAOPostgres = new UserDAOPostgres();
        photoDAOPostgres = new PhotoDAOPostgres();
        User loggedInUser = userDAOPostgres.login("admin", "password123");
    }

    @Test
    void getPhotoById() {
        Photo photo = photoDAOPostgres.getPhotoById(1);
        assertNotNull(photo);
    }
}
