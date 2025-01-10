package fr.polytech.picknpic;

import fr.polytech.picknpic.ui.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The entry point of the Pick'n'Pic application.
 * Initializes the application and sets up the primary stage with the initial scene.
 */
public class Main extends Application {
    /**
     * Starts the JavaFX application.
     * Initializes the {@link SceneManager} and loads the initial scene.
     *
     * @param primaryStage The primary stage for the application.
     * @throws Exception If an error occurs during the initialization of the scene.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneManager sceneManager = new SceneManager(primaryStage);
        sceneManager.loadInitialScene();
    }

    /**
     * The main method  to launch the application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
