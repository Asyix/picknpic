package fr.polytech.picknpic;

import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Button loginButton;

    @FXML
    private Label welcomeLabel;

    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private void handleLogin() {
        Stage loginStage = new Stage();
        boolean success = sceneManager.loadLoginScene(loginStage);

        if (success && sceneManager.getCurrentUser() != null) {
            welcomeLabel.setText("Hello " + sceneManager.getCurrentUser().getUsername() + "!");
        }
    }
}
