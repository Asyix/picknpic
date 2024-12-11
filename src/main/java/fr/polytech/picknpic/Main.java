package fr.polytech.picknpic;

import fr.polytech.picknpic.ui.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The entry point of the Pick'n'Pic application.
 * Initializes the application and sets up the primary stage with the initial scene.
 */
public class Main extends Application {

    /**
     * Starts the JavaFX application.
     * Sets up the {@link SceneManager}, loads the initial FXML scene,
     * and displays it on the primary stage.
     *
     * @param primaryStage The primary stage for the application.
     * @throws Exception If an error occurs during scene loading.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize the SceneManager with the primary stage
        SceneManager sceneManager = new SceneManager(primaryStage);

        // Load the initial FXML scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/hello.fxml"));
        Scene scene = new Scene(loader.load());

        // Retrieve the controller and pass the SceneManager
        MainController controller = loader.getController();
        controller.setSceneManager(sceneManager);

        // Set up the primary stage
        primaryStage.setTitle("Hello Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main method to launch the application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
