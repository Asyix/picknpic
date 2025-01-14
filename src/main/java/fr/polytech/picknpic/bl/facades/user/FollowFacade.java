package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.persist.AbstractFactory;

/**
 * The FollowFacade class provides a unified interface to follow-related operations
 * such as following, unfollowing, and checking follow status.
 * It follows the Singleton design pattern to ensure only one instance exists.
 */
public class FollowFacade {
    /** The singleton instance of the FollowFacade. */
    private static FollowFacade followFacade = null;

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /**
     * Constructs a new FollowFacade instance.
     * Private constructor to prevent instantiation.
     */
    private FollowFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the FollowFacade.
     * Ensures that only one instance of the FollowFacade exists throughout the application.
     *
     * @return The singleton instance of the FollowFacade.
     */
    public static FollowFacade getInstance() {
        if (followFacade == null) {
            followFacade = new FollowFacade();
        }
        return followFacade;
    }

    /**
     * Follows a user.
     * Delegates the follow operation to the DAO layer.
     *
     * @param idFollowed The ID of the user to be followed.
     * @param idFollower The ID of the user who is following.
     * @return true if the follow operation was successful, false otherwise.
     */
    public boolean followUser(int idFollowed, int idFollower) {
        return abstractFactory.createUserDAO().followUser(idFollowed, idFollower);
    }

    /**
     * Unfollows a user.
     * Delegates the unfollow operation to the DAO layer.
     *
     * @param idFollowed The ID of the user to be unfollowed.
     * @param idFollower The ID of the user who is unfollowing.
     * @return true if the unfollow operation was successful, false otherwise.
     */
    public boolean unfollowUser(int idFollowed, int idFollower) {
        return abstractFactory.createUserDAO().unfollowUser(idFollowed, idFollower);
    }

    /**
     * Checks if a user is following another user.
     * Delegates the check operation to the DAO layer.
     *
     * @param idFollowed The ID of the user being followed.
     * @param idFollower The ID of the user who is following.
     * @return true if the user is following, false otherwise.
     */
    public boolean isFollowing(int idFollowed, int idFollower) {
        return abstractFactory.createUserDAO().isFollowing(idFollowed, idFollower);
    }

    /**
     * Retrieves the IDs of users followed by a specific user.
     * Delegates the retrieval operation to the DAO layer.
     *
     * @param idFollower The ID of the user whose follows are being retrieved.
     * @return An array of IDs of users followed by the specified user.
     */
    public int[] getFollowsIds(int idFollower) {
        return abstractFactory.createUserDAO().getFollowsIds(idFollower);
    }
}