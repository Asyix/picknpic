package fr.polytech.picknpic.ui.controllers.CommentControllers;

import fr.polytech.picknpic.bl.facades.comment.CommentFacade;
import fr.polytech.picknpic.bl.facades.like.LikeFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.Comment;
import fr.polytech.picknpic.bl.models.Like;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class CommentController {

    @FXML
    private VBox commentsContainer;

    @FXML
    private TextArea newCommentTextArea;

    private CommentFacade commentFacade;

    private String commentType;
    private int subjectId;

    private Comment currentComment;
    private Button currentButton;

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void initialize() {
        commentFacade = CommentFacade.getInstance();
        if ("post".equals(commentType)) {
            loadPostComments(subjectId);
        } else if ("photo".equals(commentType)) {
            loadPhotoComments(subjectId);
        }
    }

    private void loadPostComments(int postId) {
        List<Comment> comments = commentFacade.getPostComments(postId);
        for (Comment comment : comments) {
            addCommentToContainer(comment);
        }
    }

    private void loadPhotoComments(int photoId) {
        List<Comment> comments = commentFacade.getPhotoComments(photoId);
        for (Comment comment : comments) {
            addCommentToContainer(comment);
        }
    }

    private void addCommentToContainer(Comment comment) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Comment/comment.fxml"));
            HBox commentBox = loader.load(); // Cast to HBox

            Text commentText = (Text) commentBox.lookup("#commentText");
            commentText.setText(comment.getText());

            Button likeButton = (Button) commentBox.lookup("#likeButton");
            likeButton.setOnAction(event -> {
                currentComment = comment;
                currentButton = likeButton;
                handleLike();
            });

            Button replyButton = (Button) commentBox.lookup("#replyButton");
            replyButton.setOnAction(event -> {
                currentComment = comment;
                currentButton = replyButton;
                handleReply();
            });

            commentsContainer.getChildren().add(commentBox);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleShowReplies() {
        if (currentButton.getText().equals("Show Replies")) {
            List<Comment> replies = commentFacade.getCommentReplies(currentComment.getId());
            for (Comment reply : replies) {
                addReplyToContainer(reply, currentButton.getParent());
            }
            currentButton.setText("Hide Replies");
        } else {
            List<Comment> replies = commentFacade.getCommentReplies(currentComment.getId());
            for (Comment reply : replies) {
                commentsContainer.getChildren().removeIf(node -> {
                    Text commentText = (Text) node.lookup("#commentText");
                    return commentText != null && commentText.getText().equals(reply.getText());
                });
            }
            currentButton.setText("Show Replies");
        }
    }

    private void addReplyToContainer(Comment reply, Node parent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Comment/comment.fxml"));
            HBox replyBox = loader.load(); // Cast to HBox

            Text commentText = (Text) replyBox.lookup("#commentText");
            commentText.setText(reply.getText());

            Button likeButton = (Button) replyBox.lookup("#likeButton");
            likeButton.setOnAction(event -> {
                currentComment = reply;
                currentButton = likeButton;
                handleLike();
            });

            Button replyButton = (Button) replyBox.lookup("#replyButton");
            replyButton.setOnAction(event -> {
                currentComment = reply;
                currentButton = replyButton;
                handleReply();
            });

            Button showRepliesButton = (Button) replyBox.lookup("#showRepliesButton");
            showRepliesButton.setOnAction(event -> {
                currentComment = reply;
                currentButton = showRepliesButton;
                handleShowReplies();
            });

            int parentIndex = commentsContainer.getChildren().indexOf(parent);
            commentsContainer.getChildren().add(parentIndex + 1, replyBox);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleLike() {
        if (currentButton.getText().equals("Like")) {
            LikeFacade.getInstance().addLike(new Like(LoginFacade.getInstance().getCurrentUser().getId(),
                    -1,
                    -1,
                    currentComment.getId()));
            currentButton.setText("Unlike");
        } else {
            currentButton.setText("Like");
            LikeFacade.getInstance().removeLikeOnComment(LoginFacade.getInstance().getCurrentUser().getId(), currentComment.getId());
        }
    }

    @FXML
    private void handleReply() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/polytech/picknpic/Comment/comment.fxml"));
            HBox replyBox = loader.load(); // Cast to HBox

            TextArea replyTextArea = new TextArea();
            replyTextArea.setPromptText("Write a reply...");
            replyTextArea.setPrefHeight(50);
            replyTextArea.setPrefWidth(300);

            Button publishReplyButton = new Button("Publish Reply");
            publishReplyButton.setOnAction(event -> {
                String replyText = replyTextArea.getText();
                if (!replyText.isEmpty()) {
                    Comment reply = new Comment(
                            LoginFacade.getInstance().getCurrentUser().getId(),
                            -1,
                            -1,
                            currentComment.getId(),
                            replyText,
                            0,
                            0,
                            new Date()
                    );
                    commentFacade.createComment(reply);
                    addCommentToContainer(reply);
                    commentsContainer.getChildren().remove(replyBox);
                }
            });

            replyBox.getChildren().addAll(replyTextArea, publishReplyButton);
            commentsContainer.getChildren().add(commentsContainer.getChildren().indexOf(currentButton.getParent()) + 1, replyBox);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handlePublishComment() {
        String newCommentText = newCommentTextArea.getText();
        if (!newCommentText.isEmpty()) {
            Comment newComment = new Comment(
                    LoginFacade.getInstance().getCurrentUser().getId(),
                    "post".equals(commentType) ? subjectId : -1,
                    "photo".equals(commentType) ? subjectId : -1,
                    -1,
                    newCommentText,
                    0,
                    0,
                    new Date()
            );
            commentFacade.createComment(newComment);
            addCommentToContainer(newComment);
            newCommentTextArea.clear();
        }
    }
}