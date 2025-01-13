package fr.polytech.picknpic.bl.models;

import java.sql.Time;
import java.util.Date;

public class Like {
    private final int userId;

    private final int postId;

    private final int photoId;

    private final int commentId;


    /**
     * Default constructor.
     * A like can concern only a photo, a post or a comment.
     * Assign concerned object's id to its value and other ids to -1.
     * @param userId The id of the user who liked the post.
     */
    public Like(int userId, int postId, int photoId, int commentId) {
        this.userId = userId;
        this.postId = postId;
        this.photoId = photoId;
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public int getPostId() {
        return postId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public int getCommentId() {
        return commentId;
    }
}
