package fr.polytech.picknpic.ui.controllers.UserControllers;

import fr.polytech.picknpic.bl.facades.user.DisplayUsersFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.bl.facades.user.ManageUsersFacade;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageUsersController {

    @FXML
    private TableView<User> usersTable;
    @FXML
    private TableColumn<User, String> usernameColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private TableColumn<User, String> firstNameColumn;
    @FXML
    private TableColumn<User, String> lastNameColumn;
    @FXML
    private TableColumn<User, Integer> phoneNumberColumn;
    @FXML
    private TableColumn<User, Boolean> adminColumn;

    private SceneManager sceneManager;

    private User currentUser;

    private final ManageUsersFacade manageUsersFacade = ManageUsersFacade.getInstance();

    private final DisplayUsersFacade displayUsersFacade = DisplayUsersFacade.getInstance();
    private final ObservableList<User> usersList = FXCollections.observableArrayList();

    public void setSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private void initialize() {
        currentUser = LoginFacade.getInstance().getCurrentUser();
        if (currentUser != null && currentUser.isAdmin()) {
            usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
            adminColumn.setCellValueFactory(new PropertyValueFactory<>("admin"));

            usersTable.setItems(usersList);
            loadUsers();
        }
        else {
            sceneManager.loadLoginScene();
        }
    }

    private void loadUsers() {
        usersList.clear();
        usersList.setAll(displayUsersFacade.getAllUsers(LoginFacade.getInstance().getCurrentUser()));
    }

    @FXML
    private void handleCreateUser() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/User/addUser.fxml"));
            VBox page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add User");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(usersTable.getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            AddUserController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();
            loadUsers();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleUpdateUser() {
        User selectedUser = usersTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/User/updateUser.fxml"));
                VBox page = loader.load();
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Update User");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(usersTable.getScene().getWindow());
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);

                UpdateUserController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setUser(selectedUser);

                dialogStage.showAndWait();
                loadUsers();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            showAlert("No Selection", "No User Selected", "Please select a user in the table.");
        }
    }

    @FXML
    private void handleDeleteUser() {
        User selectedUser = usersTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this user?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.YES) {
                    manageUsersFacade.deleteUser(selectedUser.getId());
                    loadUsers();
                }
            });
        } else {
            showAlert("No Selection", "No User Selected", "Please select a user in the table.");
        }
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}