package de.academy.training.devops.webblog.persistence;

import de.academy.training.devops.webblog.backend.Comment;
import de.academy.training.devops.webblog.backend.Post;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;

public class DataStore {

    public Map<Integer, Post> postMap = new HashMap<>();
    private Map<Integer, ArrayList<Comment>> commentsMap = new HashMap<>();
    public int nextPostId = 1;

    public void createPost(String title, String text, String author) {
        Post post = new Post(title, text, author);
        postMap.put(nextPostId, post);
        post.setId(nextPostId);
        nextPostId++;
        System.out.println("--------------------Your post has been created and!--------------------");
    }

    public void addComment(int postId, Comment comment) {
        ArrayList<Comment> comments = commentsMap.get(postId);
        if (comments == null) {
            comments = new ArrayList<>();
            commentsMap.put(postId, comments);
        }
        comments.add(comment);
        System.out.println("--------------------Your comment has been created!--------------------");
    }

    public void showAllPosts() {
        System.out.println("--------------------All Posts--------------------");
        for (int i = 1; i < nextPostId; i++) {
            Post post = getPost(i);
            System.out.println("ID: " + i);
            System.out.println("Title: " + post.getTitle());
            System.out.println("Text: " + post.getText());
            System.out.println("Author: " + post.getAuthor());
            System.out.println("Date: " + post.getFormattedDateTime());
            System.out.println("--------------------------------------------------");
        }
    }

    public Post getPostWithComment(int postID) {
        Post post = getPost(postID);
        System.out.println("Post-ID: " + postID);
        System.out.println("Title: " + post.getTitle());
        System.out.println("Author: " + post.getAuthor());
        System.out.println("Post: " + post.getText());
        System.out.println("Date: " + post.getFormattedDateTime());
        System.out.println("---------Comment(s)------------");

        ArrayList<Comment> comments = getComments(postID);
        for (Comment comment : comments) {
            System.out.println("Author: " + comment.getAuthor());
            System.out.println("Comment: " + comment.getText());
            System.out.println("Date: " + comment.getFormattedDateTime());
        }
        return post;
    }

    public Post getPost(int postId) {
        return postMap.get(postId);
    }

    public ArrayList<Comment> getComments(int postId) {
        return commentsMap.get(postId);
    }

    public Post getPostId(int id) {
        return postMap.get(nextPostId);
    }

    public Post removePost(int postId) {
        return postMap.remove(postId);
    }

    public Map<Integer, Post> showPosts() {
        return postMap;
    }

}
