
package fr.polytech.picknpic.ui.controllers.PhotoControllers;

import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.ui.controllers.PurchaseControllers.PurchaseController;
import fr.polytech.picknpic.ui.controllers.PhotoControllers.DisplayAllPhotosController;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.bl.models.Photo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Alert;

/**
 * Controller for displaying details of a unique photo.
 */
public class DisplayUniquePhotoController {

    /**
     * The container for displaying the photo.
     */
    @FXML
    private Pane imagePane;

    /**
     * The buttons for performing actions on the photo.
     */
    @FXML
    private Button deleteButton;

    /**
     * The buttons for performing actions on the photo.
     */
    @FXML
    private Button updateButton;

    /**
     * The buttons for performing actions on the photo.
     */
    @FXML
    private Button buyButton;

    /**
     * The scene manager for loading different scenes.
     */
    private SceneManager sceneManager;

    /**
     * The current photo that was clicked from DisplayAllPhotosController.
     * This will be passed to either UpdatePhotoController, DeletePhotoController, or PurchaseController.
     */
    private Photo currentPhoto;

    /**
     * Setter for the clicked photo
     */
    public void setPhoto(Photo photo) {
        this.currentPhoto = photo;
        displayPhoto();
    }

    /**
     * Getter for the clicked photo
     */
    public Photo getPhoto() {
        return currentPhoto;
    }

    /**
     * Displays the photo in the pane.
     */
    private void displayPhoto() {
        ImageView photoImageView = new ImageView();
        photoImageView.setFitWidth(imagePane.getPrefWidth());
        photoImageView.setFitHeight(imagePane.getPrefHeight());
        photoImageView.setPreserveRatio(true);

        try {
            Image photoImage = new Image(currentPhoto.getUrl(), true); // directly use getUrl instead of photoUrl
            photoImageView.setImage(photoImage);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid URL for photo: " + currentPhoto.getUrl());
        }

        imagePane.getChildren().clear();
        imagePane.getChildren().add(photoImageView);
    }

    /**
     * Initializes the controller.
     * Can be used to set default values or placeholders for UI elements.
     */
    @FXML
    public void initialize() {
        handleRoleBasedRendering();
    }

    /**
     * Handles conditional rendering based on the current user's role.
     */
    private void handleRoleBasedRendering() {
        User currentUser = LoginFacade.getInstance().getCurrentUser();
        if (currentUser == null) {
            System.err.println("User not logged in");
            return;
        }

        if (currentUser.isAdmin()) {
            // Admin: Show delete and update buttons, hide buy button
            deleteButton.setVisible(true);
            updateButton.setVisible(true);
            if (buyButton != null) {
                buyButton.setVisible(false);
            }
        } else {
            // Regular user: Show buy button, hide delete and update buttons
            deleteButton.setVisible(false);
            updateButton.setVisible(false);
            if (buyButton != null) {
                buyButton.setVisible(true);
            }
        }
    }

    /**
     * Handles the action of buying the displayed photo.
     */
    public void navigateToBuyPhoto() {
        sceneManager.loadPurchasePhotoScene(currentPhoto);
    }

    /**
     * Handles the action of deleting the displayed photo.
     */
    public void navigateToDeletePhotoScene() {
        sceneManager.loadDeletePhotoScene(currentPhoto);
    }

    /**
     * Handles the action of updating the displayed photo.
     */
    public void navigateToUpdatePhotoScene() {
        sceneManager.loadUpdatePhotoDetailsScene(currentPhoto);
    }

    /**
     * Handles the action of navigating to the unique photo details scene.
     */
    public void navigateToUniquePhotoDetailsScene() {
        sceneManager.loadUniquePhotoDetailsScene(currentPhoto);
    }

}
