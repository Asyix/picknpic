package fr.polytech.picknpic.login;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    private final Stage primaryStage;

    public SceneManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Loads a new scene.
     *
     * @param scene The new scene to display.
     */
    public void loadScene(Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
