package de.academy.training.devops.webblog.persistence;

import de.academy.training.devops.webblog.backend.Comment;
import de.academy.training.devops.webblog.backend.Post;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class DataStore {

    private Map<Integer, Post> postMap = new HashMap<>();
    private Map<Integer, ArrayList<Comment>> commentsMap = new HashMap<>();
    public int nextPostId = 1;

    public void createPost(String title, String text, String author) {
        Post post = new Post(title, text, author);
        postMap.put(nextPostId, post);
        post.setId(nextPostId);
        nextPostId++;
        System.out.println("--------------------Your post has been created and!--------------------");
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

    public void addComment(int postID, Comment comment) {
    }

}
