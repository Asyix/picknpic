package fr.polytech.picknpic.ui.controllers.PostControllers;

import fr.polytech.picknpic.bl.facades.like.LikeFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.Like;
import fr.polytech.picknpic.bl.models.Post;
import fr.polytech.picknpic.bl.facades.post.PostFacade;
import fr.polytech.picknpic.ui.controllers.UserControllers.ProfileController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class PostsController {

    @FXML
    private TableView<Post> postsTable;
    @FXML
    private TableColumn<Post, Integer> userIdColumn;
    @FXML
    private TableColumn<Post, String> textColumn;
    @FXML
    private TableColumn<Post, String> dateColumn;
    @FXML
    private TableColumn<Post, Integer> likesColumn;
    @FXML
    private TableColumn<Post, Integer> commentsColumn;

    @FXML
    private VBox postsContainer;

    @FXML
    private Button likeButton;

    private PostFacade postFacade = PostFacade.getInstance();

    private ProfileController profileController;

    public void setProfileController(ProfileController profileController) {
        this.profileController = profileController;
    }

    @FXML
    private void initialize() {
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        textColumn.setCellValueFactory(new PropertyValueFactory<>("text"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        likesColumn.setCellValueFactory(new PropertyValueFactory<>("nbLikes"));
        commentsColumn.setCellValueFactory(new PropertyValueFactory<>("nbComments"));

        loadPosts();

        postsTable.setOnMouseClicked(this::handlePostSelection);
    }

    private void loadPosts() {
        List<Post> posts = postFacade.getUserPosts(LoginFacade.getInstance().getCurrentUser().getId());
        postsTable.getItems().setAll(posts);
    }

    @FXML
    private void handleSeePost() {
        Post selectedPost = postsTable.getSelectionModel().getSelectedItem();
        if (selectedPost != null) {
            addPostToContainer(selectedPost);
        }
    }

    @FXML
    private void handleLikePost() {
        Post selectedPost = postsTable.getSelectionModel().getSelectedItem();
        if (selectedPost != null) {
            LikeFacade likeFacade = LikeFacade.getInstance();
            if (likeButton.getText().equals("Like")) {
                likeFacade.addLike(new Like(LoginFacade.getInstance().getCurrentUser().getId(), selectedPost.getId(), -1, -1));
                likeButton.setText("Unlike");
                selectedPost.setNbLikes(selectedPost.getNbLikes() + 1);
            } else {
                likeFacade.removeLikeOnPost(LoginFacade.getInstance().getCurrentUser().getId(), selectedPost.getId());
                likeButton.setText("Like");
                selectedPost.setNbLikes(selectedPost.getNbLikes() - 1);
            }
            postsTable.refresh(); // Refresh the posts table to update the likes count
        }
    }

    public void addPostToContainer(Post post) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Post/post.fxml"));
            VBox postBox = loader.load();
            PostController postController = loader.getController();
            postController.setPost(post);
            postController.setPostsContainer(postsContainer);
            postController.setProfileController(profileController); // Set the ProfileController reference
            postsContainer.getChildren().add(postBox);
            System.out.println("Post added to container: " + post.getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleCreatePost() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Post/createPost.fxml"));
            VBox page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Create Post");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(postsContainer.getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            CreatePostController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

            if (controller.isPublishClicked()) {
                loadPosts(); // Refresh the posts table
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handlePostSelection(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Post selectedPost = postsTable.getSelectionModel().getSelectedItem();
            if (selectedPost != null) {
                addPostToContainer(selectedPost);
            }
        }
    }
}