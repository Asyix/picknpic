package fr.polytech.picknpic.ui.controllers;

import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;

public class MainLayoutController {

    @FXML
    private StackPane contentPane;

    @FXML
    private StackPane navbarPane;

    /**
     * Initializes the main layout view.
     * Loads the navbar into the navbarPane.
     */
    @FXML
    public void initialize() {
        try {
            // Load navbar.fxml and set it into the navbarPane
            FXMLLoader navbarLoader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/navbar.fxml"));
            Parent navbar = navbarLoader.load();
            navbarPane.getChildren().add(navbar); // Add the navbar to the top pane
        } catch (Exception e) {
            throw new RuntimeException("Failed to load NavbarController", e);
        }
    }

    /**
     * Sets the content of the main layout.
     * @param content The content to set.
     */
    public void setContent(Parent content) {
        contentPane.getChildren().clear();
        contentPane.getChildren().add(content);
    }
}
