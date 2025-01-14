package fr.polytech.picknpic.ui.controllers.ChatControllers;

import fr.polytech.picknpic.bl.facades.chat.ChatFacade;
import fr.polytech.picknpic.bl.facades.user.LoginFacade;
import fr.polytech.picknpic.bl.models.Chat;
import fr.polytech.picknpic.ui.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class DisplayAllChatsController {

    private final ChatFacade chatFacade = ChatFacade.getChatFacadeInstance();

    @FXML
    private TableView<Chat> chatTable;

    @FXML
    private void initialize() {
        callHandleGetAllChats();

        // Set a listener for row selection in the TableView
        chatTable.setOnMouseClicked(this::handleRowClick);
    }

    /**
     * Handles retrieving all chats for a user and populating the table.
     *
     * @param idUser The ID of the user.
     */
    public void handleGetAllChats(int idUser) {
        List<Chat> chats = chatFacade.getAllChats(idUser);
        ObservableList<Chat> chatObservableList = FXCollections.observableArrayList(chats);
        chatTable.setItems(chatObservableList);
    }

    public void callHandleGetAllChats() {
        int currentUserId = LoginFacade.getInstance().getCurrentUser().getId();
        handleGetAllChats(currentUserId);
    }

    /**
     * Handles navigation back to the main scene.
     */
    @FXML
    public void loadMainScene() {
        SceneManager.loadMainScene();
    }

    /**
     * Handles row click to load the messages scene for the selected chat.
     *
     * @param event The mouse event triggered by clicking a row.
     */
    private void handleRowClick(MouseEvent event) {
        if (event.getClickCount() == 2) { // Double-click to select a chat
            Chat selectedChat = chatTable.getSelectionModel().getSelectedItem();
            if (selectedChat != null) {
                loadMessagesScene(selectedChat);
            }
        }
    }

    /**
     * Loads the messages scene for the selected chat.
     *
     * @param chat The selected chat.
     */
    public void loadMessagesScene(Chat chat) {
        SceneManager.loadMessagesScene(chat); // Pass the selected chat
    }
}
