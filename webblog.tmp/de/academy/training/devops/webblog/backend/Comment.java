package de.academy.training.devops.webblog.backend;
import java.time.LocalDate;
import java.time.LocalTime;

public class Comment {
 
    private String text;
    private String author;
    
        public Comment(String text, String author) {
            this.text = text;
            this.author = author;
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
    }

    public String getText() {
        return text;
    }
}
