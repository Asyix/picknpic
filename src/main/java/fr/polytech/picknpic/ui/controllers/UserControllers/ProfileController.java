package fr.polytech.picknpic.ui.controllers.UserControllers;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.facades.user.ManageAccountFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class ProfileController {

    @FXML
    private Label emailLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label phoneNumberLabel;

    private User currentUser;

    private SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private void initialize() {
        currentUser = LoginFacade.getInstance().getCurrentUser();
        System.out.println(currentUser.getEmail());
        if (currentUser != null) {
            loadUserData();
        }
        else {
            sceneManager.loadLoginScene();
        }
    }

    private void loadUserData() {
            emailLabel.setText(currentUser.getEmail());
            usernameLabel.setText(currentUser.getUsername());
            firstNameLabel.setText(currentUser.getFirstName());
            lastNameLabel.setText(currentUser.getLastName());
            phoneNumberLabel.setText(String.valueOf(currentUser.getPhoneNumber()));
    }

    @FXML
    private void loadUpdateAccount() {
        sceneManager.loadUpdateAccountScene();
    }

    @FXML
    private void handleDeleteAccount() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Delete Account");
        dialog.setHeaderText("Confirm Deletion");
        dialog.setContentText("Please enter your password:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String password = result.get();
            User currentUser = LoginFacade.getInstance().getCurrentUser();
            if (currentUser != null) {
                boolean success = ManageAccountFacade.getInstance().deleteAccount(currentUser.getId(), password);
                if (success) {
                    LoginFacade.getInstance().setCurrentUser(null);
                    sceneManager.loadLoginScene();
                } else {
                    showAlert("Error", "Account deletion failed.");
                }
            } else {
                showAlert("Error", "Incorrect password.");
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}