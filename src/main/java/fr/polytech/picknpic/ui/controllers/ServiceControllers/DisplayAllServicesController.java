package fr.polytech.picknpic.ui.controllers.ServiceControllers;

import fr.polytech.picknpic.bl.facades.service.ServiceFacade;
import fr.polytech.picknpic.ui.controllers.MainController;
import javafx.scene.control.Alert;

/**
 * Controller for displaying all services.
 * Handles user interactions related to retrieving and displaying services for a user.
 */
public class DisplayAllServicesController {

    /** The facade for service-related operations. */
    private final ServiceFacade serviceFacade;

    /** The main controller for the application. */
    private MainController mainController;

    /**
     * Constructs a new `DisplayAllServicesController` instance.
     * Initializes the {@link ServiceFacade} singleton.
     */
    public DisplayAllServicesController() {
        this.serviceFacade = ServiceFacade.getServiceFacadeInstance();
    }

    /**
     * Sets the {@link MainController} instance.
     * @param mainController The main controller to set.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
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
     * Handles user interactions for retrieving all services for a user.
     */
    public void handleGetAllServices() {

        int id_user = 1;

        try {
            // Retrieve all services for the user
            serviceFacade.getAllServices(id_user);
        } catch (Exception e) {
            showAlert("Error", "Failed to retrieve services", e.getMessage());
        }

    }
}
