package de.academy.training.devops.webblog.persistence;

import de.academy.training.devops.webblog.backend.Comment;
import de.academy.training.devops.webblog.backend.Post;
import java.util.HashMap;
import java.util.Map;

public class DataStore {

    private Map<Integer, Post> postMap;
    private Map<Integer, Comment> commentMap;
    public int nextPostId = 1;
    public int nextCommentId = 1;
    public int getPostId;

    public DataStore() {
        postMap = new HashMap<>();
    }

    public void addPost(Post post) {
        postMap.put(nextPostId, post);
        nextPostId++;
    }

    public void addComment(Comment comment) {
        commentMap.put(nextCommentId, comment);
        nextCommentId++;
    }

    public Post getPost(int id) {
        return postMap.get(id);
    }

    public Post getComment() {
        return postMap.get(getPostId);
    }

    public Post getPostId(int id) {
        return postMap.get(nextPostId);
    }

}
