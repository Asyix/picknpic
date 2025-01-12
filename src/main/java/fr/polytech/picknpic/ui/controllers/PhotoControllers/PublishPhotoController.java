package fr.polytech.picknpic.ui.controllers.PhotoControllers;

import fr.polytech.picknpic.bl.facades.photo.PhotoFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller for handling gallery-related operations in the UI.
 * Provides methods for displaying and publishing photos.
 */
public class PublishPhotoController {

    /**
     * The facade for photo-related operations.
     */
    private final PhotoFacade photoFacade;

    /**
     * The scene manager for loading different scenes.
     */
    private SceneManager sceneManager;

    /**
     * The text field for entering the photo name.
     */
    @FXML
    private TextField photoNameTextField;

    /**
     * The text field for entering the price of the photo.
     */
    @FXML
    private TextField priceTextField;

    /**
     * The text field for entering the photo URL.
     */
    @FXML
    private TextField photoUrlTextField;

    /**
     * The text area for entering the photo description.
     */
    @FXML
    private TextArea descriptionTextArea;

    /**
     * The check box for setting the photo as for sale.
     */
    @FXML
    private CheckBox isForSaleCheckBox;

    /**
     * The check box for setting the photo as for subscribers only.
     */
    @FXML
    private CheckBox isForSubscribersOnlyCheckBox;

    /**
     * Initializes the GalleryController with the PhotoFacade instance.
     */
    public PublishPhotoController() {
        this.photoFacade = PhotoFacade.getPhotoFacadeInstance();
    }

    /**
     * Initializes the controller.
     * Can be used to set default values or placeholders for UI elements.
     */
    @FXML
    public void initialize() {
        // Set up placeholders for the input fields
        setupPlaceholder(photoNameTextField, "Enter Photo Name");
        setupPlaceholder(descriptionTextArea, "Enter Description");
        setupPlaceholder(photoUrlTextField, "Enter Photo URL");
    }

    /**
     * Displays an alert with the given title, header, and message.
     *
     * @param title   The title of the alert.
     * @param header  The header text of the alert.
     * @param message The message text of the alert.
     */
    private void showAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Sets up a placeholder for the given text field.
     *
     * @param field       The text field to set up the placeholder for.
     * @param placeholder The placeholder text.
     */
    private void setupPlaceholder(TextField field, String placeholder) {
        field.setText(placeholder);
        field.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue && field.getText().equals(placeholder)) {
                field.clear();
            } else if (!newValue && field.getText().isEmpty()) {
                field.setText(placeholder);
            }
        });
    }

    /**
     * Sets up a placeholder for the given text area.
     *
     * @param area        The text area to set up the placeholder for.
     * @param placeholder The placeholder text.
     */
    private void setupPlaceholder(TextArea area, String placeholder) {
        area.setText(placeholder);
        area.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue && area.getText().equals(placeholder)) {
                area.clear();
            } else if (!newValue && area.getText().isEmpty()) {
                area.setText(placeholder);
            }
        });
    }

    /**
     * Handles the action of publishing a new photo.
     */
    @FXML
    public void handlePublishPhoto() {
        String photoName = photoNameTextField.getText();
        String description = descriptionTextArea.getText();
        String priceText = priceTextField.getText();
        String photoUrl = photoUrlTextField.getText();
        boolean isForSale = isForSaleCheckBox.isSelected();
        boolean isForSubscribersOnly = isForSubscribersOnlyCheckBox.isSelected();

        int currentUserId = LoginFacade.getInstance().getCurrentUser().getId();

        try {
            int price = priceText.isEmpty() ? 0 : Integer.parseInt(priceText); // Default to 0 if empty
            photoFacade.publishPhoto(photoName, description, price, photoUrl, currentUserId, isForSale, isForSubscribersOnly, 0);
            showAlert("Photo Published", "Photo successfully published", "The photo has been published successfully.");
            sceneManager.loadMainScene();
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format.");
        } catch (Exception e) {
            System.out.println("Error while publishing photo: " + e.getMessage());
        }
    }
}
