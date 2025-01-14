package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Comment;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.CommentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * PostgreSQL implementation of the {@link CommentDAO} interface.
 * Provides methods for managing comments by interacting with the PostgreSQL database.
 */
public class CommentDAOPostgres implements CommentDAO {

    /**
     * Retrieves all comments for a specific post from the PostgreSQL database.
     *
     * @param postId The ID of the post to retrieve comments for.
     * @return A list of {@link Comment} objects containing the comments for the post.
     */
    @Override
    public List<Comment> getPostComments(int postId) {
        List<Comment> comments = new ArrayList<>();
        String query = "SELECT * FROM \"Comment\" WHERE id_post = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, postId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment(resultSet.getInt("id"),
                        resultSet.getInt("id_user"),
                        resultSet.getInt("id_post"),
                        resultSet.getInt("id_photo"),
                        resultSet.getInt("id_comment"),
                        resultSet.getString("text"),
                        resultSet.getInt("nb_likes"),
                        resultSet.getInt("nb_replies"),
                        resultSet.getDate("creation_date"),
                        getCommentReplies(resultSet.getInt("id")));
                comments.add(comment);
            }
            return comments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves all comments for a specific photo from the PostgreSQL database.
     *
     * @param photoId The ID of the photo to retrieve comments for.
     * @return A list of {@link Comment} objects containing the comments for the photo.
     */
    @Override
    public List<Comment> getPhotoComments(int photoId) {
        List<Comment> comments = new ArrayList<>();
        String query = "SELECT * FROM \"Comment\" WHERE id_photo = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, photoId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment(resultSet.getInt("id"),
                        resultSet.getInt("id_user"),
                        resultSet.getInt("id_post"),
                        resultSet.getInt("id_photo"),
                        resultSet.getInt("id_comment"),
                        resultSet.getString("text"),
                        resultSet.getInt("nb_likes"),
                        resultSet.getInt("nb_replies"),
                        resultSet.getDate("creation_date"),
                        getCommentReplies(resultSet.getInt("id")));
                comments.add(comment);
            }
            return comments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves all replies for a specific comment from the PostgreSQL database.
     *
     * @param commentId The ID of the comment to retrieve replies for.
     * @return A list of {@link Comment} objects containing the replies for the comment.
     */
    @Override
    public List<Comment> getCommentReplies(int commentId) {
        List<Comment> comments = new ArrayList<>();
        String query = "SELECT * FROM \"Comment\" WHERE id_comment = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, commentId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment(resultSet.getInt("id"),
                        resultSet.getInt("id_user"),
                        resultSet.getInt("id_post"),
                        resultSet.getInt("id_photo"),
                        resultSet.getString("text"),
                        resultSet.getInt("nb_likes"),
                        resultSet.getInt("nb_replies"),
                        resultSet.getDate("creation_date"));
                comments.add(comment);
            }
            return comments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a new comment in the PostgreSQL database.
     *
     * @param comment The comment to be created.
     * @return {@code true} if the comment was created successfully, {@code false} otherwise.
     */
    @Override
    public boolean createComment(Comment comment) {
        String query = "INSERT INTO \"Comment\" (id_user, id_post, id_photo, id_comment, text, nb_likes, creation_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String updateQuery = "";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, comment.getUserId());
            if (comment.getPostId() != -1) {
                statement.setInt(2, comment.getPostId());
                updateQuery = "UPDATE \"Posts\" SET nb_comments = nb_comments + 1 WHERE id = ?";
            } else {
                statement.setNull(2, java.sql.Types.INTEGER);
            }
            if (comment.getPhotoId() != -1) {
                statement.setInt(3, comment.getPhotoId());
                updateQuery = "UPDATE \"Photo\" SET nb_comments = nb_comments + 1 WHERE id = ?";
            } else {
                statement.setNull(3, java.sql.Types.INTEGER);
            }
            if (comment.getCommentId() != -1) {
                statement.setInt(4, comment.getCommentId());
                updateQuery = "UPDATE \"Comment\" SET nb_replies = nb_replies + 1 WHERE id = ?";
            } else {
                statement.setNull(4, java.sql.Types.INTEGER);
            }
            statement.setString(5, comment.getText());
            statement.setInt(6, comment.getNbLikes());
            statement.setDate(7, new java.sql.Date(comment.getCreationDate().getTime()));

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                    if (comment.getPostId() != -1) {
                        updateStatement.setInt(1, comment.getPostId());
                    } else if (comment.getPhotoId() != -1) {
                        updateStatement.setInt(1, comment.getPhotoId());
                    } else if (comment.getCommentId() != -1) {
                        updateStatement.setInt(1, comment.getCommentId());
                    }
                    return updateStatement.executeUpdate() > 0;
                }
            }
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Updates an existing comment in the PostgreSQL database.
     *
     * @param comment The comment with updated details.
     * @return {@code true} if the comment was updated successfully, {@code false} otherwise.
     */
    @Override
    public boolean updateComment(Comment comment) {
        String query = "UPDATE \"Comment\" SET text = ? WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, comment.getText());
            statement.setInt(2, comment.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes a comment from the PostgreSQL database.
     *
     * @param commentId The unique identifier of the comment to be deleted.
     * @return {@code true} if the comment was deleted successfully, {@code false} otherwise.
     */
    @Override
    public boolean deleteComment(int commentId) {
        String deleteQuery = "DELETE FROM \"Comment\" WHERE id = ?";
        String updateQuery = "";
        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setInt(1, commentId);

                int rowsAffected = deleteStatement.executeUpdate();
                if (rowsAffected > 0) {
                    // Determine which entity to update based on the comment's relationships
                    String selectQuery = "SELECT id_post, id_photo, id_comment FROM \"Comment\" WHERE id = ?";
                    try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
                        selectStatement.setInt(1, commentId);
                        ResultSet resultSet = selectStatement.executeQuery();
                        if (resultSet.next()) {
                            int postId = resultSet.getInt("id_post");
                            int photoId = resultSet.getInt("id_photo");
                            int parentCommentId = resultSet.getInt("id_comment");

                            if (postId != 0) {
                                updateQuery = "UPDATE \"Posts\" SET nb_comments = nb_comments - 1 WHERE id = ?";
                            } else if (photoId != 0) {
                                updateQuery = "UPDATE \"Photo\" SET nb_comments = nb_comments - 1 WHERE id = ?";
                            } else if (parentCommentId != 0) {
                                updateQuery = "UPDATE \"Comment\" SET nb_replies = nb_replies - 1 WHERE id = ?";
                            }

                            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                                if (postId != 0) {
                                    updateStatement.setInt(1, postId);
                                } else if (photoId != 0) {
                                    updateStatement.setInt(1, photoId);
                                } else if (parentCommentId != 0) {
                                    updateStatement.setInt(1, parentCommentId);
                                }
                                updateStatement.executeUpdate();
                            }
                        }
                    }
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
}
