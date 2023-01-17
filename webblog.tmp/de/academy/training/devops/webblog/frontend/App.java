package de.academy.training.devops.webblog.frontend;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import de.academy.training.devops.webblog.backend.*;
import java.time.format.DateTimeFormatter;

public class App {

    public static void main(String[] args) throws Exception {

        System.out.println("********************Welcome on the SuSiFe-Website!********************");

        // Get user input for Blog title, Author, Blog Text and Date and Time of submission
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter Name: ");
            String author = input.nextLine();
            System.out.println("Enter Title: ");
            String title = input.nextLine();
            System.out.println("Enter Text: ");
            String text = input.nextLine();
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            System.out.println(dateTime.format(formatter));


            Post post = new Post(title, text, author);
            System.out.println("Enter comment: ");
            String commentText = input.nextLine();
            Comment comment = new Comment(commentText, author);
            post.addComment(comment);
            LocalDateTime dateTime1 = LocalDateTime.now();
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            System.out.println(dateTime.format(formatter));
           
        // Create Arraylist to hold all Posts
        ArrayList<Post> allPosts = new ArrayList<>();
        
        // Create Post Objects including all arguments
        Post post1 = new Post(title, commentText, author);
        Post post2 = new Post(title, commentText, author);
        Post post3 = new Post(title, commentText, author);
        
        
        
        
        }

    }
}
