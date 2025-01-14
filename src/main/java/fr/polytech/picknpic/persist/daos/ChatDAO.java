package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Chat;
import java.util.List;

/**
 * DAO interface for managing Chat entities.
 */
public interface ChatDAO {

    /**
     * Creates a new chat in the database.
     *
     * @param idRequest    The ID of the related request.
     * @param idUserSeller The ID of the seller.
     * @param idUserBuyer  The ID of the buyer.
     * @return The created Chat object.
     */
    Chat createChat(int idRequest, int idUserSeller, int idUserBuyer);

    /**
     * Retrieves all chats for a given user.
     *
     * @param idUser The ID of the user.
     * @return A list of Chat objects.
     */
    List<Chat> getAllChats(int idUser);
}
