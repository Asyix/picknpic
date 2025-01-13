package fr.polytech.picknpic.bl.facades.comment;
import fr.polytech.picknpic.bl.models.Comment;
import fr.polytech.picknpic.persist.AbstractFactory;

import java.util.List;

public class CommentFacade {

    private static CommentFacade commentFacade;
    private final AbstractFactory abstractFactory;

    /**
     * Private constructor to initialize the PurchaseFacade with the AbstractFactory.
     */
    private CommentFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    /**
     * Retrieves the singleton instance of the PurchaseFacade.
     *
     * @return The singleton instance of PurchaseFacade.
     */
    public static CommentFacade getInstance() {
        if (commentFacade == null) {
            commentFacade = new CommentFacade();
        }
        return commentFacade;
    }

    public boolean createComment(Comment comment) {
        return abstractFactory.createCommentDAO().createComment(comment);
    }

    public boolean updateComment(Comment comment) {
        return abstractFactory.createCommentDAO().updateComment(comment);
    }

    public boolean deleteComment(int commentId) {
        return abstractFactory.createCommentDAO().deleteComment(commentId);
    }

    public List<Comment> getPostComments(int postId) {
        return abstractFactory.createCommentDAO().getPostComments(postId);
    }

    public List<Comment> getPhotoComments(int photoId) {
        return abstractFactory.createCommentDAO().getPhotoComments(photoId);
    }

    public List<Comment> getCommentReplies(int commentId) {
        return abstractFactory.createCommentDAO().getCommentReplies(commentId);
    }


}
