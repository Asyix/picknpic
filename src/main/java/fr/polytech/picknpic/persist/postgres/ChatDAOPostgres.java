package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Chat;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.ChatDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PostgreSQL implementation of ChatDAO.
 */
public class ChatDAOPostgres implements ChatDAO {

    private final JDBCConnector jdbcConnector = JDBCConnector.getInstance();

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
