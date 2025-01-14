package fr.polytech.picknpic.ui.controllers.ServiceControllers;

import fr.polytech.picknpic.bl.facades.service.ServiceFacade;
import fr.polytech.picknpic.bl.models.Service;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * Controller for handling the deletion of a service in the application.
 * Provides functionality to delete a service by its ID.
 */
public class DeleteServiceController {

    /** The facade for service-related operations. */
    private final ServiceFacade serviceFacade;

    /** The service that was clicked. */
    private Service currentService;

    @FXML
    private Label confirmationLabel;

    /**
     * Constructs a new `DeleteServiceController` instance.
     * Initializes the {@link ServiceFacade} singleton.
     */
    public DeleteServiceController() {
        this.serviceFacade = ServiceFacade.getServiceFacadeInstance();
    }

    /**
     * Setter method to set the service that was clicked.
     *
     * @param service The service to be deleted.
     */
    public void setService(Service service) {
        this.currentService = service;
        updateConfirmationLabel();
    }

    /**
     * Updates the confirmation label to display the name of the service to be deleted.
     */
    private void updateConfirmationLabel() {
        if (currentService != null) {
            confirmationLabel.setText("ARE YOU SURE YOU WANT TO DELETE “" + currentService.getName() + "”?");
        } else {
            confirmationLabel.setText("Service information not available.");
        }
    }

    /**
     * Displays an alert dialog with the provided title, header, and message.
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
     * Loads the main scene.
     * This method will be triggered when the user clicks "NO" in the confirm delete dialog.
     */
    @FXML
    public void loadMainScene() throws Exception {
        SceneManager.loadMainScene();
    }

    /**
     * Handles the deletion of a service when the user confirms the action.
     * Invokes the delete service method from the facade.
     */
    @FXML
    public void handleDeleteService() {
        try {
            int idService = currentService.getIdService();
            serviceFacade.deleteService(idService);
            showAlert("Service Deleted", "Deletion Successful", "The service has been successfully deleted.");
            loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Deletion Failed", "An error occurred while deleting the service: " + e.getMessage());
        }
    }
}
