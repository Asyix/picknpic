package fr.polytech.picknpic.ui.controllers.PhotoControllers;

import fr.polytech.picknpic.bl.facades.photo.PhotoFacade;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.bl.models.Photo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller for handling the update photo operation.
 * Responsible for updating photo details, including name, price, and description.
 */
public class UpdatePhotoController {

    private PhotoFacade photoFacade;
    private int currentPhotoId;

    private Photo photo;
    private SceneManager sceneManager;

    @FXML
    private TextField photoNameField;

    @FXML
    private TextField photoPriceField;

    @FXML
    private TextArea photoDescriptionField;

    /**
     * Constructs the UpdatePhotoController and initializes the PhotoFacade instance.
     */
    public UpdatePhotoController() {
        this.photoFacade = PhotoFacade.getPhotoFacadeInstance();
    }

    /**
     * Initializes the controller.
     * Can be used to set default values or placeholders for UI elements.
     */
    @FXML
    public void initialize() {
        //setupPlaceholder(photoNameTextField, "Current photo name");
        //setupPlaceholder(descriptionTextArea, "Current description");
        //setupPlaceholder(photoPriceTextField, "Current price");
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

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Photo getPhoto() {
        return photo;
    }

    /**
     * Handles the action of updating the current photo.
     * Reads user inputs and updates the photo using the PhotoFacade.
     */
    @FXML
    public void handlePhotoUpdate() {
        try {
            String title = photoNameField.getText();
            String description = photoDescriptionField.getText();
            int price = Integer.parseInt(photoPriceField.getText());

            photoFacade.updatePhoto(currentPhotoId, title, description, price, null); // File path as null for now
            showAlert("Photo Updated", "Success", "The photo has been updated successfully.");
            sceneManager.loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Update Failed", "An error occurred while updating the photo.");
        }
    }

    /**
     * Displays an alert dialog with the specified details.
     *
     * @param title   The title of the alert dialog.
     * @param header  The header text of the alert dialog.
     * @param message The message content of the alert dialog.
     */
    private void showAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Sets the ID of the photo to be updated.
     *
     * @param photoId The ID of the photo to update.
     */
    public void setCurrentPhotoId(int photoId) {
        this.currentPhotoId = photoId;
    }
}
