package de.academy.training.devops.webblog.persistence;

import de.academy.training.devops.webblog.backend.Comment;
import de.academy.training.devops.webblog.backend.Post;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

    public void createAndSavePost(String title, String text, String author) {
        Post post = new Post(title, text, author);
        post.setId(nextPostId);
        postMap.put(nextPostId, post);
        nextPostId++;
        savePostsToCsv("posts.csv");
        System.out.println("--------------------Your post has been created and!--------------------");
    }

    public void addComment(Comment comment) {
        commentMap.put(nextCommentId, comment);
        nextCommentId++;
    }

    public Post getPost(int id) {
        return postMap.get(id);
    }

    public Post getComment(int id) {
        return postMap.get(id);
    }

    public Post getPostId() {
        return postMap.get(nextPostId);
    }

    public Comment getCommentId() {
        return commentMap.get(nextCommentId);
    }

    public void savePostsToCsv(String filePath) {
        File file = new File(filePath);
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Map.Entry<Integer, Post> entry : postMap.entrySet()) {
                Post post = entry.getValue();
                String line = nextPostId + "," + post.getTitle() + "," + post.getText() + "," + post.getAuthor() + ","
                        + post.getFormattedDateTime();
                writer.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void showAllPosts() {
        for (int i = 1; i < nextPostId; i++) {
            Post post = postMap.get(i);
            System.out.println("ID: " + i);
            System.out.println("Title: " + post.getTitle());
            System.out.println("Text: " + post.getText());
            System.out.println("Author: " + post.getAuthor());
            System.out.println("Comments: " + post.getComments());
            System.out.println("Date: " + post.getFormattedDateTime());
            System.out.println("--------------------------------------------------");
        }
    }
}
