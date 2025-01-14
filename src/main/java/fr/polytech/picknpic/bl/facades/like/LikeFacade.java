package fr.polytech.picknpic.bl.facades.like;

import fr.polytech.picknpic.bl.models.Like;
import fr.polytech.picknpic.persist.AbstractFactory;

import java.util.List;

/**
 * The LikeFacade class provides a unified interface to like management operations
 * such as adding, removing, and retrieving likes on posts, photos, and comments.
 * It follows the Singleton design pattern to ensure only one instance exists.
 */
public class LikeFacade {
    /** The singleton instance of the LikeFacade. */
    private static LikeFacade instance;

    /** The abstract factory used to create DAO instances. */
    private final AbstractFactory abstractFactory;

    /**
     * Constructs a new LikeFacade instance.
     * Private constructor to prevent instantiation.
     */
    private LikeFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the LikeFacade.
     * Ensures that only one instance of the LikeFacade exists throughout the application.
     *
     * @return The singleton instance of the LikeFacade.
     */
    public static LikeFacade getInstance() {
        if (instance == null) {
            instance = new LikeFacade();
        }
        return instance;
    }

    /**
     * Adds a like.
     * Delegates the add operation to the DAO layer.
     *
     * @param like The {@link Like} object containing the like details.
     * @return true if the like was added successfully, false otherwise.
     */
    public boolean addLike(Like like) {
        return abstractFactory.createLikeDAO().addLike(like);
    }

    /**
     * Removes a like from a post.
     * Delegates the remove operation to the DAO layer.
     *
     * @param id_user The ID of the user who liked the post.
     * @param id_post The ID of the post to remove the like from.
     * @return true if the like was removed successfully, false otherwise.
     */
    public boolean removeLikeOnPost(int id_user, int id_post) {
        return abstractFactory.createLikeDAO().removeLikeOnPost(id_user, id_post);
    }

    /**
     * Removes a like from a photo.
     * Delegates the remove operation to the DAO layer.
     *
     * @param id_user The ID of the user who liked the photo.
     * @param id_photo The ID of the photo to remove the like from.
     * @return true if the like was removed successfully, false otherwise.
     */
    public boolean removeLikeOnPhoto(int id_user, int id_photo) {
        return abstractFactory.createLikeDAO().removeLikeOnPhoto(id_user, id_photo);
    }

    /**
     * Removes a like from a comment.
     * Delegates the remove operation to the DAO layer.
     *
     * @param id_user The ID of the user who liked the comment.
     * @param id_comment The ID of the comment to remove the like from.
     * @return true if the like was removed successfully, false otherwise.
     */
    public boolean removeLikeOnComment(int id_user, int id_comment) {
        return abstractFactory.createLikeDAO().removeLikeOnComment(id_user, id_comment);
    }

    /**
     * Retrieves likes on a post.
     * Delegates the retrieval operation to the DAO layer.
     *
     * @param idPost The ID of the post to retrieve likes for.
     * @return A list of {@link Like} objects containing the likes on the post.
     */
    public List<Like> getPostLikes(int idPost) {
        return abstractFactory.createLikeDAO().getPostLikes(idPost);
    }

    /**
     * Retrieves likes on a photo.
     * Delegates the retrieval operation to the DAO layer.
     *
     * @param idPhoto The ID of the photo to retrieve likes for.
     * @return A list of {@link Like} objects containing the likes on the photo.
     */
    public List<Like> getPhotoLikes(int idPhoto) {
        return abstractFactory.createLikeDAO().getPhotoLikes(idPhoto);
    }

    /**
     * Retrieves likes on a comment.
     * Delegates the retrieval operation to the DAO layer.
     *
     * @param idComment The ID of the comment to retrieve likes for.
     * @return A list of {@link Like} objects containing the likes on the comment.
     */
    public List<Like> getCommentLikes(int idComment) {
        return abstractFactory.createLikeDAO().getCommentLikes(idComment);
    }
}