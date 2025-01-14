package fr.polytech.picknpic.bl.facades.message;

import fr.polytech.picknpic.bl.models.Message;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.MessageDAO;

import java.util.List;

/**
 * Facade for retrieving all messages for a chat.
 * Implements the Singleton design pattern.
 */
public class DisplayAllMessagesFacade {

    private static DisplayAllMessagesFacade displayAllMessagesFacade;

    private final AbstractFactory abstractFactory;

    private DisplayAllMessagesFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of DisplayAllMessagesFacade.
     *
     * @return The singleton instance of DisplayAllMessagesFacade.
     */
    public static DisplayAllMessagesFacade getInstance() {
        if (displayAllMessagesFacade == null) {
            displayAllMessagesFacade = new DisplayAllMessagesFacade();
        }
        return displayAllMessagesFacade;
    }

    /**
     * Retrieves all messages for a given chat.
     *
     * @param idChat The ID of the chat.
     * @return A list of messages associated with the chat.
     */
    public List<Message> getAllMessages(int idChat) {
        MessageDAO messageDAO = abstractFactory.createMessageDAO();
        return messageDAO.getAllMessages(idChat);
    }
}
