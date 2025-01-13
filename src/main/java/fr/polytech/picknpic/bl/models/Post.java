package fr.polytech.picknpic.bl.models;

import java.util.Date;
import java.util.List;

public class Post {

    /**
     * Attributes
     */
    private int id;
    private int userId;
    private String text;
    private int nbLikes;
    private int nbComments;
    private Date creationDate;

    private List<Comment> Comments;

    private List<Like> Likes;

    /**
     * Constructors
     */
    public Post() {}

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
     * Getters and Setters
     */
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

    public int getNbComments() {
        return nbComments;
    }

    public void setNbComments(int nbComments) {
        this.nbComments = nbComments;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Comment> getComments() {
        return Comments;
    }

    public void setComments(List<Comment> Comments) {
        this.Comments = Comments;
    }

    public List<Like> getLikes() {
        return Likes;
    }

    public void setLikes(List<Like> Likes) {
        this.Likes = Likes;
    }
}