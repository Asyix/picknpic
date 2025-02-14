
package fr.polytech.picknpic.ui.controllers.PhotoControllers;

import fr.polytech.picknpic.bl.facades.photo.PhotoFacade;
import fr.polytech.picknpic.bl.models.Photo;
import javafx.beans.property.SimpleIntegerProperty;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Controller for displaying all photos.
 * Handles user interactions for retrieving and displaying photos in the application.
 */
public class DisplayAllPhotosController {

    /**
     * The facade for photo-related operations.
     */
    private final PhotoFacade photoFacade;

    // Property to store the clicked photo ID
    private final SimpleIntegerProperty clickedPhotoId = new SimpleIntegerProperty();

    @FXML
    private VBox photosContainer;

    public DisplayAllPhotosController() {
        this.photoFacade = PhotoFacade.getPhotoFacadeInstance();
    }

    /**
     * Initializes the controller.
     * Can be used to set default values or placeholders for UI elements.
     */
    @FXML
    public void initialize() {
        handleGetAllPhotos();
    }

    /**
     * Fetches and displays all photos.
     */
    public void handleGetAllPhotos() {
        List<Photo> photos = photoFacade.getAllPhotos();

        photosContainer.getChildren().clear(); // Clear existing children

        for (Photo photo : photos) {
            Pane photoPane = createPhotoPane(photo);
            photosContainer.getChildren().add(photoPane);
        }
    }

    /**
     * Creates a styled pane for a photo.
     *
     * @param photo The photo to display.
     * @return A pane representing the photo.
     */
    private Pane createPhotoPane(Photo photo) {
        Pane pane = new Pane();
        pane.setPrefSize(450, 200);
        pane.setStyle("-fx-background-color: #3E3E3E; -fx-border-color: white; -fx-padding: 10;");

        // Hover effect
        pane.setOnMouseEntered(event -> pane.setStyle("-fx-background-color: #343434; -fx-border-color: white; -fx-padding: 10;"));
        pane.setOnMouseExited(event -> pane.setStyle("-fx-background-color: #3E3E3E; -fx-border-color: white; -fx-padding: 10;"));

        Label titleLabel = new Label("Title: " + photo.getTitle());
        titleLabel.setLayoutX(10);
        titleLabel.setLayoutY(10);
        titleLabel.setStyle("-fx-text-fill: white;");

        Label descriptionLabel = new Label("Description: " + photo.getDescription());
        descriptionLabel.setLayoutX(10);
        descriptionLabel.setLayoutY(30);
        descriptionLabel.setStyle("-fx-text-fill: white;");

        Label priceLabel = new Label("Price: " + photo.getPrice() + " €");
        priceLabel.setLayoutX(10);
        priceLabel.setLayoutY(50);
        priceLabel.setStyle("-fx-text-fill: white;");

        ImageView photoImageView = new ImageView();
        photoImageView.setLayoutX(10);
        photoImageView.setLayoutY(70);
        photoImageView.setFitWidth(150);
        photoImageView.setFitHeight(100);
        photoImageView.setPreserveRatio(true);

        try {
            Image photoImage = new Image(photo.getUrl(), true);
            photoImageView.setImage(photoImage);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid URL for photo: " + photo.getUrl());
        }

        Label likesLabel = new Label("Likes: " + photo.getNbLikes());
        likesLabel.setLayoutX(170);
        likesLabel.setLayoutY(90);
        likesLabel.setStyle("-fx-text-fill: white;");

        // Add click event to the pane
        pane.setOnMouseClicked(event -> handlePhotoClick(photo));

        pane.getChildren().addAll(titleLabel, descriptionLabel, priceLabel, photoImageView, likesLabel);

        return pane;
    }

    /**
     * Handles the action of clicking on a photo pane.
     *
     * @param photo The clicked photo.
     */
    private void handlePhotoClick(Photo photo) {
        clickedPhotoId.set(photo.getPhotoId());
        Photo clickedPhoto = photoFacade.getPhotoById(photo.getPhotoId());
        if (clickedPhoto != null) {
            SceneManager.loadUniquePhotoDetailsScene(photo);
        } else {
            System.err.println("Photo not found for ID: " + photo.getPhotoId());
        }
    }

}
