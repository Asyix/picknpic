package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Like;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.LikeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikeDAOPostgres implements LikeDAO {

    @Override
    public boolean addLike(Like like) {
        String query = "INSERT INTO \"Like\" (id_user, id_post, id_photo, id_comment) " +
                "VALUES (?, ?, ?, ?)";
        String query2 = "";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query);) {

            statement.setInt(1, like.getUserId());
            if (like.getPostId() != -1) {
                statement.setInt(2, like.getPostId());
                query2 = "UPDATE \"Post\" SET nb_likes = nb_likes + 1 WHERE id = ?";
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


    @Override
    public boolean removeLikeOnPost(int id_user, int id_post) {
        String deleteQuery = "DELETE FROM \"Like\" WHERE id_user = ? AND id_post = ?";
        String updateQuery = "UPDATE \"Post\" SET nb_likes = nb_likes - 1 WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                 PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

                deleteStatement.setInt(1, id_user);
                deleteStatement.setInt(2, id_post);
                updateStatement.setInt(1, id_post);

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

    @Override
    public boolean removeLikeOnPhoto(int id_user, int id_photo) {
        String deleteQuery = "DELETE FROM \"Like\" WHERE id_user = ? AND id_photo = ?";
        String updateQuery = "UPDATE \"Photo\" SET nb_likes = nb_likes - 1 WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                 PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

                deleteStatement.setInt(1, id_user);
                deleteStatement.setInt(2, id_photo);
                updateStatement.setInt(1, id_photo);

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

    @Override
    public boolean removeLikeOnComment(int id_user, int id_comment) {
        String deleteQuery = "DELETE FROM \"Like\" WHERE id_user = ? AND id_comment = ?";
        String updateQuery = "UPDATE \"Comment\" SET nb_likes = nb_likes - 1 WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                 PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

                deleteStatement.setInt(1, id_user);
                deleteStatement.setInt(2, id_comment);
                updateStatement.setInt(1, id_comment);

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

    @Override
    public List<Like> getPostLikes(int idPost) {
        List<Like> likes = new ArrayList<>();
        String query = "SELECT * FROM \"Like\" WHERE id_post = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idPost);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("id_user");
                int postId = resultSet.getInt("id_post");
                likes.add(new Like(userId, postId, -1, -1));
            }
            return likes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Like> getPhotoLikes(int idPhoto) {
        List<Like> likes = new ArrayList<>();
        String query = "SELECT * FROM \"Like\" WHERE id_photo = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idPhoto);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("id_user");
                int photoId = resultSet.getInt("id_photo");
                likes.add(new Like(userId, -1, photoId, -1));
            }
            return likes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Like> getCommentLikes(int idComment) {
        List<Like> likes = new ArrayList<>();
        String query = "SELECT * FROM \"Like\" WHERE id_comment = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idComment);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("id_user");
                int commentId = resultSet.getInt("id_comment");
                likes.add(new Like(userId, -1, -1, commentId));
            }
            return likes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
