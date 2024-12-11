package fr.polytech.picknpic.persist;

public abstract class AbstractFactory {

    // Singleton instance
    private static AbstractFactory abstractFactory;

    // Protected constructor to prevent direct instantiation
    protected AbstractFactory() {}

    // Static method to get the singleton instance
    public static AbstractFactory createAbstractFactory() {
        if (abstractFactory == null) {
            abstractFactory = PostgresFactory.createPostgresFactory(); // Default factory (PostgreSQL)
        }
        return abstractFactory;
    }

    // Abstract method to create a UserDAO
    public abstract UserDAO createUserDAO();
}
