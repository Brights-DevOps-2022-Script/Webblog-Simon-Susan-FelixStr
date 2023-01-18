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

    public void addComment(int postId, Comment comment) {
        ArrayList<Comment> comments = commentsMap.get(postId);
        if (comments == null) {
            comments = new ArrayList<>();
            commentsMap.put(postId, comments);
        }
        comments.add(comment);
        System.out.println("--------------------Your comment has been created!--------------------");
    }

    public ArrayList<Comment> getComments(int postId) {
        return commentsMap.get(postId);
    }

    public Post getPost(int postId) {
        return postMap.get(postId);
    }

    public void showAllPosts() {
        for (int i = 1; i < nextPostId; i++) {
            Post post = postMap.get(i);
            System.out.println("ID: " + i);
            System.out.println("Title: " + post.getTitle());
            System.out.println("Text: " + post.getText());
            System.out.println("Author: " + post.getAuthor());
            System.out.println("Date: " + post.getFormattedDateTime());
            System.out.println("Number of comments: " + commentsMap.size());
            System.out.println("--------------------------------------------------");
        }
    }

    public void showPost(int postId) {
        Post post = postMap.get(postId);
        System.out.println("ID: " + postId);
        System.out.println("Title: " + post.getTitle());
        System.out.println("Text: " + post.getText());
        System.out.println("Author: " + post.getAuthor());
        System.out.println("Date: " + post.getFormattedDateTime());
        System.out.println("--------------------------------------------------");
    }

    public void showPostAndComments(int postId) {
        Post post = getPost(postId);
        System.out.println("-----------Post-----------");
        System.out.println("ID: " + postId);
        System.out.println("Title: " + post.getTitle());
        System.out.println("Text: " + post.getText());
        System.out.println("Author: " + post.getAuthor());
        System.out.println("Date: " + post.getFormattedDateTime());
        ArrayList<Comment> comments = getComments(postId);
        if (comments == null || comments.isEmpty()) {
            System.out.println("No comments yet.");
        } else {
            for (Comment comment : comments) {
                System.out.println("---Comment---");
                System.out.println("Comment: " + comment.getText());
                System.out.println("Author: " + comment.getAuthor());
                System.out.println("Date: " + comment.getFormattedDateTime());
                System.out.println("--------------------------------------------------");
            }
        }
    }

}
