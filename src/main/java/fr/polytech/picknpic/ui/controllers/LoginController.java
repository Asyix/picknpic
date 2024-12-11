package fr.polytech.picknpic.ui.controllers;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    private LoginFacade loginFacade;
    private SceneManager sceneManager;

    public void setLoginFacade(LoginFacade loginFacade) {
        this.loginFacade = loginFacade;
    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = loginFacade.login(username, password);

        if (user != null) {
            sceneManager.setCurrentUser(user);
            ((Stage) usernameField.getScene().getWindow()).close();
        } else {
            messageLabel.setText("Invalid username or password.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
