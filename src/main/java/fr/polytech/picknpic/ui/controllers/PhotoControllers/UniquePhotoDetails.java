package fr.polytech.picknpic.ui.controllers.PhotoControllers;

import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Controller for displaying details of a unique photo.
 */
public class UniquePhotoDetails {

    @FXML
    private Pane imagePane;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    private SceneManager sceneManager;

    private String photoUrl;

    /**
     * Sets the URL of the photo to display and updates the UI.
     *
     * @param url The URL of the photo.
     */
    public void setPhotoUrl(String url) {
        this.photoUrl = url;
        displayPhoto();
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
        // Additional initialization if needed
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
        sceneManager.loadUniquePhotoDetailsScene(photoUrl);
    }

}
