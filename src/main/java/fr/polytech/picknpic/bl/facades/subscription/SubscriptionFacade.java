package fr.polytech.picknpic.bl.facades.subscription;

import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.SubscriptionDAO;

/**
 * Facade for managing subscriptions in the system.
 * Provides a simplified interface for subscription operations
 * by delegating to the DAO layer.
 */
public class SubscriptionFacade {

    private final AbstractFactory abstractFactory;
    private static SubscriptionFacade subscriptionFacade;

    private SubscriptionFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the SubscriptionFacade.
     *
     * @return The singleton instance of SubscriptionFacade.
     */
    public static SubscriptionFacade getSubscriptionFacadeInstance() {
        if (subscriptionFacade == null) {
            subscriptionFacade = new SubscriptionFacade();
        }
        return subscriptionFacade;
    }

    /**
     * Allows the current user to subscribe to a provider.
     *
     * @param subscriberId The ID of the user subscribing.
     * @param providerId   The ID of the user offering the subscription.
     */
    public void subscribe(int subscriberId, int providerId) {
        SubscriptionDAO subscriptionDAO = abstractFactory.createSubscriptionDAO();
        subscriptionDAO.subscribe(subscriberId, providerId);
    }

    /**
     * Checks if a subscription exists between two users.
     *
     * @param subscriberId The ID of the subscriber.
     * @param providerId   The ID of the provider.
     * @return `true` if the subscription exists, `false` otherwise.
     */
    public boolean isSubscribed(int subscriberId, int providerId) {
        SubscriptionDAO subscriptionDAO = abstractFactory.createSubscriptionDAO();
        return subscriptionDAO.isSubscribed(subscriberId, providerId);
    }

    /**
     * Allows the current user to unsubscribe from a provider.
     *
     * @param subscriberId The ID of the user unsubscribing.
     * @param providerId   The ID of the provider.
     */
    public void unsubscribe(int subscriberId, int providerId) {
        SubscriptionDAO subscriptionDAO = abstractFactory.createSubscriptionDAO();
        subscriptionDAO.unsubscribe(subscriberId, providerId);
    }
}
