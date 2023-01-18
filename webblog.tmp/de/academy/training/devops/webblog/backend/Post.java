package de.academy.training.devops.webblog.backend;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalTime;



public class Post{

    private String title;
    private String text;
    private String author;
    private ArrayList<Comment> comment;

    

    public Post(String title, String text, String author) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.comment = new ArrayList<Comment>();

    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
    
    public String getAuthor() {
        return author;
    }
    public ArrayList<Comment> getComments() {
        return comment;


        }
    private ArrayList<Comment> comments;
    public void addComment(Comment comment) {
        comments.add(comment);
}}
