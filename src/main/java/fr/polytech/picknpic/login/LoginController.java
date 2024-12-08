package fr.polytech.picknpic.login;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class LoginController {
    private LoginFacade loginFacade;
    private SceneManager sceneManager;

    public void setLoginFacade(LoginFacade loginFacade) {
        this.loginFacade = loginFacade;
    }

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    /**
     * Handle the login action.
     *
     * @param usernameField The TextField containing the username.
     * @param passwordField The PasswordField containing the password.
     * @param messageLabel  The Label to display messages.
     */
    public void handleLogin(TextField usernameField, PasswordField passwordField, Label messageLabel) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = loginFacade.login(username, password);
        if (user != null) {
            messageLabel.setText("Login successful!");
            messageLabel.setStyle("-fx-text-fill: green;");

            // Load the dashboard scene directly
            Label welcomeLabel = new Label("Welcome to the Dashboard!");
            welcomeLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: green;");

            StackPane dashboardLayout = new StackPane(welcomeLabel);
            dashboardLayout.setStyle("-fx-background-color: #f4f4f4;");
            Scene dashboardScene = new Scene(dashboardLayout, 400, 300);

            sceneManager.loadScene(dashboardScene);
        } else {
            messageLabel.setText("Invalid username or password.");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }
}
