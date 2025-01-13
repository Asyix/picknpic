package fr.polytech.picknpic.ui.controllers.ServiceControllers;

import fr.polytech.picknpic.bl.facades.service.ServiceFacade;
import fr.polytech.picknpic.bl.models.Service;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller for handling the update of a service in the application.
 * Provides functionality to update the service details such as name, image, price, and description.
 */
public class UpdateServiceController {

    /** The facade for service-related operations. */
    private final ServiceFacade serviceFacade;

    /** The service that was clicked. */
    private Service currentService;

    @FXML
    private TextField serviceNameField;

    @FXML
    private TextField serviceImageField;

    @FXML
    private TextField servicePriceField;

    @FXML
    private TextArea serviceDescriptionField;

    /**
     * Constructs a new `UpdateServiceController` instance.
     * Initializes the {@link ServiceFacade} singleton.
     */
    public UpdateServiceController() {
        this.serviceFacade = ServiceFacade.getServiceFacadeInstance();
    }

    /**
     * Sets the service to be updated and populates the fields with its current details.
     *
     * @param service The service to be updated.
     */
    public void setService(Service service) {
        this.currentService = service;

        // Populate fields with the current service details
        if (currentService != null) {
            serviceNameField.setText(currentService.getName());
            serviceImageField.setText(currentService.getExampleImage());
            servicePriceField.setText(String.valueOf(currentService.getPrice()));
            serviceDescriptionField.setText(currentService.getDescription());
        }
    }

    /**
     * Initializes the controller.
     * Ensures the placeholder behavior is correctly set up.
     */
    @FXML
    public void initialize() {
        setupPlaceholder(serviceNameField, "Enter updated service name");
        setupPlaceholder(serviceImageField, "Enter updated image URL");
        setupPlaceholder(servicePriceField, "Enter updated price");
        setupPlaceholder(serviceDescriptionField, "Enter updated description");
    }

    /**
     * Sets up placeholder behavior for a TextField.
     *
     * @param field       The TextField to set up.
     * @param placeholder The placeholder text to display when the field is empty and not focused.
     */
    private void setupPlaceholder(TextField field, String placeholder) {
        field.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue && field.getText().equals(placeholder)) {
                field.clear();
            } else if (!newValue && field.getText().isEmpty()) {
                field.setText(placeholder);
            }
        });
    }

    /**
     * Sets up placeholder behavior for a TextArea.
     *
     * @param area        The TextArea to set up.
     * @param placeholder The placeholder text to display when the area is empty and not focused.
     */
    private void setupPlaceholder(TextArea area, String placeholder) {
        area.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue && area.getText().equals(placeholder)) {
                area.clear();
            } else if (!newValue && area.getText().isEmpty()) {
                area.setText(placeholder);
            }
        });
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
     * Handles the update of a service when the user clicks the "CONFIRM" button.
     * Collects input data and invokes the update service method from the facade.
     */
    @FXML
    public void handleUpdateService() {
        try {
            int idService = currentService.getIdService();
            String name = serviceNameField.getText();
            String imageUrl = serviceImageField.getText();
            float price = Float.parseFloat(servicePriceField.getText());
            String description = serviceDescriptionField.getText();

            serviceFacade.updateService(idService, name, imageUrl, price, description);
            showAlert("Service Updated", "Update Successful", "The service has been successfully updated.");
            loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Update Failed", "An error occurred while updating the service: " + e.getMessage());
        }
    }
}
