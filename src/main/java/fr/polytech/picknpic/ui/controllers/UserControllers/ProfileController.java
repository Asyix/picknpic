package fr.polytech.picknpic.ui.controllers.UserControllers;

import fr.polytech.picknpic.bl.facades.user.FollowFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.facades.user.ManageAccountFacade;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.ui.SceneManager;
import fr.polytech.picknpic.ui.controllers.PostControllers.PostsController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class ProfileController {

    @FXML
    private Label usernameLabel;
    @FXML
    private Label followersLabel;
    @FXML
    private Label followedLabel;
    @FXML
    private Button followButton;
    @FXML
    private Button subscribeButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button requestsButton;
    @FXML
    private Button salesButton;
    @FXML
    private Pane contentPane;

    private User currentUser;
    private User profileUser;

    @FXML
    private void initialize() {
        currentUser = LoginFacade.getInstance().getCurrentUser();
        if (currentUser != null) {

        } else {
            SceneManager.loadLoginScene();
        }
    }

    public void initializeWithUser(User profileUser) {
        this.profileUser = profileUser;
        updateProfileInfo();
        updateButtonsVisibility();
        loadPostsScene();
    }

    public void setProfileUser(User profileUser) {
        this.profileUser = profileUser;
    }

    private void updateProfileInfo() {
        usernameLabel.setText(profileUser.getUsername());
        followersLabel.setText(String.valueOf(profileUser.getNbFollowers()));
        followedLabel.setText(String.valueOf(profileUser.getNbFollows()));
        followButton.setText(FollowFacade.getInstance().isFollowing(profileUser.getId(), currentUser.getId()) ? "Unfollow" : "Follow");
        //subscribeButton.setText(currentUser.isSubscribed(profileUser) ? "Unsubscribe" : "Subscribe");
    }

    private void updateButtonsVisibility() {
        boolean isOwnProfile = currentUser.equals(profileUser);
        followButton.setVisible(!isOwnProfile);
        subscribeButton.setVisible(!isOwnProfile);
        updateButton.setVisible(isOwnProfile);
        deleteButton.setVisible(isOwnProfile);
        requestsButton.setVisible(isOwnProfile);
        salesButton.setVisible(isOwnProfile);
    }

    @FXML
    private void handleFollow() {
        FollowFacade followFacade = FollowFacade.getInstance();
        if (followFacade.isFollowing(profileUser.getId(), currentUser.getId())) {
            followFacade.unfollowUser(profileUser.getId(), currentUser.getId());
        } else {
            followFacade.followUser(profileUser.getId(), currentUser.getId());
        }
        updateProfileInfo();
    }



    @FXML
    public void loadPostsScene() {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/fr/polytech/picknpic/Post/posts.fxml"));
            Parent content = loader.load();
            PostsController postsController = loader.getController();
            postsController.setProfileController(this); // Pass the ProfileController reference
            contentPane.getChildren().clear();
            contentPane.getChildren().add(content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void handleSubscribe() {

    }


    @FXML
    private void loadPhotosScene() {

    }

    @FXML
    private void loadServicesScene() {

    }

    @FXML
    private void loadRequestsScene() {

    }


    @FXML
    private void loadSalesScene() {

    }


    @FXML
    private void loadUpdateAccount() {
        SceneManager.loadUpdateAccountScene();
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
                    SceneManager.loadLoginScene();
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