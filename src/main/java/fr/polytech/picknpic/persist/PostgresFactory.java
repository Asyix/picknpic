package fr.polytech.picknpic.persist;

public class PostgresFactory extends AbstractFactory {

    private static PostgresFactory postgresFactory;
    private static UserDAOPostgres userPostgres;

    // Private constructor to ensure controlled instantiation
    private PostgresFactory() {}

    public static PostgresFactory createPostgresFactory() {
        if (postgresFactory == null) {
            postgresFactory = new PostgresFactory();
        }
        return postgresFactory;
    }

    @Override
    public UserDAO createUserDAO() {
        return new UserDAOPostgres(); // DAO spécifique à PostgreSQL
    }
}
