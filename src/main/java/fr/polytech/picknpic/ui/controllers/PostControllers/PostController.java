package fr.polytech.picknpic.ui.controllers.PostControllers;

import fr.polytech.picknpic.bl.facades.comment.CommentFacade;
import fr.polytech.picknpic.bl.facades.like.LikeFacade;
import fr.polytech.picknpic.bl.facades.post.PostFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.Comment;
import fr.polytech.picknpic.bl.models.Like;
import fr.polytech.picknpic.bl.models.Post;
import fr.polytech.picknpic.ui.controllers.CommentControllers.CommentController;
import fr.polytech.picknpic.ui.controllers.UserControllers.ProfileController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class PostController {

    @FXML
    private Text postUser;

    @FXML
    private Text postText;

    @FXML
    private Text postDate;

    @FXML
    private Text postLikes;

    @FXML
    private Text postComments;

    @FXML
    private Button likeButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private VBox commentsSection;

    private VBox postsContainer;
    private Post post;

    private ProfileController profileController;

    public void setProfileController(ProfileController profileController) {
        this.profileController = profileController;
    }

    public void setPost(Post post) {
        this.post = post;
        postUser.setText(String.valueOf(post.getUserId()));
        postText.setText(post.getText());
        postDate.setText(post.getCreationDate().toString());
        postLikes.setText("Likes: " + post.getNbLikes());
        postComments.setText("Comments: " + post.getNbComments());

        if (post.getUserId() == LoginFacade.getInstance().getCurrentUser().getId()) {
            editButton.setVisible(true);
            deleteButton.setVisible(true);
        }

        loadComments();
    }

    @FXML
    private void handleLike() {
        LikeFacade likeFacade = LikeFacade.getInstance();
        if (likeButton.getText().equals("Like")) {
            likeFacade.addLike(new Like(LoginFacade.getInstance().getCurrentUser().getId(), post.getId(), -1, -1));
            likeButton.setText("Unlike");
        } else {
            likeFacade.removeLikeOnPost(LoginFacade.getInstance().getCurrentUser().getId(), post.getId());
            likeButton.setText("Like");
        }
        setPost(PostFacade.getInstance().getPost(post.getId())); // Refresh the post details
    }

    private void loadComments() {
        commentsSection.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Comment/commentList.fxml"));
            VBox commentListBox = loader.load();
            CommentController commentController = loader.getController();
            commentController.setCommentType("post");
            commentController.setSubjectId(post.getId());
            commentController.initialize();
            commentsSection.getChildren().add(commentListBox);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPostsContainer(VBox postsContainer) {
        this.postsContainer = postsContainer;
    }

    @FXML
    private void handleEdit() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Post/editPost.fxml"));
            VBox page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Post");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(postsContainer.getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EditPostController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPost(post);

            dialogStage.showAndWait();

            if (controller.isSaveClicked()) {
                setPost(PostFacade.getInstance().getPost(post.getId())); // Refresh the post details
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleDelete() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Post/confirmDelete.fxml"));
            VBox page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Confirm Delete");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(postsContainer.getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ConfirmDeleteController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

            if (controller.isConfirmed()) {
                PostFacade.getInstance().deletePost(post.getId());
                postsContainer.getChildren().removeIf(node -> {
                    PostController postController = (PostController) node.getUserData();
                    return postController != null && postController.post.getId() == post.getId();
                });

                // Reload the posts scene as a subsection of the profile page
                if (profileController != null) {
                    profileController.loadPostsScene();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}