package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Message;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.MessageDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PostgreSQL implementation of the {@link MessageDAO}.
 * Handles database operations for the Message entity using JDBC.
 */
public class MessageDAOPostgres implements MessageDAO {

    /** Singleton instance of the JDBC connector for database connections. */
    private final JDBCConnector jdbcConnector = JDBCConnector.getInstance();

    /**
     * Creates a new message in the database.
     *
     * @param idUserSender The ID of the user who sent the message.
     * @param idChat       The ID of the chat the message belongs to.
     * @param content      The content of the message.
     * @param timestamp    The timestamp of when the message was sent.
     * @return The created {@link Message} object.
     */
    @Override
    public Message createMessage(int idUserSender, int idChat, String content, Timestamp timestamp) {
        String query = "INSERT INTO \"Message\" (id_user_sender, id_chat, content, time_stamp) VALUES (?, ?, ?, ?)";
        try (Connection connection = jdbcConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, idUserSender);
            preparedStatement.setInt(2, idChat);
            preparedStatement.setString(3, content);
            preparedStatement.setTimestamp(4, timestamp);

            preparedStatement.executeUpdate();
            return new Message(idUserSender, idChat, content, timestamp.toLocalDateTime());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create message.", e);
        }
    }


    /**
     * Retrieves all messages for a given chat from the database.
     *
     * @param idChat The ID of the chat.
     * @return A list of {@link Message} objects for the specified chat.
     */
    @Override
    public List<Message> getAllMessages(int idChat) {
        String query = "SELECT id_message, id_user_sender, id_chat, content, time_stamp FROM \"Message\" WHERE id_chat = ? ORDER BY time_stamp ASC";
        List<Message> messages = new ArrayList<>();
        try (Connection connection = jdbcConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, idChat);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    messages.add(new Message(
                            resultSet.getInt("id_message"),         // Include id_message
                            resultSet.getInt("id_user_sender"),
                            resultSet.getInt("id_chat"),
                            resultSet.getString("content"),
                            resultSet.getTimestamp("time_stamp").toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch messages", e);
        }
        return messages;
    }

}
