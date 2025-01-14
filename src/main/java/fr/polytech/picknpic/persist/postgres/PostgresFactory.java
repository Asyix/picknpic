package fr.polytech.picknpic.persist.postgres;

import fr.polytech.picknpic.bl.facades.post.PostFacade;
import fr.polytech.picknpic.persist.AbstractFactory;
import fr.polytech.picknpic.persist.daos.*;
import fr.polytech.picknpic.persist.daos.UserDAO;
import fr.polytech.picknpic.persist.daos.RequestDAO;
import fr.polytech.picknpic.persist.daos.ServiceDAO;
import fr.polytech.picknpic.persist.daos.GradeDAO;
import fr.polytech.picknpic.persist.daos.SubscriptionDAO;
import fr.polytech.picknpic.persist.daos.NotificationDAO;
import fr.polytech.picknpic.persist.daos.PurchaseDAO;
import fr.polytech.picknpic.persist.daos.PhotoDAO;

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

    /** Singleton instance of the PostgreSQL-specific LikeDAO implementation. */
    private static LikeDAOPostgres likeDAOPostgres;

    /** Singleton instance of the PostgreSQL-specific SubscriptionDAO implementation. */
    private static SubscriptionDAOPostgres subscriptionDAOPostgres;

    /** Singleton instance of the PostgreSQL-specific NotificationDAO implementation. */
    private static NotificationDAOPostgres notificationDAOPostgres;

    /** Singleton instance of the PostgreSQL-specific PhotoDAO implementation. */
    private static PhotoDAOPostgres photoDAOPostgres;

    /** Singleton instance of the PostgreSQL-specific PurchaseDAO implementation. */
    private static PurchaseDAOPostgres purchaseDAOPostgres;

    private static PostDAOPostgres postDAOPostgres;

    private static CommentDAOPostgres commentDAOPostgres;

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

    @Override
    public LikeDAO createLikeDAO() {
        if (likeDAOPostgres == null) {
            likeDAOPostgres = new LikeDAOPostgres();
        }
        return likeDAOPostgres;
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

    /**
     * Creates a PostgreSQL-specific implementation of the {@link NotificationDAO}.
     *
     * @return A {@link NotificationDAOPostgres} instance.
     */
    @Override
    public NotificationDAO createNotificationDAO() {
        if (notificationDAOPostgres == null) {
            notificationDAOPostgres = new NotificationDAOPostgres();
        }
        return notificationDAOPostgres;
    }

    /**
     * Creates a PostgreSQL-specific implementation of the {@link PhotoDAO}.
     *
     * @return A {@link PhotoDAOPostgres} instance.
     */
    @Override
    public PhotoDAO createPhotoDAO() {
        if (photoDAOPostgres == null) {
            photoDAOPostgres = new PhotoDAOPostgres();
        }
        return photoDAOPostgres;
    }

    /**
     * Creates a PostgreSQL-specific implementation of the {@link PurchaseDAO}.
     *
     * @return A {@link PurchaseDAOPostgres} instance.
     */
    @Override
    public PurchaseDAO createPurchaseDAO() {
        if (purchaseDAOPostgres == null) {
            purchaseDAOPostgres = new PurchaseDAOPostgres();
        }
        return purchaseDAOPostgres;
    }

    /**
     * Creates a PostgreSQL-specific implementation of the {@link CommentDAO}.
     *
     * @return A {@link CommentDAOPostgres} instance.
     */
    @Override
    public CommentDAO createCommentDAO() {
        if (commentDAOPostgres == null) {
            commentDAOPostgres = new CommentDAOPostgres();
        }
        return commentDAOPostgres;
    }

    /**
     * Creates a PostgreSQL-specific implementation of the {@link PostDAO}.
     *
     * @return A {@link PostDAOPostgres} instance.
     */
    @Override
    public PostDAO createPostDAO() {
        if (postDAOPostgres == null) {
            postDAOPostgres = new PostDAOPostgres();
        }
        return postDAOPostgres;
    }

}
