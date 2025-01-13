
package fr.polytech.picknpic.bl.models;

/**
 * Represents a Purchase entity with details of the purchase.
 */
public class Purchase {

    private int purchaseId; // Unique identifier for the purchase
    private int photoId;    // Identifier for the photo being purchased
    private int userId;     // Identifier for the user making the purchase

    /**
     * Gets the ID of the purchase.
     *
     * @return the purchase ID.
     */
    public int getPurchaseId() {
        return purchaseId;
    }

    /**
     * Sets the ID of the purchase.
     *
     * @param purchaseId the purchase ID to set.
     */
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    /**
     * Gets the ID of the photo being purchased.
     *
     * @return the photo ID.
     */
    public int getPhotoId() {
        return photoId;
    }

    /**
     * Sets the ID of the photo being purchased.
     *
     * @param photoId the photo ID to set.
     */
    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    /**
     * Gets the ID of the user making the purchase.
     *
     * @return the user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user making the purchase.
     *
     * @param userId the user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
