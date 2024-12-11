package fr.polytech.picknpic.persist;

public abstract class AbstractFactory {

    // Singleton instance
    private static AbstractFactory abstractFactory;

    // Protected constructor to prevent direct instantiation
    protected AbstractFactory() {}

    // Static method to get the singleton instance
    public static AbstractFactory getAbstractFactoryInstance() {
        if (abstractFactory == null) {
            abstractFactory = PostgresFactory.getPostgresFactoryInstance(); // Default factory (PostgreSQL)
        }
        return abstractFactory;
    }

    // Abstract method to create a UserDAO
    public abstract UserDAO createUserDAO();
}
