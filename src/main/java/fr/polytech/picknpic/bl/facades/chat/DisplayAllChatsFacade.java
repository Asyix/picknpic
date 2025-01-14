package fr.polytech.picknpic.bl.facades.chat;

import fr.polytech.picknpic.bl.models.Chat;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.ChatDAO;

import java.util.List;

/**
 * Facade for retrieving all chats for a user.
 * Implements the Singleton design pattern.
 */
public class DisplayAllChatsFacade {

    private static DisplayAllChatsFacade displayAllChatsFacade;

    private final AbstractFactory abstractFactory;

    private DisplayAllChatsFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of DisplayAllChatsFacade.
     *
     * @return The singleton instance of DisplayAllChatsFacade.
     */
    public static DisplayAllChatsFacade getInstance() {
        if (displayAllChatsFacade == null) {
            displayAllChatsFacade = new DisplayAllChatsFacade();
        }
        return displayAllChatsFacade;
    }

    /**
     * Retrieves all chats associated with a user.
     *
     * @param idUser The ID of the user.
     * @return A list of chats associated with the user.
     */
    public List<Chat> getAllChats(int idUser) {
        ChatDAO chatDAO = abstractFactory.createChatDAO();
        return chatDAO.getAllChats(idUser);
    }
}
