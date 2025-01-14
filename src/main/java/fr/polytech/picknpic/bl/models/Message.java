package fr.polytech.picknpic.bl.models;

import java.time.LocalDateTime;

/**
 * Represents a single message in a chat.
 * A message is sent by one user to another as part of a chat conversation.
 */
public class Message {
    private int idMessage; // Unique ID of the message
    private int idUserSender; // ID of the user who sent the message
    private int idChat; // ID of the chat the message belongs to
    private String content; // Content of the message
    private LocalDateTime timestamp; // Timestamp of when the message was sent

    /**
     * Constructs a new Message instance.
     *
     * @param idUserSender The ID of the user who sent the message.
     * @param idChat       The ID of the chat the message belongs to.
     * @param content      The text content of the message.
     * @param timestamp    The timestamp indicating when the message was sent.
     */
    public Message(int idUserSender, int idChat, String content, LocalDateTime timestamp) {
        this.idUserSender = idUserSender;
        this.idChat = idChat;
        this.content = content;
        this.timestamp = timestamp;
    }

    /**
     * Constructs a new Message instance.
     *
     * @param idMessage    The unique ID of the message.
     * @param idUserSender The ID of the user who sent the message.
     * @param idChat       The ID of the chat the message belongs to.
     * @param content      The text content of the message.
     * @param timestamp    The timestamp indicating when the message was sent.
     */
    public Message(int idMessage, int idUserSender, int idChat, String content, LocalDateTime timestamp) {
        this.idMessage = idMessage;
        this.idUserSender = idUserSender;
        this.idChat = idChat;
        this.content = content;
        this.timestamp = timestamp;
    }

    /**
     * Gets the unique ID of the message.
     *
     * @return The message ID.
     */
    public int getIdMessage() {
        return idMessage;
    }

    /**
     * Sets the unique ID of the message.
     *
     * @param idMessage The message ID to set.
     */
    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * Gets the ID of the user who sent the message.
     *
     * @return The sender's user ID.
     */
    public int getIdUserSender() {
        return idUserSender;
    }

    /**
     * Sets the ID of the user who sent the message.
     *
     * @param idUserSender The sender's user ID to set.
     */
    public void setIdUserSender(int idUserSender) {
        this.idUserSender = idUserSender;
    }

    /**
     * Gets the ID of the chat the message belongs to.
     *
     * @return The chat ID.
     */
    public int getIdChat() {
        return idChat;
    }

    /**
     * Sets the ID of the chat the message belongs to.
     *
     * @param idChat The chat ID to set.
     */
    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    /**
     * Gets the content of the message.
     *
     * @return The text content of the message.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the message.
     *
     * @param content The text content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the timestamp of when the message was sent.
     *
     * @return The timestamp as a {@link LocalDateTime}.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp of when the message was sent.
     *
     * @param timestamp The timestamp to set as a {@link LocalDateTime}.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Returns a string representation of the message.
     *
     * @return A string containing the message details.
     */
    @Override
    public String toString() {
        return "Message{" +
                "idMessage=" + idMessage +
                ", idUserSender=" + idUserSender +
                ", idChat=" + idChat +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
