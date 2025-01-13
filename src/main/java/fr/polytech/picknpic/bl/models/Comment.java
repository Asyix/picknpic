package fr.polytech.picknpic.bl.models;

import java.util.Date;
import java.util.List;

public class Comment {

    private int id;
    private int userId;
    private int postId;
    private int photoId;

    private int commentId;
    private String text;
    private int nbLikes;

    private int nbReplies;
    private Date creationDate;
    private List<Comment> replies;

    public Comment () {}

    /**
     * Constructor
     * Set userid to its value
     * Set concerned object by the comment's id to its value, all other ids to 0
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
     * Constructor
     * Set userid to its value
     * Set concerned object by the comment's id to its value, all other ids to 0
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

    public Comment(int userId, int postId, int photoId, int commentId, String text, int nbLikes, int nbReplies, Date creationDate) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.photoId = photoId;
        this.text = text;
        this.nbLikes = nbLikes;
        this.nbReplies = nbReplies;
        this.creationDate = creationDate;
        this.replies = null;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNbLikes() {
        return nbLikes;
    }

    public void setNbLikes(int nbLikes) {
        this.nbLikes = nbLikes;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }

    public int getCommentId() {
        return commentId;
    }

    public int getNbReplies() {
        return nbReplies;
    }
}