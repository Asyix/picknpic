package fr.polytech.picknpic.ui.controllers.MessageControllers;

import fr.polytech.picknpic.bl.facades.message.MessageFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.sql.Timestamp;
import java.util.List;

public class MessageController {

    private final MessageFacade messageFacade = MessageFacade.getMessageFacadeInstance();

    private int currentChatId;
    private int currentUserId;

    @FXML
    private TableView<Message> messageTable;

    @FXML
    private TextField messageInputField;

    @FXML
    private Button sendButton;

    @FXML
    private void initialize() {
        loadChatMessages(currentChatId);
    }

    public void setCurrentChatId(int currentChatId) {
        this.currentChatId = currentChatId;
    }

    /**
     * Load messages for a specific chat.
     *
     * @param chatId  The ID of the chat to load messages for.
     */
    public void loadChatMessages(int chatId) {
        this.currentChatId = chatId;
        this.currentUserId = LoginFacade.getInstance().getCurrentUser().getId();
        refreshMessages();
    }

    /**
     * Refresh the messages in the TableView.
     */
    private void refreshMessages() {
        List<Message> messages = messageFacade.getAllMessages(currentChatId);
        ObservableList<Message> messageObservableList = FXCollections.observableArrayList(messages);
        messageTable.setItems(messageObservableList);
    }

    /**
     * Handles the creation of a new message.
     */
    @FXML
    public void handleSendMessage() {
        String content = messageInputField.getText();
        if (content == null || content.trim().isEmpty()) {
            return; // Ignore empty messages
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Message message = messageFacade.createMessage(currentUserId, currentChatId, content, timestamp);

        // Clear the input field after sending
        messageInputField.clear();

        // Refresh the messages in the TableView
        refreshMessages();
    }

    /**
     * Handles sending a message when Enter key is pressed in the input field.
     *
     * @param event The key event.
     */
    @FXML
    public void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            handleSendMessage();
        }
    }

    /**
     * Handles navigation back to the main scene.
     */
    @FXML
    public void handleBackToMainScene() {
        // Code to navigate back to the main scene or chat list (e.g., using SceneManager)
    }
}
