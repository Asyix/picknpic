package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Comment;

import java.util.List;

public interface CommentDAO {

    List<Comment> getPostComments(int postId);

    List<Comment> getPhotoComments(int photoId);

    List<Comment> getCommentReplies(int commentId);

    boolean createComment(Comment comment);

    boolean updateComment(Comment comment);

    boolean deleteComment(int commentId);
}
