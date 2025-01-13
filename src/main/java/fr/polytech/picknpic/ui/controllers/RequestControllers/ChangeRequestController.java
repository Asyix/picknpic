package fr.polytech.picknpic.ui.controllers.RequestControllers;

import fr.polytech.picknpic.bl.facades.request.RequestFacade;
import javafx.scene.control.Alert;
import fr.polytech.picknpic.ui.SceneManager;

/**
 * Controller for changing request statuses.
 * Handles user interactions related to updating the status of an existing request.
 */
public class ChangeRequestController {

    /** The facade for managing requests. */
    private final RequestFacade requestFacade;

    /**
     * Constructs a new `ChangeRequestController` instance.
     * Initializes the {@link RequestFacade} singleton.
     */
    public ChangeRequestController() {
        this.requestFacade = RequestFacade.getRequestFacadeInstance();
    }

    /**
     * Shows an alert dialog with the given message.
     *
     * @param title   The title of the alert dialog.
     * @param header  The header text of the alert dialog.
     * @param message The message to display in the alert dialog.
     */
    private void showAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Handles the update of a request's status.
     */
    public void handleChangeRequestStatus() {
        // Example request status change logic
        int id_request = 1; // Replace with actual request ID
        String newStatus = "accepted waiting";

        try {
            requestFacade.changeRequestStatus(id_request, newStatus);

            // Notify the user that the request status has been updated
            showAlert("Request Updated", "Request status successfully updated!", "Your request has been updated.");
            SceneManager.loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Failed to update request status.", "Reason: " + e.getMessage());
        }

        // TODO: Handle invalid newStatus and non-existing id_request.
    }
}
