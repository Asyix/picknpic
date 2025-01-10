package fr.polytech.picknpic.ui.controllers.UserControllers;

import fr.polytech.picknpic.bl.facades.user.UserFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.ui.controllers.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneNumberField;

    private final UserFacade userFacade = UserFacade.getInstance();

    @FXML
    private void handleRegister() {
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();

        if (email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ||
                firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlert("Error", "Passwords do not match.");
            return;
        }

        try {
            int phone = Integer.parseInt(phoneNumber);
            User user = userFacade.register(email, password, username, firstName, lastName, phone);
            if (user != null) {
                showAlert("Success", "Registration successful.");
                SceneManager.loadLoginScene();
            } else {
                showAlert("Error", "Registration failed.");
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid phone number.");
        }
    }

    @FXML
    private void loadLogin() {
        SceneManager.loadLoginScene();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
