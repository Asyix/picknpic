package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Message;
import java.util.List;
import java.sql.Timestamp;

/**
 * DAO interface for managing Message entities.
 */
public interface MessageDAO {

    /**
     * Creates a new message in the database.
     *
     * @param idUserSender The ID of the user who sent the message.
     * @param idChat       The ID of the chat.
     * @param content      The content of the message.
     * @param timestamp    The timestamp of the message.
     * @return The created Message object.
     */
    Message createMessage(int idUserSender, int idChat, String content, Timestamp timestamp);

    /**
     * Retrieves all messages for a given chat.
     *
     * @param idChat The ID of the chat.
     * @return A list of Message objects.
     */
    List<Message> getAllMessages(int idChat);
}
