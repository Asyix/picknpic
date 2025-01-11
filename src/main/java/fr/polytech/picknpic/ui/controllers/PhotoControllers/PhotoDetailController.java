package fr.polytech.picknpic.ui.controllers.PhotoControllers;

import fr.polytech.picknpic.bl.facades.photo.PhotoFacade;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

/**
 * Controller for handling photo detail operations in the UI.
 * Provides methods for deleting, updating, purchasing, and downloading photos.
 */
public class PhotoDetailController {

    private PhotoFacade photoFacade;
    private String currentPhotoId;
    private SceneManager sceneManager;

    /**
     * Initializes the PhotoDetailController with the PhotoFacade instance.
     */
    public PhotoDetailController() {
        this.photoFacade = PhotoFacade.getPhotoFacadeInstance();
    }

    /**
     * Loads the main scene.
     * This method will be triggered when the user clicks "NO" in the confirm delete dialog.
     */
    @FXML
    public void loadMainScene() throws Exception {
        sceneManager.loadMainScene();
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
     * Handles the action of deleting the current photo.
     */
    @FXML
    public void deletePhoto() {
        int photoId = 1; // For now, hardcoded
        try {
            photoFacade.deletePhoto(photoId);
            showAlert("Photo Deleted", "Photo successfully deleted", "The photo has been deleted successfully.");
            sceneManager.loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Failed to delete grade", "An error occurred while deleting the grade.");
        }
    }

    /**
     * Handles the action of updating the current photo.
     */
    @FXML
    public void handlePhotoUpdate() {
        int photoId = 1;
        String title = "New Title";
        String description = "New Description";
        int price = 10;
        String filePath = "new_file.jpg";
        try {
            photoFacade.updatePhoto(photoId, title, description, price, filePath);
            showAlert("Photo Updated", "Photo successfully updated", "The photo has been updated successfully.");
            sceneManager.loadMainScene();
        } catch (Exception e) {
            showAlert("Error", "Failed to delete grade", "An error occurred while deleting the grade.");
        }
    }

    /**
     * Handles the action of purchasing the current photo.
     */
    @FXML
    public void buyPhoto() {
        // Add logic for purchasing the photo.
    }

    /**
     * Handles the action of downloading the current photo.
     */
    @FXML
    public void handlePhotoDownload() {
        // Add logic for downloading the photo.
    }

    /**
     * Sets the current photo ID to operate on.
     *
     * @param photoId The ID of the photo to be managed.
     */
    public void setCurrentPhotoId(String photoId) {
        this.currentPhotoId = photoId;
    }
}
