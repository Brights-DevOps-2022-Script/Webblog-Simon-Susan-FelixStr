package de.academy.training.devops.webblog.backend;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {

    private String text;
    private String author;
    private LocalDateTime dateTime;
    private DateTimeFormatter formatter;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        this.dateTime = LocalDateTime.now();
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getLocalDateTime() {
        return dateTime;
    }

    public String getFormattedDateTime() {
        return dateTime.format(formatter);
    }

}
