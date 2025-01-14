package fr.polytech.picknpic.ui.controllers.ChatControllers;

import fr.polytech.picknpic.bl.facades.chat.ChatFacade;
import fr.polytech.picknpic.bl.models.Chat;

/**
 * Controller for managing chat creation operations.
 */
public class ManageChatController {

    private final ChatFacade chatFacade = ChatFacade.getChatFacadeInstance();

    /**
     * Handles the creation of a new chat.
     *
     * @param idRequest    The ID of the associated request.
     * @param idUserSeller The ID of the seller.
     * @param idUserBuyer  The ID of the buyer.
     * @return The created Chat object.
     */
    public Chat handleManageChats(int idRequest, int idUserSeller, int idUserBuyer) {
        Chat chat = chatFacade.createChat(idRequest, idUserSeller, idUserBuyer);
        System.out.println("Chat created: " + chat);
        return chat; // Return the Chat object
    }

}
