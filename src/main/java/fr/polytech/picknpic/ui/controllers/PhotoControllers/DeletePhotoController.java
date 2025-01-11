package fr.polytech.picknpic.ui.controllers.PhotoControllers;

import fr.polytech.picknpic.bl.facades.photo.PhotoFacade;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * Controller for handling the delete photo operation.
 * Responsible for displaying a confirmation dialog and deleting a photo.
 */
public class DeletePhotoController {

    private PhotoFacade photoFacade;
    private int currentPhotoId;
    private SceneManager sceneManager;

    /**
     * Constructs the DeletePhotoController and initializes the PhotoFacade instance.
     */
    public DeletePhotoController() {
        this.photoFacade = PhotoFacade.getPhotoFacadeInstance();
    }

    /**
     * Deletes the currently selected photo.
     * Displays a confirmation message on successful deletion.
     */
    @FXML
    public void deletePhoto() {
        try {
            photoFacade.deletePhoto(currentPhotoId);
            showAlert("Photo Deleted", "Success", "The photo has been deleted successfully.");
            sceneManager.loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Deletion Failed", "An error occurred while deleting the photo.");
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
     * Sets the ID of the photo to be deleted.
     *
     * @param photoId The ID of the photo to delete.
     */
    public void setCurrentPhotoId(int photoId) {
        this.currentPhotoId = photoId;
    }
}
