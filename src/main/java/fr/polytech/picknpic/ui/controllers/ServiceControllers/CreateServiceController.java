package fr.polytech.picknpic.ui.controllers.ServiceControllers;

import fr.polytech.picknpic.bl.facades.service.ServiceFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateServiceController {

    /** The facade for service-related operations. */
    private final ServiceFacade serviceFacade;

    @FXML
    private TextField serviceNameField;

    @FXML
    private TextField serviceImageField;

    @FXML
    private TextField servicePriceField;

    @FXML
    private TextArea serviceDescriptionField;

    /**
     * Constructs a new `ManageServicesController` instance.
     * Initializes the {@link ServiceFacade} singleton.
     */
    public CreateServiceController() {
        this.serviceFacade = ServiceFacade.getServiceFacadeInstance();
    }

    @FXML
    public void initialize() {
        // Setup listeners for clearing placeholders when the user interacts with the fields
        setupPlaceholder(serviceNameField, "Enter service name");
        setupPlaceholder(serviceImageField, "Enter image URL");
        setupPlaceholder(servicePriceField, "Enter price");
        setupPlaceholder(serviceDescriptionField, "Enter description");
    }

    /**
     * Sets up a placeholder behavior for a TextField.
     *
     * @param field       The TextField to set up.
     * @param placeholder The placeholder text.
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
     * Sets up a placeholder behavior for a TextArea.
     *
     * @param area        The TextArea to set up.
     * @param placeholder The placeholder text.
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
     * Loads the main scene.
     * This method will be triggered when the user clicks "NO" in the confirm delete dialog.
     */
    @FXML
    public void loadMainScene() throws Exception {
        SceneManager.loadMainScene();
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
     * Handles the creation of a service when the user clicks "CONFIRM".
     */
    public void handleCreateService() {
        try {
            int id_user_owner = LoginFacade.getInstance().getCurrentUser().getId();
            String name = serviceNameField.getText();
            String exampleImage = serviceImageField.getText();
            float price = Float.parseFloat(servicePriceField.getText());
            String description = serviceDescriptionField.getText();

            serviceFacade.createService(id_user_owner, name, exampleImage, price, description, 0);
            showAlert("Service Created", "Service created successfully", "The service has been created successfully.");
            loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Failed to create service", "An error occurred while creating the service.");
        }
    }

}
