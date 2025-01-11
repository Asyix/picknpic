package fr.polytech.picknpic.ui.controllers.PhotoControllers;

import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.ui.controllers.PurchaseControllers.PurchaseController;
import fr.polytech.picknpic.ui.controllers.PhotoControllers.DisplayAllPhotosController;
import fr.polytech.picknpic.bl.models.User;
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

    private String photoUrl;

    private int currentPhotoId;

    private PurchaseController purchaseController;

    private DisplayAllPhotosController displayAllPhotosController;

    /**
     * Sets the URL of the photo to display and updates the UI.
     *
     * @param url The URL of the photo.
     */
    public void setPhotoUrl(String url) {
        this.photoUrl = url;
        displayPhoto();
    }

    public void setPhotoId(int photoId) {
        this.currentPhotoId = photoId;
        System.out.println("Photo ID set in DisplayUniquePhotoController: " + currentPhotoId);
    }

    public int getPhotoId() {
        return currentPhotoId;
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
            Image photoImage = new Image(photoUrl, true);
            photoImageView.setImage(photoImage);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid URL for photo: " + photoUrl);
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
        sceneManager.loadPurchasePhotoScene(currentPhotoId);
    }

    // use SceneManager loadDeletePhotoScene to navigate
    public void navigateToDeletePhotoScene() {
        sceneManager.loadDeletePhotoScene();
    }

    // use SceneManager loadUpdatePhotoScene to navigate
    public void navigateToUpdatePhotoScene() {
        sceneManager.loadUpdatePhotoDetailsScene();
    }

    public void navigateToUniquePhotoDetailsScene() {
        sceneManager.loadUniquePhotoDetailsScene(photoUrl, currentPhotoId);
    }

}
