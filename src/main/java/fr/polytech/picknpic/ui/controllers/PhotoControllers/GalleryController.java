package fr.polytech.picknpic.ui.controllers.PhotoControllers;

import fr.polytech.picknpic.bl.facades.photo.PhotoFacade;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;

/**
 * Controller for handling gallery-related operations in the UI.
 * Provides methods for displaying and publishing photos.
 */
public class GalleryController {

    private PhotoFacade photoFacade;
    private String currentUserId;
    private SceneManager sceneManager;

    /**
     * Initializes the GalleryController with the PhotoFacade instance.
     */
    public GalleryController() {
        this.photoFacade = PhotoFacade.getPhotoFacadeInstance();
    }

    /**
     * Handles the action of clicking on a photo in the gallery.
     */
    @FXML
    public void handlePhotoClick() {
        // Add logic for displaying photo details.
    }

    /**
     * Handles the action of publishing a new photo.
     */
    @FXML
    public void handlePublishPhoto() {
        // Add logic for opening the photo upload form.
    }

    /**
     * Sets the current user ID for the gallery context.
     *
     * @param userId The ID of the user currently interacting with the gallery.
     */
    public void setCurrentUserId(String userId) {
        this.currentUserId = userId;
    }
}
