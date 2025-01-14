package fr.polytech.picknpic.bl.facades.message;

import fr.polytech.picknpic.bl.models.Message;

import java.sql.Timestamp;
import java.util.List;

/**
 * Facade for combining message-related operations.
 * Implements the Singleton design pattern.
 */
public class MessageFacade {

    private static MessageFacade messageFacade;

    private final ManageMessagesFacade manageMessagesFacade;
    private final DisplayAllMessagesFacade displayAllMessagesFacade;

    private MessageFacade() {
        this.manageMessagesFacade = ManageMessagesFacade.getInstance();
        this.displayAllMessagesFacade = DisplayAllMessagesFacade.getInstance();
    }

    /**
     * Retrieves the singleton instance of MessageFacade.
     *
     * @return The singleton instance of MessageFacade.
     */
    public static MessageFacade getMessageFacadeInstance() {
        if (messageFacade == null) {
            messageFacade = new MessageFacade();
        }
        return messageFacade;
    }

    /**
     * Creates a new message.
     *
     * @param idUserSender The ID of the user sending the message.
     * @param idChat       The ID of the chat the message belongs to.
     * @param content      The content of the message.
     * @param timestamp    The timestamp of the message.
     * @return The created Message object.
     */
    public Message createMessage(int idUserSender, int idChat, String content, Timestamp timestamp) {
        return manageMessagesFacade.createMessage(idUserSender, idChat, content, timestamp);
    }

    /**
     * Retrieves all messages for a chat.
     *
     * @param idChat The ID of the chat.
     * @return A list of messages associated with the chat.
     */
    public List<Message> getAllMessages(int idChat) {
        return displayAllMessagesFacade.getAllMessages(idChat);
    }

}
