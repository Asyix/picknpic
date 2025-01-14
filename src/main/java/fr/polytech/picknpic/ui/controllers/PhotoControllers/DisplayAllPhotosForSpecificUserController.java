package fr.polytech.picknpic.ui.controllers.PhotoControllers;

import fr.polytech.picknpic.bl.facades.photo.PhotoFacade;
import fr.polytech.picknpic.bl.models.Photo;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Controller for displaying all photos for a specific user.
 */
public class DisplayAllPhotosForSpecificUserController {

    private final PhotoFacade photoFacade;

    @FXML
    private VBox photosContainer;

    private int userId;

    public DisplayAllPhotosForSpecificUserController() {
        this.photoFacade = PhotoFacade.getPhotoFacadeInstance();
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void displayAllPhotosForUser() {
        List<Photo> photos = photoFacade.getAllPhotosByUserId(userId);

        photosContainer.getChildren().clear();

        for (Photo photo : photos) {
            Pane photoPane = createPhotoPane(photo);
            photosContainer.getChildren().add(photoPane);
        }
    }

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

    private void handlePhotoClick(Photo photo) {
        SceneManager.loadUniquePhotoDetailsScene(photo);
    }
}
