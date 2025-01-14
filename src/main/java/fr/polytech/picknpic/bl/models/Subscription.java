package fr.polytech.picknpic.bl.models;

/**
 * Represents a subscription in the Pick'n'Pic application.
 * A subscription includes information about the subscriber and provider.
 */
public class Subscription {

    /** The unique identifier of the subscriber. */
    private int subscriberId;

    /** The unique identifier of the provider. */
    private int providerId;

    /**
     * Constructs a new Subscription object with both subscriber and provider IDs.
     *
     * @param subscriberId The unique identifier of the subscriber.
     * @param providerId   The unique identifier of the provider.
     */
    public Subscription(int subscriberId, int providerId) {
        this.subscriberId = subscriberId;
        this.providerId = providerId;
    }

    /**
     * Gets the subscriber ID of the subscription.
     *
     * @return the subscriber ID.
     */
    public int getSubscriberId() {
        return subscriberId;
    }

    /**
     * Sets the subscriber ID of the subscription.
     *
     * @param subscriberId the subscriber ID to set.
     */
    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
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
}
