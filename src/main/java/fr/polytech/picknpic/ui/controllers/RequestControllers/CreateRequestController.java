package fr.polytech.picknpic.ui.controllers.RequestControllers;

import fr.polytech.picknpic.bl.facades.request.RequestFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.bl.models.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller for creating requests.
 * Handles user interactions related to creating a new request in the application.
 */
public class CreateRequestController {

    /** The facade for managing requests. */
    private final RequestFacade requestFacade;

    /** The service that was clicked. */
    private Service currentService;

    @FXML
    private TextField serviceNameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextArea messageField;

    @FXML
    private TextField imageField;

    /**
     * Constructs a new `CreateRequestController` instance.
     * Initializes the {@link RequestFacade} singleton.
     */
    public CreateRequestController() {
        this.requestFacade = RequestFacade.getRequestFacadeInstance();
    }

    /**
     * Sets the service passed from the previous scene.
     *
     * @param service The service that was clicked.
     */
    public void setService(Service service) {
        this.currentService = service;

        // Populate fields with the service details
        if (serviceNameField != null) serviceNameField.setText(service.getName());
        if (priceField != null) priceField.setText(String.format("%.2f", service.getPrice()));
        if (messageField != null) messageField.setText("Enter your message to the seller...");
        if (imageField != null) imageField.setText("Optional image URL...");
    }

    /**
     * Displays an alert dialog with the provided message.
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
     * Handles the creation of a new request.
     */
    @FXML
    public void handleCreateRequest() {
        try {
            int id_user_buyer = LoginFacade.getInstance().getCurrentUser().getId();
            int id_service = currentService.getIdService();
            int id_chat = 1; // Placeholder for chat ID
            String message = messageField.getText();
            String image = imageField.getText();
            String status = "waiting";

            requestFacade.createRequest(id_user_buyer, id_service, id_chat, message, image, status);

            showAlert("Request Created", "Success", "Your request has been successfully created.");
            SceneManager.loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Failed to Create Request", "Reason: " + e.getMessage());
        }
    }

    /**
     * Initializes the placeholders for input fields.
     */
    @FXML
    public void initialize() {
        setupPlaceholder(serviceNameField, "Enter service name...");
        setupPlaceholder(priceField, "Enter price...");
        setupPlaceholder(messageField, "Enter your message to the seller...");
        setupPlaceholder(imageField, "Optional image URL...");
    }

    /**
     * Sets up a placeholder behavior for a TextField.
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
     * Sets up a placeholder behavior for a TextArea.
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
}
