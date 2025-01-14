package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Grade;
import fr.polytech.picknpic.persist.JDBCConnector;
import fr.polytech.picknpic.persist.daos.GradeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * PostgreSQL implementation of the {@link GradeDAO} interface.
 * Provides methods for creating, deleting, and retrieving grades in the PostgreSQL database.
 */
public class GradeDAOPostgres implements GradeDAO {

    /**
     * Creates a new grade in the database.
     *
     * @param id_user_graded   The ID of the user being graded.
     * @param id_service_graded The ID of the service being graded.
     * @param friendliness     The friendliness rating.
     * @param rapidity         The rapidity rating.
     * @param quality          The quality rating.
     * @param avg_grade        The average grade calculated from the ratings.
     * @return The created {@link Grade} object, or {@code null} if creation failed.
     */
    @Override
    public Grade createGrade(int id_user_graded, int id_service_graded, int friendliness, int rapidity, int quality, float avg_grade) {
        Grade grade = null;
        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            String query = "INSERT INTO \"Grade\" (id_user_graded, id_service_graded, friendliness, rapidity, quality, avg_grade) " +
                    "VALUES (?, ?, ?, ?, ?, ?) RETURNING *";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id_user_graded);
            statement.setInt(2, id_service_graded);
            statement.setInt(3, friendliness);
            statement.setInt(4, rapidity);
            statement.setInt(5, quality);
            statement.setFloat(6, avg_grade);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                grade = mapResultSetToGrade(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    /**
     * Deletes an existing grade from the database.
     *
     * @param id_grade The ID of the grade to delete.
     * @return The deleted {@link Grade} object, or {@code null} if deletion failed.
     */
    @Override
    public Grade deleteGrade(int id_grade) {
        Grade grade = null;
        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            String query = "DELETE FROM \"Grade\" WHERE id_grade = ? RETURNING *";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id_grade);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                grade = new Grade();
                grade.setIdGrade(resultSet.getInt("id_grade"));
                grade.setIdUserGraded(resultSet.getInt("id_user_graded"));
                grade.setIdServiceGraded(resultSet.getInt("id_service_graded"));
                grade.setFriendliness(resultSet.getInt("friendliness"));
                grade.setRapidity(resultSet.getInt("rapidity"));
                grade.setQuality(resultSet.getInt("quality"));
                grade.setAvgGrade(resultSet.getFloat("avg_grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    /**
     * Retrieves all grades for a specific user from the database.
     *
     * @param id_user The ID of the user whose grades are to be retrieved.
     * @return A list of {@link Grade} objects containing the user's grades.
     */
    @Override
    public List<Grade> getAllGrades(int id_user) {
        List<Grade> grades = new ArrayList<>();
        try (Connection connection = JDBCConnector.getInstance().getConnection()) {
            String query = "SELECT * FROM \"Grade\" WHERE id_user_graded = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id_user);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                grades.add(mapResultSetToGrade(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    /**
     * Maps a {@link ResultSet} to a {@link Grade} object.
     *
     * @param resultSet The {@link ResultSet} to map.
     * @return A {@link Grade} object containing the details from the {@link ResultSet}.
     * @throws SQLException If an SQL error occurs while mapping the {@link ResultSet}.
     */
    private Grade mapResultSetToGrade(ResultSet resultSet) throws SQLException {
        Grade grade = new Grade();
        grade.setIdGrade(resultSet.getInt("id_grade"));
        grade.setIdUserGraded(resultSet.getInt("id_user_graded"));
        grade.setIdServiceGraded(resultSet.getInt("id_service_graded"));
        grade.setFriendliness(resultSet.getInt("friendliness"));
        grade.setRapidity(resultSet.getInt("rapidity"));
        grade.setQuality(resultSet.getInt("quality"));
        grade.setAvgGrade(resultSet.getFloat("avg_grade"));
        return grade;
    }
}