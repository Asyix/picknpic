package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.facades.comment.CommentFacade;
import fr.polytech.picknpic.bl.facades.like.LikeFacade;
import fr.polytech.picknpic.bl.facades.user.FollowFacade;
import fr.polytech.picknpic.bl.facades.user.UserFacade;
import fr.polytech.picknpic.bl.models.Post;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.PostDAO;
import javafx.geometry.Pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAOPostgres implements PostDAO {
    @Override
    public boolean createPost(Post post) {
        String query = "INSERT INTO \"Posts\" (id_user, text, nb_likes, nb_comments, creation_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, post.getUserId());
            preparedStatement.setString(2, post.getText());
            preparedStatement.setInt(3, post.getNbLikes());
            preparedStatement.setInt(4, post.getNbComments());
            preparedStatement.setDate(5, new java.sql.Date(post.getCreationDate().getTime()));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updatePost(Post post) {
        String query = "UPDATE \"Posts\" SET text = ? WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, post.getText());
            preparedStatement.setInt(2, post.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deletePost(int postId) {
        String query = "DELETE FROM \"Posts\" WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, postId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Post getPost(int postId) {
        String query = "SELECT * FROM \"Posts\" WHERE id = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, postId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Post(
                            resultSet.getInt("id"),
                            resultSet.getInt("id_user"),
                            resultSet.getString("text"),
                            resultSet.getInt("nb_likes"),
                            resultSet.getInt("nb_comments"),
                            resultSet.getDate("creation_date"),
                            CommentFacade.getInstance().getPostComments(postId),
                            LikeFacade.getInstance().getPostLikes(postId)
                    );
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Post> getUserPosts(int userId) {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM \"Posts\" WHERE id_user = ?";
        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    posts.add(new Post(
                            resultSet.getInt("id"),
                            resultSet.getInt("id_user"),
                            resultSet.getString("text"),
                            resultSet.getInt("nb_likes"),
                            resultSet.getInt("nb_comments"),
                            resultSet.getDate("creation_date"),
                            CommentFacade.getInstance().getPostComments(resultSet.getInt("id")),
                            LikeFacade.getInstance().getPostLikes(resultSet.getInt("id"))
                    ));
                }
                return posts;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Post> getFollowersPosts(int userId) {
        List<Post> posts = new ArrayList<>();
        int[] followsIds = FollowFacade.getInstance().getFollowsIds(userId);

        if (followsIds.length == 0) {
            return posts;
        }

        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM \"Posts\" WHERE id_user IN (");
        for (int i = 0; i < followsIds.length; i++) {
            queryBuilder.append("?");
            if (i < followsIds.length - 1) {
                queryBuilder.append(", ");
            }
        }
        queryBuilder.append(") ORDER BY creation_date DESC LIMIT 50");

        try (Connection connection = JDBCConnector.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryBuilder.toString())) {
            for (int i = 0; i < followsIds.length; i++) {
                preparedStatement.setInt(i + 1, followsIds[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    posts.add(new Post(
                            resultSet.getInt("id"),
                            resultSet.getInt("id_user"),
                            resultSet.getString("text"),
                            resultSet.getInt("nb_likes"),
                            resultSet.getInt("nb_comments"),
                            resultSet.getDate("creation_date"),
                            CommentFacade.getInstance().getPostComments(resultSet.getInt("id")),
                            LikeFacade.getInstance().getPostLikes(resultSet.getInt("id"))
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return posts;
    }
}
