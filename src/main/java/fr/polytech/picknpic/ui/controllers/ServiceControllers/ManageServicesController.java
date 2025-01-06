package fr.polytech.picknpic.ui.controllers.ServiceControllers;

import fr.polytech.picknpic.bl.facades.service.ServiceFacade;
import fr.polytech.picknpic.ui.controllers.MainController;
import javafx.scene.control.Alert;

/**
 * Controller for managing services.
 * Handles user interactions related to managing services in the application.
 */
public class ManageServicesController {

    /** The facade for service-related operations. */
    private final ServiceFacade serviceFacade;

    /** The main controller for the application. */
    private MainController mainController;

    /**
     * Constructs a new `ManageServicesController` instance.
     * Initializes the {@link ServiceFacade} singleton.
     */
    public ManageServicesController() {
        this.serviceFacade = ServiceFacade.getServiceFacadeInstance();
    }

    /**
     * Sets the {@link MainController} instance.
     *
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
     * Handles user interactions for managing services.
     * This method will be triggered to display or modify service-related data.
     */
    public void handleCreateService() {

        int id_user_owner = 1;
        String name = "Service 1";
        String example_image = "example.jpg";
        float price = 10.0f;
        String description = "This is a service description.";
        int nb_buyers = 0; // because the service is new

        try {
            serviceFacade.createService(id_user_owner, name, example_image, price, description, nb_buyers);
            showAlert("Service Created", "Service created successfully", "The service has been created successfully.");
        } catch (Exception e) {
            showAlert("Error", "Failed to create service", "An error occurred while creating the service.");
        }
    }

    /**
     * Handles user interactions for deleting services.
     * This method will be triggered when the user wants to delete a service.
     */
    public void handleDeleteService() {

        int id_service = 2;

        try {
            serviceFacade.deleteService(id_service);
            showAlert("Service Deleted", "Service deleted successfully", "The service has been deleted successfully.");
        } catch (Exception e) {
            showAlert("Error", "Failed to delete service", "An error occurred while deleting the service.");
        }
    }

    /**
     * Handles user interactions for updating services.
     * This method will be triggered when the user wants to update a service.
     */
    public void handleUpdateService() {

        int id_service = 1;
        String name = "Service 1";
        String example_image = "example.jpg";
        float price = 12.0f;
        String description = "Updated description for service";

        try {
            serviceFacade.updateService(id_service, name, example_image, price, description);
            showAlert("Service Updated", "Service updated successfully", "The service has been updated successfully.");
        } catch (Exception e) {
            showAlert("Error", "Failed to update service", "An error occurred while updating the service.");
        }
    }

}
