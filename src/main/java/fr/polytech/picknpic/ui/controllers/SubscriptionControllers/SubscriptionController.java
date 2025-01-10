package fr.polytech.picknpic.ui.controllers.SubscriptionControllers;

import fr.polytech.picknpic.bl.facades.subscription.SubscriptionFacade;
import fr.polytech.picknpic.bl.models.Subscription;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller for managing subscription operations in the application.
 * Provides an interface between the UI and the subscription business logic.
 */
public class SubscriptionController {

    @FXML
    private Label subscriptionDescriptionLabel;

    @FXML
    private Label subscriptionDiscountLabel;

    private final SubscriptionFacade subscriptionFacade;

    private Subscription subscription;

    private SceneManager sceneManager;

    /**
     * Constructs a new `SubscriptionController` instance.
     * Initializes the {@link SubscriptionFacade} singleton for subscription operations.
     */
    public SubscriptionController() {
        this.subscriptionFacade = SubscriptionFacade.getSubscriptionFacadeInstance();
    }

    // Automatically load benefits when the scene initializes
    @FXML
    public void initialize() {
        seeBenefits();
    }

    /**
     * Subscribes the current user to a subscription offered by another user.
     *
     * @param currentUserId                The ID of the user subscribing.
     * @param userThatOffersSubscriptionId The ID of the user offering the subscription.
     */
    public void subscribe(int currentUserId, int userThatOffersSubscriptionId) {
        subscriptionFacade.subscribe(currentUserId, userThatOffersSubscriptionId);
    }

    /**
     * Displays the benefits of a specific subscription.
     */
    public void seeBenefits() {
        int subscriptionId = 1; // Temporary subscription ID
        try {
            // Fetch the subscription details
            subscription = subscriptionFacade.getSubscriptionById(subscriptionId);
            System.out.println("desc" + subscription.getDescription());
            System.out.println("disc" + subscription.getDiscount());

            // Update the labels
            subscriptionDescriptionLabel.setText(subscription.getDescription());
            subscriptionDiscountLabel.setText(String.valueOf(subscription.getDiscount()));
        } catch (Exception e) {
            System.out.println("Error while displaying subscription benefits: " + e.getMessage());
        }
    }
}
