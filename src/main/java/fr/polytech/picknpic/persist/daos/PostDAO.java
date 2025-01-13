package fr.polytech.picknpic.persist.daos;

import fr.polytech.picknpic.bl.models.Post;

import java.util.List;

public interface PostDAO {

    boolean createPost(Post post);

    boolean updatePost(Post post);

    boolean deletePost(int postId);

    Post getPost(int postId);

    List<Post> getUserPosts(int userId);

    List<Post> getFollowersPosts(int userId);
}
