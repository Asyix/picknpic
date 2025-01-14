package fr.polytech.picknpic.bl.facades.post;

import fr.polytech.picknpic.bl.models.Post;
import fr.polytech.picknpic.persist.AbstractFactory;

import java.util.List;

/**
 * The PostFacade class provides a unified interface to post management operations
 * such as creating, updating, deleting, and retrieving posts.
 * It follows the Singleton design pattern to ensure only one instance exists.
 */
public class PostFacade {
    /** The singleton instance of the PostFacade. */
    private static PostFacade postFacade;

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /**
     * Constructs a new PostFacade instance.
     * Private constructor to prevent instantiation.
     */
    private PostFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the PostFacade.
     * Ensures that only one instance of the PostFacade exists throughout the application.
     *
     * @return The singleton instance of the PostFacade.
     */
    public static PostFacade getInstance() {
        if (postFacade == null) {
            postFacade = new PostFacade();
        }
        return postFacade;
    }

    /**
     * Creates a new post.
     * Delegates the creation process to the DAO layer.
     *
     * @param post The {@link Post} object containing the post details.
     * @return true if the post was created successfully, false otherwise.
     */
    public boolean createPost(Post post) {
        return abstractFactory.createPostDAO().createPost(post);
    }

    /**
     * Updates an existing post.
     * Delegates the update process to the DAO layer.
     *
     * @param post The {@link Post} object containing the updated post details.
     * @return true if the post was updated successfully, false otherwise.
     */
    public boolean updatePost(Post post) {
        return abstractFactory.createPostDAO().updatePost(post);
    }

    /**
     * Deletes a post by its ID.
     * Delegates the deletion process to the DAO layer.
     *
     * @param postId The ID of the post to delete.
     * @return true if the post was deleted successfully, false otherwise.
     */
    public boolean deletePost(int postId) {
        return abstractFactory.createPostDAO().deletePost(postId);
    }

    /**
     * Retrieves a post by its ID.
     * Delegates the retrieval process to the DAO layer.
     *
     * @param postId The ID of the post to retrieve.
     * @return A {@link Post} object containing the post details.
     */
    public Post getPost(int postId) {
        return abstractFactory.createPostDAO().getPost(postId);
    }

    /**
     * Retrieves all posts created by a specific user.
     * Delegates the retrieval process to the DAO layer.
     *
     * @param userId The ID of the user whose posts are to be retrieved.
     * @return A list of {@link Post} objects containing the user's posts.
     */
    public List<Post> getUserPosts(int userId) {
        return abstractFactory.createPostDAO().getUserPosts(userId);
    }

    /**
     * Retrieves all posts created by users followed by a specific user.
     * Delegates the retrieval process to the DAO layer.
     *
     * @param userId The ID of the user whose followed users' posts are to be retrieved.
     * @return A list of {@link Post} objects containing the followed users' posts.
     */
    public List<Post> getFollowersPosts(int userId) {
        return abstractFactory.createPostDAO().getFollowersPosts(userId);
    }
}