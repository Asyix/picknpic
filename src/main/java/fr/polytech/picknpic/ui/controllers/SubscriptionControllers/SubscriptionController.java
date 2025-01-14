package fr.polytech.picknpic.ui.controllers.SubscriptionControllers;

import fr.polytech.picknpic.bl.facades.subscription.SubscriptionFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * Controller for managing subscription operations in the application.
 * Provides an interface between the UI and the subscription business logic.
 */
public class SubscriptionController {

    /**
     * The facade for subscription-related operations.
     */
    private final SubscriptionFacade subscriptionFacade;

    /**
     * The user of the current page we are navigating.
     */
    private User currentPageUser;

    /**
     * Constructs a new `SubscriptionController` instance.
     * Initializes the {@link SubscriptionFacade} singleton for subscription operations.
     */
    public SubscriptionController() {
        this.subscriptionFacade = SubscriptionFacade.getSubscriptionFacadeInstance();
    }

    /**
     * Initializes the controller.
     * Can be used to set default values or placeholders for UI elements.
     */
    @FXML
    public void initialize() {
    }

    /**
     * Setter method to set the current page user.
     */
    public void setCurrentPageUser(User user) {
        this.currentPageUser = user;
    }

    /**
     * Subscribes the current user to a provider's subscription.
     *
     * @param subscriberId The ID of the user subscribing.
     * @param providerId   The ID of the user offering the subscription.
     */
    public void subscribe(int subscriberId, int providerId) {
        subscriptionFacade.subscribe(subscriberId, providerId);
        showAlert("Subscription Successful", "You have successfully subscribed to the user's subscription!");
    }

    /**
     * Handles the subscription operation.
     */
    public void handleSubscribe() {
        int currentUserId = LoginFacade.getInstance().getCurrentUser().getId();
        int userThatOffersSubscriptionId = this.currentPageUser.getId();
        subscribe(currentUserId, userThatOffersSubscriptionId);
        loadProfileScene();
    }

    /**
     * Checks if a subscription exists between two users.
     *
     * @param subscriberId The ID of the subscriber.
     * @param providerId   The ID of the provider.
     * @return `true` if the subscription exists, `false` otherwise.
     */
    public boolean isSubscribed(int subscriberId, int providerId) {
        return subscriptionFacade.isSubscribed(subscriberId, providerId);
    }

    /**
     * Handles the subscription status of the current user.
     */
    public void handleSubscriptionStatus(Label subscriptionStatusLabel) {
        int currentUserId = LoginFacade.getInstance().getCurrentUser().getId();
        int userThatOffersSubscriptionId = this.currentPageUser.getId();
        boolean isSubscribed = isSubscribed(currentUserId, userThatOffersSubscriptionId);
        if (isSubscribed) {
            subscriptionStatusLabel.setText("Subscribed");
        } else {
            subscriptionStatusLabel.setText("Not Subscribed");
        }
    }

    /**
     * Displays an alert dialog with the specified title and message.
     *
     * @param title   The title of the alert.
     * @param message The message to display in the alert.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void loadProfileScene() {
        try {
            SceneManager.loadProfileScene(this.currentPageUser);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load the profile scene", e);
        }
    }

}
