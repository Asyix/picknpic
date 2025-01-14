package fr.polytech.picknpic.bl.facades.chat;

import fr.polytech.picknpic.bl.models.Chat;

import java.util.List;

/**
 * Facade for combining chat-related operations.
 * Implements the Singleton design pattern.
 */
public class ChatFacade {

    private static ChatFacade chatFacade;

    private final ManageChatsFacade manageChatsFacade;
    private final DisplayAllChatsFacade displayAllChatsFacade;

    private ChatFacade() {
        this.manageChatsFacade = ManageChatsFacade.getInstance();
        this.displayAllChatsFacade = DisplayAllChatsFacade.getInstance();
    }

    /**
     * Retrieves the singleton instance of ChatFacade.
     *
     * @return The singleton instance of ChatFacade.
     */
    public static ChatFacade getChatFacadeInstance() {
        if (chatFacade == null) {
            chatFacade = new ChatFacade();
        }
        return chatFacade;
    }

    /**
     * Creates a new chat.
     *
     * @param idRequest    The ID of the associated request.
     * @param idUserSeller The ID of the seller.
     * @param idUserBuyer  The ID of the buyer.
     * @return The created Chat object.
     */
    public Chat createChat(int idRequest, int idUserSeller, int idUserBuyer) {
        return manageChatsFacade.createChat(idRequest, idUserSeller, idUserBuyer);
    }

    /**
     * Retrieves all chats associated with a user.
     *
     * @param idUser The ID of the user.
     * @return A list of chats associated with the user.
     */
    public List<Chat> getAllChats(int idUser) {
        return displayAllChatsFacade.getAllChats(idUser);
    }

}
