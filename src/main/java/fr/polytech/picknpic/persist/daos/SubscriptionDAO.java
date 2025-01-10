package fr.polytech.picknpic.persist.daos;
import fr.polytech.picknpic.bl.models.Subscription;

/**
 * Interface for subscription-related data access operations.
 * Provides methods for displaying subscription details.
 */
public interface SubscriptionDAO {

    /**
     * The current user subscribes to another user's subscription.
     *
     * @param currentUserId The ID of the user who is subscribing.
     * @param userThatOffersSubscriptionId The ID of the user who offers the subscription.
     */
    void subscribe(int currentUserId, int userThatOffersSubscriptionId);

    /**
     * Retrieves a subscription by its unique identifier.
     *
     * @param subscriptionId The unique identifier of the subscription to retrieve.
     * @return The subscription with the specified ID.
     */
    Subscription getSubscriptionById(int subscriptionId);
}
