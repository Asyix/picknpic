package fr.polytech.picknpic.ui.controllers;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;

public class NavbarController {

    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
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