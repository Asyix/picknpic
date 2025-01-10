package fr.polytech.picknpic.ui.controllers.RequestControllers;

import fr.polytech.picknpic.bl.facades.request.RequestFacade;
import fr.polytech.picknpic.bl.models.Request;
import fr.polytech.picknpic.ui.controllers.MainController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import fr.polytech.picknpic.ui.SceneManager;

/**
 * Controller for managing requests.
 * Handles user interactions related to managing requests in the application.
 */
public class ManageRequestController {

    /**
     * The facade for managing requests.
     */
    private final RequestFacade requestFacade;

    /** The scene manager for managing scene transitions. */
    private SceneManager sceneManager;

    /**
     * Constructs a new `ManageRequestController` instance.
     * Initializes the {@link RequestFacade} singleton.
     */
    public ManageRequestController() {
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
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Handles user interactions for creating requests.
     * This method is triggered when the user want to create a request in the application.
     */
    public void handleCreateRequest() {
        // temporary request creation example
        int id_user_buyer = 2;
        int id_service = 1;
        int id_chat = 1;
        String message = "Please deliver the item to my address.";
        String image = "https://example";
        String status = "waiting";

        try {
            requestFacade.createRequest(id_user_buyer, id_service, id_chat, message, image, status);

            // Notify the user that the request has been created
            showAlert("Request Created", "Request successfully created!", "Request ID: ");
            sceneManager.loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Failed to create request.", "Reason: " + e.getMessage());
        }

        // TODO: handle non existing id_user_buyer, id_service
        // TODO: handle empty fields for message, image, status



    }

    public void handleChangeRequestStatus() {
        // temporary request status change example
        int id_request = 1;
        String newStatus = "accepted waiting";

        try {
            requestFacade.changeRequestStatus(id_request, newStatus);

            // Notify the user that the request status has been updated
            showAlert("Request Updated", "Request status successfully updated!", "Request ID: ");
            sceneManager.loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Failed to update request status.", "Reason: " + e.getMessage());
        }

        // TODO: handle non existing id_request
        // TODO: handle invalid newStatus (waiting, accepted waiting, delivered, declined)

    }

}