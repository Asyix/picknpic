package fr.polytech.picknpic.bl.facades.post;
import fr.polytech.picknpic.bl.models.Post;
import fr.polytech.picknpic.persist.AbstractFactory;

import java.util.List;

public class PostFacade {
    private final AbstractFactory abstractFactory;
    private static PostFacade postFacade;

    /**
     * Private constructor to initialize the facade with the abstract factory.
     */
    private PostFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the PhotoFacade.
     *
     * @return The singleton instance of PhotoFacade.
     */
    public static PostFacade getInstance() {
        if (postFacade == null) {
            postFacade = new PostFacade();
        }
        return postFacade;
    }

    public boolean createPost(Post post) {
        return abstractFactory.createPostDAO().createPost(post);
    }

    public boolean updatePost(Post post) {
        return abstractFactory.createPostDAO().updatePost(post);
    }

    public boolean deletePost(int postId) {
        return abstractFactory.createPostDAO().deletePost(postId);
    }

    public Post getPost(int postId) {
        return abstractFactory.createPostDAO().getPost(postId);
    }

    public List<Post> getUserPosts(int userId) {
        return abstractFactory.createPostDAO().getUserPosts(userId);
    }

    public List<Post> getFollowersPosts(int userId) {
        return abstractFactory.createPostDAO().getFollowersPosts(userId);
    }
}
