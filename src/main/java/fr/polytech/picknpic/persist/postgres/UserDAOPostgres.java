package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOPostgres implements UserDAO {

    @Override
    public User login(String username, String password) {
        User user = null;

        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            String query = "SELECT * FROM \"User\" WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPhoneNumber(resultSet.getInt("phone_number"));
                user.setAdmin(resultSet.getBoolean("admin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
