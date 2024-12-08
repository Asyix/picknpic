package fr.polytech.picknpic.persist;

public abstract class AbstractUserFactory {

    // Singleton instance
    private static AbstractUserFactory instance;

    // Protected constructor to prevent direct instantiation
    protected AbstractUserFactory() {}

    // Static method to get the singleton instance
    public static AbstractUserFactory getInstance() {
        if (instance == null) {
            instance = new PostgresFactory(); // Default factory (PostgreSQL)
        }
        return instance;
    }

    // Abstract method to create a UserDAO
    public abstract UserDAO createUserDAO();
}
