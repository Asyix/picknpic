package fr.polytech.picknpic.bl.models;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a chat between two users (buyer and seller).
 * A chat contains multiple messages exchanged between the two users.
 */
public class Chat {
    private int idChat;
    private int idRequest; // Link to the related request
    private int idUserSeller; // ID of the seller
    private int idUserBuyer;  // ID of the buyer
    private List<Message> messages; // List of messages in this chat

    /**
     * Constructs a new Chat instance.
     *
     * @param idRequest    The ID of the related request.
     * @param idUserSeller The ID of the seller involved in the chat.
     * @param idUserBuyer  The ID of the buyer involved in the chat.
     */
    public Chat(int idRequest, int idUserSeller, int idUserBuyer) {
        this.idRequest = idRequest;
        this.idUserSeller = idUserSeller;
        this.idUserBuyer = idUserBuyer;
        this.messages = new ArrayList<>();
    }

    /**
     * Gets the chat ID.
     *
     * @return The chat ID.
     */
    public int getIdChat() {
        return idChat;
    }

    /**
     * Sets the chat ID.
     *
     * @param idChat The chat ID to set.
     */
    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    /**
     * Gets the request ID related to this chat.
     *
     * @return The request ID.
     */
    public int getIdRequest() {
        return idRequest;
    }

    /**
     * Sets the request ID related to this chat.
     *
     * @param idRequest The request ID to set.
     */
    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    /**
     * Gets the seller's user ID.
     *
     * @return The seller's user ID.
     */
    public int getIdUserSeller() {
        return idUserSeller;
    }

    /**
     * Sets the seller's user ID.
     *
     * @param idUserSeller The seller's user ID to set.
     */
    public void setIdUserSeller(int idUserSeller) {
        this.idUserSeller = idUserSeller;
    }

    /**
     * Gets the buyer's user ID.
     *
     * @return The buyer's user ID.
     */
    public int getIdUserBuyer() {
        return idUserBuyer;
    }

    /**
     * Sets the buyer's user ID.
     *
     * @param idUserBuyer The buyer's user ID to set.
     */
    public void setIdUserBuyer(int idUserBuyer) {
        this.idUserBuyer = idUserBuyer;
    }

    /**
     * Gets the list of messages in this chat.
     *
     * @return The list of messages.
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Adds a message to the chat.
     *
     * @param message The message to add.
     */
    public void addMessage(Message message) {
        this.messages.add(message);
    }

    /**
     * Removes a message from the chat.
     *
     * @param message The message to remove.
     */
    public void removeMessage(Message message) {
        this.messages.remove(message);
    }

    /**
     * Gets the last message in the chat.
     *
     * @return The last message, or null if no messages exist.
     */
    public Message getLastMessage() {
        return messages.isEmpty() ? null : messages.get(messages.size() - 1);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "idChat=" + idChat +
                ", idRequest=" + idRequest +
                ", idUserSeller=" + idUserSeller +
                ", idUserBuyer=" + idUserBuyer +
                ", messages=" + messages +
                '}';
    }
}
