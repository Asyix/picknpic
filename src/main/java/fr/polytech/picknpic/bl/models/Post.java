package fr.polytech.picknpic.bl.models;

import java.util.Date;
import java.util.List;

/**
 * Represents a post in the Pick'n'Pic application.
 * A post can have various attributes such as text, number of likes, number of comments, and creation date.
 */
public class Post {

    /** The unique identifier of the post. */
    private int id;

    /** The ID of the user who created the post. */
    private int userId;

    /** The text content of the post. */
    private String text;

    /** The number of likes the post has received. */
    private int nbLikes;

    /** The number of comments on the post. */
    private int nbComments;

    /** The date the post was created. */
    private Date creationDate;

    /** The list of comments on the post. */
    private List<Comment> Comments;

    /** The list of likes on the post. */
    private List<Like> Likes;

    /**
     * Constructs a new Post instance with default values.
     */
    public Post() {}

    /**
     * Constructs a new Post instance with the specified details.
     *
     * @param id The unique identifier of the post.
     * @param userId The ID of the user who created the post.
     * @param text The text content of the post.
     * @param nbLikes The number of likes the post has received.
     * @param nbComments The number of comments on the post.
     * @param creationDate The date the post was created.
     * @param Comments The list of comments on the post.
     * @param Likes The list of likes on the post.
     */
    public Post(int id, int userId, String text, int nbLikes, int nbComments, Date creationDate, List<Comment> Comments, List<Like> Likes) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.nbLikes = nbLikes;
        this.nbComments = nbComments;
        this.creationDate = creationDate;
        this.Comments = Comments;
        this.Likes = Likes;
    }

    /**
     * Constructs a new Post instance with the specified details.
     *
     * @param userId The ID of the user who created the post.
     * @param text The text content of the post.
     * @param nbLikes The number of likes the post has received.
     * @param nbComments The number of comments on the post.
     * @param creationDate The date the post was created.
     */
    public Post(int userId, String text, int nbLikes, int nbComments, Date creationDate) {
        this.userId = userId;
        this.text = text;
        this.nbLikes = nbLikes;
        this.nbComments = nbComments;
        this.creationDate = creationDate;
        this.Comments = null;
        this.Likes = null;
    }

    /**
     * Gets the unique identifier of the post.
     *
     * @return the unique identifier of the post.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the post.
     *
     * @param id the unique identifier to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the user who created the post.
     *
     * @return the user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user who created the post.
     *
     * @param userId the user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the text content of the post.
     *
     * @return the text content of the post.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text content of the post.
     *
     * @param text the text content to set.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the number of likes the post has received.
     *
     * @return the number of likes.
     */
    public int getNbLikes() {
        return nbLikes;
    }

    /**
     * Sets the number of likes the post has received.
     *
     * @param nbLikes the number of likes to set.
     */
    public void setNbLikes(int nbLikes) {
        this.nbLikes = nbLikes;
    }

    /**
     * Gets the number of comments on the post.
     *
     * @return the number of comments.
     */
    public int getNbComments() {
        return nbComments;
    }

    /**
     * Sets the number of comments on the post.
     *
     * @param nbComments the number of comments to set.
     */
    public void setNbComments(int nbComments) {
        this.nbComments = nbComments;
    }

    /**
     * Gets the date the post was created.
     *
     * @return the creation date.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the date the post was created.
     *
     * @param creationDate the creation date to set.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the list of comments on the post.
     *
     * @return the list of comments.
     */
    public List<Comment> getComments() {
        return Comments;
    }

    /**
     * Sets the list of comments on the post.
     *
     * @param Comments the list of comments to set.
     */
    public void setComments(List<Comment> Comments) {
        this.Comments = Comments;
    }

    /**
     * Gets the list of likes on the post.
     *
     * @return the list of likes.
     */
    public List<Like> getLikes() {
        return Likes;
    }

    /**
     * Sets the list of likes on the post.
     *
     * @param Likes the list of likes to set.
     */
    public void setLikes(List<Like> Likes) {
        this.Likes = Likes;
    }
}