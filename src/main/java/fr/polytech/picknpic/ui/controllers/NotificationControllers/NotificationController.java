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

    private NotificationFacade notificationFacade;
    private SceneManager sceneManager;

    @FXML
    private Label notificationDescriptionLabel;

    @FXML
    private Label notificationTypeLabel;

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

    @FXML
    public void handleShowNotification() {
        int notificationId = 1; // Example notification ID
        displayNotification(notificationId);
    }
}
