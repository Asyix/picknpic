package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Subscription;

/**
 * Interface for subscription-related data access operations.
 * Provides methods for managing subscriptions.
 */
public interface SubscriptionDAO {

    /**
     * The current user subscribes to another user's subscription.
     *
     * @param subscriberId The ID of the user who is subscribing.
     * @param providerId   The ID of the user who is being subscribed to.
     */
    void subscribe(int subscriberId, int providerId);

    /**
     * Checks if a subscription exists between two users.
     *
     * @param subscriberId The ID of the subscriber.
     * @param providerId   The ID of the provider.
     * @return `true` if the subscription exists, `false` otherwise.
     */
    boolean isSubscribed(int subscriberId, int providerId);

    /**
     * Deletes a subscription between a subscriber and a provider.
     *
     * @param subscriberId The ID of the subscriber.
     * @param providerId   The ID of the provider.
     */
    void unsubscribe(int subscriberId, int providerId);
}
