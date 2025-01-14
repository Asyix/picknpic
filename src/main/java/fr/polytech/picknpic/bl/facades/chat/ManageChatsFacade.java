package fr.polytech.picknpic.bl.facades.chat;

import fr.polytech.picknpic.bl.models.Chat;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.ChatDAO;

/**
 * Facade for managing chat creation operations.
 * Implements the Singleton design pattern.
 */
public class ManageChatsFacade {

    private static ManageChatsFacade manageChatsFacade;

    private final AbstractFactory abstractFactory;

    private ManageChatsFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of ManageChatsFacade.
     *
     * @return The singleton instance of ManageChatsFacade.
     */
    public static ManageChatsFacade getInstance() {
        if (manageChatsFacade == null) {
            manageChatsFacade = new ManageChatsFacade();
        }
        return manageChatsFacade;
    }

    /**
     * Creates a new chat.
     *
     * @param idRequest    The ID of the request associated with the chat.
     * @param idUserSeller The ID of the seller.
     * @param idUserBuyer  The ID of the buyer.
     * @return The created Chat object.
     */
    public Chat createChat(int idRequest, int idUserSeller, int idUserBuyer) {
        ChatDAO chatDAO = abstractFactory.createChatDAO();
        return chatDAO.createChat(idRequest, idUserSeller, idUserBuyer);
    }
}
