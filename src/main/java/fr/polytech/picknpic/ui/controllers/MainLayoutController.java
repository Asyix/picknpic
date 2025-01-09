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

    private SceneManager sceneManager;

    private NavbarController navbarController;

    /**
     * Sets the SceneManager for this layout and passes it to the NavbarController.
     *
     * @param sceneManager The SceneManager instance.
     */
    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;

        // Pass the SceneManager to the NavbarController if it's already initialized
        if (navbarController != null) {
            navbarController.setSceneManager(sceneManager);
        }
    }

    @FXML
    public void initialize() {
        try {
            // Load navbar.fxml and set it into the navbarPane
            FXMLLoader navbarLoader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/navbar.fxml"));
            Parent navbar = navbarLoader.load();
            navbarController = navbarLoader.getController(); // Get the NavbarController
            navbarPane.getChildren().add(navbar); // Add the navbar to the top pane

            // Pass the SceneManager to the NavbarController if it's already set
            if (sceneManager != null) {
                navbarController.setSceneManager(sceneManager);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load NavbarController", e);
        }
    }

    public void setContent(Parent content) {
        contentPane.getChildren().clear();
        contentPane.getChildren().add(content);
    }
}
