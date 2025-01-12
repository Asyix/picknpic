package fr.polytech.picknpic.ui.controllers.PhotoControllers;

import fr.polytech.picknpic.bl.facades.photo.PhotoFacade;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.bl.models.Photo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * Controller for handling the delete photo operation.
 * Responsible for displaying a confirmation dialog and deleting a photo.
 */
public class DeletePhotoController {

    /**
     * The facade for photo-related operations.
     */
    private PhotoFacade photoFacade;

    /**
     * The current photo to be deleted.
     */
    private Photo currentPhoto;

    /**
     * The scene manager for loading different scenes.
     */
    private SceneManager sceneManager;

    /**
     * The confirmation label for the delete operation.
     */
    @FXML
    private Label confirmationLabel;

    /**
     * Constructs the DeletePhotoController and initializes the PhotoFacade instance.
     */
    public DeletePhotoController() {
        this.photoFacade = PhotoFacade.getPhotoFacadeInstance();
    }

    /**
     * Setter method to set the current photo
     * @param photo the photo to be deleted
     */
    public void setPhoto(Photo photo) {
        this.currentPhoto = photo;
        updateConfirmationLabel();
    }

    /**
     * Getter method to get the current photo
     * @return the current photo
     */
    public Photo getPhoto() {
        return currentPhoto;
    }

    /**
     * Updates the confirmation label with the current photo title.
     */
    private void updateConfirmationLabel() {
        if (currentPhoto != null) {
            confirmationLabel.setText("ARE YOU SURE YOU WANT TO DELETE “" + currentPhoto.getTitle() + "”?");
        } else {
            confirmationLabel.setText("No photo selected.");
        }
    }

    /**
     * Navigates back to the main scene.
     */
    @FXML
    public void loadMainScene() {
        sceneManager.loadMainScene();
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
     * Deletes the currently selected photo.
     * Displays a confirmation message on successful deletion.
     */
    @FXML
    public void deletePhoto() {
        try {
            photoFacade.deletePhoto(currentPhoto.getPhotoId());
            showAlert("Photo Deleted", "Success", "The photo has been deleted successfully.");
            sceneManager.loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Deletion Failed", "An error occurred while deleting the photo.");
        }
    }

}
