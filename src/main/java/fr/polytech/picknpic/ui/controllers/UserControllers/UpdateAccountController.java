package fr.polytech.picknpic.ui.controllers.UserControllers;

import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.facades.user.ManageAccountFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class UpdateAccountController {

    @FXML
    private TextField emailField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;

    /**
     * Initializes the update account view.
     * Loads the current user's data into the form fields.
     */
    private void loadUserData() {
        User currentUser = LoginFacade.getInstance().getCurrentUser();
        if (currentUser != null) {
            emailField.setText(currentUser.getEmail());
            usernameField.setText(currentUser.getUsername());
            firstNameField.setText(currentUser.getFirstName());
            lastNameField.setText(currentUser.getLastName());
            phoneNumberField.setText(String.valueOf(currentUser.getPhoneNumber()));
        }
    }

    /**
     * Initializes the update account view.
     * Loads the current user's data into the form fields.
     */
    @FXML
    private void handleUpdateAccount() {
        User currentUser = LoginFacade.getInstance().getCurrentUser();
        if (currentUser != null) {
            String email = emailField.getText();
            String username = usernameField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String phoneNumber = phoneNumberField.getText();

            try {
                int phone = Integer.parseInt(phoneNumber);
                User updatedUser = new User(currentUser.getId(), email, currentUser.getPassword(), username, firstName, lastName, phone, currentUser.isAdmin());
                boolean success = ManageAccountFacade.getInstance().updateAccount(updatedUser);
                if (success) {
                    LoginFacade.getInstance().setCurrentUser(updatedUser);
                    showAlert("Success", "Profile updated successfully.");
                    SceneManager.loadProfileScene(LoginFacade.getInstance().getCurrentUser());
                } else {
                    showAlert("Error", "Profile update failed.");
                }
            } catch (NumberFormatException e) {
                showAlert("Error", "Invalid phone number.");
            }
        }
    }

    /**
     * Initializes the update account view.
     * Loads the current user's data into the form fields.
     */
    @FXML
    private void loadProfile() {
        SceneManager.loadProfileScene(LoginFacade.getInstance().getCurrentUser());
    }

    /**
     * Initializes the update account view.
     * Loads the current user's data into the form fields.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}