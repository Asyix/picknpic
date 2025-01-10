package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.UserDAO;
import fr.polytech.picknpic.persist.daos.RequestDAO;
import fr.polytech.picknpic.persist.daos.ServiceDAO;
import fr.polytech.picknpic.persist.daos.GradeDAO;
import fr.polytech.picknpic.persist.daos.SubscriptionDAO;

/**
 * A factory class for creating PostgreSQL-specific DAO implementations.
 * Extends the {@link AbstractFactory} and provides PostgreSQL-specific DAOs.
 */
public class PostgresFactory extends AbstractFactory {

    /** Singleton instance of the PostgresFactory. */
    private static PostgresFactory postgresFactory;

    /** Singleton instance of the PostgreSQL-specific UserDAO implementation. */
    private static UserDAOPostgres userDAOPostgres;

    /** Singleton instance of the PostgreSQL-specific RequestDAO implementation. */
    private static RequestDAOPostgres requestDAOPostgres;

    /** Singleton instance of the PostgreSQL-specific ServiceDAO implementation. */
    private static ServiceDAOPostgres serviceDAOPostgres;

    /** Singleton instance of the PostgreSQL-specific GradeDAO implementation. */
    private static GradeDAOPostgres gradeDAOPostgres;

    /** Singleton instance of the PostgreSQL-specific SubscriptionDAO implementation. */
    private static SubscriptionDAOPostgres subscriptionDAOPostgres;

    /**
     * Private constructor to ensure controlled instantiation of the factory.
     */
    private PostgresFactory() {}

    /**
     * Retrieves the singleton instance of the PostgresFactory.
     *
     * @return The singleton instance of {@link PostgresFactory}.
     */
    public static PostgresFactory getPostgresFactoryInstance() {
        if (postgresFactory == null) {
            postgresFactory = new PostgresFactory();
        }
        return postgresFactory;
    }

    /**
     * Creates a PostgreSQL-specific implementation of the {@link UserDAO}.
     *
     * @return A {@link UserDAOPostgres} instance.
     */
    @Override
    public UserDAO createUserDAO() {
        if (userDAOPostgres == null) {
            userDAOPostgres = new UserDAOPostgres();
        }
        return userDAOPostgres;
    }

    /**
     * Creates a PostgreSQL-specific implementation of the {@link RequestDAO}.
     *
     * @return A {@link RequestDAOPostgres} instance.
     */
    @Override
    public RequestDAO createRequestDAO() {
        if (requestDAOPostgres == null) {
            requestDAOPostgres = new RequestDAOPostgres();
        }
        return requestDAOPostgres;
    }

    /**
     * Creates a PostgreSQL-specific implementation of the {@link ServiceDAO}.
     *
     * @return A {@link ServiceDAOPostgres} instance.
     */
    @Override
    public ServiceDAO createServiceDAO() {
        if (serviceDAOPostgres == null) {
            serviceDAOPostgres = new ServiceDAOPostgres();
        }
        return serviceDAOPostgres;
    }

    /**
     * Creates a PostgreSQL-specific implementation of the {@link GradeDAO}.
     *
     * @return A {@link GradeDAOPostgres} instance.
     */
    @Override
    public GradeDAO createGradeDAO() {
        if (gradeDAOPostgres == null) {
            gradeDAOPostgres = new GradeDAOPostgres();
        }
        return gradeDAOPostgres;
    }

    /**
     * Creates a PostgreSQL-specific implementation of the {@link SubscriptionDAO}.
     *
     * @return A {@link SubscriptionDAOPostgres} instance.
     */
    @Override
    public SubscriptionDAO createSubscriptionDAO() {
        if (subscriptionDAOPostgres == null) {
            subscriptionDAOPostgres = new SubscriptionDAOPostgres();
        }
        return subscriptionDAOPostgres;
    }

}
