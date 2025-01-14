package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Comment;
import fr.polytech.picknpic.bl.models.Post;
import fr.polytech.picknpic.bl.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommentDAOPostgresTest {
    private CommentDAOPostgres commentDAOPostgres;
    private Comment comment;
    private PostDAOPostgres postDAOPostgres;
    private Post post;
    private User loggedInUser;

    @BeforeEach
    void setUp() {
        UserDAOPostgres userDAOPostgres = new UserDAOPostgres();
        loggedInUser = userDAOPostgres.login("admin", "password123");
        postDAOPostgres = new PostDAOPostgres();
        commentDAOPostgres = new CommentDAOPostgres();
    }

    @AfterEach
    void tearDown() {
        if (post != null) {
            List<Comment> comments = commentDAOPostgres.getPostComments(post.getId());
            if (!comments.isEmpty()) {
                Comment maxIdComment = comments.stream().max((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).orElse(null);
                commentDAOPostgres.deleteComment(maxIdComment.getId());
            }
        }
    }

    @Test
    void createComment() {

        post = postDAOPostgres.getPost(1);
        comment = new Comment(loggedInUser.getId(), post.getId(), -1, -1, "Test Comment", 0, 0, new java.util.Date());
        commentDAOPostgres.createComment(comment);
        assertNotNull(commentDAOPostgres.getPostComments(post.getId()));
    }
}