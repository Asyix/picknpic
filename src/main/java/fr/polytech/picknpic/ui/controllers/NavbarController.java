package fr.polytech.picknpic.ui.controllers;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class NavbarController {

    @FXML
    private HBox navbar;

    /**
     * Initializes the navbar view.
     * Adds the Users and Reports buttons to the navbar if the current user is an admin.
     */
    @FXML
    private void initialize() {
        User currentUser = LoginFacade.getInstance().getCurrentUser();
        System.out.println(currentUser.isAdmin());
        if (currentUser != null && currentUser.isAdmin()) {
            Button usersButton = new Button("Users");
            usersButton.setOnAction(event -> SceneManager.loadManageUsersScene());
            navbar.getChildren().add(4, usersButton); // Add after Chat button

            Button reportsButton = new Button("Reports");
            reportsButton.setOnAction(event -> SceneManager.loadReportsScene());
            navbar.getChildren().add(5, reportsButton); // Add after Users button
        }
    }
    /**
     * Loads the home scene.
     */
    @FXML
    private void loadHome() {
        SceneManager.loadMainScene();
    }

    @FXML
    private void loadPosts() {
        SceneManager.loadPostsScene();
    }

    @FXML
    private void loadNotifications() {
        SceneManager.loadNotificationsScene();
    }

    @FXML
    private void loadChat() {
        SceneManager.loadChatScene();
    }

    @FXML
    private void loadProfile() {
        SceneManager.loadProfileScene(LoginFacade.getInstance().getCurrentUser());
    }

    /**
     * Logs out the current user and navigates to the login scene.
     */
    @FXML
    private void handleLogout() {
        LoginFacade.getInstance().setCurrentUser(null);
        SceneManager.loadLoginScene();
    }
}