package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Like;
import fr.polytech.picknpic.bl.models.Post;
import fr.polytech.picknpic.bl.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LikeDAOPostgresTest {
    private LikeDAOPostgres likeDAOPostgres;
    private PostDAOPostgres postDAOPostgres;
    private Post post;
    private User loggedInUser;
    private Like like;

    @BeforeEach
    void setUp() {
        UserDAOPostgres userDAOPostgres = new UserDAOPostgres();
        loggedInUser = userDAOPostgres.login("admin", "password123");
        postDAOPostgres = new PostDAOPostgres();
        postDAOPostgres = new PostDAOPostgres();
    }

    @AfterEach
    void tearDown() {
        likeDAOPostgres.removeLikeOnPost(loggedInUser.getId(), post.getId());
        postDAOPostgres.deletePost(post.getId());
    }

    @Test
    void addLike() {
        post = new Post();
        post.setUserId(loggedInUser.getId());
        post.setText("Test Post");
        post.setNbLikes(0);
        post.setNbComments(0);
        post.setCreationDate(new java.util.Date());

        postDAOPostgres.createPost(post);

        like = new Like(loggedInUser.getId(), post.getId(), -1, -1);
        assertTrue(likeDAOPostgres.addLike(like));
    }
}