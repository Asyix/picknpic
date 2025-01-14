package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Service;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.ServiceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PostgreSQL implementation of the {@link ServiceDAO} interface.
 * Provides methods for performing CRUD operations on services in the PostgreSQL database.
 */
public class ServiceDAOPostgres implements ServiceDAO {

    /**
     * Creates a new service.
     *
     * @param id_user_owner The ID of the user who owns the service.
     * @param name The name of the service.
     * @param example_image The example image of the service.
     * @param price The price of the service.
     * @param description The description of the service.
     * @param nb_buyers The number of buyers of the service.
     * @return A {@link Service} object if the service was created successfully, or {@code null} if the creation failed.
     */
    @Override
    public Service createService(int id_user_owner, String name, String example_image, float price, String description, int nb_buyers) {
        String query = "INSERT INTO \"Service\" (id_user_owner, name, example_image, price, description, nb_buyers) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING *";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id_user_owner);
            statement.setString(2, name);
            statement.setString(3, example_image);
            statement.setFloat(4, price);
            statement.setString(5, description);
            statement.setInt(6, nb_buyers);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToService(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Deletes a service by its ID.
     *
     * @param id_service The ID of the service to delete.
     * @return {@code true} if the service was deleted successfully, {@code false} otherwise.
     */
    @Override
    public boolean deleteService(int id_service) {
        String query = "DELETE FROM \"Service\" WHERE id_service = ?";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id_service);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Updates an existing service.
     *
     * @param id_service The ID of the service to update.
     * @param name The new name of the service.
     * @param example_image The new example image of the service.
     * @param price The new price of the service.
     * @param description The new description of the service.
     * @return A {@link Service} object if the service was updated successfully, or {@code null} if the update failed.
     */
    @Override
    public Service updateService(int id_service, String name, String example_image, float price, String description) {
        String query = "UPDATE \"Service\" SET name = ?, example_image = ?, price = ?, description = ? WHERE id_service = ? RETURNING *";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);
            statement.setString(2, example_image);
            statement.setFloat(3, price);
            statement.setString(4, description);
            statement.setInt(5, id_service);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToService(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Retrieves all services owned by a specific user.
     *
     * @param id_user_owner The ID of the user who owns the services.
     * @return A list of {@link Service} objects containing the details of the services.
     */
    @Override
    public List<Service> getAllServices(int id_user_owner) {
        String query = "SELECT * FROM \"Service\" WHERE id_user_owner = ?";
        List<Service> services = new ArrayList<>();

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id_user_owner);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                services.add(mapResultSetToService(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return services;
    }

    /**
     * Maps a {@link ResultSet} to a {@link Service} object.
     *
     * @param resultSet The {@link ResultSet} to map.
     * @return A {@link Service} object containing the details from the {@link ResultSet}.
     * @throws SQLException If an SQL error occurs while mapping the {@link ResultSet}.
     */
    private Service mapResultSetToService(ResultSet resultSet) throws SQLException {
        Service service = new Service();
        service.setIdService(resultSet.getInt("id_service"));
        service.setIdUserOwner(resultSet.getInt("id_user_owner"));
        service.setName(resultSet.getString("name"));
        service.setExampleImage(resultSet.getString("example_image"));
        service.setPrice(resultSet.getFloat("price"));
        service.setDescription(resultSet.getString("description"));
        service.setNbBuyers(resultSet.getInt("nb_buyers"));
        return service;
    }

    /**
     * Retrieves a service by its ID.
     *
     * @param serviceId The ID of the service to retrieve.
     * @return A {@link Service} object containing the service details, or {@code null} if no service is found.
     */
    @Override
    public Service getService(int serviceId) {
        String query = "SELECT * FROM \"Service\" WHERE id_service = ?";

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, serviceId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToService(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Return null if no service is found
    }
}