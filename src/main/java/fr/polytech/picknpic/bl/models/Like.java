package fr.polytech.picknpic.bl.models;

/**
 * Represents a like in the Pick'n'Pic application.
 * A like can be associated with a post, photo, or comment.
 */
public class Like {
    /** The ID of the user who liked the post, photo, or comment. */
    private final int userId;

    /** The ID of the post that was liked. */
    private final int postId;

    /** The ID of the photo that was liked. */
    private final int photoId;

    /** The ID of the comment that was liked. */
    private final int commentId;

    /**
     * Constructs a new Like instance.
     * A like can concern only a photo, a post, or a comment.
     * Assign the concerned object's ID to its value and other IDs to -1.
     *
     * @param userId The ID of the user who liked the post, photo, or comment.
     * @param postId The ID of the post that was liked.
     * @param photoId The ID of the photo that was liked.
     * @param commentId The ID of the comment that was liked.
     */
    public Like(int userId, int postId, int photoId, int commentId) {
        this.userId = userId;
        this.postId = postId;
        this.photoId = photoId;
        this.commentId = commentId;
    }

    /**
     * Gets the ID of the user who liked the post, photo, or comment.
     *
     * @return the user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Gets the ID of the post that was liked.
     *
     * @return the post ID.
     */
    public int getPostId() {
        return postId;
    }

    /**
     * Gets the ID of the photo that was liked.
     *
     * @return the photo ID.
     */
    public int getPhotoId() {
        return photoId;
    }

    /**
     * Gets the ID of the comment that was liked.
     *
     * @return the comment ID.
     */
    public int getCommentId() {
        return commentId;
    }
}