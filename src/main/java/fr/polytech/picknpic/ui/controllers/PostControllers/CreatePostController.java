package fr.polytech.picknpic.ui.controllers.PostControllers;

import fr.polytech.picknpic.bl.facades.post.PostFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.Post;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.Date;

public class CreatePostController {

    @FXML
    private TextArea postTextArea;

    private Stage dialogStage;
    private boolean publishClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isPublishClicked() {
        return publishClicked;
    }

    @FXML
    private void handlePublish() {
        String postText = postTextArea.getText();
        if (!postText.isEmpty()) {
            Post newPost = new Post(
                    LoginFacade.getInstance().getCurrentUser().getId(),
                    postText,
                    0,
                    0,
                    new Date()
            );
            PostFacade.getInstance().createPost(newPost);
            publishClicked = true;
            dialogStage.close();
        }
    }
}