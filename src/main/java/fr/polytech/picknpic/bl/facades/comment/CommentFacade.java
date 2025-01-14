package fr.polytech.picknpic.bl.facades.comment;

import fr.polytech.picknpic.bl.models.Comment;
import fr.polytech.picknpic.persist.AbstractFactory;

import java.util.List;

/**
 * The CommentFacade class provides a unified interface to comment management operations
 * such as creating, updating, deleting, and retrieving comments on posts and photos.
 * It follows the Singleton design pattern to ensure only one instance exists.
 */
public class CommentFacade {
    /** The singleton instance of the CommentFacade. */
    private static CommentFacade commentFacade;

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /**
     * Constructs a new CommentFacade instance.
     * Private constructor to prevent instantiation.
     */
    private CommentFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the CommentFacade.
     * Ensures that only one instance of the CommentFacade exists throughout the application.
     *
     * @return The singleton instance of the CommentFacade.
     */
    public static CommentFacade getInstance() {
        if (commentFacade == null) {
            commentFacade = new CommentFacade();
        }
        return commentFacade;
    }

    /**
     * Creates a new comment.
     * Delegates the creation process to the DAO layer.
     *
     * @param comment The {@link Comment} object containing the comment details.
     * @return true if the comment was created successfully, false otherwise.
     */
    public boolean createComment(Comment comment) {
        return abstractFactory.createCommentDAO().createComment(comment);
    }

    /**
     * Updates an existing comment.
     * Delegates the update process to the DAO layer.
     *
     * @param comment The {@link Comment} object containing the updated comment details.
     * @return true if the comment was updated successfully, false otherwise.
     */
    public boolean updateComment(Comment comment) {
        return abstractFactory.createCommentDAO().updateComment(comment);
    }

    /**
     * Deletes a comment by its ID.
     * Delegates the deletion process to the DAO layer.
     *
     * @param commentId The ID of the comment to delete.
     * @return true if the comment was deleted successfully, false otherwise.
     */
    public boolean deleteComment(int commentId) {
        return abstractFactory.createCommentDAO().deleteComment(commentId);
    }

    /**
     * Retrieves comments on a post.
     * Delegates the retrieval process to the DAO layer.
     *
     * @param postId The ID of the post to retrieve comments for.
     * @return A list of {@link Comment} objects containing the comments on the post.
     */
    public List<Comment> getPostComments(int postId) {
        return abstractFactory.createCommentDAO().getPostComments(postId);
    }

    /**
     * Retrieves comments on a photo.
     * Delegates the retrieval process to the DAO layer.
     *
     * @param photoId The ID of the photo to retrieve comments for.
     * @return A list of {@link Comment} objects containing the comments on the photo.
     */
    public List<Comment> getPhotoComments(int photoId) {
        return abstractFactory.createCommentDAO().getPhotoComments(photoId);
    }

    /**
     * Retrieves replies to a comment.
     * Delegates the retrieval process to the DAO layer.
     *
     * @param commentId The ID of the comment to retrieve replies for.
     * @return A list of {@link Comment} objects containing the replies to the comment.
     */
    public List<Comment> getCommentReplies(int commentId) {
        return abstractFactory.createCommentDAO().getCommentReplies(commentId);
    }
}