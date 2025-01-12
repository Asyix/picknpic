package fr.polytech.picknpic.ui.controllers.NotificationControllers;

import fr.polytech.picknpic.bl.facades.notification.NotificationFacade;
import fr.polytech.picknpic.bl.models.Notification;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller for managing notification operations in the UI.
 */
public class NotificationController {

    /**
     * The facade for notification-related operations.
     */
    private NotificationFacade notificationFacade;

    /**
     * The scene manager for loading different scenes.
     */
    private SceneManager sceneManager;

    /**
     * The label for displaying the notification description.
     */
    @FXML
    private Label notificationDescriptionLabel;

    /**
     * The label for displaying the notification type.
     */
    @FXML
    private Label notificationTypeLabel;

    /**
     * Constructs a new `NotificationController` instance.
     * Initializes the {@link NotificationFacade} singleton for notification operations.
     */
    public NotificationController() {
        this.notificationFacade = NotificationFacade.getNotificationFacadeInstance();
    }

    /**
     * Displays a notification based on its ID.
     *
     * @param notificationId The ID of the notification to display.
     */
    public void displayNotification(int notificationId) {
        try {
            Notification notification = notificationFacade.displayNotification(notificationId);
            notificationDescriptionLabel.setText(notification.getDescription());
            notificationTypeLabel.setText(notification.getType().name());
        } catch (Exception e) {
            System.out.println("Error while displaying notification: " + e.getMessage());
        }
    }

    /**
     * Initializes the controller.
     * Can be used to set default values or placeholders for UI elements.
     */
    @FXML
    public void handleShowNotification() {
        int notificationId = 1; // Example notification ID
        displayNotification(notificationId);
    }
}
