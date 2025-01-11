package fr.polytech.picknpic.persist;

import fr.polytech.picknpic.persist.daos.UserDAO;
import fr.polytech.picknpic.persist.daos.RequestDAO;
import fr.polytech.picknpic.persist.daos.ServiceDAO;
import fr.polytech.picknpic.persist.daos.GradeDAO;
import fr.polytech.picknpic.persist.daos.SubscriptionDAO;
import fr.polytech.picknpic.persist.daos.NotificationDAO;
import fr.polytech.picknpic.persist.daos.PhotoDAO;
import fr.polytech.picknpic.persist.daos.PurchaseDAO;
import fr.polytech.picknpic.persist.postgres.PostgresFactory;

/**
 * An abstract factory class for creating Data Access Object (DAO) instances.
 * Implements the Singleton design pattern to ensure only one factory instance exists.
 * Provides an abstraction for different database implementations (e.g., PostgreSQL).
 */
public abstract class AbstractFactory {

    /** The singleton instance of the AbstractFactory. */
    private static AbstractFactory abstractFactory;

    /**
     * Protected constructor to prevent direct instantiation of the abstract class.
     */
    protected AbstractFactory() {}

    /**
     * Retrieves the singleton instance of the AbstractFactory.
     * Defaults to a {@link PostgresFactory} implementation.
     *
     * @return The singleton instance of {@link AbstractFactory}.
     */
    public static AbstractFactory getInstance() {
        if (abstractFactory == null) {
            abstractFactory = PostgresFactory.getPostgresFactoryInstance(); // Default factory (PostgreSQL)
        }
        return abstractFactory;
    }

    /**
     * Abstract method to create a {@link UserDAO}.
     * Must be implemented by subclasses to provide a specific DAO implementation.
     *
     * @return A {@link UserDAO} instance.
     */
    public abstract UserDAO createUserDAO();

    /**
     * Abstract method to create a {@link RequestDAO}.
     * Must be implemented by subclasses to provide a specific DAO implementation.
     *
     * @return A {@link RequestDAO} instance.
     */
    public abstract RequestDAO createRequestDAO();

    /**
     * Abstract method to create a {@link ServiceDAO}.
     * Must be implemented by subclasses to provide a specific DAO implementation.
     *
     * @return A {@link ServiceDAO} instance.
     */
    public abstract ServiceDAO createServiceDAO();

    /**
     * Abstract method to create a {@link GradeDAO}.
     * Must be implemented by subclasses to provide a specific DAO implementation.
     *
     * @return A {@link GradeDAO} instance.
     */
    public abstract GradeDAO createGradeDAO();

    /**
     * Abstract method to create a {@link SubscriptionDAO}.
     * Must be implemented by subclasses to provide a specific DAO implementation.
     *
     * @return A {@link SubscriptionDAO} instance.
     */
    public abstract SubscriptionDAO createSubscriptionDAO();

    /**
     * Abstract method to create a {@link NotificationDAO}.
     * Must be implemented by subclasses to provide a specific DAO implementation.
     *
     * @return A {@link NotificationDAO} instance.
     */
    public abstract NotificationDAO createNotificationDAO();

    /**
     * Abstract method to create a {@link PhotoDAO}.
     * Must be implemented by subclasses to provide a specific DAO implementation.
     *
     * @return A {@link PhotoDAO} instance.
     */
    public abstract PhotoDAO createPhotoDAO();

    /**
     * Abstract method to create a {@link PurchaseDAO}.
     * Must be implemented by subclasses to provide a specific DAO implementation.
     *
     * @return A {@link PurchaseDAO} instance.
     */
    public abstract PurchaseDAO createPurchaseDAO();

}
