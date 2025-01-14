package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Like;

import java.util.List;

/**
 * Interface for Data Access Object (DAO) operations related to the Like entity.
 * Provides methods for adding, removing, and retrieving likes on posts, photos, and comments.
 */
public interface LikeDAO {

    /**
     * Adds a like.
     *
     * @param like The {@link Like} object containing the like details.
     * @return true if the like was added successfully, false otherwise.
     */
    boolean addLike(Like like);

    /**
     * Removes a like from a post.
     *
     * @param id_user The ID of the user who liked the post.
     * @param id_post The ID of the post to remove the like from.
     * @return true if the like was removed successfully, false otherwise.
     */
    boolean removeLikeOnPost(int id_user, int id_post);

    /**
     * Removes a like from a photo.
     *
     * @param id_user The ID of the user who liked the photo.
     * @param id_photo The ID of the photo to remove the like from.
     * @return true if the like was removed successfully, false otherwise.
     */
    boolean removeLikeOnPhoto(int id_user, int id_photo);

    /**
     * Removes a like from a comment.
     *
     * @param id_user The ID of the user who liked the comment.
     * @param id_comment The ID of the comment to remove the like from.
     * @return true if the like was removed successfully, false otherwise.
     */
    boolean removeLikeOnComment(int id_user, int id_comment);

    /**
     * Retrieves likes on a post.
     *
     * @param idPost The ID of the post to retrieve likes for.
     * @return A list of {@link Like} objects containing the likes on the post.
     */
    List<Like> getPostLikes(int idPost);

    /**
     * Retrieves likes on a photo.
     *
     * @param idPhoto The ID of the photo to retrieve likes for.
     * @return A list of {@link Like} objects containing the likes on the photo.
     */
    List<Like> getPhotoLikes(int idPhoto);

    /**
     * Retrieves likes on a comment.
     *
     * @param idComment The ID of the comment to retrieve likes for.
     * @return A list of {@link Like} objects containing the likes on the comment.
     */
    List<Like> getCommentLikes(int idComment);
}