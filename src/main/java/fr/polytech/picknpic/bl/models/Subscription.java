package fr.polytech.picknpic.bl.models;

/**
 * Represents a subscription in the Pick'n'Pic application.
 * A subscription includes information about the provider, discount,
 * description, and a unique subscription ID.
 */
public class Subscription {

    /** The unique identifier of the provider. */
    private int providerId;

    /** The discount percentage for the subscription. */
    private double discount;

    /** The description of the subscription. */
    private String description;

    /** The unique identifier of the subscription. */
    private final int subscriptionId;

    /**
     * Constructs a new Subscription object.
     *
     * @param subscriptionId The unique identifier of the subscription.
     */
    public Subscription(int subscriptionId) {
        this.subscriptionId = subscriptionId;
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
     * Gets the discount percentage of the subscription.
     *
     * @return the discount percentage.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets the discount percentage of the subscription.
     *
     * @param discount the discount percentage to set.
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

    /**
     * Gets the subscription ID.
     *
     * @return the subscription ID.
     */
    public int getSubscriptionId() {
        return subscriptionId;
    }
}
