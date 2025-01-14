package fr.polytech.picknpic.ui.controllers.UserControllers;

import fr.polytech.picknpic.bl.facades.user.UserFacade;
import fr.polytech.picknpic.bl.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UpdateUserController {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private CheckBox adminCheckBox;

    private final UserFacade userFacade = UserFacade.getInstance();
    private Stage dialogStage;
    private User user;

    /**
     * Sets the dialog stage for this controller.
     *
     * @param dialogStage The dialog stage.
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the user to be updated.
     *
     * @param user The user to be updated.
     */
    public void setUser(User user) {
        this.user = user;
        emailField.setText(user.getEmail());
        passwordField.setText(user.getPassword());
        usernameField.setText(user.getUsername());
        firstNameField.setText(user.getFirstName());
        lastNameField.setText(user.getLastName());
        phoneNumberField.setText(String.valueOf(user.getPhoneNumber()));
        adminCheckBox.setSelected(user.isAdmin());
    }

    /**
     * Handles the update user button action.
     */
    @FXML
    private void handleUpdateUser() {
        user.setEmail(emailField.getText());
        user.setPassword(passwordField.getText());
        user.setUsername(usernameField.getText());
        user.setFirstName(firstNameField.getText());
        user.setLastName(lastNameField.getText());
        user.setPhoneNumber(Integer.parseInt(phoneNumberField.getText()));
        user.setAdmin(adminCheckBox.isSelected());

        if (userFacade.updateUser(user)) {
            dialogStage.close();
        } else {
            showAlert("Error", "User update failed", "Please check the input fields.");
        }
    }

    /**
     * Handles the cancel button action.
     */
    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}