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

    @FXML
    private Pane imagePane;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button buyButton;

    private SceneManager sceneManager;

    /**
     * The current photo that was clicked from DisplayAllPhotosController.
     * This will be passed to either UpdatePhotoController, DeletePhotoController, or PurchaseController.
     */
    private Photo currentPhoto;

    private PurchaseController purchaseController;

    private DisplayAllPhotosController displayAllPhotosController;

    /**
     * Setter for the clicked photo
     */
    public void setPhoto(Photo photo) {
        this.currentPhoto = photo;
        displayPhoto();
    }

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

    // use SceneManager loadDeletePhotoScene to navigate
    public void navigateToDeletePhotoScene() {
        sceneManager.loadDeletePhotoScene(currentPhoto);
    }

    // use SceneManager loadUpdatePhotoScene to navigate
    public void navigateToUpdatePhotoScene() {
        sceneManager.loadUpdatePhotoDetailsScene(currentPhoto);
    }

    public void navigateToUniquePhotoDetailsScene() {
        sceneManager.loadUniquePhotoDetailsScene(currentPhoto);
    }

}
