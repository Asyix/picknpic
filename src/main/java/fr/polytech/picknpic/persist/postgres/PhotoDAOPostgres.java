package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Photo;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.PhotoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PostgreSQL implementation of the PhotoDAO interface.
 * Handles database operations for the Photo entity.
 */
public class PhotoDAOPostgres implements PhotoDAO {

    /**
     * Publishes a new photo by inserting it into the database.
     *
     * @param photo The photo to be published.
     */
    @Override
    public void publishPhoto(Photo photo) {
        String query = "INSERT INTO \"Photo\" (title, description, price, user_id, upload_date, url, is_for_sale, is_for_subscribers_only, nb_likes) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, photo.getTitle());
            statement.setString(2, photo.getDescription());
            statement.setInt(3, photo.getPrice());
            statement.setInt(4, photo.getUserId());
            statement.setDate(5, new java.sql.Date(photo.getUploadDate().getTime()));
            statement.setString(6, photo.getUrl());
            statement.setBoolean(7, photo.getIsForSale());
            statement.setBoolean(8, photo.getIsForSubscribersOnly());
            statement.setInt(9, photo.getNbLikes());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error while publishing photo", e);
        }
    }

    /**
     * Updates the details of an existing photo in the database.
     *
     * @param photo The photo with updated information.
     */
    @Override
    public void updatePhoto(Photo photo) {
        String query = "UPDATE \"Photo\" SET title = ?, description = ?, price = ?, url = ?, is_for_sale = ?, is_for_subscribers_only = ?, nb_likes = ? " +
                "WHERE photo_id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, photo.getTitle());
            statement.setString(2, photo.getDescription());
            statement.setInt(3, photo.getPrice());
            statement.setString(4, photo.getUrl());
            statement.setBoolean(5, photo.getIsForSale());
            statement.setBoolean(6, photo.getIsForSubscribersOnly());
            statement.setInt(7, photo.getNbLikes());
            statement.setInt(8, photo.getPhotoId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error while updating photo", e);
        }
    }

    /**
     * Deletes a photo from the database by its ID.
     *
     * @param photoId The ID of the photo to be deleted.
     */
    @Override
    public void deletePhoto(int photoId) {
        String query = "DELETE FROM \"Photo\" WHERE photo_id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, photoId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting photo", e);
        }
    }

    /**
     * Retrieves a photo by its ID.
     *
     * @param photoId The ID of the photo to be retrieved.
     * @return The photo object corresponding to the ID, or null if not found.
     */
    @Override
    public Photo getPhotoById(int photoId) {
        String query = "SELECT * FROM \"Photo\" WHERE photo_id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, photoId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Photo photo = new Photo();
                    photo.setPhotoId(resultSet.getInt("photo_id"));
                    photo.setTitle(resultSet.getString("title"));
                    photo.setDescription(resultSet.getString("description"));
                    photo.setPrice(resultSet.getInt("price"));
                    photo.setUserId(resultSet.getInt("user_id"));
                    photo.setUploadDate(resultSet.getDate("upload_date"));
                    photo.setUrl(resultSet.getString("url"));
                    photo.setIsForSale(resultSet.getBoolean("is_for_sale"));
                    photo.setIsForSubscribersOnly(resultSet.getBoolean("is_for_subscribers_only"));
                    photo.setNbLikes(resultSet.getInt("nb_likes"));
                    return photo;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while fetching photo by ID", e);
        }
        return null;
    }

    /**
     * Retrieves all photos from the database.
     *
     * @return A list of all photos in the database.
     */
    @Override
    public List<Photo> getAllPhotos() {
        String query = "SELECT * FROM \"Photo\"";
        List<Photo> photos = new ArrayList<>();
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Photo photo = new Photo();
                photo.setPhotoId(resultSet.getInt("photo_id"));
                photo.setTitle(resultSet.getString("title"));
                photo.setDescription(resultSet.getString("description"));
                photo.setPrice(resultSet.getInt("price"));
                photo.setUserId(resultSet.getInt("user_id"));
                photo.setUploadDate(resultSet.getDate("upload_date"));
                photo.setUrl(resultSet.getString("url"));
                photo.setIsForSale(resultSet.getBoolean("is_for_sale"));
                photo.setIsForSubscribersOnly(resultSet.getBoolean("is_for_subscribers_only"));
                photo.setNbLikes(resultSet.getInt("nb_likes"));
                photos.add(photo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while fetching all photos", e);
        }
        return photos;
    }
}
