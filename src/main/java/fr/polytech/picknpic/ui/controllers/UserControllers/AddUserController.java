package fr.polytech.picknpic.ui.controllers.UserControllers;

import fr.polytech.picknpic.bl.facades.user.ManageUsersFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddUserController {

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
    private final ManageUsersFacade manageUsersFacade = ManageUsersFacade.getInstance();
    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleCreateUser() {
        String email = emailField.getText();
        String password = passwordField.getText();
        String username = usernameField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        int phoneNumber = Integer.parseInt(phoneNumberField.getText());
        boolean admin = adminCheckBox.isSelected();

        boolean success = manageUsersFacade.createUser(email, password, username, firstName, lastName, phoneNumber, admin);
        if (success) {
            dialogStage.close();
        } else {
            showAlert("Error", "User creation failed", "Please check the input fields.");
        }
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}