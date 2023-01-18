package de.academy.training.devops.webblog.backend;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Post {

    private String title;
    private String text;
    private String author;
    private ArrayList<Comment> comment;
    private LocalDateTime dateTime;
    private DateTimeFormatter formatter;

    public Post(String title, String text, String author) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.dateTime = LocalDateTime.now();
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
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

    public LocalDateTime getLocalDateTime() {
        return dateTime;
    }

    public String getFormattedDateTime() {
        return dateTime.format(formatter);
    }

}
