package fr.polytech.picknpic.bl.facades.like;

import fr.polytech.picknpic.bl.models.Like;
import fr.polytech.picknpic.persist.AbstractFactory;

import java.util.List;

public class LikeFacade {
    private static LikeFacade instance;

    private final AbstractFactory abstractFactory;

    private LikeFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the DisplayUsersFacade.
     * Ensures that only one instance of the DisplayUsersFacade exists throughout the application.
     * @return The singleton instance of the DisplayUsersFacade.
     */
    public static LikeFacade getInstance() {
        if (instance == null) {
            instance = new LikeFacade();
        }
        return instance;
    }

    public boolean addLike(Like like) {
        return abstractFactory.createLikeDAO().addLike(like);
    }

    public boolean removeLikeOnPost(int id_user, int id_post) {
        return abstractFactory.createLikeDAO().removeLikeOnPost(id_user, id_post);
    }

    public boolean removeLikeOnPhoto(int id_user, int id_photo) {
        return abstractFactory.createLikeDAO().removeLikeOnPhoto(id_user, id_photo);
    }

    public boolean removeLikeOnComment(int id_user, int id_comment) {
        return abstractFactory.createLikeDAO().removeLikeOnComment(id_user, id_comment);
    }

    public List<Like> getPostLikes(int idPost) {
        return abstractFactory.createLikeDAO().getPostLikes(idPost);
    }

    public List<Like> getPhotoLikes(int idPhoto) {
        return abstractFactory.createLikeDAO().getPhotoLikes(idPhoto);
    }

    public List<Like> getCommentLikes(int idComment) {
        return abstractFactory.createLikeDAO().getCommentLikes(idComment);
    }

}
