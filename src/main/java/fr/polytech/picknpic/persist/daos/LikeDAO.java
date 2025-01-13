package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Like;

import java.util.List;

public interface LikeDAO {

    boolean addLike(Like like);

    boolean removeLikeOnPost(int id_user, int id_post);

    boolean removeLikeOnPhoto(int id_user, int id_photo);

    boolean removeLikeOnComment(int id_user, int id_comment);

    List<Like> getPostLikes(int idPost);

    List<Like> getPhotoLikes(int idPhoto);

    List<Like> getCommentLikes(int idComment);


}
