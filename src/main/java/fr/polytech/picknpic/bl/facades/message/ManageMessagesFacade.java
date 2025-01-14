package fr.polytech.picknpic.bl.facades.message;

import fr.polytech.picknpic.bl.models.Message;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.MessageDAO;

import java.sql.Timestamp;

/**
 * Facade for managing message creation operations.
 * Implements the Singleton design pattern.
 */
public class ManageMessagesFacade {

    private static ManageMessagesFacade manageMessagesFacade;

    private final AbstractFactory abstractFactory;

    private ManageMessagesFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of ManageMessagesFacade.
     *
     * @return The singleton instance of ManageMessagesFacade.
     */
    public static ManageMessagesFacade getInstance() {
        if (manageMessagesFacade == null) {
            manageMessagesFacade = new ManageMessagesFacade();
        }
        return manageMessagesFacade;
    }

    /**
     * Creates a new message.
     *
     * @param idMessage   The ID of the message.
     * @param idUserSender The ID of the user sending the message.
     * @param idChat       The ID of the chat the message belongs to.
     * @param content      The content of the message.
     * @param timestamp    The timestamp of the message.
     * @return The created Message object.
     */
    public Message createMessage(int idUserSender, int idChat, String content, Timestamp timestamp) {
        MessageDAO messageDAO = abstractFactory.createMessageDAO();
        return messageDAO.createMessage(idUserSender, idChat, content, timestamp);
    }
}
