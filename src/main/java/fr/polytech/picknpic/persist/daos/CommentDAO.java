package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Comment;

import java.util.List;

/**
 * Interface for Data Access Object (DAO) operations related to the Comment entity.
 * Provides methods for creating, updating, deleting, and retrieving comments on posts and photos.
 */
public interface CommentDAO {

    /**
     * Retrieves comments on a post.
     *
     * @param postId The ID of the post to retrieve comments for.
     * @return A list of {@link Comment} objects containing the comments on the post.
     */
    List<Comment> getPostComments(int postId);

    /**
     * Retrieves comments on a photo.
     *
     * @param photoId The ID of the photo to retrieve comments for.
     * @return A list of {@link Comment} objects containing the comments on the photo.
     */
    List<Comment> getPhotoComments(int photoId);

    /**
     * Retrieves replies to a comment.
     *
     * @param commentId The ID of the comment to retrieve replies for.
     * @return A list of {@link Comment} objects containing the replies to the comment.
     */
    List<Comment> getCommentReplies(int commentId);

    /**
     * Creates a new comment.
     *
     * @param comment The {@link Comment} object containing the comment details.
     * @return true if the comment was created successfully, false otherwise.
     */
    boolean createComment(Comment comment);

    /**
     * Updates an existing comment.
     *
     * @param comment The {@link Comment} object containing the updated comment details.
     * @return true if the comment was updated successfully, false otherwise.
     */
    boolean updateComment(Comment comment);

    /**
     * Deletes a comment by its ID.
     *
     * @param commentId The ID of the comment to delete.
     * @return true if the comment was deleted successfully, false otherwise.
     */
    boolean deleteComment(int commentId);
}