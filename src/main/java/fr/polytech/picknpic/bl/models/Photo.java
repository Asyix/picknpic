package fr.polytech.picknpic.bl.models;

import java.util.Date;

/**
 * Represents a photo in the system, with its details and attributes.
 */
public class Photo {
    private int photoId;
    private String title;
    private String description;
    private int price;
    private int userId;
    private Date uploadDate;
    private String url;
    private boolean isForSale;
    private boolean isForSubscribersOnly;
    private int nbLikes;

    /**
     * Gets the ID of the photo.
     *
     * @return the ID of the photo.
     */
    public int getPhotoId() {
        return photoId;
    }

    /**
     * Sets the ID of the photo.
     *
     * @param photoId the ID of the photo.
     */
    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    /**
     * Gets the title of the photo.
     *
     * @return the title of the photo.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the photo.
     *
     * @param title the title of the photo.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the photo.
     *
     * @return the description of the photo.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the photo.
     *
     * @param description the description of the photo.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price of the photo.
     *
     * @return the price of the photo.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the photo.
     *
     * @param price the price of the photo.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets the ID of the user who owns the photo.
     *
     * @return the ID of the user who owns the photo.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user who owns the photo.
     *
     * @param userId the ID of the user who owns the photo.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the upload date of the photo.
     *
     * @return the upload date of the photo.
     */
    public Date getUploadDate() {
        return uploadDate;
    }

    /**
     * Sets the upload date of the photo.
     *
     * @param uploadDate the upload date of the photo.
     */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    /**
     * Gets the file path of the photo.
     *
     * @return the file path of the photo.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the file path of the photo.
     *
     * @param url the file path of the photo.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Checks if the photo is available for sale.
     *
     * @return {@code true} if the photo is for sale, {@code false} otherwise.
     */
    public boolean getIsForSale() {
        return isForSale;
    }

    /**
     * Sets whether the photo is available for sale.
     *
     * @param isForSale {@code true} if the photo is for sale, {@code false} otherwise.
     */
    public void setIsForSale(boolean isForSale) {
        this.isForSale = isForSale;
    }

    /**
     * Checks if the photo is available only for subscribers.
     *
     * @return {@code true} if the photo is for subscribers only, {@code false} otherwise.
     */
    public boolean getIsForSubscribersOnly() {
        return isForSubscribersOnly;
    }

    /**
     * Sets whether the photo is available only for subscribers.
     *
     * @param isForSubscribersOnly {@code true} if the photo is for subscribers only, {@code false} otherwise.
     */
    public void setIsForSubscribersOnly(boolean isForSubscribersOnly) {
        this.isForSubscribersOnly = isForSubscribersOnly;
    }

    /**
     * Gets the number of likes for the photo.
     *
     * @return the number of likes for the photo.
     */
    public int getNbLikes() {
        return nbLikes;
    }

    /**
     * Sets the number of likes for the photo.
     *
     * @param nbLikes the number of likes for the photo.
     */
    public void setNbLikes(int nbLikes) {
        this.nbLikes = nbLikes;
    }
}
