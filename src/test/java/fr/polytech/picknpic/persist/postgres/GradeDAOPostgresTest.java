package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.models.Grade;
import fr.polytech.picknpic.bl.models.Service;
import fr.polytech.picknpic.bl.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeDAOPostgresTest {
    private GradeDAOPostgres gradeDAOPostgres;
    private ServiceDAOPostgres serviceDAOPostgres;
    private User loggedInUser;
    private Service service;
    private Grade grade;

    @BeforeEach
    void setUp() {
        UserDAOPostgres userDAOPostgres = new UserDAOPostgres();
        loggedInUser = userDAOPostgres.login("admin", "password123");
        serviceDAOPostgres = new ServiceDAOPostgres();
        gradeDAOPostgres = new GradeDAOPostgres();
    }

    @AfterEach
    void tearDown() {
        gradeDAOPostgres.deleteGrade(grade.getIdGrade());
        serviceDAOPostgres.deleteService(service.getIdService());
    }

    @Test
    void createGrade() {
        service = serviceDAOPostgres.createService(loggedInUser.getId(), "Test Service", "Test Description", 5, "good", 5);

        grade = gradeDAOPostgres.createGrade(loggedInUser.getId(), service.getIdService(), 5, 5, 5, 5);
        assertNotNull(grade);
    }
}