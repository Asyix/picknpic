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

    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private void initialize() {
        User currentUser = LoginFacade.getInstance().getCurrentUser();
        System.out.println(currentUser.isAdmin());
        if (currentUser != null && currentUser.isAdmin()) {
            Button usersButton = new Button("Users");
            usersButton.setOnAction(event -> sceneManager.loadManageUsersScene());
            navbar.getChildren().add(4, usersButton); // Add after Chat button

            Button reportsButton = new Button("Reports");
            reportsButton.setOnAction(event -> sceneManager.loadReportsScene());
            navbar.getChildren().add(5, reportsButton); // Add after Users button
        }
    }

    @FXML
    private void loadHome() {
        sceneManager.loadMainScene();
    }

    @FXML
    private void loadPosts() {
        sceneManager.loadPostsScene();
    }

    @FXML
    private void loadNotifications() {
        sceneManager.loadNotificationsScene();
    }

    @FXML
    private void loadChat() {
        sceneManager.loadChatScene();
    }

    @FXML
    private void loadProfile() {
        sceneManager.loadProfileScene();
    }

    @FXML
    private void handleLogout() {
        LoginFacade.getInstance().setCurrentUser(null);
        sceneManager.loadLoginScene();
    }
}