package fr.polytech.picknpic.ui.controllers.RequestControllers;

import fr.polytech.picknpic.bl.facades.request.RequestFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.bl.models.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

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
    private Label serviceNameLabel;

    @FXML
    private Label priceLabel;

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

        // Debugging: Ensure service data is correct
        System.out.println("Service ID: " + currentService.getIdService() +
                ", Service name: " + currentService.getName() +
                ", Service price: " + currentService.getPrice());

        // Set the labels to display the service name and price
        if (serviceNameLabel != null) {
            serviceNameLabel.setText(service.getName());
        } else {
            System.out.println("serviceNameLabel is null");
        }

        if (priceLabel != null) {
            priceLabel.setText(String.format("%.2f", service.getPrice()));
        } else {
            System.out.println("priceLabel is null");
        }
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
