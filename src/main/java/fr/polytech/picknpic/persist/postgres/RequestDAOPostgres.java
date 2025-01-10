package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Request;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.RequestDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PostgreSQL implementation of the {@link RequestDAO} interface.
 * Provides methods for creating and updating requests in the PostgreSQL database.
 */
public class RequestDAOPostgres implements RequestDAO {

    /**
     * Creates a new request in the PostgreSQL database.
     *
     * @param id_user_buyer The ID of the user making the request.
     * @param id_service The ID of the service requested.
     * @param id_chat The ID of the associated chat.
     * @param message The message or details provided by the user.
     * @param image The image associated with the request (URL or file path).
     * @param status The initial status of the request. Valid values are:
     *               "waiting", "accepted waiting", "delivered", or "declined".
     * @return The newly created {@link Request} object.
     */
    @Override
    public Request createRequest(int id_user_buyer, int id_service, int id_chat, String message, String image, String status) {
        Request request = null;

        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            String query = "INSERT INTO \"Request\" (id_user_buyer, id_service, id_chat, message, image, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?) RETURNING id_request";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id_user_buyer);
            statement.setInt(2, id_service);
            statement.setInt(3, id_chat);
            statement.setString(4, message);
            statement.setString(5, image);
            statement.setString(6, status);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id_request = resultSet.getInt("id_request");

                // Create a new Request object with the retrieved ID
                request = new Request();
                request.setIdRequest(id_request);
                request.setIdUserBuyer(id_user_buyer);
                request.setIdService(id_service);
                request.setIdChat(id_chat);
                request.setMessage(message);
                request.setImage(image);
                request.setStatus(status);
            }
        } catch (SQLException e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
        }

        return request;
    }

    /**
     * Changes the status of an existing request in the PostgreSQL database.
     *
     * @param id_request The ID of the request to update.
     * @param newStatus The new status to set for the request.
     * @return The updated {@link Request} object with the new status.
     */
    @Override
    public Request changeRequestStatus(int id_request, String newStatus) {
        Request request = null;

        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            String query = "UPDATE \"Request\" SET status = ? WHERE id_request = ? RETURNING *";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newStatus);
            statement.setInt(2, id_request);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                request = new Request();
                request.setIdRequest(resultSet.getInt("id_request"));
                request.setIdUserBuyer(resultSet.getInt("id_user_buyer"));
                request.setIdService(resultSet.getInt("id_service"));
                request.setIdChat(resultSet.getInt("id_chat"));
                request.setMessage(resultSet.getString("message"));
                request.setImage(resultSet.getString("image"));
                request.setStatus(resultSet.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return request;
    }
}