package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Chat;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.ChatDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PostgreSQL implementation of the {@link ChatDAO} interface.
 * Provides methods for creating and retrieving chats in the PostgreSQL database.
 */
public class ChatDAOPostgres implements ChatDAO {

    private final JDBCConnector jdbcConnector = JDBCConnector.getInstance();

    /**
     * Creates a new chat in the database.
     *
     * @param idRequest   The ID of the request associated with the chat.
     * @param idUserSeller The ID of the user who is the seller in the chat.
     * @param idUserBuyer  The ID of the user who is the buyer in the chat.
     * @return The created {@link Chat} object, or {@code null} if creation failed.
     */
    @Override
    public Chat createChat(int idRequest, int idUserSeller, int idUserBuyer) {
        String query = "INSERT INTO \"Chat\" (id_request, id_user_seller, id_user_buyer) VALUES (?, ?, ?) RETURNING id_chat";
        try (Connection connection = jdbcConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, idRequest);
            preparedStatement.setInt(2, idUserSeller);
            preparedStatement.setInt(3, idUserBuyer);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int generatedId = resultSet.getInt("id_chat");
                    Chat chat = new Chat(idRequest, idUserSeller, idUserBuyer);
                    chat.setIdChat(generatedId); // Set the generated chat ID
                    return chat;
                } else {
                    throw new RuntimeException("Failed to retrieve generated chat ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print full details of the exception
            throw new RuntimeException("Failed to create chat. Reason: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieves all chats for a specific user from the database.
     *
     * @param idUser The ID of the user whose chats are to be retrieved.
     * @return A list of {@link Chat} objects containing the user's chats.
     */
    @Override
    public List<Chat> getAllChats(int idUser) {
        String query = "SELECT * FROM \"Chat\" WHERE id_user_seller = ? OR id_user_buyer = ?";
        List<Chat> chats = new ArrayList<>();
        try (Connection connection = jdbcConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, idUser);
            preparedStatement.setInt(2, idUser);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Chat chat = new Chat(
                            resultSet.getInt("id_request"),
                            resultSet.getInt("id_user_seller"),
                            resultSet.getInt("id_user_buyer")
                    );
                    chat.setIdChat(resultSet.getInt("id_chat")); // Set the chat ID
                    chats.add(chat);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch chats.", e);
        }
        return chats;
    }
}