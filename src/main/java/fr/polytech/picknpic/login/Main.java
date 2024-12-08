package fr.polytech.picknpic.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create SceneManager
        SceneManager sceneManager = new SceneManager(primaryStage);

        // Create DAO and Facade
        AbstractUserFactory factory = AbstractUserFactory.getInstance();
        UserDAO userDAO = factory.createUserDAO();
        LoginFacade loginFacade = new LoginFacade(userDAO);

        // Create UI components
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        // Set up layout
        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.add(messageLabel, 1, 3);

        // Set up controller
        LoginController loginController = new LoginController();
        loginController.setLoginFacade(loginFacade);
        loginController.setSceneManager(sceneManager);

        // Button action
        loginButton.setOnAction(e -> loginController.handleLogin(usernameField, passwordField, messageLabel));

        // Show scene
        Scene loginScene = new Scene(grid, 400, 300);
        primaryStage.setTitle("Login Application");
        sceneManager.loadScene(loginScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
