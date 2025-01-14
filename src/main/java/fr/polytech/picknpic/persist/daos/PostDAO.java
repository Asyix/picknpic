package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Post;

import java.util.List;

/**
 * Interface for Data Access Object (DAO) operations related to the Post entity.
 * Provides methods for creating, updating, deleting, and retrieving posts.
 */
public interface PostDAO {

    /**
     * Creates a new post.
     *
     * @param post The {@link Post} object containing the post details.
     * @return true if the post was created successfully, false otherwise.
     */
    boolean createPost(Post post);

    /**
     * Updates an existing post.
     *
     * @param post The {@link Post} object containing the updated post details.
     * @return true if the post was updated successfully, false otherwise.
     */
    boolean updatePost(Post post);

    /**
     * Deletes a post by its ID.
     *
     * @param postId The ID of the post to delete.
     * @return true if the post was deleted successfully, false otherwise.
     */
    boolean deletePost(int postId);

    /**
     * Retrieves a post by its ID.
     *
     * @param postId The ID of the post to retrieve.
     * @return A {@link Post} object containing the post details.
     */
    Post getPost(int postId);

    /**
     * Retrieves all posts created by a specific user.
     *
     * @param userId The ID of the user whose posts are to be retrieved.
     * @return A list of {@link Post} objects containing the user's posts.
     */
    List<Post> getUserPosts(int userId);

    /**
     * Retrieves all posts created by users followed by a specific user.
     *
     * @param userId The ID of the user whose followed users' posts are to be retrieved.
     * @return A list of {@link Post} objects containing the followed users' posts.
     */
    List<Post> getFollowersPosts(int userId);
}