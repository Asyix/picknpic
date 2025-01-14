package fr.polytech.picknpic.bl.models;

import java.util.Date;
import java.util.List;

/**
 * Represents a comment in the Pick'n'Pic application.
 * A comment can be associated with a post, photo, or another comment.
 */
public class Comment {

    /** The unique identifier of the comment. */
    private int id;

    /** The ID of the user who created the comment. */
    private int userId;

    /** The ID of the post that the comment is associated with. */
    private int postId;

    /** The ID of the photo that the comment is associated with. */
    private int photoId;

    /** The ID of the comment that this comment is replying to. */
    private int commentId;

    /** The text content of the comment. */
    private String text;

    /** The number of likes the comment has received. */
    private int nbLikes;

    /** The number of replies to the comment. */
    private int nbReplies;

    /** The date the comment was created. */
    private Date creationDate;

    /** The list of replies to the comment. */
    private List<Comment> replies;

    /**
     * Constructs a new Comment instance with default values.
     */
    public Comment() {}

    /**
     * Constructs a new Comment instance with the specified details.
     *
     * @param id The unique identifier of the comment.
     * @param userId The ID of the user who created the comment.
     * @param postId The ID of the post that the comment is associated with.
     * @param photoId The ID of the photo that the comment is associated with.
     * @param commentId The ID of the comment that this comment is replying to.
     * @param text The text content of the comment.
     * @param nbLikes The number of likes the comment has received.
     * @param nbReplies The number of replies to the comment.
     * @param creationDate The date the comment was created.
     * @param replies The list of replies to the comment.
     */
    public Comment(int id, int userId, int postId, int photoId, int commentId, String text, int nbLikes, int nbReplies, Date creationDate, List<Comment> replies) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.photoId = photoId;
        this.commentId = commentId;
        this.text = text;
        this.nbLikes = nbLikes;
        this.nbReplies = nbReplies;
        this.creationDate = creationDate;
        this.replies = replies;
    }

    /**
     * Constructs a new Comment instance with the specified details.
     *
     * @param id The unique identifier of the comment.
     * @param userId The ID of the user who created the comment.
     * @param postId The ID of the post that the comment is associated with.
     * @param photoId The ID of the photo that the comment is associated with.
     * @param commentId The ID of the comment that this comment is replying to.
     * @param text The text content of the comment.
     * @param nbLikes The number of likes the comment has received.
     * @param nbReplies The number of replies to the comment.
     * @param creationDate The date the comment was created.
     */
    public Comment(int id, int userId, int postId, int photoId, int commentId, String text, int nbLikes, int nbReplies, Date creationDate) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.photoId = photoId;
        this.commentId = commentId;
        this.text = text;
        this.nbLikes = nbLikes;
        this.nbReplies = nbReplies;
        this.creationDate = creationDate;
        this.replies = null;
    }

    /**
     * Constructs a new Comment instance with the specified details.
     *
     * @param userId The ID of the user who created the comment.
     * @param postId The ID of the post that the comment is associated with.
     * @param photoId The ID of the photo that the comment is associated with.
     * @param commentId The ID of the comment that this comment is replying to.
     * @param text The text content of the comment.
     * @param nbLikes The number of likes the comment has received.
     * @param nbReplies The number of replies to the comment.
     * @param creationDate The date the comment was created.
     */
    public Comment(int userId, int postId, int photoId, int commentId, String text, int nbLikes, int nbReplies, Date creationDate) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.photoId = photoId;
        this.commentId = commentId;
        this.text = text;
        this.nbLikes = nbLikes;
        this.nbReplies = nbReplies;
        this.creationDate = creationDate;
        this.replies = null;
    }

    // Getters and Setters

    /**
     * Gets the unique identifier of the comment.
     *
     * @return the unique identifier of the comment.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the comment.
     *
     * @param id the unique identifier to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the user who created the comment.
     *
     * @return the user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user who created the comment.
     *
     * @param userId the user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the ID of the post that the comment is associated with.
     *
     * @return the post ID.
     */
    public int getPostId() {
        return postId;
    }

    /**
     * Sets the ID of the post that the comment is associated with.
     *
     * @param postId the post ID to set.
     */
    public void setPostId(int postId) {
        this.postId = postId;
    }

    /**
     * Gets the ID of the photo that the comment is associated with.
     *
     * @return the photo ID.
     */
    public int getPhotoId() {
        return photoId;
    }

    /**
     * Sets the ID of the photo that the comment is associated with.
     *
     * @param photoId the photo ID to set.
     */
    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    /**
     * Gets the text content of the comment.
     *
     * @return the text content of the comment.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text content of the comment.
     *
     * @param text the text content to set.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the number of likes the comment has received.
     *
     * @return the number of likes.
     */
    public int getNbLikes() {
        return nbLikes;
    }

    /**
     * Sets the number of likes the comment has received.
     *
     * @param nbLikes the number of likes to set.
     */
    public void setNbLikes(int nbLikes) {
        this.nbLikes = nbLikes;
    }

    /**
     * Gets the date the comment was created.
     *
     * @return the creation date.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the date the comment was created.
     *
     * @param creationDate the creation date to set.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the list of replies to the comment.
     *
     * @return the list of replies.
     */
    public List<Comment> getReplies() {
        return replies;
    }

    /**
     * Sets the list of replies to the comment.
     *
     * @param replies the list of replies to set.
     */
    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }

    /**
     * Gets the ID of the comment that this comment is replying to.
     *
     * @return the comment ID.
     */
    public int getCommentId() {
        return commentId;
    }

    /**
     * Gets the number of replies to the comment.
     *
     * @return the number of replies.
     */
    public int getNbReplies() {
        return nbReplies;
    }
}