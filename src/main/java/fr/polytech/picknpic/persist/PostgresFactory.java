package fr.polytech.picknpic.persist;

public class PostgresFactory extends AbstractFactory {

    private static PostgresFactory postgresFactory;
    private static UserDAOPostgres userDAOPostgres;

    // Private constructor to ensure controlled instantiation
    private PostgresFactory() {}

    public static PostgresFactory getPostgresFactoryInstance() {
        return new PostgresFactory();
    }

    @Override
    public UserDAO createUserDAO() {
        return new UserDAOPostgres(); // DAO spécifique à PostgreSQL
    }
}
