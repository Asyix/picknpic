package fr.polytech.picknpic.login;

public class PostgresFactory extends AbstractUserFactory {

    // Private constructor to ensure controlled instantiation
    protected PostgresFactory() {}

    @Override
    public UserDAO createUserDAO() {
        return new UserPostgres(); // DAO spécifique à PostgreSQL
    }
}
