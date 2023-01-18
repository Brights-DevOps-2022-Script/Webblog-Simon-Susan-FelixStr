package de.academy.training.devops.webblog.persistence;

import de.academy.training.devops.webblog.backend.Comment;
import de.academy.training.devops.webblog.backend.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore {

    private Map<Integer, Post> postMap = new HashMap<>();
    public int nextPostId = 1;

    public void createPost(String title, String text, String author) {
        Post post = new Post(title, text, author);
        postMap.put(nextPostId, post);
        post.setId(nextPostId);
        nextPostId++;
        System.out.println("--------------------Your post has been created and!--------------------");
    }

    public void showAllPosts() {
        for (int i = 1; i < nextPostId; i++) {
            Post post = postMap.get(i);
            System.out.println("ID: " + i);
            System.out.println("Title: " + post.getTitle());
            System.out.println("Text: " + post.getText());
            System.out.println("Author: " + post.getAuthor());
            System.out.println("Date: " + post.getFormattedDateTime());
            System.out.println("--------------------------------------------------");
        }
    }

    public Post getPost(int postId) {
        return postMap.get(postId);
    }
}
