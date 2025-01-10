package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.persist.AbstractFactory;

public class FollowFacade {
    private static FollowFacade followFacade = null;

    private final AbstractFactory abstractFactory;

    private FollowFacade() { this.abstractFactory = AbstractFactory.getInstance(); }

    public static FollowFacade getInstance() {
        if (followFacade == null) {
            followFacade = new FollowFacade();
        }
        return followFacade;
    }

    public boolean followUser(int idFollowed, int idFollower) {
        return abstractFactory.createUserDAO().followUser(idFollowed, idFollower);
    }

    public boolean unfollowUser(int idFollowed, int idFollower) {
        return abstractFactory.createUserDAO().unfollowUser(idFollowed, idFollower);
    }

    public boolean isFollowing(int idFollowed, int idFollower) {
        return abstractFactory.createUserDAO().isFollowing(idFollowed, idFollower);
    }
}
