package fr.polytech.picknpic.bl.facades.subscription;

import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.SubscriptionDAO;
import fr.polytech.picknpic.bl.models.Subscription;

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
     * Allows the current user to subscribe to a subscription offered by another user.
     *
     * @param currentUserId                The ID of the user subscribing.
     * @param userThatOffersSubscriptionId The ID of the user offering the subscription.
     */
    public void subscribe(int currentUserId, int userThatOffersSubscriptionId) {
        SubscriptionDAO subscriptionDAO = abstractFactory.createSubscriptionDAO();
        subscriptionDAO.subscribe(currentUserId, userThatOffersSubscriptionId);
    }

    /**
     * Retrieves a subscription by its unique identifier.
     *
     * @param subscriptionId The unique identifier of the subscription to retrieve.
     * @return The subscription with the specified ID.
     */
    public Subscription getSubscriptionById(int subscriptionId) {
        return abstractFactory.createSubscriptionDAO().getSubscriptionById(subscriptionId);
    }
}