package fr.polytech.picknpic;

import fr.polytech.picknpic.ui.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Passer UserPostgres à SceneManager
        SceneManager sceneManager = new SceneManager(primaryStage);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/hello.fxml"));
        Scene scene = new Scene(loader.load());

        MainController controller = loader.getController();
        controller.setSceneManager(sceneManager);

        primaryStage.setTitle("Hello Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
