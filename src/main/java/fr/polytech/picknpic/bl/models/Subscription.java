package fr.polytech.picknpic.bl.models;

/**
 * Represents a subscription with details about the provider, discount, and description.
 */
public class Subscription {

    /** Unique identifier for the subscription. */
    private int id_subscription;

    /** Unique identifier for the provider. */
    private int providerId;

    /** Discount associated with the subscription. */
    private double discount;

    /** Description of the subscription. */
    private String description;

    /**
     * Gets the unique identifier of the subscription.
     *
     * @return the subscription ID.
     */
    public int getIdSubscription() {
        return id_subscription;
    }

    /**
     * Sets the unique identifier of the subscription.
     * Will be removed later.
     * @param id_subscription the subscription ID to set.
     */
    public void setIdSubscription(int id_subscription) {
        this.id_subscription = id_subscription;
    }

    /**
     * Gets the provider ID of the subscription.
     *
     * @return the provider ID.
     */
    public int getProviderId() {
        return providerId;
    }

    /**
     * Sets the provider ID of the subscription.
     *
     * @param providerId the provider ID to set.
     */
    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    /**
     * Gets the discount of the subscription.
     *
     * @return the discount.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets the discount of the subscription.
     *
     * @param discount the discount to set.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Gets the description of the subscription.
     *
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the subscription.
     *
     * @param description the description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
