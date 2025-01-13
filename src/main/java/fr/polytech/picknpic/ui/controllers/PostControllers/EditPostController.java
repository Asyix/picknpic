package fr.polytech.picknpic.ui.controllers.PostControllers;

import fr.polytech.picknpic.bl.facades.post.PostFacade;
import fr.polytech.picknpic.bl.models.Post;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class EditPostController {

    @FXML
    private TextArea postTextArea;

    private Stage dialogStage;
    private Post post;
    private boolean saveClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPost(Post post) {
        this.post = post;
        postTextArea.setText(post.getText());
    }

    public boolean isSaveClicked() {
        return saveClicked;
    }

    @FXML
    private void handleSave() {
        post.setText(postTextArea.getText());
        PostFacade.getInstance().updatePost(post);
        saveClicked = true;
        dialogStage.close();
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}