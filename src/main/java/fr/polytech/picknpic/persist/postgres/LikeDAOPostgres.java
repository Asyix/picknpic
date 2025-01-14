package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Like;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.LikeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * PostgreSQL implementation of the {@link LikeDAO} interface.
 * Provides methods for managing likes by interacting with the PostgreSQL database.
 */
public class LikeDAOPostgres implements LikeDAO {

    /**
     * Adds a like to a post, photo, or comment in the PostgreSQL database.
     *
     * @param like The like to be added.
     * @return {@code true} if the like was added successfully, {@code false} otherwise.
     */
    @Override
    public boolean addLike(Like like) {
        String query = "INSERT INTO \"Like\" (user_id, post_id, photo_id, comment_id) " +
                "VALUES (?, ?, ?, ?)";
        String query2 = "";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);) {

            statement.setInt(1, like.getUserId());
            if (like.getPostId() != -1) {
                statement.setInt(2, like.getPostId());
                query2 = "UPDATE \"Posts\" SET nb_likes = nb_likes + 1 WHERE id = ?";
            } else {
                statement.setNull(2, java.sql.Types.INTEGER);
            }
            if (like.getPhotoId() != -1) {
                statement.setInt(3, like.getPhotoId());
                query2 = "UPDATE \"Photo\" SET nb_likes = nb_likes + 1 WHERE id = ?";
            } else {
                statement.setNull(3, java.sql.Types.INTEGER);
            }
            if (like.getCommentId() != -1) {
                statement.setInt(4, like.getCommentId());
                query2 = "UPDATE \"Comment\" SET nb_likes = nb_likes + 1 WHERE id = ?";
            } else {
                statement.setNull(4, java.sql.Types.INTEGER);
            }
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                try (PreparedStatement statement2 = connection.prepareStatement(query2)) {
                    statement2.setInt(1, like.getPostId());
                    return(statement2.executeUpdate() > 0);
                }
            }
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Removes a like from a post in the PostgreSQL database.
     *
     * @param user_id The ID of the user who liked the post.
     * @param post_id The ID of the post to remove the like from.
     * @return {@code true} if the like was removed successfully, {@code false} otherwise.
     */
    @Override
    public boolean removeLikeOnPost(int user_id, int post_id) {
        String deleteQuery = "DELETE FROM \"Like\" WHERE user_id = ? AND post_id = ?";
        String updateQuery = "UPDATE \"Posts\" SET nb_likes = nb_likes - 1 WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                 PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

                deleteStatement.setInt(1, user_id);
                deleteStatement.setInt(2, post_id);
                updateStatement.setInt(1, post_id);

                int rowsAffected = deleteStatement.executeUpdate();
                if (rowsAffected > 0) {
                    updateStatement.executeUpdate();
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Removes a like from a photo in the PostgreSQL database.
     *
     * @param user_id The ID of the user who liked the photo.
     * @param photo_id The ID of the photo to remove the like from.
     * @return {@code true} if the like was removed successfully, {@code false} otherwise.
     */
    @Override
    public boolean removeLikeOnPhoto(int user_id, int photo_id) {
        String deleteQuery = "DELETE FROM \"Like\" WHERE user_id = ? AND photo_id = ?";
        String updateQuery = "UPDATE \"Photo\" SET nb_likes = nb_likes - 1 WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                 PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

                deleteStatement.setInt(1, user_id);
                deleteStatement.setInt(2, photo_id);
                updateStatement.setInt(1, photo_id);

                int rowsAffected = deleteStatement.executeUpdate();
                if (rowsAffected > 0) {
                    updateStatement.executeUpdate();
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Removes a like from a comment in the PostgreSQL database.
     *
     * @param user_id The ID of the user who liked the comment.
     * @param comment_id The ID of the comment to remove the like from.
     * @return {@code true} if the like was removed successfully, {@code false} otherwise.
     */
    @Override
    public boolean removeLikeOnComment(int user_id, int comment_id) {
        String deleteQuery = "DELETE FROM \"Like\" WHERE user_id = ? AND comment_id = ?";
        String updateQuery = "UPDATE \"Comment\" SET nb_likes = nb_likes - 1 WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                 PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

                deleteStatement.setInt(1, user_id);
                deleteStatement.setInt(2, comment_id);
                updateStatement.setInt(1, comment_id);

                int rowsAffected = deleteStatement.executeUpdate();
                if (rowsAffected > 0) {
                    updateStatement.executeUpdate();
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves all likes for a specific post from the PostgreSQL database.
     *
     * @param idPost The ID of the post to retrieve likes for.
     * @return A list of {@link Like} objects containing the likes for the post.
     */
    @Override
    public List<Like> getPostLikes(int idPost) {
        List<Like> likes = new ArrayList<>();
        String query = "SELECT * FROM \"Like\" WHERE post_id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idPost);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                int postId = resultSet.getInt("post_id");
                likes.add(new Like(userId, postId, -1, -1));
            }
            return likes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Retrieves all likes for a specific photo from the PostgreSQL database.
     *
     * @param idPhoto The ID of the photo to retrieve likes for.
     * @return A list of {@link Like} objects containing the likes for the photo.
     */
    @Override
    public List<Like> getPhotoLikes(int idPhoto) {
        List<Like> likes = new ArrayList<>();
        String query = "SELECT * FROM \"Like\" WHERE photo_id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idPhoto);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                int photoId = resultSet.getInt("photo_id");
                likes.add(new Like(userId, -1, photoId, -1));
            }
            return likes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves all likes for a specific comment from the PostgreSQL database.
     *
     * @param idComment The ID of the comment to retrieve likes for.
     * @return A list of {@link Like} objects containing the likes for the comment.
     */
    @Override
    public List<Like> getCommentLikes(int idComment) {
        List<Like> likes = new ArrayList<>();
        String query = "SELECT * FROM \"Like\" WHERE comment_id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idComment);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                int commentId = resultSet.getInt("comment_id");
                likes.add(new Like(userId, -1, -1, commentId));
            }
            return likes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
