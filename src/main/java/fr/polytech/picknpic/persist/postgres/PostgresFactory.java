package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.UserDAO;

/**
 * A factory class for creating PostgreSQL-specific DAO implementations.
 * Extends the {@link AbstractFactory} and provides PostgreSQL-specific DAOs.
 */
public class PostgresFactory extends AbstractFactory {

    /** Singleton instance of the PostgresFactory. */
    private static PostgresFactory postgresFactory;

    /** Singleton instance of the PostgreSQL-specific UserDAO implementation. */
    private static UserDAOPostgres userDAOPostgres;

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
}
