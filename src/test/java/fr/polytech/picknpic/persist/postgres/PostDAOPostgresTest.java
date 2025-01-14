package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Post;
import fr.polytech.picknpic.bl.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostDAOPostgresTest {
    private PostDAOPostgres postDAOPostgres;
    private User loggedInUser;
    private Post post;

    @BeforeEach
    void setUp() {
        UserDAOPostgres userDAOPostgres = new UserDAOPostgres();
        postDAOPostgres = new PostDAOPostgres();
        loggedInUser = userDAOPostgres.login("admin", "password123");
    }

    @AfterEach
    void tearDown() {
        postDAOPostgres.deletePost(post.getId());
    }

    @Test
    void createPost() {
        post = new Post();
        post.setUserId(loggedInUser.getId());
        post.setText("Test Post");
        post.setNbLikes(0);
        post.setNbComments(0);
        post.setCreationDate(new java.util.Date());

        assertTrue(postDAOPostgres.createPost(post));
    }
}